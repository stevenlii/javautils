package com.paymoon.demo.Ztest;

import java.math.BigDecimal;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.paymoon.demo.Util.MathDoubleUtil;

public class Test30 {
	private static final Logger logger = LogManager.getLogger();

	public static void main(String[] args) {
		double new_profit = ProfitCalculator.calcProfitScopeDouble(new BigDecimal(6.65), new BigDecimal(5.3));
		new_profit = MathDoubleUtil.mul(new_profit, 100);
		System.out.println(new BigDecimal(new_profit).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
	}
	
}
