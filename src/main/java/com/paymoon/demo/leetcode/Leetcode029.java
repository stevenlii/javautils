package com.paymoon.demo.leetcode;

public class Leetcode029 {
	public static void main(String[] args) {
		Leetcode029 leetcode = new Leetcode029();
		System.out.println(leetcode.fractionToDecimal(1,2));
	}
	 public String fractionToDecimal(int numerator, int denominator) {
		 String result = "";
		 double numeratorD = Double.valueOf(numerator);
		 double denominatorD = Double.valueOf(denominator);
		 if (numeratorD % denominatorD == 0) {
			return String.valueOf(numeratorD/denominatorD);
		 }
		 result = String.valueOf(numeratorD/denominatorD);
		 result += String.valueOf(numeratorD % denominatorD);
		 return result;
	    }
}
