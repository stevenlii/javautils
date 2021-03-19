package com.paymoon.demo.reactor.mono;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class FluxSimple {
	public static void main(String[] args) {
		Flux.just("Hello", "World").subscribe(System.out::printf);
		Flux.fromArray(new Integer[] { 1, 2, 3 }).subscribe(System.out::print);
		System.out.println();
		Flux.empty().subscribe(System.out::print);
		System.out.println();
		Flux.range(1, 18).subscribe(System.out::print);
		System.out.println();
		Duration d0 = Duration.of(0, ChronoUnit.MILLIS);
		Duration d50 = Duration.of(50, ChronoUnit.MILLIS);
		Duration d100 = Duration.of(100, ChronoUnit.MILLIS);
		Duration d1s = Duration.of(1, ChronoUnit.SECONDS);

		System.out.println("d1s");
//		Flux.interval(d100).subscribe(System.out::print);
		Flux.interval(d1s).toStream().forEach(t -> System.out.println(t+","));

		System.out.println("..end");
	}
}
