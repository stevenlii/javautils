package com.paymoon.demo.reactor.mono;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.stream.Stream;

import reactor.core.publisher.Flux;

/**
combineLatest 操作符把所有流中的最新产生的元素合并成一个新的元素，作为返回结果流中的元素。只要其中任何一个流中产生了新的元素，合并操作就会被执行一次，结果流中就会产生新的元素。
在 代码清单 14 中，流中最新产生的元素会被收集到一个数组中，通过 Arrays.toString 方法来把数组转换成 String。
 */
public class FluxCombineLatest {
	public static void main(String[] args) {
		Duration d0 = Duration.of(0, ChronoUnit.MILLIS);
		Duration d50 = Duration.of(50, ChronoUnit.MILLIS);
		Duration d100 = Duration.of(100, ChronoUnit.MILLIS);
		Duration d1s = Duration.of(1, ChronoUnit.SECONDS);
		Flux.combineLatest(
		        Arrays::toString,
		        Flux.interval(d100).take(5),
		        Flux.interval(d50, d100).take(5)
		).toStream().forEach(t -> System.out.println(t+","));
		Flux.interval(d100).take(5).subscribe(t -> System.out.println(t+","));
		Flux.interval(d1s).toStream().forEach(t -> System.out.println(t+","));
	}
}
