package com.example.pro.test1;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by pro on 2017/5/24.
 */

public class postdetail extends AppCompatActivity {
    private TextView textView1,textView2,textView3;
    private String tv1,tv2,tv3;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.postdetail);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        final Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbar_detail_post);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        mToolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                int id = item.getItemId();
                switch (id) {
                    case R.id.action_share:
                        Toast.makeText(postdetail.this, "share~~", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.action_like:
                        Toast.makeText(postdetail.this, "like~~", Toast.LENGTH_SHORT).show();
                        break;
                    default:
                        break;
                }
                return true;
            }
        });
        textView1 = (TextView) findViewById(R.id.textView7);
        textView2 = (TextView) findViewById(R.id.textView8);
        textView3 = (TextView) findViewById(R.id.textView9);
        tv1 = bundle.getString("postTitle");
        tv2 = bundle.getString("postType");
        tv3 = bundle.getString("postsummary");
        textView1.setText(tv1);
        textView2.setText(tv2);
        textView3.setText(tv3);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_detail, menu);
        return true;
    }
}
