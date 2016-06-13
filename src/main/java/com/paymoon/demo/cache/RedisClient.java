package com.paymoon.demo.cache;

import com.paymoon.demo.Util.MyProp;

import redis.clients.jedis.Jedis;

public interface RedisClient {
	
    String get(String key);
    void set(String key,String value);
    void set(String key,String value,int second);
    
	class defaultRedisClient implements RedisClient{
		
		private   String host;
		private   int port=6379;
		private String password;
		
		public static RedisClient instance (){
			try{
			String host=MyProp.getVariable("redis.host");
			String portString = MyProp.getVariable("redis.port");
			String password=MyProp.getVariable("redis.password");
			if (host!=null&&!host.equals("")&&portString!=null&&!portString.equals("")) {
				int port=Integer.valueOf(portString);
				return new defaultRedisClient(host,port,password);
			}else {
				return null;
			}
			}catch(Exception e){ 
				e.printStackTrace();
				return new defaultRedisClient("127.0.0.1",6379,""); 
			}
		}
		private defaultRedisClient(String host,int port,String password){
			this.host=host;
			this.port=port;
			this.password=password;
		}
		@Override
		public String get(String key){
			try{
			Jedis jedis = new Jedis(host, port);
			if(password!=null&&!"".equalsIgnoreCase(password.trim()))
				jedis.auth(password);
			String o=jedis.get(key);
			jedis.close();
			return o;
			}catch(Exception e){
				return null;
			}
		}
		@Override
		public void set(String key,String value){
			try{
			Jedis jedis = new Jedis(host, port);
			if(password!=null&&!"".equalsIgnoreCase(password.trim()))
				jedis.auth(password);
			jedis.set(key,value);
			jedis.close();
			}catch(Exception e){}
		}
		
		public  void main(String[] args) {
			// TODO Auto-generated method stub
			RedisClient jc= RedisClient.defaultRedisClient.instance();
//			jc.set("a", "火车王");
			Jedis jedis = new Jedis(host, port);
			if(password!=null&&!"".equalsIgnoreCase(password.trim()))
				jedis.auth(password);
//			System.out.println("oo");
			System.out.println(jc.get("a").toString());
			
		}
		@Override
		public void set(String key, String value, int second) {
			// TODO Auto-generated method stub
			try{
			Jedis jedis = new Jedis(host, port);
			jedis.set(key,value);
			jedis.expire(key, second);
			jedis.close();
			}catch(Exception e){}
		}
	}
	
	
	

}
