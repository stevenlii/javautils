package com.paymoon.demo.cache;

import com.paymoon.demo.Util.MyProp;

import redis.clients.jedis.Jedis;
/**
 * redis+jedis
 * @author yol
 *
 */
public class testrun {
	public static void main(String[] args) {
		admintoken2redis();
	}
	public static boolean admintoken2redis() {
		String host=MyProp.getVariable("runtime.properties","redis.host","localhost");
		String portString = MyProp.getVariable("runtime.properties","redis.port1","localhost");
		String password=MyProp.getVariable("runtime.properties","redis.password1","localhost");
		System.out.println(host);
		return true;
	}
}
