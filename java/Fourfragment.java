package com.example.pro.test1;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;

/**
 * Created by pro on 2017/5/14.
 */

public class Fourfragment extends Fragment {
    public User user1;
    private ImageButton imageButton;
    private ImageView imageView;
    private View headerview;
    private NavigationView navigationView;
    public Fourfragment() {

    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        return inflater.inflate(R.layout.fragment_four, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        user1 = new User("李大松","123456","ldslds","这个人很懒，什么都没有写","我是李大松，来自上海交大，今年大二、、、",20,"上海",true);
        //imageButton = (ImageButton) getActivity().findViewById(R.id.imageView5);
        navigationView = (NavigationView) getActivity().findViewById(R.id.navigation);
        headerview = navigationView.getHeaderView(0);
        //imageButton = (ImageButton) headerview.findViewById(R.id.imageView5);
        imageView = (ImageView) headerview.findViewById(R.id.imageView5);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Userdetail.class);//activity
                Bundle bundle = new Bundle();

                //bundle.putInt("ItemImage", placess[position].image);
                bundle.putString("user_name",user1.name);
                bundle.putString("signature",user1.signature);
                bundle.putString("introduction",user1.introduction);
                bundle.putString("place",user1.place);
                bundle.putBoolean("sex",user1.sex);
                bundle.putInt("age",user1.age);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        //imageButton.setOnClickListener();
    }
}
