package com.paymoon.demo.Util;

public class UtilTransfer {
	/**
	 * 把nano变成ms
	 * @param nano 默认一个参数时，是两位
	 * @return
	 */
	public static String nano2Ms(long nano) {
		return nano2Ms(nano, 2);
	}

	/**
	 * 把nano变成ms
	 * @param nano 默认一个参数时，是两位
	 * @param nf 小数点位数
	 * @return
	 */
	public static String nano2Ms(long nano, int nf) {
		if (nano < 0) {
			return "-1";
		}
		double doubleNum = nano / 1000000L;
		return String.format("%."+nf+"f", doubleNum);
	}
}
