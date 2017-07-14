package com.example.pro.test1;
import android.content.Intent;
import android.location.Location;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationListener;
import com.amap.api.maps.AMap;
import com.amap.api.maps.CameraUpdate;
import com.amap.api.maps.CameraUpdateFactory;
import com.amap.api.maps.LocationSource;
import com.amap.api.maps.MapView;
import com.amap.api.maps.UiSettings;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.CameraPosition;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.Marker;
import com.amap.api.maps.model.MarkerOptions;
import com.amap.api.navi.AMapNavi;
import com.amap.api.navi.AMapNaviListener;
import com.amap.api.navi.AMapNaviView;
import com.amap.api.navi.AMapNaviViewListener;
import com.amap.api.navi.enums.NaviType;
import com.amap.api.navi.model.AMapLaneInfo;
import com.amap.api.navi.model.AMapNaviCameraInfo;
import com.amap.api.navi.model.AMapNaviCross;
import com.amap.api.navi.model.AMapNaviInfo;
import com.amap.api.navi.model.AMapNaviLocation;
import com.amap.api.navi.model.AMapNaviTrafficFacilityInfo;
import com.amap.api.navi.model.AMapServiceAreaInfo;
import com.amap.api.navi.model.AimLessModeCongestionInfo;
import com.amap.api.navi.model.AimLessModeStat;
import com.amap.api.navi.model.NaviInfo;
import com.amap.api.navi.model.NaviLatLng;
import com.autonavi.tbt.TrafficFacilityInfo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by pro on 2017/5/6.
 */

public class placedetail extends AppCompatActivity implements LocationSource,AMapLocationListener {
    private String name;
    private String location;
    private Boolean isvisited;
    private String phone;
    private ListView listView;
    private ImageView imageView;
    private TextView textView, textViewintro;
    private MapView map;
    private AMapNaviView mAMapNaviView;
    private AMapNavi mAMapNavi;
    private MapView mapView;
    private AMap aMap;
    private UiSettings mUiSettings;
    private CameraUpdate mUpdata;
    private Button btn1;
    protected NaviLatLng mEndLatlng = new NaviLatLng(22.652, 113.966);
    //算路起点坐标
    protected NaviLatLng mStartLatlng = new NaviLatLng(22.540332, 113.939961);
    //存储算路起点的列表
    protected final List<NaviLatLng> sList = new ArrayList<NaviLatLng>();
    //存储算路终点的列表
    protected final List<NaviLatLng> eList = new ArrayList<NaviLatLng>();
    private String[] ItemTitle = new String[]{"名字", "地点", "电话", "isvisited"};
    private String[] ItemValue = new String[]{"bool", "wewfrgfdf", "010-3456789", "NO"};
    protected List<NaviLatLng> mWayPointList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.placedetail);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        final Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbar_detail);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        mapView = (MapView) findViewById(R.id.map);//找到地图控件
        mapView.onCreate(savedInstanceState);// 此方法必须重写
        AMap aMap = mapView.getMap();//得到一个map对象

        /*//获取AMapNavi实例
        mAMapNavi = AMapNavi.getInstance(getApplicationContext());
        //添加监听
        mAMapNavi.addAMapNaviListener(this);

        mAMapNaviView = (AMapNaviView) findViewById(R.id.map);
        mAMapNaviView.setAMapNaviViewListener(this);

        //设置模拟导航的行车速度
        mAMapNavi.setEmulatorNaviSpeed(75);

        sList.add(mStartLatlng);
        eList.add(mEndLatlng);*/


        int image = bundle.getInt("ItemImage");
        ItemValue[0] = bundle.getString("Itemname");
        ItemValue[1] = bundle.getString("Itemplace");
        ItemValue[2] = bundle.getString("Itemphone");
        String introduction = bundle.getString("ItemIntroduction");
        Boolean vis = bundle.getBoolean("Itemisvisited");
        if (vis == true) {
            ItemValue[3] = "Yes";
        } else {
            ItemValue[3] = "NO";
        }

        imageView = (ImageView) findViewById(R.id.imageView3);
        imageView.setImageResource(image);
        listView = (ListView) findViewById(R.id.detail_list);
        textView = (TextView) findViewById(R.id.tool_bar_text_detail);
        textView.setText(ItemValue[0]);
        textViewintro = (TextView) findViewById(R.id.tv_introduction);
        textViewintro.setText(introduction);

        //textView = (TextView) findViewById(R.id.tool_bar_text_detail);
        ArrayList<HashMap<String, Object>> listitem = new ArrayList<HashMap<String, Object>>();
        for (int i = 0; i < 4; i++) {
            HashMap<String, Object> map = new HashMap<String, Object>();
            //map.put("ItemImage",ImageList[i]);
            //map.put("ItemTitle",TextList[i]);
            map.put("ItemTitle", ItemTitle[i]);
            map.put("ItemValue", ItemValue[i]);
            listitem.add(map);
        }
        SimpleAdapter listItemAdapter = new SimpleAdapter(this, listitem, R.layout.placeitem,
                new String[]{"ItemTitle", "ItemValue"}, new int[]{R.id.tv1, R.id.tv2});
        listView.setAdapter(listItemAdapter);
        mToolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                int id = item.getItemId();
                switch (id) {
                    case R.id.action_share:
                        Toast.makeText(placedetail.this, "share~~", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.action_like:
                        Toast.makeText(placedetail.this, "like~~", Toast.LENGTH_SHORT).show();
                        break;
                    default:
                        break;
                }
                return true;
            }
        });


        /*btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_SEND);


                //intent.putExtra(Intent.EXTRA_SUBJECT,"I love to share");
                intent.putExtra(Intent.EXTRA_TEXT,"this is a test app share function");
                intent.setType("text/plain");
                //intent.setType("image/*");
                //intent.setFlags(intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(Intent.createChooser(intent,"share"));
                //intent.setType("image/*");
                //intent.putExtra(Intent.EXTRA_SUBJECT,"Share");
                //intent.putExtra(Intent.EXTRA_TEXT,"I have successful shared my message through my app");
                //intent.setFlags(intent.FLAG_ACTIVITY_NEW_TASK);
                //startActivity(Intent.createChooser(intent,getTitle()));
                //startActivity(intent);
            }
        });*/
    }
    private void init() {
        if (aMap == null) {
            aMap = mapView.getMap();
            mUiSettings = aMap.getUiSettings();
            mUiSettings.setZoomControlsEnabled(false);
            mUiSettings.setCompassEnabled(true);
            mUpdata = CameraUpdateFactory.newCameraPosition(
//15是缩放比例，0是倾斜度，30显示比例
                    new CameraPosition(new LatLng(40.043212,116.299728), 15, 0, 30));//这是地理位置，就是经纬度。
            aMap.moveCamera(mUpdata);//定位的方法
            drawMarkers();
        }
    }
    public void drawMarkers() {

        Marker marker = aMap.addMarker(new MarkerOptions()
                .position(new LatLng(0,0))
                .title("八维")
                .icon(BitmapDescriptorFactory
                        .defaultMarker(BitmapDescriptorFactory.HUE_AZURE))
                .draggable(true));
        marker.showInfoWindow();// 设置默认显示一个infowinfow
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_detail, menu);
        return true;
    }


    @Override
    public void onLocationChanged(AMapLocation aMapLocation) {

    }

    @Override
    public void activate(OnLocationChangedListener onLocationChangedListener) {

    }

    @Override
    public void deactivate() {

    }
    @Override
    protected void onResume() {
        super.onResume();
        mapView.onResume();
    }



}