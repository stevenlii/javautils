package com.paymoon.demo.Ztest;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Test22 {
	private static final Logger logger = LogManager.getLogger();

	   public static void main(String[] args) {
	    	String opp = "10.0.13.104";
	    	
			System.out.println((opp.hashCode() & 0x7FFFFFFF) % 4);
		}
}
