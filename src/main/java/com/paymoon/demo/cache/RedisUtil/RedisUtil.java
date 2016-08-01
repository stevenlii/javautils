package com.paymoon.demo.cache.RedisUtil;

import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.paymoon.demo.Util.MyProp;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class RedisUtil {
	private static JedisPool pool;
	private static Logger logger=LogManager.getLogger();

    static {
    	logger.debug("start to read redis configuration..");
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(Integer.valueOf(MyProp.getVariable("redis.maxTotal", "500")));
        config.setMaxIdle(Integer.valueOf(MyProp.getVariable("redis.maxIdle", "200")));
        config.setMaxWaitMillis(5000L);
        config.setTestOnBorrow(true);
        config.setTestOnReturn(true);
        
        logger.debug("read success,start to create redis pool");
        pool = new JedisPool(config, 
        		MyProp.getVariable("redis.host", "localhost"), 
        		Integer.valueOf(MyProp.getVariable("redis.port")), 
        		2000, MyProp.getVariable("redis.password", "localhost"));
        logger.debug("create redis pool success.");
    }

    private RedisUtil() {}
    
    /**
     * dbIndex == null?MyProp.redis.db.index:dbIndex
     * @param dbIndex
     * @return
     */
    public static Jedis getJedis(Integer dbIndex) {
    	if (dbIndex == null) 
			dbIndex = Integer.valueOf(MyProp.getVariable("redis.db.index", "10"));
    	
    	 Jedis jedis = getPool().getResource();
         jedis.select(dbIndex);
         return jedis;
    }
    /**
     * default is 0
     * @return
     */
    public static Jedis getJedis() {
    	Integer dbIndex = Integer.valueOf(MyProp.getVariable("redis.db.index", "10"));
    	return getJedis(dbIndex);
    	}
    public static JedisPool getPool() {
        return pool;
    }
    public static void closeJedis(Jedis jedis) {
    	if(jedis != null) {
    		jedis.close();
    	}
    }
    public static void destroyPool(Jedis jedis) {
        getPool().destroy();
    }
    public static void main(String[] args) {
    	//调用示例
    	getStatus(null);
	}
    public static Map<String, String> getStatus(final String alarmId) {
		Jedis jedis = null;
		try {
			jedis = RedisUtil.getJedis();
			Map<String, String> map = new HashMap<String, String>();
			String mapString = jedis.get(MyProp.getVariable("my.channel.name")+"_"+alarmId);
			ObjectMapper mapper = new ObjectMapper();
			Map<String, String> dataMaps = new HashMap<>();
			dataMaps = mapper.readValue(mapString, Map.class);
			logger.info("success to update final send status, alarmId is {},mapString is {}" , alarmId , mapString);
			return dataMaps;
		}catch (Exception e) {
			logger.error("failed to update final send status, alarmId is {}" , alarmId );
		}finally {
			RedisUtil.closeJedis(jedis);
		}	
		return null;
	}
}
