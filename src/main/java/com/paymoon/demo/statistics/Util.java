package com.paymoon.demo.statistics;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

class Util{
/**
 * 
	 * ***************** 生成日期的方法，返回"yyyyMMdd" *****************<br>
	 * method name   :  calender
	 * @return		 :  String
	 * @author       :  lizhiqiang 2014年11月13日下午3:23:54
	 * **********************************************
 */
	public static String calender() {
		return "20141107";
//		 return calender("yyyyMMdd");
	}
	
	public static String calender(String fmt) {
		Date date=new Date();
		SimpleDateFormat df=new SimpleDateFormat(fmt);
		String time=df.format(date);
		return time;
	}
	/**
	 * 
		 * *****************基姆拉尔森计算星期几  *****************<br>
		 * method name   :  weekNo
		 * @return		 :  String
		 * @author       :  lizhiqiang 2014年11月13日下午5:35:03
		 * 一月和二月看成是上一年的十三月和十四月，例：如果是2004-1-10则换算成：2003-13-10来代入公式计算
		 * **********************************************
	 */
	public static String weekNo() {
		
		String year = calender("yyyy");
		String MM = calender("MM");
		String dd = calender("dd");
		// y－年，m－月，d－日期
		int y = Integer.parseInt(year);
		int m = Integer.parseInt(MM);
		int d = Integer.parseInt(dd);
		if (m == 1 || m == 2) {
			m += 12;
			y--;
		}
		int week = (d + 2 * m + 3 * (m + 1) / 5 + y + y / 4 - y / 100 + y / 400) % 7;
		String weekNo = "";
		switch (week) {
		case 0:
			weekNo = "1";
			break;// 星期一
		case 1:
			weekNo = "2";
			break;// 星期二
		case 2:
			weekNo = "3";
			break;// 星期三
		case 3:
			weekNo = "4";
			break;// 星期四
		case 4:
			weekNo = "5";
			break;// 星期五
		case 5:
			weekNo = "6";
			break;// 星期六
		case 6:
			weekNo = "0";
			break;// 星期日
		}
		return weekNo;
	}
	/**
	 * 
		 * ***************** 计算百分比  *****************<br>
		 * method name   :  percent
		 * @return		 :  String
		 * @author       :  lizhiqiang 2014年11月14日上午10:23:50
		 * **********************************************
	 */
	  public static String percent(Long member, Long denominator) {
		  String perRate = "";// 接受百分比的值
		  if (denominator == 0) {
			return "0";
		}
	        double baiy = member * 1.0;
	        double baiz = denominator * 1.0;
	        double fen = baiy / baiz;
	        // NumberFormat nf = NumberFormat.getPercentInstance(); 注释掉的也是一种方法
	        // nf.setMinimumFractionDigits( 2 ); 保留到小数点后几位
	        DecimalFormat df1 = new DecimalFormat("##.00%"); // ##.00%
	                                                            // 百分比格式，后面不足2位的用0补齐
	        // baifenbi=nf.format(fen);
	        perRate = df1.format(fen);
	        if (perRate.equals(".00%")) {
	        	perRate = "0";
			}
	        
	        return perRate;
	    }
	  public static String percent(int member, int denominator) {
		  String perRate = "";// 接受百分比的值
		  if (denominator == 0) {
			  return "0";
		  }
		  double baiy = member * 1.0;
		  double baiz = denominator * 1.0;
		  double fen = baiy / baiz;
		  // NumberFormat nf = NumberFormat.getPercentInstance(); 注释掉的也是一种方法
		  // nf.setMinimumFractionDigits( 2 ); 保留到小数点后几位
		  DecimalFormat df1 = new DecimalFormat("##.00%"); // ##.00%
		  // 百分比格式，后面不足2位的用0补齐
		  // baifenbi=nf.format(fen);
		  perRate = df1.format(fen);
		  if (perRate.equals(".00%")) {
			  perRate = "0";
		  }
		  
		  return perRate;
	  }
	  
	 
}