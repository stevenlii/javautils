package com.paymoon.demo.Ztest;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Test9 {
	private static final Logger logger = LogManager.getLogger();

	public static void main(String[] args) {
		List<List<Boolean>> booleansall = new ArrayList<>();
		List<Boolean> booleans = new ArrayList<>();
		List<Boolean> booleans2 = new ArrayList<>();
		booleans.add(true);
		booleans.add(true);
		booleans.add(true);
		booleans.add(true);
		booleans.add(true);
		booleans.add(true);
		booleans.add(true);
		
		booleans2.add(true);
		booleans2.add(true);
		booleans2.add(true);
		booleans2.add(true);
		booleans2.add(true);
		booleans2.add(true);
		booleans2.add(true);	
		booleansall.add(booleans2);
		booleansall.add(booleans);
		System.out.println(booleansall);
		String sss = "[true, true, true, true, true, true, true]";
		
		booleans = new ArrayList<>();
		boolean[][] grid = (boolean[][]) booleansall.toArray();
	}
	
	public static int numIslands(boolean[][] grid) {
		int landnum = 0;
		for (int i = 0; i < grid.length; i++) {
			boolean[] bs = grid[i];

			for (int j = 0; j < bs.length; j++) {
				boolean current = grid[i][j];
				// first num
				if (i == 0 && j == 0 && current) {
					//System.out.println(i+" first num " +j);
					if (i+1<grid.length) {
						boolean firstDrop = grid[i+1][0];
						if (current&&!firstDrop) {
							landnum++;
						}
					}else {
						landnum++;
					}
					
				}
				// 左墙
				else if (i != 0 && j == 0) {
					int nextline = i + 1;
					if (nextline < grid.length) {
						boolean leftWallDrop = grid[i + 1][0];
						if (current && !leftWallDrop) {
							//System.out.println(i+"左墙"+j);
							landnum++;
						}
					} else if (i == (grid.length - 1)) {// 左墙角
						if (current) {
							//System.out.println(i+"左墙"+j);
							landnum++;
						}
					}
				}
				// 中间
				else if (j != 0) {
					boolean pre = grid[i][j - 1];
					if (i + 1 < grid.length) {
						boolean drop = grid[i + 1][j];
						if (current && !pre && !drop) {
							
							//diagonal对角线
							if (i-1>=0&&j-1>=0) {
								boolean diagonal = grid[i - 1][j-1];
								if (current&&!diagonal) {
									//System.out.println(i +"对角线middle1>>"+j);
									landnum++;
								}
							}else {
								//System.out.println(i +"middle1>>"+j);
								landnum++;
							}
							
							
						}
					} else if (i == (grid.length - 1)) {
						if (current && !pre) {
							//System.out.println(i +"middle2>>"+j);
							landnum++;
						}
					}
				} // end middle

			}
		}
		return landnum;
	}
}
