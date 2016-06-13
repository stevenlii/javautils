package com.paymoon.demo.cache;

import com.paymoon.demo.Util.MyProp;

import redis.clients.jedis.Jedis;
/**
 * redis+jedis
 * @author yol
 *
 */
public class MyJedis7 {
	public static void main(String[] args) {
		admintoken2redis();
	}
	public static boolean admintoken2redis() {
		String host=MyProp.getVariable("redis.host");
		String portString = MyProp.getVariable("redis.port");
		String password=MyProp.getVariable("redis.password");
		//OL
//		host="114.215.80.226";
		Jedis redis = new Jedis(host,Integer.valueOf(portString));
		redis.auth(password);
		String key="redis_user_token_key_123";
		redis.set(key, "123");
		String value = redis.get(key);
		System.out.println(value);
		redis.set(key, "12345");
		value = redis.get(key);		
		System.out.println(value);
		redis.close();
		return true;
	}
}
