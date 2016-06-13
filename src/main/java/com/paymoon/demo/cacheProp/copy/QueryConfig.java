package com.paymoon.demo.cacheProp.copy;

import java.util.Map;

/**
 * User: wbb
 * Date: 14-8-11
 * Time: 上午11:25
 * 缓存查询信息的单例
 */
public class QueryConfig {
    private Map<String, String> queryConfig;
    private static QueryConfig instance = null;

    public static synchronized QueryConfig getInstance() {
        if(instance == null) {
            instance = new QueryConfig();
        }
        return instance;
    }

    //清楚对象中缓存的内容
    public void clearQueryConfig() {
        queryConfig = null;
    }

    public Map<String, String> getQueryConfig() {
        return queryConfig;
    }

    public void setQueryConfig(Map<String, String> queryConfig) {
        this.queryConfig = queryConfig;
    }
}
