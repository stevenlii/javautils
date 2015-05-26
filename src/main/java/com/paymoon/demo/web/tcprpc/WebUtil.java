package com.paymoon.demo.web.tcprpc;

public class WebUtil {

	public static int bytes2Int( byte[] bytes) {
		int num = bytes[3] & 0XFF;
		num |= ((bytes[2] << 8) & 0xFF00);
		num |= ((bytes[1] << 16) & 0xFF0000);
		num |= ((bytes[0] << 24) & 0xFF000000);
		
		return num;
		
	}
	public static byte[] int2ByteArray( int i) {
		byte[] resutl = new byte[4];
		resutl[0] = (byte)((i >> 24) & 0xFF);
		resutl[1] = (byte)((i >> 16) & 0xFF);
		resutl[2] = (byte)((i >> 8) & 0xFF);
		resutl[3] = (byte)(i & 0xFF);
		
		return resutl;
		
	}
	
	public static void main(String[] args) {
		byte[] resutl = int2ByteArray(55);
		for (int i = 0; i < resutl.length; i++) {
			System.out.println(resutl[i]);
		}
		int num = bytes2Int(resutl);
		System.out.println(num);
	}
}
