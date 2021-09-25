package com.paymoon.demo.java8.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.commons.collections4.map.HashedMap;
import org.apache.commons.lang3.StringUtils;

/**
 * 同时从新浪和网易查询证券代码，需要返回所有结果，才下一步查询价格，查询价格也同时从新浪和网易查询，返回所有结果，才完成操作：
https://www.liaoxuefeng.com/wiki/1252599548343744/1306581182447650
anyOf()可以实现“任意个CompletableFuture只要一个成功”，allOf()可以实现“所有CompletableFuture都必须成功
先请求完第一步，再第二步
 *
 */
public class Java8CompletableFutureAllOf4 {
	public static void main(String[] args) throws Exception {
		// 两个CompletableFuture执行异步查询:
		CompletableFuture<String> cfQueryFromSina = CompletableFuture.supplyAsync(() -> {
			return queryCode("中国石油", "https://finance.sina.com.cn/code/");
		});
		CompletableFuture<String> cfQueryFrom163 = CompletableFuture.supplyAsync(() -> {
			return queryCode("美国石油", "https://money.163.com/code/");
		});
		List<CompletableFuture<String>> futureList = new ArrayList<>(2);
		futureList.add(cfQueryFromSina);
		futureList.add(cfQueryFrom163);
		//请求聚合结合
		Map<Integer, String> ResultDtoMap = mergeFutureV3(futureList);
		System.out.println("结果1："+ResultDtoMap.get(0));
		System.out.println("结果2："+ResultDtoMap.get(1));
		//以下第二步类似第一步
		/**
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
		*/
		// 主线程不要立刻结束，否则CompletableFuture默认使用的线程池会立刻关闭:
		Thread.sleep(200);
	}

	static String queryCode(String name, String url) {
		System.out.println("query name: " + name + "'s code from " + url + "...");
		try {
			Thread.sleep((long) (Math.random() * 100));
		} catch (InterruptedException e) {
		}
		if (StringUtils.equals(name, "中国石油")) {
			return "601857";
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
	 public static final <T>  Map<Integer, T> mergeFutureV3(List<CompletableFuture<T>> futures) {
	        if (futures.isEmpty()) {
	            return new HashedMap<>();
	        }
	        // 构造数据流集合
	        Map<Integer, T> resultMap = new ConcurrentHashMap<>(futures.size() * 2);
	        for (int i = 0; i < futures.size(); i++) {
	            Integer index = i;
	            futures.get(i).thenApply(x -> resultMap.put(index, x));
	        }
	        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();

	        return resultMap;
	    }
}