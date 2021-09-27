package com.paymoon.demo.reactor.mono;

import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import reactor.core.publisher.Mono;

/*
 * Mono 的创建方式与之前介绍的 Flux 比较相似。
 * Mono 类中也包含了一些与 Flux 类中相同的静态方法。
 * 这些方法包括 just()，empty()，error()和 never()等。
 * 除了这些方法之外，Mono 还有一些独有的静态方法。
 */
public class MonoSimple2 {
	private static Logger log = LogManager.getLogger(MonoSimple2.class);

	public static void main(String[] args) {
		Mono.just("test").subscribe(System.out::printf);
		// Mono.just("Hello", "World").subscribe(System.out::printf);
//		Mono.fromArray(new Integer[] { 1, 2, 3 }).subscribe(System.out::print);
		System.out.println();
		Mono.empty().subscribe(System.out::print);
		System.out.println();
//		Mono.range(1, 18).subscribe(System.out::print);
		System.out.println();
//		Mono.interval(Duration.of(100, ChronoUnit.SECONDS)).subscribe(System.out::print);
		System.out.println("..end");
		Mono.fromSupplier(() -> "Hello").subscribe(System.out::println);
		Mono.justOrEmpty(Optional.of("Hello")).subscribe(System.out::println);
		Mono.create(sink -> sink.success("Hello")).subscribe(System.out::println);
	}

	public Object main2(Object object) {
		Mono<Exception> flux = (Mono<Exception>) object;
		return flux.onErrorResume(t -> {
			log.error("ttttttttt", t);
			return Mono.empty();
		});
	}

	public Object main3(Object object) {
		Mono<String> flux = Mono.just("111");
		return flux.onErrorResume(t -> {
			log.error("ttttttttt", t);
			 return Mono.just("");
		});
	}

}
