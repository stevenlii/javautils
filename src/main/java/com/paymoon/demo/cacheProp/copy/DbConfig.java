package com.paymoon.demo.cacheProp.copy;

import java.util.Map;

/**
 * 从配置文件或数据库中读取信息并缓存 - w_basketboy的专栏 - 博客频道 - CSDN.NET
http://blog.csdn.net/w_basketboy24/article/details/38492175
 * User: wbb
 * Date: 14-8-11
 * Time: 上午11:12
 * 缓存数据库连接信息的单例
 */
public class DbConfig {
    private Map<String,String> sysConfig;
    private static DbConfig instance = null;

    public static synchronized DbConfig getInstance()
    {
        if (instance == null)
        {
            instance = new DbConfig();
        }
        return instance;
    }

    //清楚对象中缓存的内容
    public void clearSysConfig() {
        sysConfig = null;
    }

    public Map<String, String> getSysConfig() {
        return sysConfig;
    }

    public void setSysConfig(Map<String, String> sysConfig) {
        this.sysConfig = sysConfig;
    }
}
