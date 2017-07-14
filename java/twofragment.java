package com.example.pro.test1;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.github.clans.fab.FloatingActionButton;
import com.github.clans.fab.FloatingActionMenu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by pro on 2017/5/14.
 */

public class twofragment extends Fragment {
    private RecyclerView recyclerView;
    private List<String> mDatas;
    private mSimpleAdapter mAdapter;
    private ImageView imageView;
    private Context mcontext;
    private ListView listView;
    private View view;
    private Toolbar mtoolbar;
    private FloatingActionMenu floatingActionMenu;
    private FloatingActionButton button1,button2,button3;
    private post[] postss = new post[] {
            new post("10年老司机恋爱经验总结，6条聊天秘笈大揭秘！","“我和女生聊天都聊什么?“没有话题怎么办?”你需要注意以下6点。","情感类"),
            new post("在第一次约会时必须注意的8件事","想要让一份情感可以从萌芽到发展再长大，那第一次约会这个时机一定要把握好。第一次约会非常重要，也很有讲究，是你能否收获这份情感的决定性一步，" +
                    "如果这一步走好了，那么这份情感也就落入囊中了。","情感类"),
            new post("如何让恋爱百分百成功","要有性格，吃、喝、赌、抽四大恶习中，你至少得保留一样，知道啥叫\"男人不坏，女人不爱\"不？如果你一点恶习都没有，" +
                    "女人就会失去改造你的乐趣，恋爱成功的机率也会大大降低。","情感类"),
            new post("恋爱时，五个现象说明他很爱你","有人说恋爱中的女人特别美丽，因为有爱情的滋润，有男人的呵护。其实一点都不假，在对的时间遇到那个对的他，会把你捧在手心的爱。我们需要恋爱，恋爱时感觉空气都是甜美的。" +
                    "那么恋爱时，哪几个现象表明他真的很投入？很爱你呢？","情感类")

    };
    /*private void  setcontent() {
        postss[0].setcontent("");
    }*/
    public twofragment() {

    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_two, container, false);
        setHasOptionsMenu(true);
        return view;
    }

    /*@Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.mcontext = context;
    }*/

    /*@Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        init_View();
        init_Datas();
        mAdapter = new mSimpleAdapter(this.getActivity(),mDatas);
        recyclerView.setAdapter(mAdapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.getActivity(),LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);
        //设置分割线item
        recyclerView.addItemDecoration(new DividerItemDecoration(this.getActivity(),DividerItemDecoration.VERTICAL_LIST));
    }*/

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        listView = (ListView) getActivity().findViewById(R.id.twofrag_postlist);
        init_View(view);
        /*init_Datas();
        mAdapter = new mSimpleAdapter(this.getActivity(),mDatas);
        recyclerView.setAdapter(mAdapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.getActivity(),LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);
        //设置分割线item
        recyclerView.addItemDecoration(new DividerItemDecoration(this.getActivity(),DividerItemDecoration.VERTICAL_LIST));*/
        add_data(postss);
    }

    /*private void init_Datas() {
        mDatas = new ArrayList<String>();
        for (int i='A';i<='Z';i++) {
            mDatas.add(""+(char)i);
        }
    }*/

    private void init_View(View view) {
        //recyclerView = (RecyclerView) getActivity().findViewById(R.id.recycleview1);

        mtoolbar = (Toolbar) getActivity().findViewById(R.id.toolbar2);
        imageView = (ImageView) getActivity().findViewById(R.id.imageView4);
        imageView.setImageResource(R.drawable.circle);
        //((AppCompatActivity)getActivity()).setSupportActionBar(mtoolbar);
        mtoolbar.inflateMenu(R.menu.toolbar2);
        //((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayShowTitleEnabled(false);
        mtoolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                int itemid = item.getItemId();
                switch (itemid) {
                    case R.id.action_item1:

                        break;
                    case R.id.action_item2:

                        break;
                    case R.id.action_item3:

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
    private void add_data(final post postss[]) {
        ArrayList<HashMap<String, Object>> listitem = new ArrayList<HashMap<String, Object>>();
        for (int i = 0; i < postss.length; i++) {
            HashMap<String, Object> map = new HashMap<String, Object>();
            //map.put("ItemImage",ImageList[i]);
            //map.put("ItemTitle",TextList[i]);
            //map.put("postImage", postss[i].image);
            map.put("postTitle", postss[i].title);
            map.put("postType", postss[i].categary);
            map.put("postsummary", postss[i].summary);

            listitem.add(map);
        }
        SimpleAdapter listItemAdapter = new SimpleAdapter(getActivity(), listitem, R.layout.post_item,
                new String[]{ "postTitle", "postType", "postsummary"}, new int[]{R.id.textView4, R.id.textView6, R.id.textView5});
        listView.setAdapter(listItemAdapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), postdetail.class);//activity
                Bundle bundle = new Bundle();

                //bundle.putInt("ItemImage", placess[position].image);
                bundle.putString("postTitle",postss[position].title);
                bundle.putString("postType",postss[position].categary);
                bundle.putString("postsummary",postss[position].summary);

                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getActivity(),"this is a beautiful post",Toast.LENGTH_SHORT).show();
                return false;
            }
        });
        //floatingActionMenu = (FloatingActionMenu) getActivity().findViewById(R.id.fab);
        //floatingActionMenu.setClosedOnTouchOutside(false);
        //button1 = (FloatingActionButton) getActivity().findViewById(R.id.fab_share);
        //button2 = (FloatingActionButton) getActivity().findViewById(R.id.fab_upload);
        button3 = (FloatingActionButton) getActivity().findViewById(R.id.fab_preview);
        /*button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                
            }
        });*/
    }
    /*@Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        //menu.clear();
        inflater.inflate(R.menu.toolbar2,menu);
        super.onCreateOptionsMenu(menu,inflater);
    }*/

    /*@Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        menu.clear();
        inflater.inflate(R.menu.toolbar2,menu);
        super.onCreateOptionsMenu(menu, inflater);
    }*/
}
