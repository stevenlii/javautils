package com.paymoon.demo.reactor.mono;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;

/**
 * 在开发和调试中的另外一项实用功能是把流相关的事件记录在日志中。这可以通过添加 log 操作符来实现。在代码清单 26 中，添加了 log 操作符并指定了日志分类的名称。
 * 13:07:56.735 [main] DEBUG reactor.util.Loggers$LoggerFactory - Using Slf4j logging framework
13:07:56.751 [main] INFO Range - | onSubscribe([Synchronous Fuseable] FluxRange.RangeSubscription)
13:07:56.753 [main] INFO Range - | request(unbounded)
13:07:56.754 [main] INFO Range - | onNext(1)
1
13:07:56.754 [main] INFO Range - | onNext(2)
2
13:07:56.754 [main] INFO Range - | onComplete()
 */
public class FluxLog {
	public static void main(String[] args) {
		Flux.range(1, 2).log("Range").subscribe(System.out::println);
	}
}
