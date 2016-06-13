package com.paymoon.demo.cacheProp;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;
import java.util.Properties;

/**
 * User: wbb
 * Date: 14-8-11
 * Time: 上午11:03
 * 测试从配置文件中读取
 */
public class GetConfigurationFromProperties {
    public static void main(String[] args) {
        Properties properties = null;
        /**
         * 从配置文件中读取配置信息，并缓存到DbConfig单例对象中
         */
        try {
            //读取配置文件
            properties = SystemConfigUtil.getProperties();
            //将数据库配置写入(缓存)到dbconfig
            SystemConfigUtil.setDBConfig(properties);
            //获取数据库连接信息的实例
            Map<String, String> dbConfig = DbConfig.getInstance().getSysConfig();

            /**
             * 从数据库中读取信息并缓存到QueryConfig单例对象中
             */

            //连接数据库
            Connection conn = null;
            Class.forName(dbConfig.get("driver_class"));
            conn = DriverManager.getConnection(dbConfig.get("url"), dbConfig.get("username"), dbConfig.get("password"));

            //获取执行sql语句的对象
            Statement stmt =null;
            stmt = conn.createStatement();

            //执行sql语句，获取结果集
            ResultSet rs=null;
            rs=stmt.executeQuery("select * from t_pz_xtpz");

            //将查询信息写入(缓存)到queryconfig
            SystemConfigUtil.setQueryConfig(rs);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("读取配置文件失败");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("没有找到驱动文件");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("数据库连接失败");
        }
    }
}
