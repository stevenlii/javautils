package com.paymoon.demo.cache;

import redis.clients.jedis.Jedis;
/**
 * redis+jedis
 * @author yol
 *
 */
public class MyJedis3 {
	public static void main(String[] args) {
		//just ip without port:6379
		Jedis redis = new Jedis("101.227.255.236",6379);
		redis.set("foo", "bar");
		redis.setex("content", 5, "hello");
		String value = redis.get("foo");
		System.out.println(value);
		redis.set("foo", "foo");
		value = redis.get("foo");		
		System.out.println(value);
	}
}
