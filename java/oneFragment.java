package com.example.pro.test1;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.example.pro.test1.MainActivity;
import com.github.clans.fab.FloatingActionButton;
import com.github.clans.fab.FloatingActionMenu;

/**
 * Created by pro on 2017/5/14.
 */

public class oneFragment extends Fragment {
    private Button btn1;
    private android.widget.SearchView searchView;
    private SearchControl searchControl;
    private ListView list;
    private ImageView imageView;
    private Toolbar mtoolbar;
    private View view;
    private SatelliteMenu menu;
    private boolean fabopened = false;
    private FloatingActionMenu floatingActionMenu;
    private FloatingActionButton button1,button2,button3;
    private FloatingActionButton btn_fab_one;
    //public Place[] all_list,zhejiang_list,shanghai_list;
    private Place[] places = new Place[]{
            new Place("西湖","5A级风景名胜","杭州上城区,浙江",R.drawable.xihu1,false,"0571-87179617","Zhejiang",0.5,0.1,0.6,0.7,0.6,0.1,0.5,0.2,0.1),
            new Place("千岛湖","5A级旅游景区","淳安县,杭州西郊,浙江",R.drawable.qiandaohu2,false,"4006789691","Zhejiang",0.6,0.2,0.3,0.5,0.3,0.1,0.7,0.1,0.6),
            new Place("雁荡山","5A级风景名胜","温州市东北部海滨,浙江",R.drawable.yandangshan3,false,"577-621788888","Zhejiang",0.6,0.1,0.3,0.6,0.4,0.2,0.5,0.1,0.5),
            new Place("西栅","5A级景区","桐乡,嘉兴市,浙江",R.drawable.xishan4,false,"0573-88731088","Zhejiang",0.4,0.4,0.2,0.8,0.4,0.1,0.6,0.1,0.3),
            new Place("普陀山","5A级旅游风景区","舟山市,浙江",R.drawable.putuoshan5,false,"0580-6091414","Zhejiang",0.4,0.3,0.5,0.6,0.4,0.3,0.4,0.4,0.6),
            new Place("横店影视城","5A级旅游景区","东阳市,浙江",R.drawable.hengdian6,false,"0579-86547211","Zhejiang",0.2,0.1,0.5,0.9,0.2,0.3,0.4,0.8,0.3),
            new Place("嘉兴南湖","5A级旅游景区","嘉兴市,浙江",R.drawable.jiaxingnanhu7,false,"0573-82532848","Zhejiang",0.1,0.2,0.2,0.3,0.1,0.2,0.4,0.5,0.6),
            new Place("绍兴东湖","风景名胜","绍兴古城东,浙江",R.drawable.shaoxingdonghu8,false,"0575-88649560","Zhejiang",0.3,0.2,0.4,0.3,0.4,0.2,0.5,0.1,0.4),
            new Place("楠溪江","4A级旅游区","永嘉县,温州市,浙江",R.drawable.nanxijiang9,false,"0577-67061788","Zhejiang",0.2,0.2,0.3,0.4,0.3,0.2,0.5,0.1,0.5),
            new Place("钱塘江","风景名胜","杭州市,浙江",R.drawable.qiantangjiang10,false,"不存在的","Zhejiang",0.1,0.1,0.2,0.4,0.2,0.0,0.3,0.2,0.4),
            new Place("西溪","5A级旅游景区","杭州市区西部,浙江",R.drawable.xixi11,false,"0571-88106688","Zhejiang",0.2,0.1,0.3,0.5,0.4,0.1,0.4,0.2,0.5),
            new Place("莫干山","4A级旅游景区","德清县,浙江",R.drawable.moganshan12,false,"0572-8412345","Zhejiang",0.2,0.1,0.2,0.6,0.3,0.1,0.4,0.1,0.6),
            new Place("灵隐寺","全国重点文物保护单位","杭州市,浙江",R.drawable.lingyinsi13,false,"0571-87968665","Zhejiang",0.1,0.4,0.1,0.2,0.7,0.6,0.4,0.1,0.8),
            new Place("双龙洞","5A级旅游区","金华市,浙江",R.drawable.shuanglongdong14,false,"0579-83202095","Zhejiang",0.3,0.1,0.2,0.5,0.2,0.1,0.3,0.1,0.4),
            new Place("天目山","4A级景区","临安市,浙江",R.drawable.tianmushan15,false,"0571-63751978","Zhejiang",0.2,0.3,0.1,0.4,0.4,0.2,0.5,0.1,0.3),
            new Place("浙西大峡谷","风景名胜","临安市,浙江",R.drawable.zhexidaxiagu16,false,"0571-63631745","Zhejiang",0.1,0.1,0.3,0.5,0.2,0.1,0.3,0.1,0.2),
            new Place("雷峰塔","4A级旅游景区","杭州市,浙江",R.drawable.leifengta17,false,"0571-87982111","Zhejiang",0.2,0.3,0.1,0.7,0.2,0.6,0.3,0.1,0.1),
            new Place("杭州宋城景区","主题公园","杭州市,浙江",R.drawable.songcheng18,false,"0571-87313101","Zhejiang",0.4,0.4,0.3,0.6,0.1,0.1,0.7,0.1,0.1),
            new Place("嵊泗列岛","风景名胜","嵊泗县,舟山市,浙江",R.drawable.chengsi19,false,"不存在的","Zhejiang",0.2,0.1,0.2,0.5,0.1,0.1,0.5,0.1,0.6),
            new Place("古堰画乡","4A级景区","丽水市,浙江",R.drawable.gurang20,false,"4007777777","Zhejiang",0.3,0.1,0.2,0.8,0.5,0.1,0.6,0.1,0.5),
            new Place("东栅","5A级景区","桐乡,嘉兴市,浙江",R.drawable.dongshan21,false,"0573-88731991","Zhejiang",0.4,0.3,0.2,0.7,0.4,0.1,0.5,0.1,0.3),
            new Place("老外滩","最早外滩","宁波市,浙江",R.drawable.laowaitan22,false,"不存在的","Zhejiang",0.2,0.5,0.3,0.4,0.6,0.1,0.2,0.4,0.2),
            new Place("天一阁博物馆","以藏书文化为特色的专题性博物馆","宁波市,浙江",R.drawable.tianyibowuguan23,false,"0574-87293526","Zhejiang",0.7,0.6,0.6,0.5,0.8,0.2,0.3,0.1,0.3),
            new Place("兰亭","4A级旅游区","绍兴市西南,浙江",R.drawable.lanting24,false,"0575-84606885","Zhejiang",0.5,0.2,0.1,0.3,0.6,0.2,0.3,0.1,0.3),
            new Place("中南百草园","4A级景区","安吉县,浙江",R.drawable.baicaoyuan25,false,"0572-5023456","Zhejiang",0.2,0.4,0.1,0.2,0.1,0.3,0.1,0.1,0.5),
            new Place("诸葛八卦村","古文化村落","兰溪市西,浙江",R.drawable.zhugebaguacun26,false,"不存在的","Zhejiang",0.2,0.4,0.3,0.4,0.5,0.6,0.2,0.6,0.6),
            new Place("云和梯田","4A级景区","崇头镇,云和县,丽水市,浙江",R.drawable.yunhetitian27,false,"0578-5156688","Zhejiang",0.4,0.4,0.3,0.5,0.1,0.1,0.2,0.1,0.4),
            new Place("长屿硐天","4A级旅游区","温岭市东北,浙江",R.drawable.changyudongtian28,false,"0576-86598151","Zhejiang",0.2,0.1,0.2,0.4,0.2,0.1,0.3,0.1,0.5),
            new Place("大明山景区","4A级风景名胜区","临安西部,浙江",R.drawable.damingshan29,false,"0571-63709588","Zhejiang",0.3,0.1,0.2,0.3,0.1,0.4,0.6,0.2,0.5),
            new Place("鲁迅故里","5A级旅游景区","鲁迅中路,绍兴市,浙江",R.drawable.luxunguli30,false,"0575-85124580","Zhejiang",0.1,0.5,0.3,0.2,0.7,0.5,0.2,0.5,0.6),


            new Place("浦东滨江大道","上海东外滩","东昌路和浦东南路,上海",R.drawable.binjiangdadao31,false,"021-58871096","Shanghai",0.3,0.2,0.2,0.1,0.2,0.2,0.6,0.1,0.4),
            new Place("锦江乐园","浪漫的摩天轮","上海市闵行区虹梅路201号",R.drawable.jinjiangleyuan32,false,"021-54204956","Shanghai",0.2,0.1,0.2,0.3,0.1,0.4,0.8,0.1,0.5),
            new Place("甜爱路","最浪漫的道路","上海市虹口区甜爱路",R.drawable.tianailu33,false,"暂无","Shanghai",0.5,0.6,0.1,0.3,0.1,0.2,0.6,0.1,0.4),
            new Place("上海新天地","中西结合","上海市黄浦区太仓路181弄",R.drawable.xintiandi34,false,"暂无","Shanghai",0.3,0.3,0.6,0.5,0.1,0.1,0.5,0.5,0.2),
            new Place("吴江路","美食圣地","上海市静安区",R.drawable.wujianglu35,false,"暂无","Shanghai",0.1,0.5,0.2,0.3,0.1,0.2,0.7,0.1,0.4),
            new Place("上海科技馆","科技爱好者必去之地","上海浦东新区世纪大道2000号",R.drawable.kejiguan36,false,"021-68542000","Shanghai",0.6,0.4,0.6,0.5,0.7,0.2,0.1,0.1,0.2),
            new Place("人民广场","喂鸽子吃炸鸡","上海市黄浦区",R.drawable.renminguangchang37,false,"暂无","Shanghai",0.2,0.4,0.5,0.4,0.1,0.1,0.6,0.1,0.4),
            new Place("城隍庙","小吃王国","上海市黄浦区方浜中路",R.drawable.chenghuangmiao38,false,"021-60480367","Shanghai",0.2,0.4,0.1,0.2,0.1,0.1,0.4,0.2,0.5),
            new Place("上海大剧院","歌剧爱好者必去","上海市黄陂北路286号",R.drawable.shanghaidajuyuan39,false,"(8621)6386 8686","Shanghai",0.4,0.3,0.5,0.7,0.5,0.2,0.3,0.1,0.3),
            new Place("静安寺","佛教圣地","静安区南京西路1686号",R.drawable.jignansi40,false,"(021)62566366","Shanghai",0.2,0.3,0.2,0.1,0.5,0.5,0.4,0.0,0.6),
            new Place("上海动物园","中国第二大动物园","上海市长宁区虹桥路2381号",R.drawable.shanghaidongwuyuan41,false,"021-62687775","Shanghai",0.1,0.0,0.1,0.2,0.6,0.2,0.7,0.0,0.3),
            new Place("银七星滑雪场","亚洲第一大的滑雪场","上海市七莘路1835号(近华中路)",R.drawable.yinqixinghuaxvechang42,false,"暂无","Shanghai",0.4,0.1,0.1,0.3,0.1,0.0,0.5,0.0,0.1),
            new Place("上海蜡像馆","让名人们见证你们的爱情","上海黄浦区南京西路2-68号",R.drawable.shanghailaxiangguan43,false,"(021)63587878","Shanghai",0.1,0.4,0.5,0.8,0.2,0.1,0.5,0.0,0.4),
            new Place("七宝古镇","谈一场古色古香的恋爱","上海市闵行区",R.drawable.qibaoguzhen44,false,"暂无","Shanghai",0.1,0.1,0.2,0.4,0.3,0.3,0.5,0.1,0.4),
            new Place("临江公园","江南古典园林","友谊路1号（近东林路）",R.drawable.linjianggongyuan45,false,"(021)56104731","Shanghai",0.2,0.3,0.4,0.6,0.5,0.1,0.3,0.0,0.4),
            new Place("秋霞圃","仿红楼梦园林","嘉定区城乡镇东大街314号",R.drawable.qiuxiapu46,false,"(021)59531949","Shanghai",0.2,0.4,0.5,0.5,0.3,0.2,0.3,0.1,0.2),
            new Place("枫泾古镇","吴越名镇","金山区湖北路180号(枫丽路新枫路)",R.drawable.fengjingguzhen47,false,"暂无","Shanghai",0.2,0.4,0.2,0.3,0.3,0.4,0.4,0.1,0.5),
            new Place("上海马戏城","中国马戏第一城","上海市静安区",R.drawable.shanghaimaxicheng48,false,"(021)56656622","Shanghai",0.1,0.5,0.2,0.3,0.1,0.1,0.7,0.0,0.4),
            new Place("上海植物园","大自然中的约会","徐汇区龙吴路1111号(近百色路)",R.drawable.shanghaizhiwuyuan49,false,"(021)54363369","Shanghai",0.1,0.2,0.1,0.3,0.8,0.2,0.6,0.0,0.4),
            new Place("陕西南路","购物狂出没之地","上海市黄浦区（原卢湾区）、徐汇区、静安区3区交界处",R.drawable.shanxinanlu50,false,"暂无","Shanghai",0.1,0.5,0.4,0.4,0.1,0.0,0.6,0.6,0.2),
            new Place("上海音乐厅","音乐爱好者圣地","黄浦区延安东路523号",R.drawable.shanghaiyinyueting51,false,"021-63868920,021-63869153,021-53866666","Shanghai",0.4,0.5,0.5,0.6,0.3,0.2,0.6,0.0,0.4),
            new Place("龙华寺","在许愿树下立下爱情誓言","徐汇区龙华路2853号",R.drawable.longhuasi52,false,"4006228228","Shanghai",0.2,0.4,0.2,0.5,0.1,0.6,0.4,0.0,0.1),
            new Place("热带风暴水上乐园","亚洲最大的水上乐园","上海市闵行区新镇路7号",R.drawable.redaifengbao53,false,"021-64783333","Shanghai",0.1,0.3,0.2,0.1,0.2,0.5,0.8,0.1,0.5),
            new Place("吴淞炮台湾湿地森林公园","湿地里的爱情","塘后路206号",R.drawable.wusongpaotaishidigongyuan54,false,"(021)56579009","Shanghai",0.1,0.1,0.1,0.3,0.1,0.6,0.6,0.0,0.4),
            new Place("徐家汇公园","晚上CP聚集地","肇嘉浜路889号(天平路宛平路间)",R.drawable.xvjiahuigongyuan55,false,"暂无","Shanghai",0.1,0.4,0.2,0.4,0.1,0.6,0.6,0.0,0.4),
            new Place("共青森林公园","森林中的恋爱","上海市杨浦区军工路2000号",R.drawable.gongqingsenlingongyuan56,false,"暂无","Shanghai",0.2,0.1,0.5,0.3,0.1,0.2,0.5,0.1,0.6),
            new Place("长风公园","海洋世界","上海市普陀区大渡河路451号",R.drawable.haiyangshijie57,false,"","Shanghai",0.2,0.4,0.4,0.5,0.2,0.5,0.6,0.1,0.4),
            new Place("铜仁路","异国风情","上海市静安区",R.drawable.tongrenlu58,false,"暂无","Shanghai",0.3,0.5,0.4,0.5,0.5,0.2,0.6,0.0,0.1),
            new Place("世纪公园","自然与和谐","上海市浦东新区芳甸路666号",R.drawable.shijigongyuan59,false,"(021)58337122","Shanghai",0.1,0.2,0.1,0.3,0.3,0.5,0.5,0.0,0.7),
            new Place("莫干山路艺术街","即将消失的涂鸦墙","闸北区莫干山路50号",R.drawable.moganshanluyishujie60,false,"暂无","Shanghai",0.2,0.4,0.5,0.7,0.4,0.3,0.5,0.0,0.3)
    };
    public oneFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        view = inflater.inflate(R.layout.fragment_one, container, false);
        /*searchView = (SearchView) view.findViewById(R.id.searchview);
        list = (ListView) view.findViewById(R.id.ListView01);
        mtoolbar = (Toolbar) view.findViewById(R.id.toolbar);*/
        setHasOptionsMenu(true);
        return view;
    }

    @Override
    public void onActivityCreated( Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

         /*btn1 = (Button) getView().findViewById(R.id.button3);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(oneFragment.class,"this is the first page",Toast.LENGTH_SHORT).show();
                Toast.makeText(getActivity(),"this is the first page",Toast.LENGTH_SHORT).show();
                //btn1.setText("234435");
            }
        });*/

        setIntoduction();
        placeSort res = new placeSort(places);
        int charType = 0;
        final Place[] alllist = res.allSort(charType);
        final Place[] zhejianglist = res.zhejiangSort(charType);
        final Place[] shanghailist = res.shanghaiSort(charType);
        final SearchControl searchControl = new SearchControl(places);
        //View rootView = inflater.inflate(R.layout.file, null);
        searchView = (SearchView) getActivity().findViewById(R.id.searchview);
        list = (ListView) getActivity().findViewById(R.id.ListView01);

        mtoolbar = (Toolbar) getActivity().findViewById(R.id.toolbar);
        imageView = (ImageView) getActivity().findViewById(R.id.imageView3);
        imageView.setImageResource(R.drawable.circle);
        //searchControl.setSearchtext(searchView.getQuery());
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if (!TextUtils.isEmpty(newText)) {
                    searchControl.setSearchtext(newText);
                    add_data(searchControl.Search());
                } else {
                    add_data(alllist);
                }
                return false;
            }
        });
        add_data(alllist);

        /*floatingActionButton = (FloatingActionButton) getActivity().findViewById(R.id.fab);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!fabopened) {
                    openMenu(v);
                } else {
                    closeMenu(v);
                }
            }
        });*/
        floatingActionMenu = (FloatingActionMenu) getActivity().findViewById(R.id.fab);
        floatingActionMenu.setClosedOnTouchOutside(false);
        button1 = (FloatingActionButton) getActivity().findViewById(R.id.fab_share);
        button2 = (FloatingActionButton) getActivity().findViewById(R.id.fab_upload);
        button3 = (FloatingActionButton) getActivity().findViewById(R.id.fab_preview);
        //final Toolbar mToolbar = (Toolbar) getView().findViewById(R.id.toolbar);//toolbar
        //mToolbar.setLogo(android.R.drawable.btn_star);
        //mToolbar.setTitle("好好约会");
        //mToolbar.setSubtitle("love is the most important");
        //getActivity().setSupportActionBar(mToolbar);
        
        //((AppCompatActivity)getActivity()).setSupportActionBar(mtoolbar);
        mtoolbar.inflateMenu(R.menu.toolbar);
        //((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayShowTitleEnabled(false);
        mtoolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                int itemid = item.getItemId();
                switch (itemid) {
                    case R.id.action_item1:
                        add_data(shanghailist);
                        break;
                    case R.id.action_item2:
                        add_data(zhejianglist);
                        break;
                    case R.id.action_item3:
                        add_data(alllist);
                        break;
                    case R.id.action_edit:
                        Toast.makeText(getActivity(), "edit~~~", Toast.LENGTH_SHORT).show();
                        break;
                    default:
                        break;
                }
                return true;
            }
        });
    }

    /*private void openMenu(View v) {
        ObjectAnimator animator = ObjectAnimator.ofFloat(view,"rotation",0,-155,-135);
        animator.setDuration(500);
        animator.start();

    }*/

    private void add_data(final Place placess[]) {
        ArrayList<HashMap<String, Object>> listitem = new ArrayList<HashMap<String, Object>>();
        for (int i = 0; i < placess.length; i++) {
            HashMap<String, Object> map = new HashMap<String, Object>();
            //map.put("ItemImage",ImageList[i]);
            //map.put("ItemTitle",TextList[i]);
            map.put("ItemImage", placess[i].image);
            map.put("ItemTitle", placess[i].name);
            map.put("ItemType", placess[i].type);
            map.put("ItemLocation", placess[i].location);
            listitem.add(map);
        }
        SimpleAdapter listItemAdapter = new SimpleAdapter(getActivity(), listitem, R.layout.item_list,
                new String[]{"ItemImage", "ItemTitle", "ItemType", "ItemLocation"}, new int[]{R.id.imageView2, R.id.textView1, R.id.textView2, R.id.textView3});
        list.setAdapter(listItemAdapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), placedetail.class);//activity
                Bundle bundle = new Bundle();

                bundle.putInt("ItemImage", placess[position].image);
                bundle.putString("Itemname", placess[position].name);
                bundle.putString("Itemplace", placess[position].location);
                bundle.putString("Itemphone", placess[position].phone);
                bundle.putString("ItemIntroduction", placess[position].introduction);
                bundle.putBoolean("Itemisvisited", placess[position].isvisited);

                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

        list.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getActivity(),"this is a beautiful place",Toast.LENGTH_SHORT).show();
                //btn_fab_one = (FloatingActionButton) getActivity().findViewById(R.id.fab_pageone_item_one);
                btn_fab_one = (FloatingActionButton) getActivity().findViewById(R.id.fab_pageone_item_one);
                btn_fab_one.setVisibility(View.VISIBLE);
                btn_fab_one.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getActivity(),"wawawa",Toast.LENGTH_SHORT).show();
                    }
                });
                return false;
            }
        });
        //list.setOnItem
    }


    /*@Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        menu.clear();
        inflater.inflate(R.menu.toolbar,menu);
        super.onCreateOptionsMenu(menu,inflater);
    }*/

    private void setIntoduction() {
        places[0].setIntroduction("西湖，位于浙江省杭州市西面，是中国大陆首批国家重点风景名胜区和中国十大风景名胜之一。它是中国大陆主要赏性淡水湖泊之一，也是现今《世界遗产名录》中少数几个" +
                "和中国唯一一个湖泊类文化遗产。\n  西湖三面环山，面积约6.39平方千米，东西宽约2.8千米，南北长约3.2千米，绕湖一周近15千米。湖中被孤山、白堤、苏堤、杨公堤分隔，按面积大小分别为外西湖、" +
                "西里湖、北里湖、小南湖及岳湖等五片水面，苏堤、白堤越过湖面，小瀛洲、湖心亭、阮公墩三个小岛鼎立于外西湖湖心，夕照山的雷峰塔与宝石山的保俶塔隔湖相映，由此形成了“" +
                "一山、二塔、三岛、三堤、五湖”的基本格局。");
        places[1].setIntroduction("千岛湖，位于中国浙江省杭州西郊淳安县境内，东距杭州129千米、西距黄山140千米，是长江三角洲地区的后花园，是世界上岛屿最多的湖，" +
                "因湖内拥有1078座翠岛而得名。\n杭州千岛湖与加拿大渥太华西南200多千米的金斯顿千岛湖、湖北黄石阳新仙岛湖并称为''世界三大千岛湖''\n千岛湖即新安江水库。" +
                "是1959年我国建造了第一座自行设计、自制设备的大型水力发电站——新安江水力发电站而拦坝蓄水形成的人工湖，水库坝高105米，长462米；水库长约150千米，最宽处达10余千米；" +
                "最深处达100余米。在正常水位情况下，面积约580平方千米，比杭州西湖大108倍，蓄水量可达178亿立方，比西湖大3000多倍。\n千岛湖，以千岛、秀水、金腰带（岛屿与湖水相接处环绕着有一层金黄色的土带，" +
                "称之名“金腰带”）为主要特色景观，是中国首批国家级风景名胜区之一，千岛湖景区总面积为982平方公里，也是中国面积最大的森林公园。千岛湖深受海内外游客青睐，被台湾游客和媒体评为台湾市民赴大陆旅游的" +
                "三大热点之一，与北京、长江三峡齐名，2015年接待游客首次突破千万人次。\n千岛湖水在中国大江大湖中位居优质水之首。国家一级水体，不经任何处理即达饮用水标准，赞誉为“天下第一秀水”。\n2001年被评" +
                "为首批中国AAAAA级旅游区。2002年被评为全国保护旅游消费者权益示范景区和浙江青年文明号示范景区。2010年4月18日，国家旅游局授予千岛湖为国家5A级旅游景区殊荣。千岛湖也在继西湖之后，" +
                "成为杭州地区第二个荣获5A级的旅游景区。");
        places[2].setIntroduction("雁荡山以山水奇秀闻名，素有“海上名山、寰中绝胜”之誉，史称中国“东南第一山”，主体位于浙江省温州市东北部海滨，小部在台州市温岭南境。" +
                "雁荡山形成于一亿二千万年以前，是环太平洋大陆边缘火山带中一座日至纪流纹质破火地。《载敬堂集》载：“雁荡山以瓯江自然断裂，分北雁荡山和南雁荡山。以景观区位分有北雁荡山、南雁荡山、西雁荡山、" +
                "东雁荡山、中雁荡山之称。”其开山凿胜始于南北朝，兴于唐，盛于宋。历代文人墨客纷至沓来，谢灵运、沈括、徐霞客、张大千、郭沫若等都留下了诗篇和墨迹。");
        places[3].setIntroduction("西栅以原汁原味的水乡风貌和千年积淀的文化底蕴成为江南古镇中的佼佼者。十字形的内河水系将全镇划分为东南西北四个区块，人称东南西北四栅。最早开发的是东栅，而比东栅大三四倍" +
                "的西栅景区，却真是能带给人们一番“全新”的古镇游体验。这种“新鲜”的感受不仅在于白天观光，更在于流光溢彩的夜游休闲，以及多样化的个性住宿，让人能真正住下来细品。\n  西栅由12座小岛组成，70多座小桥将这些小岛串连在一起，河流密度和石桥数量均为全国古镇之最。夜幕降临时，喝着小酒，看对岸楼台上唱戏，或者到水边放几盏莲花灯，都会令人心醉。");
        places[4].setIntroduction("普陀山，与山西五台山、四川峨眉山、安徽九华山并称为中国佛教四大名山，是观世音菩萨教化众生的道场。普陀山是舟山群岛1390个岛屿中的一个小岛，形似苍龙卧海，面积近13平方公里，与舟山群岛的沈家门隔海相望，素有“海天佛国”、“南海圣境”之称，是首批国家重点风景名胜区。2007年（丁亥年）5月8日，舟山市普陀山风景名胜区，经国家旅游局正式批准，为国家5A级旅游风景区。“海上有仙山，山在虚无缥缈间”，普陀山以其神奇、神圣、神秘，成为驰誉中外的旅游胜地。普陀山是国务院首批公布的44个国家级重点风景名胜区之一，中国国家5A级旅游景区，全国文明山、卫生山，浙江省唯一的ISO14000国家示范区。");
        places[5].setIntroduction("横店影视城，是集影视旅游、度假、休闲、观光为一体的大型综合性旅游区，以其厚重的文化底蕴和独特的历史场景而被评为国家AAAAA级旅游区。1996年，为配合著名导演谢晋拍摄历史巨片《鸦片战争》而建，并对社会正式开放。影视城位于中国浙江省金华市东阳市横店镇，处于江、浙、沪、闽、赣四小时交通旅游经济圈内。自1996年以来，横店集团累计投入30个亿资金兴建广州街·香港街、明清宫苑、秦王宫、清明上河图、华夏文化园、明清民居博览城、梦幻谷、屏岩洞府、大智禅寺、红军长征博览城、圆明新园等13个跨越几千年历史时空，汇聚南北地域特色的影视拍摄基地和两座超大型的现代化摄影棚。横店影视城已成为全球规模最大的影视拍摄基地，中国唯一的“国家级影视产业实验区”，被美国《好莱坞》杂志称为”中国好莱坞“。");
        places[6].setIntroduction("嘉兴南湖（South Lake），位于浙江省嘉兴市，与南京玄武湖和杭州西湖并称为江南三大名湖，素来以“轻烟拂渚，微风欲来”的迷人景色著称於世。其位於嘉兴城南，因此得名“南湖”。南湖原名滮湖、马场湖，又叫东湖，嘉兴城西南有西南湖，原称鸳鸯湖。现在，南湖已经并入了南湖风景名胜区，其位於嘉兴市区，规划区域总面积276.3公顷，其中水域面积98公顷。\n南湖风景名胜区也是国家AAAAA级旅游景区、国家级风景名胜区、全国红色旅游经典景区、华东旅游线上著名的旅游区、全国百个爱国主义教育示范基地之一。\n嘉兴南湖不仅以秀丽的风光享有盛名，而且还因中国共产党第一次全国代表大会在这里胜利闭幕而备受世人瞩目，是中国共产党诞生地，成为我国近代史上重要的革命纪念地。");
        places[7].setIntroduction("湖在绍兴古城东约六公里处，以崖壁、岩洞、石桥、湖面巧妙结合，成为著名园林，是浙江省的三大名湖之一。东湖虽小，但因它的奇石、奇洞所构成的奇景使东湖成为旅游业界人士公认的罕见的“湖中之奇”。日本旅游机构交通公社，曾在同时游历过杭州西湖与绍兴东湖的日本游客中作过问卷调查，对东湖的印象超过西湖，可见对东湖的赞誉并非绍兴人的自我感觉。");
        places[8].setIntroduction("楠溪江位于浙江省温州市北部的永嘉县境内，南距温州市区26公里 ，东与雁荡山毗邻，西接缙云仙都，近中国最美乡村婺源。北与仙居景区接壤，近中国十大名山之一黄山。\n楠溪江是国家AAAA级旅游区，世界地质公园。楠溪江和雁荡山这两个国家级名胜区之间有石桅岩至雁湖的旅游专用公路。\n楠溪江，总面积671平方公里的景区分为大楠溪 、石桅岩、大若岩、太平岩、岩坦溪、四海山、源头七大景区，共有八百多个景点。风景区沿江分布，有台湾水青冈、银杏、华西枫杨等多种国家重点保护珍贵树种。\n大若岩山麓江滨村寨风貌独特，保存有宋代以来的亭台楼阁、庙观祠殿牌楼等古建筑。\n");
        places[9].setIntroduction("钱塘江，古称浙，全名“浙江”，又名“折江”、“之江”、“罗刹江”，一般浙江富阳段称为富春江，浙江下游杭州段称为钱塘江。钱塘江最早见名于《山海经》，因流经古钱塘县（今杭州）而得名 ，是吴越文化的主要发源地之一。\n钱塘江是浙江省最大河流，是宋代两浙路的命名来源，也是明初浙江省成立时的省名来源。以北源新安江起算，河长588.73千米；以南源衢江上游马金溪起算，河长522.22千米。自源头起，流经今安徽省南部和浙江省，流域面积55058平方公里，经杭州湾注入东海。\n钱塘江潮被誉为“天下第一潮”，是世界一大自然奇观，它是天体引力和地球自转的离心作用，加上杭州湾喇叭口的特殊地形所造成的特大涌潮。");
        places[10].setIntroduction("西溪国家湿地公园坐落于浙江省杭州市区西部，离杭州主城区武林门只有6公里，距西湖仅5公里。\n西溪国家湿地公园总面积约为11.5平方公里，分为东部湿地生态保护培育区、中部湿地生态旅游休闲区和西部湿地生态景观封育区。\n西溪国家湿地公园是一个集城市湿地、农耕湿地、文化湿地于一体的国家湿地公园。2009年11月03日，被列入国际重要湿地名录。2012年1月10日，被评为国家AAAAA级旅游景区。");
        places[11].setIntroduction("莫干山，为天目山之余脉，位于浙江省北部德清县境内，美丽富饶的沪、宁、杭金三角的中心，国家重点风景名胜区。因春秋末年，吴王阖闾派干将、莫邪在此铸成举世无双的雌雄双剑而得名，是中国著名的度假休闲旅游及避暑胜地。莫干山山峦连绵起伏，风景秀丽多姿，景区面积达43平方公里，它虽不及泰岱之雄伟、华山之险峻，却以绿荫如海的修竹、清澈不竭的山泉、星罗棋布的别墅、四季各异的迷人风光称秀于江南，享有“江南第一山”之美誉。");
        places[12].setIntroduction("到杭州旅游，一看西湖，二看灵隐。灵隐寺创建于东晋年间，又名云林寺。是杭州最早的古寺名刹。也是济公出家的地方。印度僧人慧理见这里景色奇幽，以为是“仙灵所隐”就在这里建寺。\n大雄宝殿前的石塔，天王殿前的石经幢均是五代十国吴越时的遗物。灵隐寺珍藏的佛教文物，有古代贝叶写经，东魏镏金佛像，明董其昌写本《金刚经》，清雍正木刻龙藏等等，都是珍贵的宝物。\n游灵隐，看飞来峰，背依北高峰，面迎飞来峰，两峰挟峙，山地平缓，四周林青木秀，鸟鸣山幽，云飘雾浮。");
        places[13].setIntroduction("双龙风景区素以林海莽原、奇异洞景、道教名山著称于世，全区共有景点151处，其中自然景点134处，人文景观17处，最为有名的自然景观是四洞，分别以“卧舟”、“观瀑”、“赏石”、“探险”四种特殊游览方式扬名于世的双龙洞、冰壶洞、朝真洞和仙瀑洞，并有奇趣盎然的桃源洞。");
        places[14].setIntroduction("素有“大树华盖闻九州”之誉的天目山，地处浙江省西北部临安市境内，浙皖两省交界处，距杭州84公里，在杭州至黄山黄金旅游线中段。主峰仙人顶海拔1506米。古名浮玉山，“天目”之名始于汉，有东西两峰，顶上各有一池，长年不枯，故名。是韦陀菩萨的道场。\n动植物种类繁多，珍稀物种荟萃，为国家教学科研重要基地。被国家授予“全国青少年科技教育基地”、“全国科普教育基地”。天目山峰恋叠翠，古木葱茏，有奇岩怪石之险，有流泉飞瀑之胜，素负“大树王国”“清凉世界”盛名，为古今揽胜颐神胜地。天目千重秀，灵山十里深，她赋予人类享之不竭的璀璨文化与独特的大自然风韵。");
        places[15].setIntroduction("景区简介浙西大峡谷，位于浙江（浙）安徽（皖）接壤的临安市清凉峰国家级自然保护区区域内。地处浙江西北部而名“浙西”。峡谷境内山高水急，山为黄山延伸的余脉水为钱塘江水系的源流。环带状的狭谷全长83公里，沿途花木遍地，地貌奇特，奇峰秀石“生长”在落差悬殊的峡谷两旁悬崖，有“白马岩中出，黄牛壁上耕”之誉，与长江三峡相比，自有不同诗情画意的领略。");
        places[16].setIntroduction("雷峰塔（Leifeng Pagoda）又名皇妃塔、西关砖塔，位于浙江省会杭州市西湖风景区岸夕照山的雷峰上。雷峰塔为吴越忠懿王钱弘俶因黄妃得子建，初名“皇妃塔”因地建于雷峰，后人改称“雷峰塔”。\n中国民间故事《白蛇传》中，法海和尚骗许仙至金山，白娘子水漫金山救许仙，被法海镇在雷峰塔下。后小青苦练法力,终于打败了法海，雷峰塔倒塌，白素贞获救。\n旧雷峰塔已于1924年倒塌，后重建，新建的雷峰塔为中国首座彩色铜雕宝塔。雷峰夕照为西湖十景之一。");
        places[17].setIntroduction("杭州宋城景区是中国大陆人气最旺的主题公园（由国际主题公园及景点行业权威组织TEA评选），年游客逾700万人次。\n秉承“建筑为形，文化为魂”的经营理念，园区内宋河东街、土豪家族、胭脂巷、非来巷、美食街、市井街六大主题街区华丽升级，热闹非凡；大宋博文化体验馆、柳永风月阁、七十二行老作坊等崭新亮相；活着的清明上河图、聊斋惊魂鬼屋、步步惊心鬼屋、人皮客栈听音室等高科技体验项目惊喜不断；土豪家族尝现打年糕、览古法木榨油、吃手工豆腐，寻找父辈的记忆；更有一年四季活动不断。《宋城千古情》是杭州宋城景区的灵魂，金戈铁马，美女如云。园区内大型实景演出《丽江恋歌》、《王员外家三小姐彩楼抛绣球》、《穿越快闪秀》、《风月美人》等二十大演艺秀，给游客带来独特的游览体验。");
        places[18].setIntroduction("嵊泗列岛，即嵊泗县，位于杭州湾以东、长江口东南，由钱塘江与长江入海口汇合处的数以百计的岛屿群构成，包括大洋山、小洋山、沈家湾岛、薄刀嘴岛等404多个大小岛屿，其中有人居住的岛屿16个。最大的岛屿泗礁山，面积21.2平方公里。\n嵊泗列岛是全国唯一的国家级列岛风景名胜区，素有“海上仙山”的美誉，具有“碧海奇礁、金沙渔火”等原生态旅游特点，已被认定的风景点有50多处。");
        places[19].setIntroduction("古堰画乡景区，位于浙江省丽水市莲都区碧湖镇和大港头镇境内，距丽水市区二十公里，核心区块包括大港头、堰头、坪地和保定范围，历史文化积淀深厚，氛围浓厚。龙丽、丽龙高速公路在此有出口，53，50省道贯穿全境，通过金温铁路丽水站接轨全国铁路大动脉，交通便捷，距中国最大的小商品城义乌只有100多公里。古堰画乡把一个生态和人文的丽水完整地传达给世人。");
        places[20].setIntroduction("东栅以原汁原味的水乡风貌和千年积淀的文化底蕴成为江南古镇中的佼佼者，以河成街，街桥相连，依河筑屋，水镇一体，组织起水阁、桥梁、石板巷、茅盾故居等独具江南韵味的建筑因素，体现了中国古典民居“以和为美”的人文思想。");
        places[21].setIntroduction("宁波老外滩坐落于浙江省宁波市三江口北岸的江北区。宁波老外滩于1844年开埠， 地处宁波市中心，位于甬江、奉化江和余姚江的三江汇流之地，唐宋以来就是最繁华的港口之一，曾是“五口通商”中最早的对外开埠区，比上海外滩还早20年。是目前国内仅存的几个具有百年历史的外滩之一。宁波老外滩于1992年后开发，宁波老外滩已经成为长三角大景观之一。");
        places[22].setIntroduction("天一阁博物馆是以天一阁为主体、以藏书文化为特色的专题性博物馆，占地2.6万平方米，由藏书文化区、园林休闲区、陈列展览区三大功能区组成，为全国重点文物保护单位、全国古籍重点保护单位、中国十大历史文化名楼和国家AAAA级人文旅游胜地。\n1994年宁波博物馆与天一阁文保所合并，建立天一阁博物馆。该馆毗邻风光秀美的月湖，是我国现存历史最久的藏书楼，是亚洲现存最古老的图书馆，也是世界上现存最古老的三大家族图书馆之一。而今已扩展为藏书文化、陈列展览、园林休闲三大功能区，融藏书文化、社会历史、文化艺术于一体，成为展示宁波历史文化的窗口。");
        places[23].setIntroduction("兰亭，位于浙江省绍兴市西南14公里兰亭镇的兰渚山下，是东晋著名书法家，会稽内史王羲之的园林住所，是一座晋代园林。这一带“崇山峻岭，茂林修竹，又有清流激湍，映带左右”，是山阴道上的风景佳丽之处。相传春秋时越王勾践曾在此植兰，汉时设驿亭，故名兰亭。\n现址为明嘉靖二十七年（公元1548年），郡守沈启重建，其后几经改建，于1980年修复成明清园林的风格。");
        places[24].setIntroduction("中南百草原（中南百草园）景区位于“中国美丽乡村”——浙江省安吉县境内，是国家AAAA级旅游景区，先后获得了国家级青少年户外体育活动营地、全国十大休闲农庄、全国野生动物保护科普教育基地等众多荣誉，目前已列入国家5A级景区培育名单。\n中南百草原占地5600亩，拥有森林、草原、湿地、竹海、野生动物等生态资源以及餐饮、会议、住宿、娱乐、养生、拓展等众多产品，农业、林业、生态、体育、科普等与旅游完美结合，成为以植物世界、动物世界和运动世界为三大主题的综合性旅游景区，游客量连续6年突破百万人次，是长三角地区发展创新迅速，深受游客欢迎的十大景区之一。\n植物世界由碧水晨曦、丹枫流霞、百草映雪等八景和白茶园、桂花园、紫竹园、采摘果园、淡竹林等十八园组成，植物品种有2000种，珍稀植物有30多种，景区植被覆盖率达95%，是天然的绿色大氧吧。动物世界内有150种动物，游客可观赏到老虎、狮子、大象、长颈鹿等70种国家珍奇野生动物，同时还可以领略到狮虎献艺、海狮杂技等精彩表演。运动世界有户外拓展、森林骑马、F1卡丁车、真人CS野战、攀岩、高空溜索、湿地漂流等各类运动项目50多种，以及大型游乐场——中南欢乐世界和儿童乐园共21个项目组成，游客可在此体验极致的欢乐与刺激。\n除游乐、观赏项目外，景区还设有中南旅游饭店、烧烤场，供应竹乡特色菜肴和野味，鲜香可口。而座落于涌泉湖畔的度假酒店则堪称世外桃源，绿树成荫，环境优美。");
        places[25].setIntroduction("诸葛村，又名八卦村。位于兰溪市西部18公里处，有330国道途经该村，交通便捷，是兰溪与国家级风景名胜区“二江（新安江、富春江）一湖（千岛湖）一山（黄山）一草（兔耳岭）”衔接的接点和必经之地。\n诸葛八卦村是迄今发现的诸葛亮后裔的最大聚居地。村中建筑格局按“八阵图”样式布列，且保存了大量明清古民居，是国内仅有、举世无双的古文化村落。\n北纬29.5，东经119.2。该村地形中间低平，四周渐高，形成一口池塘。池是诸葛八卦村的核心所在，也是布列“八阵图”的基点。");
        places[26].setIntroduction("云和梯田集旅游休闲、摄影观光、民俗欣赏于一体的云和县首批4A级旅游景区。景区位于崇头镇，距县城5公里，最早开发于唐初，兴于元、明，距今有1000多年历史，总面积51平方公里，主要分布在云和县崇头镇周围高山上，海拔跨度为200米—1400多米，垂直高度1200多米，跨越高山、丘陵、谷地三个地质景观带，最多有700多层，是华东最大的梯田群，被誉为“中国最美梯田”，是中国摄影之乡——丽水的主要采风基地，景区拥有梯田、云海、山村、竹海、溪流、瀑布、雾凇等自然景观，“云雾奇观，浮云世界”是云和梯田的一大特色亮点。");
        places[27].setIntroduction("长屿硐天，位于浙江台州湾南隅温岭市东北，坐落举世闻名的“石板之乡”新河镇长屿村境内，为省级风景名胜区，是规模最大的人工开凿石硐。一九九八年四月荣获世界吉尼斯之最，二00二年四月被国家旅游局评为国家AAAA旅游区。由八仙岩、双门硐、崇国寺和野山四大景区组成。是南北朝以来人工开采石板后形成的石文化景观，历经1500余年，共凿出了28个硐群，1314个硐体。");
        places[28].setIntroduction("大明山风景名胜区为国家AAAA级风景名胜区，大明山位于临安西部顺溪镇，面积约29平方公里。风景区以大明山为主体，共有32峰、13涧、8瀑。此山多奇峰怪石，森耸峭拔，足称名胜。有一巨石，平坦如榻，相传朱元璋起义兵败至此，曾卧石上，故名“天子石”，朱元璋屯垦时曾登台拜将， 故山顶有点将台，朱元璋屯军千亩田，招兵买马，生聚训练，养精蓄锐，然后杀下山去，打下大明江山，故此山称为大明山。");
        places[29].setIntroduction("鲁迅故里，国家AAAAA级旅游景区，全国优秀社会教育基地，全国百个爱国主义教育示范基地，浙江省文明示范博物馆。\n鲁迅故里位于浙江省绍兴市鲁迅中路，是原汁原味解读鲁迅作品，品味鲁迅笔下风物，感受鲁迅当年生活情境的真实场所，是绍兴市区保存最完好、最具文化内涵、水乡古城经典风貌和独具江南风情的历史街区，占地50公顷，总投资10亿元。\n鲁迅故里由鲁迅纪念馆演化而来，如今已初具规模，不仅再现了鲁迅当年生活的故居、祖居、三味书屋、百草园的原貌，还可看到鲁迅祖居从未对外开放的西厢房和近期恢复的周家新台门、寿家台门、土谷祠、鲁迅笔下风情园等一批与鲁迅有关的古宅古迹，是立体解读中国近代文豪鲁迅先生的场所，是浙江绍兴的“镇城之宝”。");
        places[30].setIntroduction("上海滨江大道于1997年建成，全长2500米，从泰东路沿黄浦江一直到东昌路，与浦西外滩隔江相望，是集观光、绿化、交通及服务设施为一体的沿江景观工程。它由亲水平台、坡地绿化、半地下厢体及景观道路等组成。凭栏临江，浦东两岸百舸争流，和外滩万国博览建筑群的动与静的结合，给人们无限的遐想，有一种移步拾景的意境，它犹如一条彩带飘落在黄浦江的东岸，被人们赞誉为浦东的新外滩。是集观光、绿化、交通及服务设施为一体，着眼于城市生态环境和功能的沿江景观工程。滨江大道由亲水平台、坡地绿化、半地下厢体及景观道路等组成，是面向二十一世纪的上海东外滩。");
        places[31].setIntroduction("锦江乐园是中国上海第一家大型现代化游乐园，占地面积170亩，共有40项游乐项目，适合各种年龄游客游玩，每年接待游客100万人次左右。1998年共投资9000余万元，相继建成了全国独创的具国际水平的“欢乐世界”和“峡谷漂流”两项目，大大改变了锦江乐园的面貌，使锦江乐园的吸引力明显增强。");
        places[32].setIntroduction("上海虹口区的甜爱路，被誉为上海“最浪漫”的道路。路口设一只特别的爱情邮筒（爱心邮筒），从这座爱心邮筒投出的每一封信函，都将被盖上一枚英文爱的邮戳，让收件人通过这个邮戳感受一份爱心与浪漫，留作永久的纪念和收藏。邮筒、邮戳，和道路两侧由28首中外著名爱情诗篇组成的“爱情墙”，将让这条浪漫之路在2009年焕发出新的甜蜜气息。其独有的寂静和舒缓的情调浸透其间。这里被誉为“上海最浪漫的马路”，与山阴路不同的是，甜爱路两边多有围墙，抵挡了视线，于是又增添了几分神秘，那可是一个恋人甜蜜拥吻的好去处。");
        places[33].setIntroduction("上海新天地是一个具有上海历史文化风貌，中西融合的都市旅游景点，它以上海近代建筑的标志石库门建筑旧区为基础，首次改变了石库门原有的居住功能，创新地赋予其商业经营功能，把这片反映了上海历史和文化的老房子改造成餐饮、购物、演艺等功能的时尚、休闲文化娱乐中心。漫步新天地，仿佛时光倒流，有如置身于二十世纪二、三十年代的上海，但一步跨进每个建筑内部，则非常现代和时尚，亲身体会新天地独特的理念，这有机的组合与错落有致地巧妙安排形成了一首上海昨天、明天、今天的交响乐，让海内外游客品味独特的文化。");
        places[34].setIntroduction("吴江路是上海唯一一条人车分流、呈双层步行街的立体休闲街。位于地铁二号线的南京西路站的出口处，是平行于南京西路的一条小马路，全长不过200余米。近年来，经改造已成为时尚的食街，沿途有造型独特别致的流动售货车和可移动的花坛、树木等。这里集地铁交通、购物休闲、旅游观光和广场文化为一体，是上海受人瞩目的一条特色休闲街。");
        places[35].setIntroduction("上海科技馆是上海市人民政府为贯彻落实科教兴国战略，提高城市综合竞争力和市民科学文化素养而投资兴建的具有中国特色、时代特征、上海特点的综合性的自然科学技术博物馆，是对公众进行科普教育的公益性机构，是中国重要的科普教育基地和精神文明建设基地。");
        places[36].setIntroduction("上海人民广场位于上海黄浦区，是上海的政治、经济、文化、旅游中心和交通枢纽，也是上海最为重要的地标之一。成形于上海开埠以后，原来称上海跑马厅，是当时上层社会举行赛马等活动的场所。广义上的人民广场主要是由一个开放式的广场、人民公园以及周边一些文化、旅游、商业建筑等组成。位于上海市中心的人民广场总面积达14万平方米，过去作为全市人民游行集会的场所，可容纳120多万人。它也是318国道的起点。");
        places[37].setIntroduction("上海市城隍庙（City God Temple of Shanghai），道教庙宇，位于黄浦区方浜中路，为“长江三大庙”之一 。城隍，又称城隍神、城隍爷。是中国宗教文化中普遍崇祀的重要神祇之一，由有功于地方民众的名臣英雄充当，是中国民间和道教信奉守护城池之神。");
        places[38].setIntroduction("上海大剧院于1998年8月27日开业，位于市中心人民广场，毗邻上海市人民政府、上海博物馆，占地面积约为2.1公顷，建筑风格独特，造型优美。上海大剧院是上海的标志性建筑物，它的建成使得人民广场成为上海名副其实的政治文化中心。大剧院成功上演过歌剧、音乐剧、芭蕾、交响乐、室内乐、话剧、戏曲等各类大型演出和综艺晚会，正日益成为上海重要的中外文化交流窗口和艺术沟通的桥梁。");
        places[39].setIntroduction("静安寺，又称静安古寺，位于上海市静安区，其历史相传最早可追溯至三国孙吴赤乌十年（247年），初名沪渎重玄寺。宋大中祥符元年（1008年），更名静安寺。南宋嘉定九年（1216年），寺从吴淞江畔迁入境内芦浦沸井浜边（今南京西路），早于上海建城。静安寺总建筑面积达2.2万平方米，整个庙宇形成前寺后塔的格局，由大雄宝殿、天王殿、三圣殿三座主要建筑构成，是上海最古老的佛寺。寺内藏有八大山人名画、文征明真迹《琵琶行》行草长卷。静安区亦由静安寺而闻名于世。静安寺的建筑风格是仿明代以前的建筑风格，典型的代表就是斗拱的形制。静安寺是汉族地区佛教全国重点寺院之一，上海市真言宗古刹之一，上海市文物保护单位。");
        places[40].setIntroduction("上海动物园位于上海市长宁区虹桥路2381号，紧邻上海虹桥国际机场。始建于1954年，原名西郊公园。上海动物园属于国家级大型动物园，占地面积74.3万平方米，饲养展出动物400余种，饲养展出动物的馆舍面积有47237平方米。是全国十佳动物园之一，中国第二大城市动物园。");
        places[41].setIntroduction("上海银七星室内滑雪场，是由上海大顺北海道滑雪有限公司投资兴建的首家专业的室内滑雪场馆，其规模目前为亚洲第一。滑雪场总占地面积100，800平方米，一期项目建筑面积52，000平方米。整个滑雪道长380米，宽80米，最大落差达42米，共分三段坡道(12°、15°、17°)和一个练习大平台，可供不同程度的滑雪爱好者使用。整个雪场面积为25000多平方米，可供近千名游客滑雪。雪场内温度终年保持在-2℃以下，积雪厚度从30cm至50cm不等。让滑雪爱好者遗憾的是作为上海唯一一家室内滑雪场，位于七莘路的银七星滑雪场还在扩展装修，无雪可滑的现状还要持续一段时间。新的场馆可最多容纳1000人，将在2017年开始营业。");
        places[42].setIntroduction("上海从全球三十几个候选城市中脱颖而出，成为全球第6座杜莎夫人蜡像馆的落脚地，杜莎集团看中的是中国巨大的明星优势和广阔的市场前景。通过详细精确的市场调查，在冗长的候选名人名单中精挑细选，每位入选者都是大多数中国人渴望见到的名人。 在上海杜莎夫人蜡像馆分为“在幕后”、“上海魅力”、“历史名人和国家领袖”、“电影”、“音乐”、“运动”和“速度”七个主题展区，观众除了可以与80多尊足以乱真的中外明星蜡像留下亲密合影外，还可以加入到与“明星”对歌、拍电影、打篮球等互动体验中去。");
        places[43].setIntroduction("七宝镇，位于上海市西南部，是一座既有江南水乡自然风光，又有悠久人文内涵的历史古镇。东临漕河泾高新技术开发区，西接松江、青浦，南靠上海市莘庄工业区，北邻虹桥国际机场。境内七莘路、漕宝路、吴中路、顾戴路、中春路、沪青平路等纵横环道成网，有91路、92路、911路等10余条公交线路起讫或经过；2005年，从市区途径七宝至松江新城的轨道交通申松线也正式通行。全镇地域面积21.3平方公里，有9个行政村，39个居委会，人口20余万。");
        places[44].setIntroduction("上海临江公园位于友谊路1号，因濒临长江而得名，是宝山的标志性公园。东临长江，西接友谊路和南门街，北为居民住宅及农田，原宝山县护城河南北纵贯园东部，然后向西折，成为公园南部界河。1956年利用残存的孔庙大成殿和清代形成的土山建成公园。公园内有一段仅存的宝山古城墙和一座古代水关，1992年建立了陈化成纪念馆，随后又相继设立了“姚子青营牺牲地纪念石”。全园分十个景区，以山水造景为主，呈现出江南古典园林的艺术风格。");
        places[45].setIntroduction("秋霞圃，中国南方古典园林艺术的又一代表，一般认为是南宋时期修建的秋霞圃同时也是上海五大园林之一，并以其布局精致、环境幽雅，小巧玲珑的特点而受到广大游客喜爱。而其建筑风格中的“小中见大”、曲折有致特点吸引了广大建筑学家们研究。");
        places[46].setIntroduction("枫泾古镇是隶属于上海市金山区，位于上海市西南，与沪浙五区县交界，是上海通往西南各省的最重要的“西南门户”。枫泾镇是中国历史文化名镇，亦为新沪上八景之一，历史上因地处吴越交汇之处，素有吴越名镇之称；枫泾为典型的江南水乡古镇。古镇周围水网遍布，镇区内河道纵横，桥梁有52座之多，现存最古的为元代致和桥，距今有近700年历史。枫泾全镇有29处街、坊，84条巷、弄。至今仍完好保存的有和平街、生产街、北大街、友好街四处古建筑物，总面积达48750平方米，是上海地区现存规模较大保存完好的水乡古镇。");
        places[47].setIntroduction("上海马戏城坐落在静安区共和新路上，南侧紧靠大宁久光百货，北侧紧邻大宁灵石公园，占地面积2.25公顷，是上海市区的文化、体育、娱乐中心。马戏城以杂技场为主体建筑，配有排练辅助楼、兽房和文化商业城等配套设施。上海马戏城，有“中国马戏第一城”的美誉， 其独特的建筑造型，金灿灿的穹型屋顶，是上海国际文化都市又一标志性建筑。");
        places[48].setIntroduction("上海植物园位于徐汇区西南部，前身为龙华苗圃，是一个以植物引种驯化和展示、园艺研究及科普教育为主的综合性植物园。1974年起筹建，1980年1月1日正式建园，占地81.86公顷。展览区设植物进化区、盆景园、草药园、展览温室、兰室和绿化示范区等15个专类园。上海植物园是国家AAAA级旅游景区。1996年，上海植物园被驻沪海外人士评为最喜爱的郊游目的地，2000年又被评为新千年“六一”好去处。");
        places[49].setIntroduction("陕西南路（South Shaanxi Road）是中国上海市黄浦区（原卢湾区）、徐汇区、静安区3区交界处的一条重要街道，南北走向，北起延安中路，南到肇嘉浜路，全长2360米。宽15米到19.7米。在1915年到1943年之间名为亚尔培路。");
        places[50].setIntroduction("上海音乐厅原名南京大戏院，建于1930年，当年3月26日开业。 1950年更名为北京电影院。1959年再更名为上海音乐厅至今。现今的音乐厅是从原址整体平移过来的，完好地保留了原貌。欧式风格的建筑，气派十足；幽雅庄重的装修，很典雅。无论是乐队演奏还是歌剧表演，大跨度的穹顶还原了真实的音色，配上极佳的音响设备，音色丰满，乐声圆润，效果惊人。音乐厅价格虽高，但所能感受的艺术是无价的。");
        places[51].setIntroduction("龙华寺位于上海市南郊龙华街道，是上海地区历史最久、规模最大的古刹。龙华寺的名称来源于佛经中弥勒菩萨在龙华树下成佛的典故。据传龙华寺是三国时期孙权为其母所建，距今已有1700多年，然而有文献记载可考的历史是龙华寺建于北宋太平兴国二年（公元977年）。北宋治平三年（公元1066年），龙华寺更名为“空相寺”，如今尚有赐“空相寺”额、今寺碑残石留存。明永乐年间（公元1403—1424年）恢复了原名“龙华寺”。明万历二年（1574）赐名“大兴国万寿慈华禅寺”，寺名仍沿用龙华寺。1953年由上海市佛教协会复制各殿佛像，重修各殿宇，新建藏经楼等。寺西之桃园于民国十七年（1928年）辟为血华公园，后改名为龙华公园，今为龙华烈士陵园的一部分。1959年，龙华寺被列为上海市文物保护单位。");
        places[52].setIntroduction("热带风暴水上乐园，位于上海市新镇路顾戴路口，占地130亩。园中营造了湖泊、河流、沙滩，拥有30多种惊险、刺激的水上游乐项目，是目前亚洲最大的露天水上乐园之一。");
        places[53].setIntroduction("吴淞炮台湾湿地森林公园：总面积为53.46公顷的吴淞炮台湾湿地森林公园位于宝山区东部，背山面水，东临长江、黄浦江，西倚炮台山，南迄塘后支路，北至宝杨路，沿江的岸线长达1974.13米，其西南角是著名的吴淞口，清朝时借此地形建造水师炮台，所以得名为炮台湾。该公园的设计突出生态恢复及文化重建理念，不仅让原有的滩涂湿地在设计中得到有效的保护，并在沿江岸线一侧利用大小生态岛的组合及潮起潮落的水位变化，营造11公顷的迷人湿地景观。");
        places[54].setIntroduction("徐家汇公园是一座开放式公园绿地。地处繁华的上海市徐家汇城市副中心，位于肇嘉浜路、天平路、衡山路及宛平路之间，北起衡山路、南至肇嘉浜路、西临天平路、东近宛平路。公园占地面积约为8.47公顷，分三期实施建设：一期为原大中华橡胶厂地块，约为3.3公顷；二期是原中国唱片厂地块，约为3.7公顷；三期为宛平路周边旧居民住宅地块，约为1.47公顷。公园建于2000年，保留了橡胶厂烟囱、唱片厂办公楼，传承历史记忆。设计布局呈上海版图形状，模拟黄浦江等水域，并有近200米长的天桥贯通。");
        places[55].setIntroduction("共青森林公园位于上海市杨浦区，东濒黄浦江，西临军工路，全园总占地1965亩，开放公共绿地1870.6亩，其中北园“共青森林公园”1631亩，南园“万竹园”239.6亩。上海共青国家森林公园是以森林为主要景观的特色公园，共种植200余种树木，总数达30多万株。公园分为南北两园，北园占地1631亩称为共青森林公园，南园占地239.6亩称为万竹园。南北园风格各异，北园着重森林景色，有丘陵湖泊草地，南园则小桥流水一派南国风光。除观景之外，游人也可在园内骑马，烧烤和垂钓。");
        places[56].setIntroduction("上海长风公园位于上海市大渡河路189号，东邻华东师范大学，南近吴淞江(苏州河)，西靠大渡河路，北临怒江路。始建于1956年，1959年国庆节建成开放。面积36.6万平方米，其中水面积14.3万平方米，是上海市大型的综合性山水公园。长风海洋世界坐落在风景优美的长风公园内，它是隶属于澳大利亚澳洋集团旗下，集大型海洋动物表演与水族馆鱼类展览为一体的综合海洋主题公园。澳洋国际集团在水族馆行业中是全球最大的集团公司在全球共拥有六个水族馆分别位于澳大利亚阳光海岸、澳大利亚墨尔本、韩国釜山、中国上海、泰国曼谷、中东阿联酋迪拜而在加拿大多伦多的水族馆项目正在筹建中。");
        places[57].setIntroduction("铜仁路(Tongren Lu) 在静安区南部。南起延安中路，北至北京西路。长659米，宽12.3～16.8米，车行道宽6.7～12.5米。民国3年(1914年)筑，以英籍犹太人名命名哈同路(Hardoon Road)。民国32年以贵州铜仁改今名。沿路为住宅，有市水利局、市规划设计院等。铜仁路是有着它值得记忆的历史的，这条路上原先有一条叫慈厚里的弄堂，慈厚里最早叫民厚里。里面曾经住过毛泽东、施蛰存、戴望舒、田汉、张闻天、郁达夫等名人，如今，慈厚里已经永远地成为了历史名词，被记在了地方志和人们越来越淡的记忆里，而原址上已高高耸立起一幢大楼嘉里中心。 ");
        places[58].setIntroduction("上海世纪公园，位于浦东新区花木行政文化区，东邻芳甸路，南临花木路，北靠锦绣路，占地面积140.3公顷，是上海市中心区域内最大的城市生态公园。公园总体规划方案由英国LUC公司设计，设计思想体现了中西方文化、人与自然相互融合的理念，公园建设总投资10亿元人民币。公园以大面积的草坪、森林、湖泊为主体，建有七大景区，分别是乡土田园区、观景区、湖滨区、疏林草坪区、鸟类保护区、异国园区和迷你高尔夫球场区；并建有景点53处，分别是世纪花钟、镜天湖、大喷泉、绿色世界浮雕、音乐喷泉、音乐广场、缘池、鸟岛、奥尔梅加头像和蒙特利尔园等。世纪公园绿地面积86万平方米，水体面积27万平方米，道路总长度为16公里，道路面积7.3万平方米，广场面积8.5万平方米，其他均为建筑面积及停车场。公园内共有乔木8万株，灌木74万株，草坪71万平方米。公园犹如一枚绿色的翡翠镶接于壮观的世纪大道终点，充分体现了“人、自然、和谐”的主题。");
        places[59].setIntroduction("“莫干山路50号”是上海最出名的“艺术家群落”,聚集了一批有名的无名的画家和画廊。");
    }

}
