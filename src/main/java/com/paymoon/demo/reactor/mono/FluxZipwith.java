package com.paymoon.demo.reactor.mono;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;

/**
 * zipWith 操作符把当前流中的元素与另外一个流中的元素按照一对一的方式进行合并。在合并时可以不做任何处理，由此得到的是一个元素类型为 Tuple2 的流；也可以通过一个 BiFunction 函数对合并的元素进行处理，所得到的流的元素类型为该函数的返回值。

在代码清单 8 中，两个流中包含的元素分别是 a，b 和 c，d。第一个 zipWith 操作符没有使用合并函数，因此结果流中的元素类型为 Tuple2；第二个 zipWith 操作通过合并函数把元素类型变为 String。
 *
 */
public class FluxZipwith {
	public static void main(String[] args) {
		Flux.just("a", "b").zipWith(Flux.just("c", "d")).subscribe(System.out::println);
		Flux.just("a", "b").zipWith(Flux.just("c", "d"), (s1, s2) -> String.format("%s-%s", s1, s2))
				.subscribe(System.out::println);
		Flux<Tuple2<String, String>> zipResult = Flux.just("a", "b").zipWith(Flux.just("c", "d"));
		zipResult.subscribe(t -> {
			System.out.println("t.get1:"+t.getT1());
			System.out.println("t.get2:"+t.getT2());
		});
	}
}
