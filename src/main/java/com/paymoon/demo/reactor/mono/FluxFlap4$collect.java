package com.paymoon.demo.reactor.mono;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import reactor.core.publisher.Flux;

/**
 flatMap 和 flatMapSequential 操作符把流中的每个元素转换成一个流，再把所有流中的元素进行合并。flatMapSequential 和 flatMap 之间的区别与 mergeSequential 和 merge 之间的区别是一样的。

在代码清单 12 中，流中的元素被转换成每隔 100 毫秒产生的数量不同的流，再进行合并。由于第一个流中包含的元素数量较少，所以在结果流中一开始是两个流的元素交织在一起，然后就只有第二个流中的元素。
 */
public class FluxFlap4$collect {
	public static void main(String[] args) {
		Flux.just(2, 34, 56, 75, 4, 56).collectList()
				.subscribe(list -> list.forEach(value -> System.out.print(value + "  ")));

		System.out.println();
		Flux.just(2, 34, 56, 75, 4, 56).collectSortedList()
				.subscribe(list -> list.forEach(value -> System.out.print(value + "  ")));

		System.out.println("\n\n****************");
		Flux.just("1 瓜田李下", "2 瓜田李下2", "3 瓜田李下3").collectMap(value -> {
			String[] s = value.split(" ");
			return s[0];
		}, value -> {
			String[] s = value.split(" ");
			return s[1];
		}).subscribe(map -> map.forEach((key, value1) -> System.out.println(key + "  " + value1)));

		System.out.println("\n****************");
		Flux.just("1 瓜田李下 瓜田李下2 瓜田李下3 瓜田李下4 瓜田李下5 瓜田李下6", "2 hello hello2 hello3 hello4 hello5 hello6")
				.collectMultimap(value -> {
					String[] s = value.split(" ");
					return s[0];
				}, value -> {
					String[] s = value.split(" ");

					List<String> list = new ArrayList<>();
					if (s.length > 1) {
						list.addAll(Arrays.asList(s).subList(1, s.length));
					}

					return list;
				}).subscribe(map -> map.forEach((key, value) -> System.out.println(key + "  " + value)));

	}
}
