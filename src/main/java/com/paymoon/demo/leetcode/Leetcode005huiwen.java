package com.paymoon.demo.leetcode;
public class Leetcode005huiwen {

    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }

        int maxLen = 1;
        int begin = 0;
        // dp[i][j] 表示 s[i..j] 是否是回文串
        boolean[][] dp = new boolean[len][len];
        // 初始化：所有长度为 1 的子串都是回文串
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }

        char[] charArray = s.toCharArray();
        // 递推开始
        // 先枚举子串长度
        for (int L = 1; L < len; L++) {
            // 枚举左边界，左边界的上限设置可以宽松一些
            for (int i = 0,j = L + i; i < len&&j < len; i++,j = L + i) {
                // 由 L 和 i 可以确定右边界，即 j - i = L 得(步长)
//                int j = L + i;
               
            	//小于3的，直接是true,大于3的，用之前计算的结果。这就是动态规划的核心
                if (charArray[i] != charArray[j]) {
                    dp[i][j] = false;
                } else {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
//                System.out.println("L="+L+",i="+i+",j="+j+",len="+len+",dp[i][j]="+dp[i][j]);
                // 只要 dp[i][L] == true 成立，就表示子串 s[i..L] 是回文，此时记录回文长度和起始位置
                
                if (dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }
    public static void main(String[] args) {
    	String huiwen = "sa11211";
		System.out.println(new Leetcode005huiwen().longestPalindrome(huiwen));
	}
}

