package com.paymoon.demo.Ztest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Test28 {
	private static final Logger logger = LogManager.getLogger();

	public static void main(String[] args) {
		System.out.println(CheckSum("$1*"));
	}

	public static int CheckSum(String s) {
		String ss = s.substring(1, s.indexOf("*"));
		byte[] bt = ss.getBytes();
		
		int checksum = bt[0];
		for (int i = 1; i < bt.length; i++) {
			System.out.println(bt[i] +" ");
			checksum ^= bt[i];
		}
		return checksum;
	}
	public String getEncryption(String para){
		int key = 0x10;
		char[] charArray = para.toCharArray();
		for(int i =0;i<charArray.length;i++){
			charArray[i]=(char)(charArray[i]^key);
		}
//		byte key = 0x10;
//		byte[] bts =  para.getBytes();
//		for(int i = 0; i< bts.length;i++){
//			bts[i]^=key;
//		}
//		String s = new String(bts);
		
		return String.valueOf(charArray);
	}
	public static void fsDbw(Integer simkh,String fsnr){
	    StringBuffer str = new StringBuffer();
	    str.append("$CCTXA,");//指令关键字
	    str.append(simkh).append(",");//收件人地址
	    str.append("1,");//默认普通通信 1表示普通通信，0表示特快通信
	    str.append("2,");// 2表示混合传输，1表示代码传输，0表示汉字传输
	    try {
	        str.append(ByteUtils.str2HexStr(fsnr));//汉字转化为16进制数
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    str.append("*");
	    //异或校验字节
	    int checkSum = CheckSum(str.toString());
	    String sum=Integer.toHexString(checkSum);
	    if(sum.length()<2){
	        sum = "0"+sum;
	    }
	    str.append(sum+"\r\n");
	    System.out.println(str.toString());
//	    SerialPortManager.sendToPort(mSerialport,str.toString().getBytes());
	}
}
