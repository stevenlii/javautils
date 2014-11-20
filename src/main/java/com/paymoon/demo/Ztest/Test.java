package com.paymoon.demo.Ztest;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class Test {
	private static final Logger logger = LogManager.getLogger(); 
public static void main(String[] args) {
	String msg = new String("abcdef");
	msg = msg.substring(1);
	Map<String, String> map1 = new HashMap<String, String>();
	Map<String, String> map2 = new HashMap<String, String>();
	map2.put("1", "2");
	map1.putAll(map2);
	
	System.out.println(map1.get("1"));
	logger.info(msg);
	logger.info(msg,new Test().getClazzName());
	
}
/**
 * @author Administrator
 * @deprecated we recommend the other method
 *
 */
public static String getClazzName() {
	String clazzName3 = new Object() {  
	    public String getClassName() {  
	        String clazzName = this.getClass().getName();  
	        return clazzName.substring(0, clazzName.lastIndexOf('$'));  
	    }  
	}.getClassName(); 
	return clazzName3;
}
}
