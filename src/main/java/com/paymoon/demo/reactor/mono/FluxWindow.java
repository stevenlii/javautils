package com.paymoon.demo.reactor.mono;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

import reactor.core.publisher.Flux;

/**
window 操作符的作用类似于 buffer，所不同的是 window 操作符是把当前流中的元素收集到另外的 Flux 序列中，因此返回值类型是 Flux<flux>。在代码清单 7 中，两行语句的输出结果分别是 5 个和 2 个 UnicastProcessor 字符。这是因为 window 操作符所产生的流中包含的是 UnicastProcessor 类的对象，而 UnicastProcessor 类的 toString 方法输出的就是 UnicastProcessor 字符。
 */
public class FluxWindow {
	public static void main(String[] args) {
		Flux.range(1, 100).window(20).subscribe(System.out::println);
		Flux.interval(Duration.of(100, ChronoUnit.MILLIS)).window(Duration.of(10001, ChronoUnit.MILLIS)).take(2).toStream().forEach(System.out::println);
	}
}
