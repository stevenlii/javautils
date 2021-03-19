package com.paymoon.demo.reactor.mono;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

import reactor.core.publisher.Flux;

/**
merge 和 mergeSequential 操作符用来把多个流合并成一个 Flux 序列。不同之处在于 merge 按照所有流中元素的实际产生顺序来合并，而 mergeSequential 则按照所有流被订阅的顺序，以流为单位进行合并。

代码清单 11 中分别使用了 merge 和 mergeSequential 操作符。进行合并的流都是每隔 100 毫秒产生一个元素，不过第二个流中的每个元素的产生都比第一个流要延迟 50 毫秒。在使用 merge 的结果流中，来自两个流的元素是按照时间顺序交织在一起；而使用 mergeSequential 的结果流则是首先产生第一个流中的全部元素，再产生第二个流中的全部元素。
 */
public class FluxMerge {
	public static void main(String[] args) {
		Duration d0 = Duration.of(0, ChronoUnit.MILLIS);
		Duration d50 = Duration.of(50, ChronoUnit.MILLIS);
		Duration d100 = Duration.of(100, ChronoUnit.MILLIS);
		
		System.out.println(d100.toMillis());
		Flux.merge(Flux.interval(d0,d100).take(5), Flux.interval(d50,d100).take(5)).toStream()
				.forEach(t -> System.out.print(t+","));
		System.out.println();
		Flux.mergeSequential(Flux.interval(d0,d100).take(5), Flux.interval(d50,d100).take(5)).toStream()
				.forEach(t -> System.out.print(t+","));
	}
}
