package com.paymoon.demo.cache;

import com.paymoon.demo.Util.MyProp;

import redis.clients.jedis.Jedis;
/**
 * redis+jedis
 * @author yol
 *
 */
public class MyJedis6_Del {
	public static void main(String[] args) {
		admintoken2redis();
	}
	public static boolean admintoken2redis() {
		String host=MyProp.getVariable("redis.host");
		String portString = MyProp.getVariable("redis.port");
		String password=MyProp.getVariable("redis.password");
		//OL
		host="114.215.80.226";
		Jedis redis = new Jedis(host,Integer.valueOf(portString));
		redis.auth(password);
		String key="redis_user_token_key_";
		
		String token="5caee75a-d9ad-4f94-a16b-7dfb7afcddf1";
		key +=token;
		String value = redis.get(key);
		System.out.println(value);
		redis.del(key);
		value = redis.get(key);		
		System.out.println(value);
		redis.close();
		return true;
	}
}
