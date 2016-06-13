package com.paymoon.demo.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.paymoon.demo.Util.Dict;

public class read2 {
	protected static Log logger = LogFactory.getLog(read2.class);

	public static void main(String[] args) throws Exception {
		read();
	}

	public static File read() throws Exception {
		Map<String, String> map = new HashMap<String, String>();
		//直接写/Users/yol/workspace/agent-alert/target/classes/conf/iplist.txt
		///Users/yol/workspace/agent-alert/target/classes/conf/iplist
		//会报错, 找不到folder
//		FileInputStream csvread = new FileInputStream("/Users/yol/workspace/agent-alert/target/classes/conf/iplilst.txt");
		File csvread2 = new File("/Users/yol/workspace/agent-alert/target/classes/conf/iplist.txt");
		
		File csvFile = null;
		BufferedReader csvReader = new BufferedReader(new FileReader(
				csvread2), 1024);
		String string = null;
		while ((string = csvReader.readLine()) != null) {
			parseLinuxResult(map, string,"5");
		}
//		for (Map.Entry entry  : map.entrySet()) {
//			 System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
//		}
		return csvFile;

	}

	private static Map parseLinuxResult(Map m, String s, String n) {
		String plp = "0";
		String time = null;
		String max = null;
		String min = null;
		String lostStart = n + " packets transmitted,";
		if (s.indexOf(n + " packets transmitted,") != -1) {
			int start = s.indexOf(',', s.indexOf("received"));
			int end = s.indexOf("%", start);
			if (start != -1 && end != -1) {
				String tmp = s.substring(start + 1, end);
				plp = tmp.trim();
				m.put(Dict.PACKET_LOSS_PERCENT, plp);
				logger.info("PacketLossPercent:" + plp + "%");
				// timeout
				if (plp.equals("100")) {
					logger.warn("ResponseTimeMin:" + -1);
					logger.warn("ResponseTimeMax:" + -1);
					logger.warn("ResponseTime:" + -1);
					m.put(Dict.RESPONSE_TIME_MIN, -1);
					m.put(Dict.RESPONSE_TIME_MAX, -1);
					m.put(Dict.RESPONSE_TIME, -1);
					return m;
				}
			}
		}
		if (s.indexOf("rtt min/avg/max/mdev =") != -1) {
			int start = s.indexOf("rtt min/avg/max/mdev =");
			int end = s.indexOf("ms", start);
			if (start != -1 && end != -1) {
				String tmp = s.substring(
						start + "rtt min/avg/max/mdev =".length(), end);
				String arr[] = tmp.split("/");

				min = arr[0].trim();
				time = arr[1].trim();
				max = arr[2].trim();
				logger.info("ResponseTimeMin:" + min);
				logger.info("ResponseTimeMax:" + max);
				logger.info("ResponseTime:" + time);
				m.put(Dict.RESPONSE_TIME_MIN, min);
				m.put(Dict.RESPONSE_TIME_MAX, max);
				m.put(Dict.RESPONSE_TIME, time);
			}
		}

		return m;
	}

	private static Map parseWindowsResult(Map m, String s) {
		String plp = "0";
		String time = null;
		String max = null;
		String min = null;
		if (s.indexOf("数据包:") != -1) {
			int start = s.indexOf('(', s.indexOf("数据包:"));
			int end = s.indexOf('%', start);
			if (start != -1 && end != -1) {
				String tmp = s.substring(start + 1, end);
				plp = tmp.trim();
				logger.info("PacketLossPercent:" + plp + "%");
				// timeout
				if (plp.equals("100")) {
					logger.warn("ResponseTimeMin:" + -1);
					logger.warn("ResponseTimeMax:" + -1);
					logger.warn("ResponseTime:" + -1);
					m.put(Dict.RESPONSE_TIME_MIN, -1);
					m.put(Dict.RESPONSE_TIME_MAX, -1);
					m.put(Dict.RESPONSE_TIME, -1);
					return m;
				}
			}
			m.put(Dict.PACKET_LOSS_PERCENT, plp);
		}
		if (s.indexOf("最短 =") != -1) {
			int start = s.indexOf("最短 =");
			int end = s.indexOf("ms", start);
			if (start != -1 && end != -1) {
				String tmp = s.substring(start + "最短 =".length(), end);
				min = tmp.trim();
				logger.info("ResponseTimeMin:" + min + "ms");
			}
		}
		if (s.indexOf("最长 =") != -1) {
			int start = s.indexOf("最长 =");
			int end = s.indexOf("ms", start);
			if (start != -1 && end != -1) {
				String tmp = s.substring(start + "最长 =".length(), end);
				max = tmp.trim();
				logger.info("ResponseTimeMax:" + max + "ms");
			}
		}
		if (s.indexOf("平均 =") != -1) {
			int start = s.indexOf("平均 =");
			int end = s.indexOf("ms", start);
			if (start != -1 && end != -1) {
				String tmp = s.substring(start + "平均 =".length(), end);
				time = tmp.trim();
				logger.info("ResponseTime:" + time + "ms");
			}
		}
		m.put(Dict.RESPONSE_TIME_MIN, min);
		m.put(Dict.RESPONSE_TIME_MAX, max);
		m.put(Dict.RESPONSE_TIME, time);
		return m;
	}
}
