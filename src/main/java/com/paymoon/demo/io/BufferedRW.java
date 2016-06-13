package com.paymoon.demo.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
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
//		IORead("/Users/yol/Desktop/444.html");
		IOReadAll("/Users/yol/Downloads/alijson");
//		IOWrite("/Users/yol/Desktop/444.html");

	}
	private static void IORead(String pathString) {
		Path txtpath = Paths.get(pathString);
		try (BufferedReader br = Files.newBufferedReader(txtpath,StandardCharsets.UTF_8)) {

			String sCurrentLine;

			while ((sCurrentLine = br.readLine()) != null) {
				System.out.println(sCurrentLine);
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	private static void IOReadAll(String pathString) {
		Path txtpath = Paths.get(pathString);
		try {
			List<String> lines = Files.readAllLines(txtpath, StandardCharsets.UTF_8);
			System.out.println(lines);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private static void IOWrite(String pathString) {
		Path txtpath = Paths.get(pathString);
		try(BufferedWriter bw = Files.newBufferedWriter(txtpath, StandardCharsets.UTF_8, StandardOpenOption.APPEND)){
			bw.write("test");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}