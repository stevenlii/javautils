package com.paymoon.demo.cacheProp;

import java.io.IOException;
import java.io.InputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Created with IntelliJ IDEA.
 * User: wbb
 * Date: 14-8-11
 * Time: 上午11:05
 * 读取或写入系统配置文件的工具类
 */
public class SystemConfigUtil {
    /**
     * 从配置文件中读取配置信息
     *
     * @return 配置信息properties
     * @throws IOException
     */
    public static Properties getProperties() throws IOException {
        Properties prop = new Properties();
        InputStream in = Object.class.getResourceAsStream("/config.properties");
        prop.load(in);
        return prop;
    }

    /**
     * 将数据库配置信息写入到dbConfig中
     *
     * @param config 数据库配置信息
     */
    public static void setDBConfig(Properties config) {
        Map<String, String> configMap = new HashMap<String, String>();
        //迭代配置文件中的配置，并放到map中
        for (Enumeration e = config.propertyNames(); e.hasMoreElements(); ) {
            String key = (String) e.nextElement();
            String value = config.getProperty(key);
            configMap.put(key, value);
        }
        //将配置写入到单例中
        DbConfig dbConfig = DbConfig.getInstance();
        dbConfig.setSysConfig(configMap);
    }

    /**
     * 读取查询配置，并写入到queryConfig中
     */
    public static void setQueryConfig(ResultSet rs) throws SQLException {
        String key = null;
        String value = null;
        Map queryConfigMap = new HashMap();
        while (rs.next()) {
            key = rs.getString("DM");
            value = rs.getString("PZZ");
            queryConfigMap.put(key, value);
            System.out.println("代码为：" + key + "对应的配置值是：" + value);
        }
        //将查询配置信息写入queryConfig
        QueryConfig queryConfig = QueryConfig.getInstance();
        //清除原有对象
        queryConfig.clearQueryConfig();
        //构造新对象
        queryConfig.setQueryConfig(queryConfigMap);
    }
}
