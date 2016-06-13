package com.paymoon.demo.Ztest;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.paymoon.demo.vo.Metric;


public class Test3 {
	private static final Logger logger = LogManager.getLogger(); 
public static void main(String[] args) {
	List<Metric> metrics = new ArrayList<>();
	Metric metric = new Metric();
	metric.setProperty("1");
	metric.setValue("2");
	metrics.add(metric);
	for (Metric m1 : metrics) {
		System.out.println(m1.getValue());
		m1.setValue("3");
	}
	
	for (Metric m2 : metrics) {
		System.out.println(m2.getValue());
	}
	
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
