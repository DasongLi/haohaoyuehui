package com.example.pro.test1;

/**
 * Created by liyanzhen on 16/7/20.
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import android.util.Log;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

public class Util {
    final static String DRIVER_NAME = "com.mysql.jdbc.Driver";

    public static void go() {
        String user = "root";//SSH连接用户名
        String password = "SJTUmdzz+++";//SSH连接密码
        String host = "106.14.214.239";//SSH服务器
        int lport = 33104;//本地端口（随便取）
        String rhost = "localhost";//远程MySQL服务器
        int rport = 3306;//远程MySQL服务端口
        int port = 22;//SSH访问端口
        Log.e("==","成功7688");
        try {
            JSch jsch = new JSch();
            Session session = jsch.getSession(user, host, port);
            session.setPassword(password);
            session.setConfig("StrictHostKeyChecking", "no");
            session.connect();
            Log.e("=======>", "服务器连接成功");
            System.out.println(session.getServerVersion());//这里打印SSH服务器版本信息
            int assinged_port =session.setPortForwardingL(lport, rhost, rport);//将服务器端口和本地端口绑定，这样就能通过访问本地端口来访问服务器
            System.out.println("localhost:" + assinged_port + " -> " + rhost + ":" + rport);
        } catch (Exception e) {
            Log.e("==","成功");
            e.printStackTrace();
        }
    }
    public static Connection openConnection(String url, String user,
                                            String password) {
        Connection conn = null;
        try {
            final String DRIVER_NAME = "com.mysql.jdbc.Driver";
            Class.forName(DRIVER_NAME);
            conn = DriverManager.getConnection(url, user, password);
            Log.e("=====连接结果=======", "数据库连接成功");
        } catch (ClassNotFoundException e) {
            Log.e("=====连接结果=======", "报ClassNotFoundException异常");
            conn = null;
        } catch (SQLException e) {
            Log.e("=====连接结果=======", "报SQLException异常");
            conn = null;
        }

        return conn;
    }

    public static void query(Connection conn, String sql) {
        if (conn == null) {
            return;
        }
        Statement statement = null;
        ResultSet result = null;
        try {
            statement = conn.createStatement();
            result = statement.executeQuery(sql);
            System.out.println(result);
            if (result != null && result.first()) {
                int idColumnIndex = result.findColumn("id");
                int nameColumnIndex = result.findColumn("account");
                System.out.println("id\t\t" + "account");
                while (!result.isAfterLast()) {
                    System.out.print(result.getString(idColumnIndex) + "\t\t");
                    System.out.println(result.getString(nameColumnIndex));
                    result.next();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (result != null) {
                    result.close();
                    result = null;
                }
                if (statement != null) {
                    statement.close();
                    statement = null;
                }} catch (SQLException sqle) {
                sqle.printStackTrace();
            }
        }
    }
    public  static String getpassword(Connection conn, String sql) {
        //if (conn == null) {
        //    return;
       // }
        Statement statement = null;
        ResultSet result = null;
        try {
            statement = conn.createStatement();
            result = statement.executeQuery(sql);
            System.out.println(result);
            if (result != null && result.first()) {
                int passwordColumnIndex = result.findColumn("password");
                System.out.print(result.getString(passwordColumnIndex) + "\n");
                return result.getString(passwordColumnIndex).toString();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (result != null) {
                    result.close();
                    result = null;
                }
                if (statement != null) {
                    statement.close();
                    statement = null;
                }} catch (SQLException sqle) {
                sqle.printStackTrace();
            }
        }
        return "not found";
    }
    public static boolean execSQL(Connection conn, String sql) {
        boolean execResult = false;
        if (conn == null) {
            return execResult;
        }
        Statement statement = null;
        try {
            statement = conn.createStatement();
            if (statement != null) {
                execResult = statement.execute(sql);
            }
        } catch (SQLException e) {
            execResult = false;
        }
        return execResult;
    }
}