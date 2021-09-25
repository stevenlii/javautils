package com.paymoon.demo.java8.stream;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;
import java.util.function.Supplier;

import org.apache.commons.lang3.StringUtils;

/**
 * 同时从新浪和网易查询证券代码，需要返回所有结果，才下一步查询价格，查询价格也同时从新浪和网易查询，返回所有结果，才完成操作：
https://www.liaoxuefeng.com/wiki/1252599548343744/1306581182447650
anyOf()可以实现“任意个CompletableFuture只要一个成功”，allOf()可以实现“所有CompletableFuture都必须成功
 *
 */
public class Java8CompletableFuture3 {
	public static void main(String[] args) throws Exception {
		Java8CompletableFuture3 completableFuture3 = new Java8CompletableFuture3();
		completableFuture3.run();
	}

	public void run() {

		// 两个supplier执行异步查询:
		Supplier<String> chinaSupplier = () -> queryCode("中国石油", "https://finance.sina.com.cn/code/");
		Supplier<String> usaSupplier = () -> queryCode("美国石油", "https://money.163.com/code/");

		MyTuple2<String, String> mergeCode = merge(chinaSupplier, usaSupplier);

		// 两个supplier执行异步查询:
		Supplier<Double> chinaPriceSupplier = () -> fetchPrice(mergeCode.getT1(), "https://finance.sina.com.cn/price/");
		Supplier<Double> usaPriceSupplier = () -> fetchPrice(mergeCode.getT2(), "https://money.163.com/price/");

		MyTuple2<Double, Double> mergePrice = merge(chinaPriceSupplier, usaPriceSupplier);
		// 两个supplier执行异步查询结果
		System.out.println("china:" + mergePrice.getT1());
		System.out.println("usa:" + mergePrice.getT2());

	}

	static String queryCode(String name, String url) {
		System.out.println("query name: " + name + "'s code from " + url + "...");
		try {
			Thread.sleep((long) (Math.random() * 100));
		} catch (InterruptedException e) {
		}
		if (StringUtils.equals(name, "中国石油")) {
//			return "601857";
			return null;
		}
		if (StringUtils.equals(name, "美国石油")) {
			return "88888";
		}
		return "";
	}

	static Double fetchPrice(String code, String url) {
		System.out.println("query " + code + "'s price from " + url + "...");
		try {
			Thread.sleep((long) (Math.random() * 100));
		} catch (InterruptedException e) {
		}
		if (StringUtils.equals(code, "601857")) {
			return 5 + Math.random() * 20;
		}
		if (StringUtils.equals(code, "88888")) {
			return 88888 + Math.random() * 20;
		}
		return 0d;
	}

	/**
	* 并行http请求
	* @param s1 请求1
	* @param s2 请求2
	* @param <T1> 请求1返回类型
	* @param <T2> 请求2返回类型
	* @return 返回元组
	*/
	public <T1, T2> MyTuple2<T1, T2> merge(Supplier<T1> s1, Supplier<T2> s2) {
		MyTuple2<T1, T2> tuple = new MyTuple2<>();
		CompletableFuture c1 = this.createFuture(s1, tuple::setT1);
		CompletableFuture c2 = this.createFuture(s2, tuple::setT2);
		CompletableFuture.allOf(c1, c2).join();
		return tuple;
	}

	private <T> CompletableFuture createFuture(Supplier<? extends T> supplier, Consumer<? super T> consumer) {
		return CompletableFuture.supplyAsync(supplier).thenAcceptAsync(consumer);
	}
}