package com.paymoon.demo.reactor.mono;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;

/**
take 系列操作符用来从当前流中提取元素。提取的方式可以有很多种。

take(long n)，take(Duration timespan)和 takeMillis(long timespan)：按照指定的数量或时间间隔来提取。
takeLast(long n)：提取流中的最后 N 个元素。
takeUntil(Predicate<? super T> predicate)：提取元素直到 Predicate 返回 true。
takeWhile(Predicate<? super T> continuePredicate)： 当 Predicate 返回 true 时才进行提取。
takeUntilOther(Publisher<?> other)：提取元素直到另外一个流开始产生元素。
在代码清单 9 中，第一行语句输出的是数字 1 到 10；第二行语句输出的是数字 991 到 1000；第三行语句输出的是数字 1 到 9；第四行语句输出的是数字 1 到 10，使得 Predicate 返回 true 的元素也是包含在内的。
 */
public class FluxTake {
	public static void main(String[] args) {
		Flux.range(1, 1000).take(10).subscribe(t -> System.out.print(t+","));
		System.out.println();
		Flux.range(1, 1000).takeLast(10).subscribe(t -> System.out.print(t+","));
		System.out.println();
		Flux.range(1, 1000).takeWhile(i -> i < 10).subscribe(t -> System.out.print(t+","));
		System.out.println();
		Flux.range(1, 1000).takeUntil(i -> i == 10).subscribe(t -> System.out.print(t+","));
	}
}
