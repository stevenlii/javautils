package com.paymoon.demo.reactor.mono;

import java.util.ArrayList;
import java.util.Random;

import reactor.core.publisher.Flux;

/**
 *create()方法与 generate()方法的不同之处在于所使用的是 FluxSink 对象。FluxSink 支持同步和异步的消息产生，并且可以在一次调用中产生多个元素。在代码清单 3 中，在一次调用中就产生了全部的 10 个元素。
 *
 */
public class FluxCreate {
	public static void main(String[] args) {
		Flux.create(sink -> {
			for (int i = 0; i < 10; i++) {
				sink.next(i);
			}
			sink.complete();
		}).subscribe(System.out::println);
	}
}
