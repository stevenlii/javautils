package com.paymoon.demo.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Leetcode022_2 {
	 public List<String> list;
	    public List<String> generateParenthesis(int n) {
	        list = new ArrayList<String>();
	        dfs(0,0,"",n);

	        return list;
	    }
	    public void dfs(int left,int right,String str,int n){

	        if((left+right)==n*2){
	            list.add(str);
	        }

	        if(left<n){
	            dfs(left+1,right,str+"(",n);
	        }

	        if(right<n && right<left){
	            dfs(left,right+1,str+")",n);
	        }

	    }

	public static void main(String[] args) {
		System.out.println(new Leetcode022_2().generateParenthesis(3));
	}
}
