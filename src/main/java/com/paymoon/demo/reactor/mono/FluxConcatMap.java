package com.paymoon.demo.reactor.mono;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

import reactor.core.publisher.Flux;

/**
concatMap 操作符的作用也是把流中的每个元素转换成一个流，再把所有流进行合并。与 flatMap 不同的是，concatMap 会根据原始流中的元素顺序依次把转换之后的流进行合并；与 flatMapSequential 不同的是，concatMap 对转换之后的流的订阅是动态进行的，而 flatMapSequential 在合并之前就已经订阅了所有的流。
 */
public class FluxConcatMap {
	public static void main(String[] args) {
		Duration d0 = Duration.of(0, ChronoUnit.MILLIS);
		Duration d50 = Duration.of(50, ChronoUnit.MILLIS);
		Duration d100 = Duration.of(100, ChronoUnit.MILLIS);
		Flux.just(5, 10).concatMap(x -> Flux.interval(Duration.of(x * 10, ChronoUnit.MILLIS), d100).take(x)).toStream()
				.forEach(t -> System.out.print(t + ","));
		System.out.println();
	}
}
