package com.example.pro.test1;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by pro on 2017/6/14.
 */

public class login extends AppCompatActivity {
    private static final String REMOTE_IP = "localhost:33104";//这里是映射地址，可以随意写，不是服务器地址
    private static final String URL = "jdbc:mysql://" + REMOTE_IP + "/mydatabase";
    private static final String USER = "date";
    private static final String PASSWORD = "yuehui";
    private User user1;
    private Connection conn;
    private Button btn1,btn2;
    private TextView tv_username,tv_password;
    private String password_return;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        tv_username = (TextView) findViewById(R.id.username);
        tv_password = (TextView) findViewById(R.id.password);
        btn1 = (Button) findViewById(R.id.btn_login_to_register);
        btn2 = (Button) findViewById(R.id.btn_login);
        onConnSsh();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        onConn();
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(login.this,signup.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                finish();
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username1;
                username1 = tv_username.getText().toString();
                onpassword(username1);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Log.i("password_return",password_return);
                if (password_return.equals(tv_password.getText().toString() )) {
                    Intent intent = new Intent(login.this,MainActivity.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                conn = null;
            } finally {
                conn = null;
            }
        }
    }

    public void onConnSsh() {

        new Thread() {
            public void run() {
                Log.e("============", "预备连接服务器");
                Util.go();
            }
        }.start();
    }

    public void onConn() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                conn = Util.openConnection(URL, USER, PASSWORD);
                Log.i("onConn", "onConn");
            }
        }).start();
    }

    /*public void onInsert() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                user1 = new User(tv_username.getText().toString(),tv_password.getText().toString(),tv_.getText().toString(),"这个人很懒，什么都没有写","我是李大松，来自上海交大，今年大二、、、",20,"上海",true);
                //Util.go();
                //conn = Util.openConnection(URL, USER, PASSWORD);
                //String sql = "INSERT INTO table_user_info (Id,Password,Account) VALUES (1,\"yyh\",\"yaoyuhang\")";
                String sql="INSERT INTO table_user_info (Id,Password,Account) VALUES ("+String.valueOf(22)+",\""+user1.password+"\",\""+user1.account+"\");";
                //String sql = "INSERT INTO table_user_info (Id,Password,Account) VALUES (1,\"yyh\",\"yaoyuhang\")";
                //String sql="INSERT INTO table_user_info (Id,Password,Account) VALUES ("+String.valueOf(us.id)+",\""+us.password+"\",\""+us.account+"\")";
                Util.execSQL(conn, sql);
                Log.i("onInsert", "onInsert");
            }
        }).start();
    }*/



    public void onDelete() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                String sql = "delete from table_user_info where Id=1;";
                Util.execSQL(conn, sql);
                Log.i("onDelete", "onDelete");
            }
        }).start();
    }

    public void onUpdate() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                String sql = "update table_user_info set Account='baba' where Id=1;";
                Util.execSQL(conn, sql);
                Log.i("onUpdate", "onUpdate");
            }
        }).start();
    }

    public void onQuery() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                Util.query(conn, "select * from table_user_info;");
                Log.i("onQuery", "onQuery");
            }
        }).start();
    }
    public void onpassword(final String name) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                String ss = "\""+name+"\"";
                Log.i("onpass --- ",ss);
                //Toast.makeText(login.this,ss,Toast.LENGTH_SHORT).show();
                String S=Util.getpassword(conn, "select password from table_user_info where Account="+ss+";");
                //String S=Util.getpassword(conn, "select password from table_user_info where Account=\"yaoyuhang\";");
                password_return = S;
                Log.i("onpassword --- ",password_return);
                //Toast.makeText(login.this,S,Toast.LENGTH_SHORT).show();
                /*TextView TextView_1 = (TextView) findViewById(R.id.TextView_1);
                TextView_1.setText(S);*/
            }
        }).start();
    }
}
