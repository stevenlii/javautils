package com.paymoon.demo.reactor.mono;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;

/**
reduce 和 reduceWith 操作符对流中包含的所有元素进行累积操作，得到一个包含计算结果的 Mono 序列。累积操作是通过一个 BiFunction 来表示的。在操作时可以指定一个初始值。如果没有初始值，则序列的第一个元素作为初始值。

在代码清单 10 中，第一行语句对流中的元素进行相加操作，结果为 5050；第二行语句同样也是进行相加操作，不过通过一个 Supplier 给出了初始值为 100，所以结果为 5150。
 */
public class FluxReduce {
	public static void main(String[] args) {
		Flux.range(1, 100).reduce((x, y) -> x + y).subscribe(System.out::println);
		Flux.range(1, 100).reduceWith(() -> 100, (x, y) -> x + y).subscribe(System.out::println);
	}
}
