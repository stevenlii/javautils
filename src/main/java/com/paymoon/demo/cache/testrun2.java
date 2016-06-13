package com.paymoon.demo.cache;

import java.util.Map;
import java.util.Map.Entry;

import com.paymoon.demo.Util.MyProp;

import redis.clients.jedis.Jedis;
/**
 * redis+jedis
 * @author yol
 *
 */
public class testrun2 {
	public static void main(String[] args) {
		admintoken2redis();
	}
	public static void admintoken2redis() {
		Map<String, String> map = null;
		for (Entry<String, String> entry : map.entrySet()) {
			entry.getKey();
			entry.getValue();
		}
	}
}
