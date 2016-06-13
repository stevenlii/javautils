package com.paymoon.demo.Ztest;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class Test5 {
	private static final Logger logger = LogManager.getLogger(); 
public static void main(String[] args) {
	//List-->Set  
    List<String> list3 = new ArrayList<String>(new HashSet<String>());   
    List<String> list4 = new ArrayList<String>();
    list4.add("1");
    list4.add("1");
    list4.add("1");
    //Set-->List  
    System.out.println(list4);
    Set<String> set = new HashSet<String>(list4);
    System.out.println(set);
}
/**
 * @author Administrator
 * @deprecated we recommend the other method
 *
 */
}
