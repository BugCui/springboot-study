package com.coinker.spi.demo2;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * @author Cui Shenpeng
 * @Classname Test
 * @Description TODO
 * @Date 2021/6/7 22:19
 */
public class Test {

    public static void main(String[] args) throws Exception {
        // 1.注册驱动
        Class.forName("com.mysql.jdbc.Driver");
        // 2.获取连接对象
        String url = "jdbc:mysql://localhost:3306/leyou?useUnicode=true&characterEncoding=utf8&useSSL=true&serverTimezone=GMT";
        Connection conn = DriverManager.getConnection(url, "root", "123456");
//        // 3.获取执行SQL语句
//        Statement stat = conn.createStatement();
//        // 拼写SQL语句
//        String sql = "select * from game";
//        // 4.调用执行者对象方法,执行SQL语句获取结果集
//        // 返回的是ResultSet接口的实现类对象,实现类在mysql驱动中
//        ResultSet rs = stat.executeQuery(sql);
//        // System.out.println(rs);//com.mysql.jdbc.JDBC4ResultSet@18cef0a
//        // 5.处理结果集
//        // ResultSet接口的方法 boolean next() 有结果集true,没有结果集返回false
//        while (rs.next()) {
//            // 获取每列的数据,使用的是ResultSet接口的方法getXXX
//            int id = rs.getInt("id");// 相当于rs.getInt(1);这个方法有弊端
//            String name = rs.getString("name");
//            System.out.println(id + "\t" + name + "\t");
//
//        }
//        // 6.关闭资源
//        rs.close();
//        stat.close();
//        conn.close();
    }

}
