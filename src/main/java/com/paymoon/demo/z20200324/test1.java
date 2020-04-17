package com.paymoon.demo.z20200324;

public class test1 implements it1, it2 {
	int x;

	@Override
	public void seta1(int n) {
		x += n;

	}

	@Override
	public int geta1() {
		return x;
	}

	public static void main(String[] args) throws InterruptedException {
		test1 t1 = new test1();
		new Thread(new Runnable() {
			@Override
			public synchronized void run() {
				t1.seta1(1);
			}

		}).start();
		new Thread(new Runnable() {
			@Override
			public synchronized void run() {
				t1.seta1(1);
			}
			
		}).start();

		System.out.println(t1.geta1());
	}
}
