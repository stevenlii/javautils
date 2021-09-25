package com.paymoon.demo.web.webserivice;

/**
 * 关于在idea中使用Thread.activeCount()的问题_LYuanZhuo的博客-CSDN博客
 * https://blog.csdn.net/qq_42862882/article/details/89309399
 * 
 * @author stephenlii
 *
 */
public class Test {
	public volatile int inc = 0;

	public void increase() {
		inc++;
	}

	public static void main(String[] args) {
		Thread.currentThread().getThreadGroup().list();
	}
}