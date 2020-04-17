package com.paymoon.demo.Ztest;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Test25 {
	private static final Logger logger = LogManager.getLogger();

	public static void main(String[] args) {
		List<Integer> skuIds = new ArrayList<Integer>();
		for (int i = 1; i < 894; i++) {
			skuIds.add(i);
		}
		sendClass3Mcq2(skuIds);
	}
	  private static Boolean sendClass3Mcq( List<Integer> skuIds) {
	        //循环发送
	        int pageSize = 10;
	        int totalPage = (skuIds.size() / pageSize);
	        if (skuIds.size() % pageSize > 0) {
	            totalPage++;
	        }
	        for (int page = 0; page < totalPage; page++) {
	            int fromIndex = page * pageSize;
	            int toIndex = (page + 1) * pageSize;
	            if (toIndex > skuIds.size()) {
	                toIndex = skuIds.size();
	            }
	            List<Integer> subSkuIds = skuIds.subList(fromIndex, toIndex);
	            logger.info("page:{},subSkuIds:{}",page,subSkuIds);
	        }
	        return true;
	    }
	  private static Boolean sendClass3Mcq2( List<Integer> skuIds) {
		  //循环发送
		  List<List<Integer>> skuIdArrayChunks =  ArrayUtils.arrayChunk(null, 10);
		  for (int page = 0; page < skuIdArrayChunks.size(); page++) {
			  logger.info("page:{},subSkuIds:{}",page,skuIdArrayChunks.get(page));
		  }
		  return true;
	  }
	  
}
