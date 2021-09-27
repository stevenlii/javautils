package com.paymoon.demo.reactor.mono;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

import reactor.core.publisher.Flux;

/**
 flatMap 和 flatMapSequential 操作符把流中的每个元素转换成一个流，再把所有流中的元素进行合并。flatMapSequential 和 flatMap 之间的区别与 mergeSequential 和 merge 之间的区别是一样的。

在代码清单 12 中，流中的元素被转换成每隔 100 毫秒产生的数量不同的流，再进行合并。由于第一个流中包含的元素数量较少，所以在结果流中一开始是两个流的元素交织在一起，然后就只有第二个流中的元素。
 */
public class FluxFlap3$toIterable$toStream {
	public static void main(String[] args) {
		Flux.just("瓜田李下", "瓜田李下 2", "瓜田李下 3", "瓜田李下 4", "瓜田李下 5", "瓜田李下 6").toIterable().forEach(System.out::println);

		Flux.just("1 ", "2 ", "3 ", "4 ", "5 ", "6 ").toStream().forEach(System.out::print);

		System.out.println("\n\n************");
		String s = Flux.just("瓜田李下", "瓜田李下 2").elementAt(0).flux().toIterable().iterator().next();
		System.out.println("flux 第0个元素为：" + s);

		String s2 = Flux.just("hello world", "hello world 2", "hello world 3").last().flux().toIterable().iterator()
				.next();
		System.out.println("flux 最后一个元素为：" + s2);

	}
}
