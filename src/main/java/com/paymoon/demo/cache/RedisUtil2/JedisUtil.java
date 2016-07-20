package com.paymoon.demo.cache.RedisUtil2;

import com.paymoon.demo.Util.MyProp;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class JedisUtil {
	private static String jedis_ip = null;
	private static int jedis_port = 0;
	private static String jedis_password = null;
	private static JedisPool jedisPool;

	static {
		jedis_ip = MyProp.getVariable("redis.host");
		jedis_port = Integer.valueOf(MyProp.getVariable("redis.port"));
		jedis_password = MyProp.getVariable("redis.password");
		JedisPoolConfig config = new JedisPoolConfig();
		config.setMaxIdle(30);
		config.setMaxWaitMillis(100000);
		config.setTestOnBorrow(true);
		jedisPool = new JedisPool(config, jedis_ip, jedis_port);
	}

	public static Jedis getJedis() {
		Jedis jedis = jedisPool.getResource();
		if (jedis_password != null)
			jedis.auth(jedis_password);
		// if(jedis != null)
		// jedisPool.returnResource(jedis);
		return jedis;
	}

	public static void releasJedis(Jedis jedis) {
		if (jedis != null) {
			jedis.disconnect();
			jedisPool.returnBrokenResource(jedis);
			jedis.flushDB();
		}
	}

	public static void main(String[] args) {
		Jedis jedis = JedisUtil.getJedis();
		System.out.println(jedis.lpop("sjt_message"));
	}
}