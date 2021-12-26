package com.paymoon.demo.leetcode;

import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSON;

/**
 * 查表法
 *
 */
class Leetcode001 {
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i< nums.length; i++) {
            if(map.containsKey(target - nums[i])) {
                return new int[] {map.get(target-nums[i]),i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
    public static void main(String[] args) {
		int[] nums = {4,4,8};
		int target = 12;
		int[] result = twoSum(nums, target);
		System.out.println(JSON.toJSONString(result));
	}
}
