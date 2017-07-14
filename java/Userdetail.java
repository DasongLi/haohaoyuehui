package com.example.pro.test1;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by pro on 2017/5/25.
 */

public class Userdetail extends AppCompatActivity {
    private TextView tv1,tv2,tv3,tv4,tv5,tv6,tv7;
    private String t1,t2,t3,t4;
    private Boolean sex;
    private int age;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.userdetail);
        tv1 = (TextView) findViewById(R.id.textview16);
        tv2 = (TextView) findViewById(R.id.textView15);
        tv3 = (TextView) findViewById(R.id.textView11);
        tv4 = (TextView) findViewById(R.id.textView12);
        tv5 = (TextView) findViewById(R.id.textView13);
        tv6 = (TextView) findViewById(R.id.textView14);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        t1 = bundle.getString("user_name");
        t2 = bundle.getString("signature");
        t3 = bundle.getString("introduction");
        t4 = bundle.getString("place");
        age = bundle.getInt("age");
        sex = bundle.getBoolean("sex");

        tv1.setText(t1);
        tv2.setText(t2);
        tv3.setText(t3);
        tv4.setText(t4);
        tv5.setText(Integer.toString(age));
        if (sex) tv6.setText("boy");
        else tv6.setText("girl");
    }
}
