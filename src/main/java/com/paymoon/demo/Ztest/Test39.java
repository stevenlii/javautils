package com.paymoon.demo.Ztest;

import java.util.*;

public class Test39 {

  public static void getResult(List<String> list, int N) {
    List<String> list2 = new ArrayList<>();
    Map<String, Integer> map = new HashMap<>();

    //重复的加入list2集合
    for (int i = 0; i < list.size(); i++) {
      for (int j = i + 1; j < list.size(); j++) {
        if (list.get(i).equals(list.get(j))) {
          list2.add(list.get(i));
          break;
        }
      }
    }
    //统计list2集合中重复数据出现次数,对应放入Map集合
    for (String obj : list2) {
      if (map.containsKey(obj)) {
        map.put(obj, map.get(obj) + 1);
      } else {
        map.put(obj, 2);
      }
    }
    list2.clear();

    Comparator<Map.Entry<String, Integer>> valueComparator = new Comparator<Map.Entry<String, Integer>>() {
      @Override public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
        return o2.getValue().compareTo(o1.getValue());
      }
    };
    // map转换成list进行排序
    List<Map.Entry<String, Integer>> sortList = new ArrayList<>(map.entrySet());
    // 排序
    Collections.sort(sortList, valueComparator);

    Iterator<Map.Entry<String, Integer>> iterator = sortList.iterator();
    int time = 0;
    System.out.println("出现次数最多的前"+N+"位的String是：");
    while (iterator.hasNext()) {
      if (time < N) {
        Map.Entry<String, Integer> entry = iterator.next();
        Integer value = entry.getValue();
        String key = entry.getKey();
        String result =String.format("%s 出现的次数是 %d 次",key,value);
        System.out.println(result);
        time++;
      }
    }
  }

  public static void main(String[] args) {
    List<String> list = new ArrayList<>();
    list.add("www.baidu.com");
    list.add("www.zhonghao.com");
    list.add("www.xiaojie.com");
    list.add("www.dumeng.com");
    list.add("www.baidu.com");
    list.add("www.zhonghao.com");
    list.add("www.xiaojie.com");
    list.add("www.dumeng.com");
    list.add("www.zhonghao.com");
    list.add("www.xiaojie.com");
    list.add("www.xiaojie.com");
    list.add("www.xiaojie.com");
    getResult(list, 3);
  }
}

