package com.paymoon.demo.java8.stream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Consumer;
import java.util.function.Supplier;

import org.apache.commons.lang3.StringUtils;

/**
 * 同时从新浪和网易查询证券代码，需要返回所有结果，才下一步查询价格，查询价格也同时从新浪和网易查询，返回所有结果，才完成操作：
https://www.liaoxuefeng.com/wiki/1252599548343744/1306581182447650
 *
 */
public class Java8CompletableFutureList {
	public static void main(String[] args) throws Exception {
		Java8CompletableFutureList completableFuture3 = new Java8CompletableFutureList();
		completableFuture3.run();
	}

	public void run() {
		List<CompletableFuture<Person>> futureList = new ArrayList<>(2);

		// 两个supplier执行异步查询:
		Supplier<Person> chinaSupplier = () -> queryCode("中国石油", "https://finance.sina.com.cn/code/");
		Supplier<Person> usaSupplier = () -> queryCode("美国石油", "https://money.163.com/code/");
		
		CompletableFuture<Person> future = CompletableFuture.supplyAsync(chinaSupplier);
		CompletableFuture<Person> future2 = CompletableFuture.supplyAsync(usaSupplier);
		futureList.add(future);
		futureList.add(future2);
		// 两个supplier执行异步查询结果
		System.out.println("china:" + futureList.get(0));
		System.out.println("usa:" + futureList.get(1));

	}

	public Person queryCode(String name, String url) {
		System.out.println("query name: " + name + "'s code from " + url + "...");
		try {
			Thread.sleep((long) (Math.random() * 100));
		} catch (InterruptedException e) {
		}
		if (StringUtils.equals(name, "中国石油")) {
			return new Person(1111, name);
		}
		if (StringUtils.equals(name, "美国石油")) {
			return new Person(22222, name);
		}
		return null;
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
	
    public final <T> List<T> mergeFutureV2(List<CompletableFuture<T>> futures) {
        if (futures.isEmpty()) {
            return Collections.emptyList();
        }
        // 构造数据流集合
        Map<Integer, T> resultMap = new ConcurrentHashMap<>(futures.size() * 2);
        for (int i = 0; i < futures.size(); i++) {
            Integer index = i;
            futures.get(i).thenApply(x -> resultMap.put(index, x));
        }
        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();
        // 按照传入顺序进行流合并
        List<T> resultList = new ArrayList<>(futures.size());
        for (int i = 0; i < futures.size(); i++) {
            if (resultMap.get(i) != null) {
                resultList.add(resultMap.get(i));
            }
        }
        return resultList;
    }
	private <T> CompletableFuture createFuture(Supplier<? extends T> supplier, Consumer<? super T> consumer) {
		return CompletableFuture.supplyAsync(supplier).thenAcceptAsync(consumer);
	}
}