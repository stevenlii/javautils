package com.paymoon.demo.Util;

import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class Rpid2 {
	private static AtomicInteger index = new AtomicInteger();

	public Rpid2() {
	}

	public static int getPid() {
		String info = getRunTimeInfo();
		int pid = (new Random()).nextInt();
		int index = info.indexOf("@");
		if (index > 0) {
			pid = Integer.parseInt(info.substring(0, index));
		}

		return pid;
	}

	public static String getRunTimeInfo() {
		RuntimeMXBean runtime = ManagementFactory.getRuntimeMXBean();
		String info = runtime.getName();
		return info;
	}

	public static String getRocketMqUniqeInstanceName() {
		return "pid" + getPid() + "_index" + index.incrementAndGet();
	}

	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();

		int count = 0;
		int index = 1;
		while (true) {
			String rpid = getRocketMqUniqeInstanceName();

			if (list.contains(rpid)) {
				System.out.println("重复啦...." + list.size());
				break;
			}
			count++;

			if ((count * index) % 10000 == 0 && count >= 10000) {
				System.out.println("已经做了" + count + "个，还没有重复。");
				index++;
			}
		}
	}
}