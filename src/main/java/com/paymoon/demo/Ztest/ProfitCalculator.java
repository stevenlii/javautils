package com.paymoon.demo.Ztest;

import java.math.BigDecimal;

import com.paymoon.demo.Util.MathDoubleUtil;

/**
 * 毛利率计算公共类
 * 
 * @author lizhiqiang09
 *
 */
public class ProfitCalculator {
	/**
	 * 毛利率计算
	 * 
	 * @param price
	 * @param costPrice
	 * @return
	 */
	public static double calcProfitScope(Double price, Double costPrice) {
		if (costPrice == null || costPrice.doubleValue() < 0) {
			costPrice = 0d;
		}
		if (price != null && price.doubleValue() > 0) {
			return MathDoubleUtil.div(MathDoubleUtil.sub(price, costPrice), price);
		}
		return 0;

	}

	/**
	 * 毛利率计算
	 * 
	 * @param price
	 * @param costPrice
	 * @return
	 */
	public static BigDecimal calcProfitScope(BigDecimal price, BigDecimal costPrice) {
		if (costPrice == null || costPrice.doubleValue() < 0) {
			costPrice = new BigDecimal(0);
		}
		if (price != null && price.doubleValue() > 0) {
			return new BigDecimal(calcProfitScope(price.doubleValue(), costPrice.doubleValue()));
		}
		return new BigDecimal(0);

	}

	/**
	 * 毛利率计算
	 * 
	 * @param price
	 * @param costPrice
	 * @return
	 */
	public static double calcProfitScopeDouble(BigDecimal price, BigDecimal costPrice) {
		if (costPrice == null) {
			costPrice = new BigDecimal(0);
		}
		if (costPrice.doubleValue() < 0) {
			costPrice = new BigDecimal(0);
		}
		if (price != null && price.doubleValue() > 0) {
			return calcProfitScope(price.doubleValue(), costPrice.doubleValue());
		}
		return 0;

	}

	/**
	 * 计算价格
	 * 
	 * @param profit
	 * @param costPrice
	 * @return
	 */
	public static double calcPrice(Double profit, Double costPrice) {
		if (costPrice == null || costPrice.doubleValue() < 0) {
			costPrice = 0d;
		}
		if (profit != null && profit.doubleValue() >= 0 && profit.doubleValue() < 1) {
			return MathDoubleUtil.div(costPrice, MathDoubleUtil.sub(1, profit));
		}
		return 0;

	}

	/**
	 * 计算价格
	 * 
	 * @param profit
	 * @param costPrice
	 * @return
	 */
	public static BigDecimal calcPriceWithProfit(BigDecimal profit, BigDecimal costPrice) {
		if (costPrice == null || costPrice.doubleValue() < 0) {
			costPrice = new BigDecimal(0);
		}
		if (profit != null && profit.doubleValue() >= 0 && profit.doubleValue() < 1) {
			return new BigDecimal(calcPrice(profit.doubleValue(), costPrice.doubleValue()));
		}
		return new BigDecimal(0);

	}

	/**
	 * 计算价格
	 * 
	 * @param profit
	 * @param costPrice
	 * @return
	 */
	public static double calcPriceDouble(BigDecimal profit, BigDecimal costPrice) {
		if (costPrice == null) {
			costPrice = new BigDecimal(0);
		}
		if (costPrice.doubleValue() < 0) {
			costPrice = new BigDecimal(0);
		}
		if (profit != null && profit.doubleValue() >= 0 && profit.doubleValue() < 1) {
			return calcPrice(profit.doubleValue(), costPrice.doubleValue());
		}
		return 0;

	}

	/**
	 * 变价幅度
	 * 
	 * @param price
	 * @param costPrice
	 * @return
	 */
	public static double calcChangeRangeDouble(BigDecimal newPrice, BigDecimal currentPrice) {
		if (currentPrice == null || currentPrice.doubleValue() < 0) {
			currentPrice = new BigDecimal(0);
		}
		if (newPrice != null && newPrice.doubleValue() > 0) {
			return MathDoubleUtil.div(MathDoubleUtil.sub(newPrice.doubleValue(), currentPrice.doubleValue()),
					newPrice.doubleValue());
		}
		return 0;

	}
}