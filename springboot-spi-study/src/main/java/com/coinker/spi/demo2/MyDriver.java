package com.coinker.spi.demo2;


import com.mysql.cj.jdbc.NonRegisteringDriver;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author Cui Shenpeng
 * @Classname MyDriver
 * @Description TODO
 * @Date 2021/6/7 22:17
 */

public class MyDriver extends NonRegisteringDriver implements Driver {
    static {
        try {
            java.sql.DriverManager.registerDriver(new MyDriver());
        } catch (SQLException E) {
            throw new RuntimeException("Can't register driver!");
        }
    }
    public MyDriver()throws SQLException {}

    public Connection connect(String url, Properties info) throws SQLException {
        System.out.println("准备创建数据库连接.url:"+url);
        System.out.println("JDBC配置信息："+info);
        info.setProperty("user", "root");
        Connection connection =  super.connect(url, info);
        System.out.println("数据库连接创建完成!"+connection.toString());
        return connection;
    }
}
//--------------------输出结果---------------------
//        准备创建数据库连接.url:jdbc:mysql:///consult?serverTimezone=UTC
//        JDBC配置信息：{user=root, password=root}
//        数据库连接创建完成!com.mysql.cj.jdbc.ConnectionImpl@7cf10a6f
