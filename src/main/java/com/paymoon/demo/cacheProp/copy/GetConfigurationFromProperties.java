package com.paymoon.demo.cacheProp.copy;

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


            System.out.println(dbConfig);
           
            System.getProperty("user.dir"); 
            System.out.println(System.getProperty("user.dir").replace("/", "."));
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("读取配置文件失败");
        } 
    }
}
