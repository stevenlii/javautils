package com.paymoon.demo.Ztest;

import org.apache.commons.lang3.StringUtils;

/**
 * （1）	若已知字符串的当前字符不是大于0的数字字符，则复制该字符于新字符串中。
 * （2）	若已知字符串的当前字符是一个数字字符，且它之后没有后继字符，则简单地将它复制到新字符串中。
 * （3）	若已知字符串的当前字符是一个大于0的数字字符，并且还有后继字符，设该数字字符的面值为n，
 * 则将它的后继字符（包括后继字符是一个数字字符）重复复制n+1次到新字符串中。
 * （4）	若已知字符串的当前字符是下划线‘_’，则将当前字符串变换为用‘\UL’。
 * （5）	以上述一次变换为一组，在不同组之间另插入一个下划线‘_’用于分隔。
 *
 * @author 马志伟
 */
public class EnCodeAndDecode {

    /**
     * 加密
     *
     * @param str
     * @return
     */
    public static String enCode(String str) {
        if (StringUtils.isEmpty(str)) {
            return "";
        }
        //转数组
        char[] chars = str.toCharArray();
        //取长度
        int length = chars.length;
        StringBuffer responseStr = new StringBuffer();
        //计数器
        Integer num = 0;
        for (char c : chars) {
            num++;
            //校验是否为数字
            if (Character.isDigit(c)) {
                //条件1
                if (c <= '0') {
                    responseStr.append(c);
                    continue;
                }
                //条件2
                if (num == length) {
                    responseStr.append(c);
                }
                //条件3
                if (c > '0' && num < length) {
                    int n = Integer.parseInt("" + c) + 1;
                    char aChar = chars[num];
                    while (n > 0) {
                        responseStr.append(aChar);
                        n--;
                    }
                }
            } else {
                //条件4
                if ('_' == c) {
                    responseStr.append("\\UL");
                } else {
                    responseStr.append(c);
                }
            }
            //条件5
            if (num < length) {
                responseStr.append("_");
            }

        }
        return responseStr.toString();
    }

    /**
     * 解密
     *
     * @param enData
     * @return
     */
    public static String deCode(String enData) {
        if (StringUtils.isEmpty(enData)) {
            return null;
        }
        if (enData.indexOf("_") == -1) {
            return enData;
        }
        int num = 0;
        StringBuffer data = new StringBuffer();
        for (String str : enData.split("_")) {
            if (str.length() == 1) {
                data.append(str);
            } else {
                if (str.length() == 0 || StringUtils.isEmpty(str)) {
                    num++;
                    continue;
                }
                if (num > 2) {
                    data.append(num - 2);
                }
                num = 0;
                if ("\\UL".equals(str)) {
                    data.append("_");
                } else {
                    int n = str.length() - 1;
                    data.append(n);
                }
            }
        }
        return data.toString();
    }

    //测试
    public static void main(String[] args) {
        String s = enCode("24ab_2t2");
        System.out.println(s);
        System.out.println(deCode(s));
    }
}
