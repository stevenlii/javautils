package com.paymoon.demo.Ztest;


import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;

public class ArrayUtils {
    public static <T> List<List<T>> arrayChunk(List<T> data, Integer pageSize) {
    	 List<List<T>> result = new ArrayList<>();
    	if (CollectionUtils.isEmpty(data)) {
    		return result;
		}
        int totalPage = data.size() / pageSize;
        if (data.size() % pageSize > 0) {
            totalPage++;
        }
        for (int page = 0; page < totalPage; page++) {
            int fromIndex = page * pageSize;
            int toIndex = (page + 1) * pageSize;
            if (toIndex > data.size()) {
                toIndex = data.size();
            }
            List<T> subData = data.subList(fromIndex, toIndex);
            result.add(subData);
        }
        return result;
    }
    public static void main(String[] args) {
		List<List<Integer>> aaIntegers = arrayChunk(null, 100);
		System.out.println(aaIntegers);
	}

}
