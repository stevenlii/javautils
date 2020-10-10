package com.paymoon.demo.Ztest;

import org.apache.axis.types.UnsignedByte;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
0,1,2,3,4,5,6,7 8  9  10 11 12 13 14 15
0,1,2,3,4 5 6 7 -8 -7 -6 -5 -4 -3 -2 -1

0001
0010
0011
0100
0101
0110
0111



0000 0101 5 
0000 1010 2*5 = 10
0001 0100 2*2*5 =20
左移5位 32*5=160 160代表的是160-256=-96
左移6位 64*5=320 320超过256大小，溢出，取256范围内的，为320%256 = 64

1100 1101 128 + 64 + 8 + 4 + 1 = 205 即 -51
逻辑右移 
0110 0110 64+32+4+2 = 102
算术右移
1110 0110 128 + 102 = 210 即-46
 *
 */
public class TestMvBit {
	private static final Logger logger = LogManager.getLogger();

	public static void main(String[] args) {
		int orgIng = 5;
		System.out.println(Integer.toBinaryString(orgIng));

		System.out.println(orgIng << 1);
		System.out.println(orgIng << 2);
		byte orgC = 5;
		byte orgC1 = (byte) (orgC << 5);
		byte orgC2 = (byte) (orgC << 6);
		System.out.println(orgC << 1);
		System.out.println(orgC << 2);
		System.out.println(orgC1);
		System.out.println(orgC2);
		System.out.println("右移------");
		byte orgCYou = (byte) 128;
		System.out.print("右移前：");
		System.out.println(orgCYou);
		System.out.print("二进制：");
		System.out.println(Integer.toBinaryString(orgCYou));
		byte orgC3 = (byte) (orgCYou >>> 1);
		System.out.print("逻辑右移后：");
		System.out.println(orgC3);
		System.out.print("二进制：");
		System.out.println(Integer.toBinaryString(orgC3));
		byte orgC4 = (byte) (orgCYou >> 1);
		System.out.print("算术右移后：");
		System.out.println(orgC4);
		System.out.print("二进制：");
		System.out.println(Integer.toBinaryString(orgC4));
		
		System.out.println("2222右移------");
		int orgCYouInt =  -7;
		System.out.print("右移前：");
		System.out.println(orgCYouInt);
		System.out.print("二进制：");
		System.out.println(Integer.toBinaryString(orgCYouInt));
		int orgC3Int =  (orgCYouInt >>> 1);
		System.out.print("逻辑右移后：");
		System.out.println(orgC3Int);
		System.out.print("二进制：");
		System.out.println(Integer.toBinaryString(orgC3Int));
		int orgC4Int =  (orgCYouInt >> 1);
		System.out.print("算术右移后：");
		System.out.println(orgC4Int);
		System.out.print("二进制：");
		System.out.println(Integer.toBinaryString(orgC4Int));

	}
	//byte 不变是因为java中的移位运算转换为了int，前面挂的全都是1，int再转为byte后，截断了，所以逻辑和算术结果一样了。但是int就能感觉到明显区别了
 //结论：java中移位运算，一定要立足于int类型四字节以上
}
