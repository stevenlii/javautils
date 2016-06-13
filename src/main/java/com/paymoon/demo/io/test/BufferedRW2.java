package com.paymoon.demo.io.test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
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

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;


public class BufferedRW2 {
	private static Logger logger = LogManager.getLogger(BufferedRW2.class);
	public static void main(String[] args) {
		readFileByLines("/Users/yol/Desktop/444");

	}
	private static void IORead(String pathString) {
		Path txtpath = Paths.get(pathString);
		ByteBuffer bb = ByteBuffer.allocate(1024);
		try {
			FileChannel fc = FileChannel.open(txtpath, StandardOpenOption.READ);
			System.out.println();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	/**
     * 以行为单位读取文件，常用于读面向行的格式化文件
     */
    public static void readFileByLines(String fileName) {
        File file = new File(fileName);
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            int line = 1;
            // 一次读入一行，直到读入null为文件结束
            while ((tempString = reader.readLine()) != null) {
                // 显示行号
//                System.out.println("line " + line + ": " + tempString);
//                line++;
            	System.out.println(tempString);
            	ObjectMapper mapper = new ObjectMapper();
            JsonNode root = 	mapper.readTree(tempString);
            String eventId = root.get("eventId").asText();
            String eventType = root.get("eventType").asText();
            String app = root.get("app").asText();
            String priority = root.get("priority").asText();
            JsonNode alarmContent = root.get("alarmContent");
//            String lp_bbook_quantity_sum = alarmContent.get("detail").get("lp_bbook_quantity_sum").asText();
            JsonNode detailNode = alarmContent.get("detail");
            String detailNodeStr = detailNode.asText();

            System.out.println(detailNodeStr);
            JsonNode titleNode = alarmContent.get("title");
            System.out.println(titleNode.asText());
            System.out.println(eventId);
            System.out.println(eventType);
            System.out.println(app);
            System.out.println(priority);
            System.out.println(root.get("alarmName").asText());
            
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                	e1.printStackTrace();
                }
            }
        }
    }
	
}