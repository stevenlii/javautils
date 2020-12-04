package com.paymoon.demo.Ztest;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Test36 {
	private static final Logger logger = LogManager.getLogger();

	public static void main(String[] args) {

		List<Integer> alarmItemDtos = null;
		List<Integer> alarmItemDtosOpen = alarmItemDtos.parallelStream().collect(Collectors.toList());
		List<Integer> alarmItemDtosOpenMap = alarmItemDtosOpen.parallelStream().collect(Collectors.toList());

//		for (Entry<String, List<PriceInsigntAlarmItemDto>> entry : alarmItemDtosOpenMap.entrySet()) {
	}

}
