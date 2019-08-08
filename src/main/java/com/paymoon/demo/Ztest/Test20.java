package com.paymoon.demo.Ztest;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.paymoon.demo.Util.MathDoubleUtil;

public class Test20 {
	private static final Logger logger = LogManager.getLogger();

	public static void main(String[] args) {
		Long lossProcessCostsInteger = (long) 1.50357097982;
		double lossProcessCosts = MathDoubleUtil.div(lossProcessCostsInteger, 1000);
		Double lastValue = (double) Double.valueOf(MathDoubleUtil.mul(lossProcessCostsInteger, 1000000)).longValue();
		System.out.println(lossProcessCosts);
		System.out.println(lastValue);
	}

}
