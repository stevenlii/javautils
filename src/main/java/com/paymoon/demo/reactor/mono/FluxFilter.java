package com.paymoon.demo.reactor.mono;

import reactor.core.publisher.Flux;

/**
对流中包含的元素进行过滤，只留下满足 Predicate 指定条件的元素。代码清单 6 中的语句输出的是 1 到 10 中的所有偶数。
 */
public class FluxFilter {
	public static void main(String[] args) {
		Flux.range(1, 10).filter(i -> i % 2 == 0).subscribe(System.out::println);

	}
}
