package com.paymoon.demo.reactor.mono;

import static org.hamcrest.CoreMatchers.nullValue;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.Optional;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/*
当需要处理 Flux 或 Mono 中的消息时，如之前的代码清单所示，可以通过 subscribe 方法来添加相应的订阅逻辑。在调用 subscribe 方法时可以指定需要处理的消息类型。可以只处理其中包含的正常消息，也可以同时处理错误消息和完成消息。代码清单 15 中通过 subscribe()方法同时处理了正常消息和错误消息。
 */
public class MonoMessageHandler {
	public static void main(String[] args) {
		Flux.just(1, 2).concatWith(Mono.error(new IllegalStateException())).subscribe(System.out::println,
				System.err::println);
		// 清单 16. 出现错误时返回默认值

		Flux.just(1, 2).concatWith(Mono.error(new IllegalStateException())).onErrorReturn(0)
				.subscribe(System.out::println);
		
		//第二种策略是通过 switchOnError()方法来使用另外的流来产生元素。在代码清单 17 中，当出现错误时，将产生 Mono.just(0)对应的流，也就是数字 0。

		//清单 17. 出现错误时使用另外的流

//		Flux.just(1, 2)
//        .concatWith(Mono.error(new IllegalStateException()))
//        .switchOnNext(Mono.just(0))
//        .subscribe(System.out::println);
		
//		Flux.just(1, 2)
//        .concatWith(Mono.error(new IllegalArgumentException()))
//        .onErrorResumeWith(e -> {
//            if (e instanceof IllegalStateException) {
//                return Mono.just(0);
//            } else if (e instanceof IllegalArgumentException) {
//                return Mono.just(-1);
//            }
//            return Mono.empty();
//        })
//        .subscribe(System.out::println);
	}
}
