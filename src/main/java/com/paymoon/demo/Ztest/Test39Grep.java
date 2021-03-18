package com.paymoon.demo.Ztest;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.beanutils.BeanMap;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.paymoon.demo.java8.stream.Person;

public class Test39Grep {
	private static final Logger logger = LogManager.getLogger();

	public static void main(String[] args) {
		List<String> replaceList = new ArrayList<>();
		replaceList.add("aa");
		replaceList.add("bb");
		replaceList.add("cc");
		replaceList.add("dd");
//		getMatchedAndReplaceStr(getClazzName(),replaceList);
//		getMatchedStr(getClazzName());
		Person person = new Person(33, "tony", 88, new BigDecimal(2200));
		System.out.println(getMatchedAndReplaceStr2(getClazzName2(),person));
	}

	public static String getClazzName() {
		String clazzName3 = "https://aftersale.stage.paymoon.com/#/service/appraise?task_id={{_pticket}}&passport_id={{passportId}}&company_id={{companyId}}&evaluate_source={{appraiseSource}}";
		return clazzName3;
	}
	public static String getClazzName2() {
		String clazzName3 = "https://aftersale.stage.paymoon.com/#/service/appraise?task_id={{age}}&passport_id={{id}}&company_id={{name}}&evaluate_source={{money}}";
		return clazzName3;
	}
	/**
	 * 匹配花括号
	 * @param str
	 */
	public static void getMatchedStr(String str) {      
	     if(str!=null && !"".equals(str)) {      
	         Pattern pattern = Pattern.compile("\\{\\{(.*?)\\}\\}"); 
	         Matcher matcher = pattern.matcher(str); 
	         while (matcher.find()) { 
	        	 System.out.println(matcher.group(0));
	        	 System.out.println(matcher.group(1));//匹配括号内
	        	 if (StringUtils.equals(matcher.group(0), "{{_pticket}}")) {
						System.out.println(1111);
					}
	         }  
	     }else {      
	        System.out.println("str is null");
	     }           
	 }   
	/**
	 * 匹配花括号并替换
	 * @param str
	 * @return 
	 */
	public static String getMatchedAndReplaceStr(String str,List<String> replaceList) {      
		if(str!=null && !"".equals(str)) {      
			Pattern pattern = Pattern.compile("\\{\\{(.*?)\\}\\}"); 
			Matcher matcher = pattern.matcher(str); 
			StringBuffer result = new StringBuffer();
			int index = 0;
			while (matcher.find()) { 
				System.out.println(matcher.group());
				matcher.appendReplacement(result, replaceList.get(index++));
				System.out.println(result);
				
			}  
		}         
		return str;
	}   
	/**
	 * 匹配花括号并替换2_使用java bean 转map替换
	 * @param str
	 * @return 
	 */
	public static String getMatchedAndReplaceStr2(String title,Person person) {

		if (StringUtils.isEmpty(title)) {
			return title;
		}
		/* 1.正则表达式，命中url模板变量如{{taskId}}，命中的group1则代表花括号内属性，即matcher.group(1)获取到taskId */
		Pattern pattern = Pattern.compile("\\{\\{(.*?)\\}\\}");
		Matcher matcher = pattern.matcher(title);
		/* 2. 替换的结果初始化，以备在matcher中使用 */
		StringBuffer result = new StringBuffer();
		/* 3. bean2map, 方便使用属性取值 */
		BeanMap detailMap = new BeanMap();
		if (person != null) {
			detailMap = new BeanMap(person);
		}
		while (matcher.find()) {
				/* 5.属性值处理，默认值空串 */
				String replaceStr = "";
				if (detailMap.get(matcher.group(1)) != null) {
					replaceStr = String.valueOf(detailMap.get(matcher.group(1)));
				}
				/* 6.属性替换处理，结果赋值给result */
				matcher.appendReplacement(result, replaceStr);
		}
		/* 返回处理结果 */
		return result.toString();
	
	}   

}
