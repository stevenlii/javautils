//package com.paymoon.demo.cache;
//
//import com.paymoon.demo.Util.MyProp;
//
//import redis.clients.jedis.Jedis;
///**
// * redis+jedis
// * @author yol
// *
// */
//public class MyJedis6_Del {
//	public static void main(String[] args) {
//		admintoken2redis();
//	}
//	public static boolean admintoken2redis() {
//		String host=MyProp.getVariable("redis.host");
//		String portString = MyProp.getVariable("redis.port");
//		String password=MyProp.getVariable("redis.password");
//		//OL
//		host="114.215.80.226";
//		Jedis redis = new Jedis(host,Integer.valueOf(portString));
//		redis.auth(password);
//		String email="gengwan@novel-supertv.com";
//
//		String token=redis.get(Dict.REDIS_FIND_TOKENBYEMAIL_KEY_+email);
//		String user=redis.get(Dict.REDIS_FIND_USERBYEMAIL_KEY_+email);
//		System.out.println();
//		System.out.println(redis.get(Dict.REDIS_USER_KEY+user));
//		System.out.println(redis.get(Dict.REDIS_FIND_TOKENBYEMAIL_KEY_+email));
//		System.out.println(redis.get(Dict.REDIS_FIND_TOKENBYUSER_KEY_+user));
//		System.out.println(redis.get(Dict.REDIS_FIND_USERBYEMAIL_KEY_+email));
//		System.out.println(redis.get(Dict.REDIS_FIND_USERBYTOKEN_KEY_+token));
//		System.out.println(redis.get(Dict.REDIS_USER_TOKEN_KEY+token));
//		System.out.println(redis.get(Dict.REDIS_USER_TOKEN_SERIALIZE_KEY+token));
//		System.out.println(redis.get(token));
//
//		System.out.println("del-----------");
//		redis.del(Dict.REDIS_USER_KEY+user);
//		redis.del(Dict.REDIS_FIND_TOKENBYEMAIL_KEY_+email);
//		redis.del(Dict.REDIS_FIND_TOKENBYUSER_KEY_+user);
//		redis.del(Dict.REDIS_FIND_USERBYEMAIL_KEY_+email);
//		redis.del(Dict.REDIS_FIND_USERBYTOKEN_KEY_+token);
//		redis.del(Dict.REDIS_USER_TOKEN_KEY+token);
//		redis.del(Dict.REDIS_USER_TOKEN_SERIALIZE_KEY+token);
//		redis.del(token);
//
//		redis.close();
//		return true;
//	}
//}
