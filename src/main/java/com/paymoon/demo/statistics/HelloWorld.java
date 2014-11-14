package com.paymoon.demo.statistics;
import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
 
public class HelloWorld {
    private static final Logger logger = LogManager.getLogger("HelloWorld");
    public static void main(String[] args) {

    	Map<String, Long> queryMap = new HashMap<String, Long>();
    	new HelloWorld().te(queryMap);
    	System.out.println(queryMap.get("1"));
//    	System.out.println("2"+"3");
    }
    public void  te(Map<String, Long> queryMap ) {
		if (queryMap.get("1") != null) {
			System.out.println(111);
		}else {
			System.out.println("noooo");
		}
		
	}
}