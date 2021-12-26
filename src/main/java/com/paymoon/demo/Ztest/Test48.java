package com.paymoon.demo.Ztest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.paymoon.demo.java8.stream.Person;

public class Test48 {
	private static final Logger logger = LogManager.getLogger();

	public static void main(String[] args) {
		
//		skuList.sort(Comparator.comparing((sku) -> searchAdDTO.getAllSkuList().indexOf(sku.getSku_id())));
//		List<Integer> resultList = 	Arrays.asList(924949,924984,924749,924762,924951,924759,924937,924758,925183,925232,909737,539696,539966,539942,924973,925040,925052,925181,925621,925514,924836,925038,925213,901464,901443,900743,902906,903050,903080,908993,903437,925404,904025,910244,924623,925177,925180,924748,924626,925398,925167,925222,924794,925373,925499,540605,925182,924786,904151,925220,924871,924226,905339,903434,905681,903308,903431,908738,901473,910973,901607,903089,902879,902909,903032,903059,903053,902945,904973,904874,905123,905126,903302,903536,903533,903407,903140,903137,903152,903788,903260,903458,903446,903491,903968,903485,903959,903944,908387,908681,907214,907166,907082,907085,907346,907349,907541,907514,907508,907445);
		List<Person> resultList = 	new ArrayList<>();
		Person p1 = new Person();
		p1.setId(924949);
		resultList.add(p1);
		p1 = new Person();
		p1.setId(924984);
		resultList.add(p1);
		p1 = new Person();
		p1.setId(924749);
		resultList.add(p1);
		p1 = new Person();
		p1.setId(924762);
		resultList.add(p1);
		p1 = new Person();
		p1.setId(924951);
		resultList.add(p1);
		List<Integer> searchSkuIds =  resultList.stream().map(Person::getId).distinct().collect(Collectors.toList());
		System.out.println(searchSkuIds);
	}
	
}
