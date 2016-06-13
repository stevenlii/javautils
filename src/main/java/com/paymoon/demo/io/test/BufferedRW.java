package com.paymoon.demo.io.test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class BufferedRW {
	private static Logger logger = LogManager.getLogger(BufferedRW.class);
	public static void main(String[] args) {
		IORead("/Users/yol/Desktop/444.html");

	}
	private static void IORead(String pathString) {
		Path txtpath = Paths.get(pathString);
		ByteBuffer bb = ByteBuffer.allocate(1024);
		try {
			FileChannel fc = FileChannel.open(txtpath, StandardOpenOption.READ);
			System.out.println(fc.size());
			System.out.println(fc.read(bb,fc.size()-300));;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}