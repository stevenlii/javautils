package com.paymoon.demo.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class BufferedRW {
	private static Logger logger = LogManager.getLogger(BufferedRW.class);
	public static void main(String[] args) {
		 logger.entry();   //Log |entry to a method 
		 logger.info("aaaa");
//		 logger.info("aa, . {}");
//		 logger.info("hi {}","df");
//	      logger.error("Did it again!");   //Log a message object with the ERROR level    
	      logger.exit();    //Log exit from a method 
		StringBuilder sb = new StringBuilder();
		
		try (BufferedReader br = new BufferedReader(new FileReader(
				"/Users/yol/workspace/agent-alert/pinghostlist.txt"))) {

			String sCurrentLine;

			while ((sCurrentLine = br.readLine()) != null) {
				System.out.println(sCurrentLine);
				sb.append(sCurrentLine.trim());
				sb.append(",");
			}
			String str = sb.toString();
			str = str.substring(0, str.length() - 1);
			System.out.println(str);
			BufferedWriter bw = new BufferedWriter(new FileWriter(
					"/Users/yol/workspace/agent-alert/iplist"));
			bw.write(str);
			bw.close();
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}