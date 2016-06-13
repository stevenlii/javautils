package com.paymoon.demo.Ztest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Test8 {
	private static final Logger logger = LogManager.getLogger();

	public static void main(String[] args) {
		//[[1,1,0,0,0],[0,1,0,0,1],[0,0,0,1,1],[0,0,0,0,0],[0,0,0,0,1]]
//		boolean[][]  grid = {{true,true,false,false,false},{false,true,false,false,true},{false,false,false,true,true},{false,false,false,false,false},{false,false,false,false,true}};
		//[
		//[1,1,1,1,1,1],
		//[1,0,0,0,0,1],
		//[1,0,1,1,0,1],
		//[1,0,0,0,0,1],
		//[1,1,1,1,1,1]]
		boolean[][]  grid = {{true,true,true,true,true,true},{true,false,false,false,false,true},{true,false,true,true,false,true},{true,false,false,false,false,true},{true,true,true,true,true,true}};
		//[[1,1]]
		//boolean[][]  grid = {{true,true}};

		//[
		//[1,0,0,1,1,1,0,1,1,0,0,0,0,0,0,0,0,0,0,0],
		//[1,0,0,1,1,0,0,1,0,0,0,1,0,1,0,1,0,0,1,0],
		//[0,0,0,1,1,1,1,0,1,0,1,1,0,0,0,0,1,0,1,0],
		//[0,0,0,1,1,0,0,1,0,0,0,1,1,1,0,0,1,0,0,1],
		//[0,0,0,0,0,0,0,1,1,1,0,0,0,0,0,0,0,0,0,0],
		//[1,0,0,0,0,1,0,1,0,1,1,0,0,0,0,0,0,1,0,1],
		//[0,0,0,1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1],
		//[0,0,0,1,0,1,0,0,1,1,0,1,0,1,1,0,1,1,1,0],
		//[0,0,0,0,1,0,0,1,1,0,0,0,0,1,0,0,0,1,0,1],
		//[0,0,1,0,0,1,0,0,0,0,0,1,0,0,1,0,0,0,1,0],
		//[1,0,0,1,0,0,0,0,0,0,0,1,0,0,1,0,1,0,1,0],
		//[0,1,0,0,0,1,0,1,0,1,1,0,1,1,1,0,1,1,0,0],
		//[1,1,0,1,0,0,0,0,1,0,0,0,0,0,0,1,0,0,0,1],
		//[0,1,0,0,1,1,1,0,0,0,1,1,1,1,1,0,1,0,0,0],
		//[0,0,1,1,1,0,0,0,1,1,0,0,0,1,0,1,0,0,0,0],
		//[1,0,0,1,0,1,0,0,0,0,1,0,0,0,1,0,1,0,1,1],
		//[1,0,1,0,0,0,0,0,0,1,0,0,0,1,0,1,0,0,0,0],
		//[0,1,1,0,0,0,1,1,1,0,1,0,1,0,1,1,1,1,0,0],
		//[0,1,0,0,0,0,1,1,0,0,1,0,1,0,0,1,0,0,1,1],
		//[0,0,0,0,0,0,1,1,1,1,0,1,0,0,0,1,1,0,0,0]]
		
		System.out.println(numIslands(grid));
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
