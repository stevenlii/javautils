package com.paymoon.demo.z20200324;

import java.util.ArrayList;
import java.util.List;

public class test3 {
	public static void main(String[] args) {
		List<String> t1 = new ArrayList<String>();
		List<String> t2 = new ArrayList<String>();
		t2.add("1");
		t2.add("2");
		t1.addAll(t2);
		List<String> t3 = new ArrayList<String>();
		t3.add("3");
		t3.add("4");
		t1.addAll(t3);
		System.out.println(t1);

	}
}

