package com.paymoon.demo.cache;

import com.paymoon.demo.Util.MyProp;

import redis.clients.jedis.Jedis;
/**
 * redis+jedis
 * @author yol
 *
 */
public class MyJedis5 {
	public static void main(String[] args) {
		String admintoken2redis = admintoken2redis("abcd");
		System.out.println("admintoken2redis"+admintoken2redis);
	}
	public static String admintoken2redis(String admintoken) {
		String host=MyProp.getVariable("redis.host");
		String portString = MyProp.getVariable("redis.port");
		String password=MyProp.getVariable("redis.password");
		
		if (host!=null&&!host.equals("")&&portString!=null&&!portString.equals("")) {
			int port=Integer.valueOf(portString);
			Jedis redis = new Jedis(host,port);
			redis.auth(password);
			String admintokenRedis = redis.get("admintoken");
			System.out.println("admintokenRedis"+admintokenRedis);
			if (admintokenRedis != null && !admintokenRedis.equals("")) {
				redis.close();
				return admintokenRedis;
			}
			redis.set("admintoken", admintoken);
			redis.expire("admintoken", 1);
			redis.close();
			return admintoken;
		}
		return null;
	}
}
