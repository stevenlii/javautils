package com.paymoon.demo.reactor.mono;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

import reactor.core.publisher.Flux;

/**
 flatMap 和 flatMapSequential 操作符把流中的每个元素转换成一个流，再把所有流中的元素进行合并。flatMapSequential 和 flatMap 之间的区别与 mergeSequential 和 merge 之间的区别是一样的。

在代码清单 12 中，流中的元素被转换成每隔 100 毫秒产生的数量不同的流，再进行合并。由于第一个流中包含的元素数量较少，所以在结果流中一开始是两个流的元素交织在一起，然后就只有第二个流中的元素。
 */
public class FluxFlap {
	public static void main(String[] args) {
		Duration d0 = Duration.of(0, ChronoUnit.MILLIS);
		Duration d50 = Duration.of(50, ChronoUnit.MILLIS);
		Duration d100 = Duration.of(100, ChronoUnit.MILLIS);
		Flux.just(5, 10).flatMap(x -> Flux.interval(Duration.of(x * 10, ChronoUnit.MILLIS), d100).take(x)).toStream()
				.forEach(t -> System.out.print(t + ","));
		System.out.println();
		Flux.just(5, 10).flatMapSequential(x -> Flux.interval(Duration.of(x * 10, ChronoUnit.MILLIS), d100).take(x)).toStream()
		.forEach(t -> System.out.print(t + ","));
	}
}
