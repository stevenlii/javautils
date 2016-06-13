package com.paymoon.demo.cache;

import com.paymoon.demo.Util.MyProp;

import redis.clients.jedis.Jedis;
/**
 * redis+jedis
 * @author yol
 *
 */
public class MyJedis3 {
	public static void main(String[] args) {
		admintoken2redis();
	}
	public static boolean admintoken2redis() {
		String host=MyProp.getVariable("redis.host");
		String portString = MyProp.getVariable("redis.port");
		String password=MyProp.getVariable("redis.password");
		Jedis redis = new Jedis(host,Integer.valueOf(portString));
		redis.auth(password);
		redis.set("foo", "bar");
		redis.setex("content", 5, "hello");
		String value = redis.get("foo");
		System.out.println(value);
		redis.set("foo", "foo");
		value = redis.get("foo");		
		System.out.println(value);
		redis.del("foo");
		value = redis.get("foo");		
		System.out.println(value);
		redis.close();
		return true;
	}
}
