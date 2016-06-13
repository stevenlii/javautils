package com.paymoon.demo.web.tcprpc;

public class SayHeloServiceImpl implements SayHeloService{

	@Override
	public String sayHello(String helloArg) {
		if (helloArg.equals("hello")) {
			return "hello";
		}else {
			return "bye";
		}
	}

}
