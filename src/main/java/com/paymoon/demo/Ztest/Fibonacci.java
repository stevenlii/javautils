package com.paymoon.demo.Ztest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Fibonacci {
	private static final Logger logger = LogManager.getLogger();

	public static void main(String[] args) {
		System.out.println(fib(193));
	}

	public static int fib(int n) {
        int[] flag = new int[n+1];
        return dp(n,flag);
    }

    private static int dp(int n,int[] flag){
        if(n == 0) return 0;
        if(n == 1 || n == 2) return 1;
        flag[n] = flag[n] == 0 ? (dp(n-2,flag) + dp(n-1,flag))%1000000007 : flag[n];
        return flag[n];
    }
    
}
