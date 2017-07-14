package com.example.pro.test1;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.jpeng.jptabbar.JPTabBar;
import com.jpeng.jptabbar.anno.NorIcons;
import com.jpeng.jptabbar.anno.SeleIcons;
import com.jpeng.jptabbar.anno.Titles;
import com.hjm.bottomtabbar.BottomTabBar;
import com.jpeng.jptabbar.JPTabBar;
import com.jpeng.jptabbar.anno.NorIcons;
import com.jpeng.jptabbar.anno.SeleIcons;
import com.jpeng.jptabbar.anno.Titles;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;


import static android.R.attr.breadCrumbShortTitle;
import static android.R.attr.left;
import static android.R.attr.right;
import static android.R.attr.singleUser;
import static java.sql.Types.NULL;

public class MainActivity extends AppCompatActivity /*implements View.OnClickListener*/ {

    private final String TAG = "MAPLocation";
    private Boolean isToggle; //private LinearLayout content;
    private EditText addrtext;
    private Button btn, btn1;
    private ImageView imageView;
    private SearchView searchView;
    private DrawerLayout mDrawerLayout;
    private FrameLayout flcontent;
    private ListView lv;
    private List<String> datas;
    public Place[] all_list, zhejiang_list, shanghai_list;
    private String title;
    private String[] city = {"1", "2", "3", "4", "5"};
    private BottomTabBar bottomTabBar;
    private static final int ITEMPAGER = 4;
    private ViewPager mVp;
    private JPTabBar mTabBar;
    private Toolbar mtoolbar;
    private long exitTime = 0;
    private int loginup = 2;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
            setContentView(R.layout.main_v2);
            initView();

            ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
            mVp.setAdapter(adapter);
            mTabBar.setContainer(mVp);
        /*else if (loginup == 1) {
            setContentView(R.layout.main_v2);
            initView();

            ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
            mVp.setAdapter(adapter);
            mTabBar.setContainer(mVp);
        }*/
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            exit();
            return false;
        }
        return super.onKeyDown(keyCode, event);
    }
    private void exit() {
        if ((System.currentTimeMillis() - exitTime) > 2000) {
            Toast.makeText(getApplicationContext(), "再按一次退出程序",
                    Toast.LENGTH_SHORT).show();
            exitTime = System.currentTimeMillis();
        } else {
            finish();
            System.exit(0);
        }
    }
    private void initView() {
        mVp = (ViewPager) findViewById(R.id.vp);
        mTabBar = (JPTabBar) findViewById(R.id.tabbar);
        /*mtoolbar = (Toolbar) findViewById(R.id.toolbar);
        imageView = (ImageView) findViewById(R.id.image_circle);
        imageView.setImageResource(R.drawable.nocircle);
        setSupportActionBar(mtoolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);*/
    }
    //设置标题
    @Titles
    private static final String[] mTitles={"推荐","发现","聊天","我"};

    //设置选中图标
    @SeleIcons
    private static final int[] mSelectIcons={R.drawable.recommend1,R.drawable.find1,R.drawable.chat1,R.drawable.me1};

    //设置未选中图标
    @NorIcons
    private static final int[] mNormalIcon={R.drawable.recommend2,R.drawable.find2,R.drawable.chat2,R.drawable.me2};

    private class ViewPagerAdapter extends FragmentStatePagerAdapter{

        public ViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            /*Bundle bundle=new Bundle();
            bundle.putInt("position",position+1);
            HomeFragment fragment = new HomeFragment();
            fragment.setArguments(bundle);
            return fragment;*/
            switch (position+1) {
                case 1:
                    oneFragment one1 = new oneFragment();
                    return one1;
                    //break;
                case 2:
                    twofragment two = new twofragment();
                    return two;
                    //break;
                case 3:
                    Threefragment three = new Threefragment();
                    return three;
                    //break;
                case 4:
                    Fourfragment four = new Fourfragment();
                    return four;
                    //break;
                default:
                    break;
            }
            oneFragment one = new oneFragment();
            return one;
        }

        @Override
        public int getCount() {
            return ITEMPAGER;
        }
    }

}





