package com.paymoon.demo.reactor.mono;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;

/**
“冷”与”热”序列
之前的代码清单中所创建的都是冷序列。冷序列的含义是不论订阅者在何时订阅该序列，总是能收到序列中产生的全部消息。而与之对应的热序列，则是在持续不断地产生消息，订阅者只能获取到在其订阅之后产生的消息。

在代码清单 28 中，原始的序列中包含 10 个间隔为 1 秒的元素。通过 publish()方法把一个 Flux 对象转换成 ConnectableFlux 对象。方法 autoConnect()的作用是当 ConnectableFlux 对象有一个订阅者时就开始产生消息。代码 source.subscribe()的作用是订阅该 ConnectableFlux 对象，让其开始产生数据。接着当前线程睡眠 5 秒钟，第二个订阅者此时只能获得到该序列中的后 5 个元素，因此所输出的是数字 5 到 9。
 */
public class FluxHot {
	public static void main(String[] args) {
		Duration d1000 = Duration.of(1000, ChronoUnit.MILLIS);
		final Flux<Long> source = Flux.interval(d1000).take(10).publish().autoConnect();
		source.subscribe();
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
		}
		source.toStream().forEach(System.out::println);
	}
}
