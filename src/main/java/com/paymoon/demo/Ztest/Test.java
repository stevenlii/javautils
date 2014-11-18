package com.paymoon.demo.Ztest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class Test {
	private static final Logger logger = LogManager.getLogger(); 
public static void main(String[] args) {
	String msg = new String("妹的!!!");
	System.out.println(msg);
	logger.info(msg);
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
