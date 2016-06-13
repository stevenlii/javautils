package com.paymoon.demo.Ztest;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class testDate {
	public static void main(String[] args) {

		run2("yyyyMMdd");

	}
/**
 * 
	 * ***************** TODO  *****************<br>
	 * method name   :  run
	 * @return		 :  void
	 * @author       :  lizhiqiang 2014年11月18日下午4:47:45
	 * **********************************************
	 * Java戏法
http://www.infoq.com/cn/articles/Java-Sleight-of-Hand
 */
	public static void run() {
		String date = "16-07-2009";

//		SimpleDateFormat sdf = new SimpleDateFormat("ddmmyyyy");
		SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy");
		try {     
		Date d = sdf.parse(date);
		System.out.println(d);
		     System.out.println(DateFormat.getDateInstance(DateFormat.MEDIUM,
		                     new Locale("US")).format(d));
		} catch (ParseException pe) {
		     System.out.println("Exception: " + pe.getMessage());
		}
	}
	/**
	 * 
		 * ***************** TODO  *****************<br>
		 * method name   :  run2
		 * @param fmt        
		 * @return		 :  void
		 * @author       :  lizhiqiang 2014年11月18日下午4:57:55
		 * **********************************************
	 */
	public static void run2(String fmt) {

		Date date=new Date();
		SimpleDateFormat df=new SimpleDateFormat(fmt);
		String time=df.format(date);
		System.out.println(time);
	
	}
}
