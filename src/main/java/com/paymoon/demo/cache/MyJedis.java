package com.paymoon.demo.cache;

import redis.clients.jedis.Jedis;
/**
 * redis+jedis
 * @author yol
 *
 */
public class MyJedis {
	public static void main(String[] args) {
		//just ip without port:6379
		Jedis jedis = new Jedis("101.227.255.236",6379);
		jedis.set("foo", "bar");
		String value = jedis.get("foo");
		System.out.println(value);
		jedis.set("foo", "foo");
		value = jedis.get("foo");		
		System.out.println(value);
	}
}
