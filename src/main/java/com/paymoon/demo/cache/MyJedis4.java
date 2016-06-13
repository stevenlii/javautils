package com.paymoon.demo.cache;

/**
 * redis+jedis
 * @author yol
 *
 */
public class MyJedis4 {
	public static void main(String[] args) {try {
		RedisClient jedisClient =RedisClient.defaultRedisClient.instance();
		if (jedisClient!=null) {
			jedisClient.set("aa","bb",100);
			System.out.println(jedisClient.get("aa"));
		}
	} catch (Exception e) {
		e.printStackTrace();
	}}
}
