package com.prj.server.util;

import com.alibaba.druid.pool.DruidDataSourceFactory;


import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCUtil {
    private static DataSource ds;

    static {
        try {
            //加载配置文件
            Properties pro = new Properties ();
            //获取流
            InputStream in = JDBCUtil.class.getClassLoader ().getResourceAsStream ("database.properties");
            if(in != null)
            pro.load (in);
            ds = DruidDataSourceFactory.createDataSource (pro);
        } catch (Exception e) {
            e.printStackTrace ( );
        }

    }

    /*获取链接*/
    public static Connection getConnection() throws SQLException {
        return ds.getConnection ();
    }

    /*获取DataSource对象*/
    public static DataSource getDs() {
        return ds;
    }
}
