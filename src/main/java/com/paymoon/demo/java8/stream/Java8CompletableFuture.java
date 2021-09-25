package com.paymoon.demo.java8.stream;

import java.util.concurrent.CompletableFuture;
/**
 * 同时从新浪和网易查询证券代码，只要任意一个返回结果，就进行下一步查询价格，查询价格也同时从新浪和网易查询，只要任意一个返回结果，就完成操作：
https://www.liaoxuefeng.com/wiki/1252599548343744/1306581182447650

重点：只要任意一个返回结果
 *
 */
public class Java8CompletableFuture {
	public static void main(String[] args) throws Exception {
		new Java8CompletableFuture().test();
	}
		public  void test()  {
		// 两个CompletableFuture执行异步查询:
		CompletableFuture<String> cfQueryFromSina = CompletableFuture.supplyAsync(() -> {
			return queryCode("新浪", "https://finance.sina.com.cn/code/");
		});
		CompletableFuture<String> cfQueryFrom163 = CompletableFuture.supplyAsync(() -> {
			return queryCode("中国石油", "https://money.163.com/code/");
		});

		// 用anyOf合并为一个新的CompletableFuture:
		CompletableFuture<Object> cfQuery = CompletableFuture.anyOf(cfQueryFromSina, cfQueryFrom163);

		// 两个CompletableFuture执行异步查询:
		CompletableFuture<Double> cfFetchFromSina = cfQuery.thenApplyAsync((code) -> {
			return fetchPrice((String) code, "https://finance.sina.com.cn/price/");
		});
		CompletableFuture<Double> cfFetchFrom163 = cfQuery.thenApplyAsync((code) -> {
			return fetchPrice((String) code, "https://money.163.com/price/");
		});

		// 用anyOf合并为一个新的CompletableFuture:
		CompletableFuture<Object> cfFetch = CompletableFuture.anyOf(cfFetchFromSina, cfFetchFrom163);

		// 最终结果:
		cfFetch.thenAccept((result) -> {
			System.out.println("price: " + result);
		});
		// 主线程不要立刻结束，否则CompletableFuture默认使用的线程池会立刻关闭:
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
		}
	}

	private String queryCode(String name, String url) {
		int code = (int) (Math.random() * 2000);
		System.out.println("query name: "+name+"'s code from " + url + "...，resultCode:"+code);
		try {
			Thread.sleep((long) (Math.random() * 100));
		} catch (InterruptedException e) {
		}
		return String.valueOf(code);
	}

	private Double fetchPrice(String code, String url) {
		double price = 5 + Math.random() * 20;
		System.out.println("query "+ code+"'s price from " + url + "...，resultPrice:"+price);
		try {
			Thread.sleep((long) (Math.random() * 100));
		} catch (InterruptedException e) {
		}
		return price;
	}
}