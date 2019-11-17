package com.paymoon.demo.web.webserivice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;

/**
 * Created by meicai on 2019/11/17.
 */
public class Test {
    public static void main(String[] args) {
//        List<String> list = new ArrayList<>();
//        toList(list);
//        for (String s : list) {
//            JSONObject jo = JSON.parseObject(s);
//            System.out.println(jo.get("locationId") + "," + jo.get("productId"));
//        }

        update();
    }


    public static class InfoDto {
        private String cityId;
        private String areaId;
        private String ssuId;

        public InfoDto(String cityId, String areaId, String ssuId) {
            this.cityId = cityId;
            this.areaId = areaId;
            this.ssuId = ssuId;
        }

        public String getCityId() {
            return cityId;
        }

        public void setCityId(String cityId) {
            this.cityId = cityId;
        }

        public String getAreaId() {
            return areaId;
        }

        public void setAreaId(String areaId) {
            this.areaId = areaId;
        }

        public String getSsuId() {
            return ssuId;
        }

        public void setSsuId(String ssuId) {
            this.ssuId = ssuId;
        }
    }

    private static void update() {
        List<String> list = new ArrayList<>();
        toUpdate(list);
        Map<String, List<InfoDto>> map = new HashMap<>();
        for (String s : list) {
            String[] arrStr = s.split("_");
            String cityId = arrStr[0];
            String areaId = arrStr[1];
            String ssuId = arrStr[2];
            InfoDto dto = new InfoDto(cityId, areaId, ssuId);
            List<InfoDto> l = null;
            if (map.containsKey(cityId)) {
                l = map.get(cityId);
            } else {
                l = new ArrayList<>();
                map.put(cityId, l);
            }
            l.add(dto);
        }
        List<InfoDto> vList = map.get("1");
        for (InfoDto dto : vList) {
            System.out.println(JSON.toJSONString(dto));
        }


    }

    private static void toUpdate(List<String> list) {}

    private static void toList(List<String> list) {
        list.add("	{\"class3Id\":114,\"creator\":243737,\"creatorType\":1,\"endTime\":4070908800,\"locationId\":1312,\"ownerId\":1,\"price\":9.1,\"priceType\":2001,\"productId\":238803,\"sourceType\":200101,\"startTime\":1573903925,\"userLabel\":-1}	");
        list.add("	{\"class3Id\":114,\"creator\":243737,\"creatorType\":1,\"endTime\":4070908800,\"locationId\":1256,\"ownerId\":1,\"price\":9.1,\"priceType\":2001,\"productId\":238803,\"sourceType\":200101,\"startTime\":1573903925,\"userLabel\":-1}	");
        list.add("	{\"class3Id\":114,\"creator\":243737,\"creatorType\":1,\"endTime\":4070908800,\"locationId\":1259,\"ownerId\":1,\"price\":9.1,\"priceType\":2001,\"productId\":238803,\"sourceType\":200101,\"startTime\":1573903925,\"userLabel\":-1}	");
        list.add("	{\"class3Id\":114,\"creator\":243737,\"creatorType\":1,\"endTime\":4070908800,\"locationId\":1196,\"ownerId\":1,\"price\":9.1,\"priceType\":2001,\"productId\":238803,\"sourceType\":200101,\"startTime\":1573903925,\"userLabel\":-1}	");
        list.add("	{\"class3Id\":114,\"creator\":243737,\"creatorType\":1,\"endTime\":4070908800,\"locationId\":1184,\"ownerId\":1,\"price\":9.1,\"priceType\":2001,\"productId\":238803,\"sourceType\":200101,\"startTime\":1573903925,\"userLabel\":-1}	");
        list.add("	{\"class3Id\":114,\"creator\":243737,\"creatorType\":1,\"endTime\":4070908800,\"locationId\":592,\"ownerId\":1,\"price\":9.1,\"priceType\":2001,\"productId\":238803,\"sourceType\":200101,\"startTime\":1573903925,\"userLabel\":-1}	");
        list.add("	{\"class3Id\":114,\"creator\":243737,\"creatorType\":1,\"endTime\":4070908800,\"locationId\":577,\"ownerId\":1,\"price\":9.1,\"priceType\":2001,\"productId\":238803,\"sourceType\":200101,\"startTime\":1573903925,\"userLabel\":-1}	");
        list.add("	{\"class3Id\":114,\"creator\":243737,\"creatorType\":1,\"endTime\":4070908800,\"locationId\":292,\"ownerId\":1,\"price\":9.1,\"priceType\":2001,\"productId\":238803,\"sourceType\":200101,\"startTime\":1573903925,\"userLabel\":-1}	");
        list.add("	{\"class3Id\":114,\"creator\":243737,\"creatorType\":1,\"endTime\":4070908800,\"locationId\":277,\"ownerId\":1,\"price\":9.1,\"priceType\":2001,\"productId\":238803,\"sourceType\":200101,\"startTime\":1573903925,\"userLabel\":-1}	");
        list.add("	{\"class3Id\":114,\"creator\":243737,\"creatorType\":1,\"endTime\":4070908800,\"locationId\":272,\"ownerId\":1,\"price\":9.1,\"priceType\":2001,\"productId\":238803,\"sourceType\":200101,\"startTime\":1573903925,\"userLabel\":-1}	");
        list.add("	{\"class3Id\":114,\"creator\":243737,\"creatorType\":1,\"endTime\":4070908800,\"locationId\":267,\"ownerId\":1,\"price\":9.1,\"priceType\":2001,\"productId\":238803,\"sourceType\":200101,\"startTime\":1573903925,\"userLabel\":-1}	");
        list.add("	{\"class3Id\":114,\"creator\":243737,\"creatorType\":1,\"endTime\":4070908800,\"locationId\":112,\"ownerId\":1,\"price\":9.1,\"priceType\":2001,\"productId\":238803,\"sourceType\":200101,\"startTime\":1573903925,\"userLabel\":-1}	");
        list.add("	{\"class3Id\":114,\"creator\":243737,\"creatorType\":1,\"endTime\":4070908800,\"locationId\":1507,\"ownerId\":1,\"price\":9.1,\"priceType\":2001,\"productId\":238803,\"sourceType\":200101,\"startTime\":1573903925,\"userLabel\":-1}	");
        list.add("	{\"class3Id\":114,\"creator\":243737,\"creatorType\":1,\"endTime\":4070908800,\"locationId\":1921,\"ownerId\":1,\"price\":9.1,\"priceType\":2001,\"productId\":238803,\"sourceType\":200101,\"startTime\":1573903925,\"userLabel\":-1}	");
        list.add("	{\"class3Id\":114,\"creator\":243737,\"creatorType\":1,\"endTime\":4070908800,\"locationId\":2818,\"ownerId\":1,\"price\":9.1,\"priceType\":2001,\"productId\":238803,\"sourceType\":200101,\"startTime\":1573903925,\"userLabel\":-1}	");
        list.add("	{\"class3Id\":114,\"creator\":243737,\"creatorType\":1,\"endTime\":4070908800,\"locationId\":2824,\"ownerId\":1,\"price\":9.1,\"priceType\":2001,\"productId\":238803,\"sourceType\":200101,\"startTime\":1573903925,\"userLabel\":-1}	");
        list.add("	{\"class3Id\":114,\"creator\":243737,\"creatorType\":1,\"endTime\":4070908800,\"locationId\":3502,\"ownerId\":1,\"price\":9.1,\"priceType\":2001,\"productId\":238803,\"sourceType\":200101,\"startTime\":1573903925,\"userLabel\":-1}	");
        list.add("	{\"class3Id\":114,\"creator\":243737,\"creatorType\":1,\"endTime\":4070908800,\"locationId\":3751,\"ownerId\":1,\"price\":9.1,\"priceType\":2001,\"productId\":238803,\"sourceType\":200101,\"startTime\":1573903925,\"userLabel\":-1}	");
        list.add("	{\"class3Id\":114,\"creator\":243737,\"creatorType\":1,\"endTime\":4070908800,\"locationId\":4156,\"ownerId\":1,\"price\":9.1,\"priceType\":2001,\"productId\":238803,\"sourceType\":200101,\"startTime\":1573903925,\"userLabel\":-1}	");
        list.add("	{\"class3Id\":114,\"creator\":243737,\"creatorType\":1,\"endTime\":4070908800,\"locationId\":4327,\"ownerId\":1,\"price\":9.1,\"priceType\":2001,\"productId\":238803,\"sourceType\":200101,\"startTime\":1573903925,\"userLabel\":-1}	");
        list.add("	{\"class3Id\":114,\"creator\":243737,\"creatorType\":1,\"endTime\":4070908800,\"locationId\":4504,\"ownerId\":1,\"price\":9.1,\"priceType\":2001,\"productId\":238803,\"sourceType\":200101,\"startTime\":1573903925,\"userLabel\":-1}	");
        list.add("	{\"class3Id\":114,\"creator\":243737,\"creatorType\":1,\"endTime\":4070908800,\"locationId\":4507,\"ownerId\":1,\"price\":9.1,\"priceType\":2001,\"productId\":238803,\"sourceType\":200101,\"startTime\":1573903925,\"userLabel\":-1}	");
        list.add("	{\"class3Id\":114,\"creator\":243737,\"creatorType\":1,\"endTime\":4070908800,\"locationId\":4663,\"ownerId\":1,\"price\":9.1,\"priceType\":2001,\"productId\":238803,\"sourceType\":200101,\"startTime\":1573903925,\"userLabel\":-1}	");
        list.add("	{\"class3Id\":114,\"creator\":243737,\"creatorType\":1,\"endTime\":4070908800,\"locationId\":5128,\"ownerId\":1,\"price\":9.1,\"priceType\":2001,\"productId\":238803,\"sourceType\":200101,\"startTime\":1573903925,\"userLabel\":-1}	");
        list.add("	{\"class3Id\":114,\"creator\":243737,\"creatorType\":1,\"endTime\":4070908800,\"locationId\":5152,\"ownerId\":1,\"price\":9.1,\"priceType\":2001,\"productId\":238803,\"sourceType\":200101,\"startTime\":1573903925,\"userLabel\":-1}	");
        list.add("	{\"class3Id\":114,\"creator\":243737,\"creatorType\":1,\"endTime\":4070908800,\"locationId\":5653,\"ownerId\":1,\"price\":9.1,\"priceType\":2001,\"productId\":238803,\"sourceType\":200101,\"startTime\":1573903925,\"userLabel\":-1}	");
        list.add("	{\"class3Id\":114,\"creator\":243737,\"creatorType\":1,\"endTime\":4070908800,\"locationId\":5668,\"ownerId\":1,\"price\":9.1,\"priceType\":2001,\"productId\":238803,\"sourceType\":200101,\"startTime\":1573903925,\"userLabel\":-1}	");
        list.add("	{\"class3Id\":114,\"creator\":243737,\"creatorType\":1,\"endTime\":4070908800,\"locationId\":6130,\"ownerId\":1,\"price\":9.1,\"priceType\":2001,\"productId\":238803,\"sourceType\":200101,\"startTime\":1573903925,\"userLabel\":-1}	");
        list.add("	{\"class3Id\":114,\"creator\":243737,\"creatorType\":1,\"endTime\":4070908800,\"locationId\":6133,\"ownerId\":1,\"price\":9.1,\"priceType\":2001,\"productId\":238803,\"sourceType\":200101,\"startTime\":1573903925,\"userLabel\":-1}	");
        list.add("	{\"class3Id\":114,\"creator\":243737,\"creatorType\":1,\"endTime\":4070908800,\"locationId\":6136,\"ownerId\":1,\"price\":9.1,\"priceType\":2001,\"productId\":238803,\"sourceType\":200101,\"startTime\":1573903925,\"userLabel\":-1}	");
        list.add("	{\"class3Id\":114,\"creator\":243737,\"creatorType\":1,\"endTime\":4070908800,\"locationId\":6139,\"ownerId\":1,\"price\":9.1,\"priceType\":2001,\"productId\":238803,\"sourceType\":200101,\"startTime\":1573903925,\"userLabel\":-1}	");
        list.add("	{\"class3Id\":114,\"creator\":243737,\"creatorType\":1,\"endTime\":4070908800,\"locationId\":6142,\"ownerId\":1,\"price\":9.1,\"priceType\":2001,\"productId\":238803,\"sourceType\":200101,\"startTime\":1573903925,\"userLabel\":-1}	");
        list.add("	{\"class3Id\":114,\"creator\":243737,\"creatorType\":1,\"endTime\":4070908800,\"locationId\":6145,\"ownerId\":1,\"price\":9.1,\"priceType\":2001,\"productId\":238803,\"sourceType\":200101,\"startTime\":1573903925,\"userLabel\":-1}	");
        list.add("	{\"class3Id\":114,\"creator\":243737,\"creatorType\":1,\"endTime\":4070908800,\"locationId\":6148,\"ownerId\":1,\"price\":9.1,\"priceType\":2001,\"productId\":238803,\"sourceType\":200101,\"startTime\":1573903925,\"userLabel\":-1}	");
        list.add("	{\"class3Id\":114,\"creator\":243737,\"creatorType\":1,\"endTime\":4070908800,\"locationId\":6151,\"ownerId\":1,\"price\":9.1,\"priceType\":2001,\"productId\":238803,\"sourceType\":200101,\"startTime\":1573903925,\"userLabel\":-1}	");
        list.add("	{\"class3Id\":114,\"creator\":243737,\"creatorType\":1,\"endTime\":4070908800,\"locationId\":6154,\"ownerId\":1,\"price\":9.1,\"priceType\":2001,\"productId\":238803,\"sourceType\":200101,\"startTime\":1573903925,\"userLabel\":-1}	");
        list.add("	{\"class3Id\":114,\"creator\":243737,\"creatorType\":1,\"endTime\":4070908800,\"locationId\":6157,\"ownerId\":1,\"price\":9.1,\"priceType\":2001,\"productId\":238803,\"sourceType\":200101,\"startTime\":1573903925,\"userLabel\":-1}	");
        list.add("	{\"class3Id\":114,\"creator\":243737,\"creatorType\":1,\"endTime\":4070908800,\"locationId\":6160,\"ownerId\":1,\"price\":9.1,\"priceType\":2001,\"productId\":238803,\"sourceType\":200101,\"startTime\":1573903925,\"userLabel\":-1}	");
        list.add("	{\"class3Id\":114,\"creator\":243737,\"creatorType\":1,\"endTime\":4070908800,\"locationId\":6166,\"ownerId\":1,\"price\":9.1,\"priceType\":2001,\"productId\":238803,\"sourceType\":200101,\"startTime\":1573903925,\"userLabel\":-1}	");
        list.add("	{\"class3Id\":114,\"creator\":243737,\"creatorType\":1,\"endTime\":4070908800,\"locationId\":6169,\"ownerId\":1,\"price\":9.1,\"priceType\":2001,\"productId\":238803,\"sourceType\":200101,\"startTime\":1573903925,\"userLabel\":-1}	");
        list.add("	{\"class3Id\":114,\"creator\":243737,\"creatorType\":1,\"endTime\":4070908800,\"locationId\":6172,\"ownerId\":1,\"price\":9.1,\"priceType\":2001,\"productId\":238803,\"sourceType\":200101,\"startTime\":1573903925,\"userLabel\":-1}	");
        list.add("	{\"class3Id\":114,\"creator\":243737,\"creatorType\":1,\"endTime\":4070908800,\"locationId\":6175,\"ownerId\":1,\"price\":9.1,\"priceType\":2001,\"productId\":238803,\"sourceType\":200101,\"startTime\":1573903925,\"userLabel\":-1}	");
        list.add("	{\"class3Id\":114,\"creator\":243737,\"creatorType\":1,\"endTime\":4070908800,\"locationId\":6178,\"ownerId\":1,\"price\":9.1,\"priceType\":2001,\"productId\":238803,\"sourceType\":200101,\"startTime\":1573903925,\"userLabel\":-1}	");
        list.add("	{\"class3Id\":114,\"creator\":243737,\"creatorType\":1,\"endTime\":4070908800,\"locationId\":6337,\"ownerId\":1,\"price\":9.1,\"priceType\":2001,\"productId\":238803,\"sourceType\":200101,\"startTime\":1573903925,\"userLabel\":-1}	");
        list.add("	{\"class3Id\":114,\"creator\":243737,\"creatorType\":1,\"endTime\":4070908800,\"locationId\":6340,\"ownerId\":1,\"price\":9.1,\"priceType\":2001,\"productId\":238803,\"sourceType\":200101,\"startTime\":1573903925,\"userLabel\":-1}	");
        list.add("	{\"class3Id\":114,\"creator\":243737,\"creatorType\":1,\"endTime\":4070908800,\"locationId\":6343,\"ownerId\":1,\"price\":9.1,\"priceType\":2001,\"productId\":238803,\"sourceType\":200101,\"startTime\":1573903925,\"userLabel\":-1}	");
        list.add("	{\"class3Id\":114,\"creator\":243737,\"creatorType\":1,\"endTime\":4070908800,\"locationId\":6346,\"ownerId\":1,\"price\":9.1,\"priceType\":2001,\"productId\":238803,\"sourceType\":200101,\"startTime\":1573903925,\"userLabel\":-1}	");
        list.add("	{\"class3Id\":114,\"creator\":243737,\"creatorType\":1,\"endTime\":4070908800,\"locationId\":6349,\"ownerId\":1,\"price\":9.1,\"priceType\":2001,\"productId\":238803,\"sourceType\":200101,\"startTime\":1573903925,\"userLabel\":-1}	");
        list.add("	{\"class3Id\":114,\"creator\":243737,\"creatorType\":1,\"endTime\":4070908800,\"locationId\":6352,\"ownerId\":1,\"price\":9.1,\"priceType\":2001,\"productId\":238803,\"sourceType\":200101,\"startTime\":1573903925,\"userLabel\":-1}	");
        list.add("	{\"class3Id\":114,\"creator\":243737,\"creatorType\":1,\"endTime\":4070908800,\"locationId\":6355,\"ownerId\":1,\"price\":9.1,\"priceType\":2001,\"productId\":238803,\"sourceType\":200101,\"startTime\":1573903925,\"userLabel\":-1}	");
        list.add("	{\"class3Id\":114,\"creator\":243737,\"creatorType\":1,\"endTime\":4070908800,\"locationId\":257,\"ownerId\":1,\"price\":9.1,\"priceType\":2001,\"productId\":238803,\"sourceType\":200101,\"startTime\":1573903925,\"userLabel\":-1}	");
        list.add("	{\"class3Id\":114,\"creator\":243737,\"creatorType\":1,\"endTime\":4070908800,\"locationId\":102,\"ownerId\":1,\"price\":9.1,\"priceType\":2001,\"productId\":238803,\"sourceType\":200101,\"startTime\":1573903925,\"userLabel\":-1}	");
        list.add("	{\"class3Id\":114,\"creator\":243737,\"creatorType\":1,\"endTime\":4070908800,\"locationId\":7003,\"ownerId\":1,\"price\":9.1,\"priceType\":2001,\"productId\":238803,\"sourceType\":200101,\"startTime\":1573903925,\"userLabel\":-1}	");
        list.add("	{\"class3Id\":114,\"creator\":243737,\"creatorType\":1,\"endTime\":4070908800,\"locationId\":7861,\"ownerId\":1,\"price\":9.1,\"priceType\":2001,\"productId\":238803,\"sourceType\":200101,\"startTime\":1573903925,\"userLabel\":-1}	");
        list.add("	{\"class3Id\":114,\"creator\":243737,\"creatorType\":1,\"endTime\":4070908800,\"locationId\":7876,\"ownerId\":1,\"price\":9.1,\"priceType\":2001,\"productId\":238803,\"sourceType\":200101,\"startTime\":1573903925,\"userLabel\":-1}	");
        list.add("	{\"class3Id\":114,\"creator\":243737,\"creatorType\":1,\"endTime\":4070908800,\"locationId\":7990,\"ownerId\":1,\"price\":9.1,\"priceType\":2001,\"productId\":238803,\"sourceType\":200101,\"startTime\":1573903925,\"userLabel\":-1}	");
        list.add("	{\"class3Id\":114,\"creator\":243737,\"creatorType\":1,\"endTime\":4070908800,\"locationId\":8014,\"ownerId\":1,\"price\":9.1,\"priceType\":2001,\"productId\":238803,\"sourceType\":200101,\"startTime\":1573903925,\"userLabel\":-1}	");
        list.add("	{\"class3Id\":114,\"creator\":243737,\"creatorType\":1,\"endTime\":4070908800,\"locationId\":8299,\"ownerId\":1,\"price\":9.1,\"priceType\":2001,\"productId\":238803,\"sourceType\":200101,\"startTime\":1573903925,\"userLabel\":-1}	");
        list.add("	{\"class3Id\":114,\"creator\":243737,\"creatorType\":1,\"endTime\":4070908800,\"locationId\":8690,\"ownerId\":1,\"price\":9.1,\"priceType\":2001,\"productId\":238803,\"sourceType\":200101,\"startTime\":1573903925,\"userLabel\":-1}	");
        list.add("	{\"class3Id\":114,\"creator\":243737,\"creatorType\":1,\"endTime\":4070908800,\"locationId\":1312,\"ownerId\":1,\"price\":9.0,\"priceType\":2001,\"productId\":413691,\"sourceType\":200101,\"startTime\":1573903925,\"userLabel\":-1}	");
        list.add("	{\"class3Id\":114,\"creator\":243737,\"creatorType\":1,\"endTime\":4070908800,\"locationId\":1256,\"ownerId\":1,\"price\":9.0,\"priceType\":2001,\"productId\":413691,\"sourceType\":200101,\"startTime\":1573903925,\"userLabel\":-1}	");
        list.add("	{\"class3Id\":114,\"creator\":243737,\"creatorType\":1,\"endTime\":4070908800,\"locationId\":1259,\"ownerId\":1,\"price\":9.0,\"priceType\":2001,\"productId\":413691,\"sourceType\":200101,\"startTime\":1573903925,\"userLabel\":-1}	");
        list.add("	{\"class3Id\":114,\"creator\":243737,\"creatorType\":1,\"endTime\":4070908800,\"locationId\":1196,\"ownerId\":1,\"price\":9.0,\"priceType\":2001,\"productId\":413691,\"sourceType\":200101,\"startTime\":1573903925,\"userLabel\":-1}	");
        list.add("	{\"class3Id\":114,\"creator\":243737,\"creatorType\":1,\"endTime\":4070908800,\"locationId\":1184,\"ownerId\":1,\"price\":9.0,\"priceType\":2001,\"productId\":413691,\"sourceType\":200101,\"startTime\":1573903925,\"userLabel\":-1}	");
        list.add("	{\"class3Id\":114,\"creator\":243737,\"creatorType\":1,\"endTime\":4070908800,\"locationId\":112,\"ownerId\":1,\"price\":9.0,\"priceType\":2001,\"productId\":413691,\"sourceType\":200101,\"startTime\":1573903925,\"userLabel\":-1}	");
        list.add("	{\"class3Id\":114,\"creator\":243737,\"creatorType\":1,\"endTime\":4070908800,\"locationId\":267,\"ownerId\":1,\"price\":9.0,\"priceType\":2001,\"productId\":413691,\"sourceType\":200101,\"startTime\":1573903925,\"userLabel\":-1}	");
        list.add("	{\"class3Id\":114,\"creator\":243737,\"creatorType\":1,\"endTime\":4070908800,\"locationId\":272,\"ownerId\":1,\"price\":9.0,\"priceType\":2001,\"productId\":413691,\"sourceType\":200101,\"startTime\":1573903925,\"userLabel\":-1}	");
        list.add("	{\"class3Id\":114,\"creator\":243737,\"creatorType\":1,\"endTime\":4070908800,\"locationId\":277,\"ownerId\":1,\"price\":9.0,\"priceType\":2001,\"productId\":413691,\"sourceType\":200101,\"startTime\":1573903925,\"userLabel\":-1}	");
        list.add("	{\"class3Id\":114,\"creator\":243737,\"creatorType\":1,\"endTime\":4070908800,\"locationId\":292,\"ownerId\":1,\"price\":9.0,\"priceType\":2001,\"productId\":413691,\"sourceType\":200101,\"startTime\":1573903925,\"userLabel\":-1}	");
        list.add("	{\"class3Id\":114,\"creator\":243737,\"creatorType\":1,\"endTime\":4070908800,\"locationId\":577,\"ownerId\":1,\"price\":9.0,\"priceType\":2001,\"productId\":413691,\"sourceType\":200101,\"startTime\":1573903925,\"userLabel\":-1}	");
        list.add("	{\"class3Id\":114,\"creator\":243737,\"creatorType\":1,\"endTime\":4070908800,\"locationId\":592,\"ownerId\":1,\"price\":9.0,\"priceType\":2001,\"productId\":413691,\"sourceType\":200101,\"startTime\":1573903925,\"userLabel\":-1}	");
        list.add("	{\"class3Id\":114,\"creator\":243737,\"creatorType\":1,\"endTime\":4070908800,\"locationId\":1507,\"ownerId\":1,\"price\":9.0,\"priceType\":2001,\"productId\":413691,\"sourceType\":200101,\"startTime\":1573903925,\"userLabel\":-1}	");
        list.add("	{\"class3Id\":114,\"creator\":243737,\"creatorType\":1,\"endTime\":4070908800,\"locationId\":1921,\"ownerId\":1,\"price\":9.0,\"priceType\":2001,\"productId\":413691,\"sourceType\":200101,\"startTime\":1573903925,\"userLabel\":-1}	");
        list.add("	{\"class3Id\":114,\"creator\":243737,\"creatorType\":1,\"endTime\":4070908800,\"locationId\":2818,\"ownerId\":1,\"price\":9.0,\"priceType\":2001,\"productId\":413691,\"sourceType\":200101,\"startTime\":1573903925,\"userLabel\":-1}	");
        list.add("	{\"class3Id\":114,\"creator\":243737,\"creatorType\":1,\"endTime\":4070908800,\"locationId\":2824,\"ownerId\":1,\"price\":9.0,\"priceType\":2001,\"productId\":413691,\"sourceType\":200101,\"startTime\":1573903925,\"userLabel\":-1}	");
        list.add("	{\"class3Id\":114,\"creator\":243737,\"creatorType\":1,\"endTime\":4070908800,\"locationId\":3502,\"ownerId\":1,\"price\":9.0,\"priceType\":2001,\"productId\":413691,\"sourceType\":200101,\"startTime\":1573903925,\"userLabel\":-1}	");
        list.add("	{\"class3Id\":114,\"creator\":243737,\"creatorType\":1,\"endTime\":4070908800,\"locationId\":3751,\"ownerId\":1,\"price\":9.0,\"priceType\":2001,\"productId\":413691,\"sourceType\":200101,\"startTime\":1573903925,\"userLabel\":-1}	");
        list.add("	{\"class3Id\":114,\"creator\":243737,\"creatorType\":1,\"endTime\":4070908800,\"locationId\":4156,\"ownerId\":1,\"price\":9.0,\"priceType\":2001,\"productId\":413691,\"sourceType\":200101,\"startTime\":1573903925,\"userLabel\":-1}	");
        list.add("	{\"class3Id\":114,\"creator\":243737,\"creatorType\":1,\"endTime\":4070908800,\"locationId\":4327,\"ownerId\":1,\"price\":9.0,\"priceType\":2001,\"productId\":413691,\"sourceType\":200101,\"startTime\":1573903925,\"userLabel\":-1}	");
        list.add("	{\"class3Id\":114,\"creator\":243737,\"creatorType\":1,\"endTime\":4070908800,\"locationId\":4504,\"ownerId\":1,\"price\":9.0,\"priceType\":2001,\"productId\":413691,\"sourceType\":200101,\"startTime\":1573903925,\"userLabel\":-1}	");
        list.add("	{\"class3Id\":114,\"creator\":243737,\"creatorType\":1,\"endTime\":4070908800,\"locationId\":4507,\"ownerId\":1,\"price\":9.0,\"priceType\":2001,\"productId\":413691,\"sourceType\":200101,\"startTime\":1573903925,\"userLabel\":-1}	");
        list.add("	{\"class3Id\":114,\"creator\":243737,\"creatorType\":1,\"endTime\":4070908800,\"locationId\":4663,\"ownerId\":1,\"price\":9.0,\"priceType\":2001,\"productId\":413691,\"sourceType\":200101,\"startTime\":1573903925,\"userLabel\":-1}	");
        list.add("	{\"class3Id\":114,\"creator\":243737,\"creatorType\":1,\"endTime\":4070908800,\"locationId\":5128,\"ownerId\":1,\"price\":9.0,\"priceType\":2001,\"productId\":413691,\"sourceType\":200101,\"startTime\":1573903925,\"userLabel\":-1}	");
        list.add("	{\"class3Id\":114,\"creator\":243737,\"creatorType\":1,\"endTime\":4070908800,\"locationId\":5152,\"ownerId\":1,\"price\":9.0,\"priceType\":2001,\"productId\":413691,\"sourceType\":200101,\"startTime\":1573903925,\"userLabel\":-1}	");
        list.add("	{\"class3Id\":114,\"creator\":243737,\"creatorType\":1,\"endTime\":4070908800,\"locationId\":5653,\"ownerId\":1,\"price\":9.0,\"priceType\":2001,\"productId\":413691,\"sourceType\":200101,\"startTime\":1573903925,\"userLabel\":-1}	");
        list.add("	{\"class3Id\":114,\"creator\":243737,\"creatorType\":1,\"endTime\":4070908800,\"locationId\":5668,\"ownerId\":1,\"price\":9.0,\"priceType\":2001,\"productId\":413691,\"sourceType\":200101,\"startTime\":1573903925,\"userLabel\":-1}	");
        list.add("	{\"class3Id\":114,\"creator\":243737,\"creatorType\":1,\"endTime\":4070908800,\"locationId\":6130,\"ownerId\":1,\"price\":9.0,\"priceType\":2001,\"productId\":413691,\"sourceType\":200101,\"startTime\":1573903925,\"userLabel\":-1}	");
        list.add("	{\"class3Id\":114,\"creator\":243737,\"creatorType\":1,\"endTime\":4070908800,\"locationId\":6133,\"ownerId\":1,\"price\":9.0,\"priceType\":2001,\"productId\":413691,\"sourceType\":200101,\"startTime\":1573903925,\"userLabel\":-1}	");
        list.add("	{\"class3Id\":114,\"creator\":243737,\"creatorType\":1,\"endTime\":4070908800,\"locationId\":6136,\"ownerId\":1,\"price\":9.0,\"priceType\":2001,\"productId\":413691,\"sourceType\":200101,\"startTime\":1573903925,\"userLabel\":-1}	");
        list.add("	{\"class3Id\":114,\"creator\":243737,\"creatorType\":1,\"endTime\":4070908800,\"locationId\":6139,\"ownerId\":1,\"price\":9.0,\"priceType\":2001,\"productId\":413691,\"sourceType\":200101,\"startTime\":1573903925,\"userLabel\":-1}	");
        list.add("	{\"class3Id\":114,\"creator\":243737,\"creatorType\":1,\"endTime\":4070908800,\"locationId\":6142,\"ownerId\":1,\"price\":9.0,\"priceType\":2001,\"productId\":413691,\"sourceType\":200101,\"startTime\":1573903925,\"userLabel\":-1}	");
        list.add("	{\"class3Id\":114,\"creator\":243737,\"creatorType\":1,\"endTime\":4070908800,\"locationId\":6145,\"ownerId\":1,\"price\":9.0,\"priceType\":2001,\"productId\":413691,\"sourceType\":200101,\"startTime\":1573903925,\"userLabel\":-1}	");
        list.add("	{\"class3Id\":114,\"creator\":243737,\"creatorType\":1,\"endTime\":4070908800,\"locationId\":6148,\"ownerId\":1,\"price\":9.0,\"priceType\":2001,\"productId\":413691,\"sourceType\":200101,\"startTime\":1573903925,\"userLabel\":-1}	");
        list.add("	{\"class3Id\":114,\"creator\":243737,\"creatorType\":1,\"endTime\":4070908800,\"locationId\":6151,\"ownerId\":1,\"price\":9.0,\"priceType\":2001,\"productId\":413691,\"sourceType\":200101,\"startTime\":1573903925,\"userLabel\":-1}	");
        list.add("	{\"class3Id\":114,\"creator\":243737,\"creatorType\":1,\"endTime\":4070908800,\"locationId\":6154,\"ownerId\":1,\"price\":9.0,\"priceType\":2001,\"productId\":413691,\"sourceType\":200101,\"startTime\":1573903925,\"userLabel\":-1}	");
        list.add("	{\"class3Id\":114,\"creator\":243737,\"creatorType\":1,\"endTime\":4070908800,\"locationId\":6157,\"ownerId\":1,\"price\":9.0,\"priceType\":2001,\"productId\":413691,\"sourceType\":200101,\"startTime\":1573903925,\"userLabel\":-1}	");
        list.add("	{\"class3Id\":114,\"creator\":243737,\"creatorType\":1,\"endTime\":4070908800,\"locationId\":6160,\"ownerId\":1,\"price\":9.0,\"priceType\":2001,\"productId\":413691,\"sourceType\":200101,\"startTime\":1573903925,\"userLabel\":-1}	");
        list.add("	{\"class3Id\":114,\"creator\":243737,\"creatorType\":1,\"endTime\":4070908800,\"locationId\":6166,\"ownerId\":1,\"price\":9.0,\"priceType\":2001,\"productId\":413691,\"sourceType\":200101,\"startTime\":1573903925,\"userLabel\":-1}	");
        list.add("	{\"class3Id\":114,\"creator\":243737,\"creatorType\":1,\"endTime\":4070908800,\"locationId\":6169,\"ownerId\":1,\"price\":9.0,\"priceType\":2001,\"productId\":413691,\"sourceType\":200101,\"startTime\":1573903925,\"userLabel\":-1}	");
        list.add("	{\"class3Id\":114,\"creator\":243737,\"creatorType\":1,\"endTime\":4070908800,\"locationId\":6172,\"ownerId\":1,\"price\":9.0,\"priceType\":2001,\"productId\":413691,\"sourceType\":200101,\"startTime\":1573903925,\"userLabel\":-1}	");
        list.add("	{\"class3Id\":114,\"creator\":243737,\"creatorType\":1,\"endTime\":4070908800,\"locationId\":6175,\"ownerId\":1,\"price\":9.0,\"priceType\":2001,\"productId\":413691,\"sourceType\":200101,\"startTime\":1573903925,\"userLabel\":-1}	");
        list.add("	{\"class3Id\":114,\"creator\":243737,\"creatorType\":1,\"endTime\":4070908800,\"locationId\":6178,\"ownerId\":1,\"price\":9.0,\"priceType\":2001,\"productId\":413691,\"sourceType\":200101,\"startTime\":1573903925,\"userLabel\":-1}	");
        list.add("	{\"class3Id\":114,\"creator\":243737,\"creatorType\":1,\"endTime\":4070908800,\"locationId\":6337,\"ownerId\":1,\"price\":9.0,\"priceType\":2001,\"productId\":413691,\"sourceType\":200101,\"startTime\":1573903925,\"userLabel\":-1}	");
        list.add("	{\"class3Id\":114,\"creator\":243737,\"creatorType\":1,\"endTime\":4070908800,\"locationId\":6340,\"ownerId\":1,\"price\":9.0,\"priceType\":2001,\"productId\":413691,\"sourceType\":200101,\"startTime\":1573903925,\"userLabel\":-1}	");
        list.add("	{\"class3Id\":114,\"creator\":243737,\"creatorType\":1,\"endTime\":4070908800,\"locationId\":6343,\"ownerId\":1,\"price\":9.0,\"priceType\":2001,\"productId\":413691,\"sourceType\":200101,\"startTime\":1573903925,\"userLabel\":-1}	");
        list.add("	{\"class3Id\":114,\"creator\":243737,\"creatorType\":1,\"endTime\":4070908800,\"locationId\":6346,\"ownerId\":1,\"price\":9.0,\"priceType\":2001,\"productId\":413691,\"sourceType\":200101,\"startTime\":1573903925,\"userLabel\":-1}	");
        list.add("	{\"class3Id\":114,\"creator\":243737,\"creatorType\":1,\"endTime\":4070908800,\"locationId\":6349,\"ownerId\":1,\"price\":9.0,\"priceType\":2001,\"productId\":413691,\"sourceType\":200101,\"startTime\":1573903925,\"userLabel\":-1}	");
        list.add("	{\"class3Id\":114,\"creator\":243737,\"creatorType\":1,\"endTime\":4070908800,\"locationId\":6352,\"ownerId\":1,\"price\":9.0,\"priceType\":2001,\"productId\":413691,\"sourceType\":200101,\"startTime\":1573903925,\"userLabel\":-1}	");
        list.add("	{\"class3Id\":114,\"creator\":243737,\"creatorType\":1,\"endTime\":4070908800,\"locationId\":6355,\"ownerId\":1,\"price\":9.0,\"priceType\":2001,\"productId\":413691,\"sourceType\":200101,\"startTime\":1573903925,\"userLabel\":-1}	");
        list.add("	{\"class3Id\":114,\"creator\":243737,\"creatorType\":1,\"endTime\":4070908800,\"locationId\":257,\"ownerId\":1,\"price\":9.0,\"priceType\":2001,\"productId\":413691,\"sourceType\":200101,\"startTime\":1573903925,\"userLabel\":-1}	");
        list.add("	{\"class3Id\":114,\"creator\":243737,\"creatorType\":1,\"endTime\":4070908800,\"locationId\":102,\"ownerId\":1,\"price\":9.0,\"priceType\":2001,\"productId\":413691,\"sourceType\":200101,\"startTime\":1573903925,\"userLabel\":-1}	");
        list.add("	{\"class3Id\":114,\"creator\":243737,\"creatorType\":1,\"endTime\":4070908800,\"locationId\":7003,\"ownerId\":1,\"price\":9.0,\"priceType\":2001,\"productId\":413691,\"sourceType\":200101,\"startTime\":1573903925,\"userLabel\":-1}	");
        list.add("	{\"class3Id\":114,\"creator\":243737,\"creatorType\":1,\"endTime\":4070908800,\"locationId\":7861,\"ownerId\":1,\"price\":9.0,\"priceType\":2001,\"productId\":413691,\"sourceType\":200101,\"startTime\":1573903925,\"userLabel\":-1}	");
        list.add("	{\"class3Id\":114,\"creator\":243737,\"creatorType\":1,\"endTime\":4070908800,\"locationId\":7876,\"ownerId\":1,\"price\":9.0,\"priceType\":2001,\"productId\":413691,\"sourceType\":200101,\"startTime\":1573903925,\"userLabel\":-1}	");
        list.add("	{\"class3Id\":114,\"creator\":243737,\"creatorType\":1,\"endTime\":4070908800,\"locationId\":7990,\"ownerId\":1,\"price\":9.0,\"priceType\":2001,\"productId\":413691,\"sourceType\":200101,\"startTime\":1573903925,\"userLabel\":-1}	");
        list.add("	{\"class3Id\":114,\"creator\":243737,\"creatorType\":1,\"endTime\":4070908800,\"locationId\":8014,\"ownerId\":1,\"price\":9.0,\"priceType\":2001,\"productId\":413691,\"sourceType\":200101,\"startTime\":1573903925,\"userLabel\":-1}	");
        list.add("	{\"class3Id\":114,\"creator\":243737,\"creatorType\":1,\"endTime\":4070908800,\"locationId\":8299,\"ownerId\":1,\"price\":9.0,\"priceType\":2001,\"productId\":413691,\"sourceType\":200101,\"startTime\":1573903925,\"userLabel\":-1}	");
        list.add("	{\"class3Id\":114,\"creator\":243737,\"creatorType\":1,\"endTime\":4070908800,\"locationId\":8690,\"ownerId\":1,\"price\":9.0,\"priceType\":2001,\"productId\":413691,\"sourceType\":200101,\"startTime\":1573903925,\"userLabel\":-1}	");
        list.add("	{\"class3Id\":114,\"creator\":243737,\"creatorType\":1,\"endTime\":4070908800,\"locationId\":1312,\"ownerId\":1,\"price\":8.9,\"priceType\":2001,\"productId\":391776,\"sourceType\":200101,\"startTime\":1573903925,\"userLabel\":-1}	");
        list.add("	{\"class3Id\":114,\"creator\":243737,\"creatorType\":1,\"endTime\":4070908800,\"locationId\":112,\"ownerId\":1,\"price\":8.9,\"priceType\":2001,\"productId\":391776,\"sourceType\":200101,\"startTime\":1573903925,\"userLabel\":-1}	");
        list.add("	{\"class3Id\":114,\"creator\":243737,\"creatorType\":1,\"endTime\":4070908800,\"locationId\":267,\"ownerId\":1,\"price\":8.9,\"priceType\":2001,\"productId\":391776,\"sourceType\":200101,\"startTime\":1573903925,\"userLabel\":-1}	");
        list.add("	{\"class3Id\":114,\"creator\":243737,\"creatorType\":1,\"endTime\":4070908800,\"locationId\":272,\"ownerId\":1,\"price\":8.9,\"priceType\":2001,\"productId\":391776,\"sourceType\":200101,\"startTime\":1573903925,\"userLabel\":-1}	");
        list.add("	{\"class3Id\":114,\"creator\":243737,\"creatorType\":1,\"endTime\":4070908800,\"locationId\":277,\"ownerId\":1,\"price\":8.9,\"priceType\":2001,\"productId\":391776,\"sourceType\":200101,\"startTime\":1573903925,\"userLabel\":-1}	");
        list.add("	{\"class3Id\":114,\"creator\":243737,\"creatorType\":1,\"endTime\":4070908800,\"locationId\":292,\"ownerId\":1,\"price\":8.9,\"priceType\":2001,\"productId\":391776,\"sourceType\":200101,\"startTime\":1573903925,\"userLabel\":-1}	");
        list.add("	{\"class3Id\":114,\"creator\":243737,\"creatorType\":1,\"endTime\":4070908800,\"locationId\":577,\"ownerId\":1,\"price\":8.9,\"priceType\":2001,\"productId\":391776,\"sourceType\":200101,\"startTime\":1573903925,\"userLabel\":-1}	");
        list.add("	{\"class3Id\":114,\"creator\":243737,\"creatorType\":1,\"endTime\":4070908800,\"locationId\":592,\"ownerId\":1,\"price\":8.9,\"priceType\":2001,\"productId\":391776,\"sourceType\":200101,\"startTime\":1573903925,\"userLabel\":-1}	");
        list.add("	{\"class3Id\":114,\"creator\":243737,\"creatorType\":1,\"endTime\":4070908800,\"locationId\":1184,\"ownerId\":1,\"price\":8.9,\"priceType\":2001,\"productId\":391776,\"sourceType\":200101,\"startTime\":1573903925,\"userLabel\":-1}	");
        list.add("	{\"class3Id\":114,\"creator\":243737,\"creatorType\":1,\"endTime\":4070908800,\"locationId\":1196,\"ownerId\":1,\"price\":8.9,\"priceType\":2001,\"productId\":391776,\"sourceType\":200101,\"startTime\":1573903925,\"userLabel\":-1}	");
        list.add("	{\"class3Id\":114,\"creator\":243737,\"creatorType\":1,\"endTime\":4070908800,\"locationId\":1259,\"ownerId\":1,\"price\":8.9,\"priceType\":2001,\"productId\":391776,\"sourceType\":200101,\"startTime\":1573903925,\"userLabel\":-1}	");
        list.add("	{\"class3Id\":114,\"creator\":243737,\"creatorType\":1,\"endTime\":4070908800,\"locationId\":1256,\"ownerId\":1,\"price\":8.9,\"priceType\":2001,\"productId\":391776,\"sourceType\":200101,\"startTime\":1573903925,\"userLabel\":-1}	");
        list.add("	{\"class3Id\":114,\"creator\":243737,\"creatorType\":1,\"endTime\":4070908800,\"locationId\":1507,\"ownerId\":1,\"price\":8.9,\"priceType\":2001,\"productId\":391776,\"sourceType\":200101,\"startTime\":1573903925,\"userLabel\":-1}	");
        list.add("	{\"class3Id\":114,\"creator\":243737,\"creatorType\":1,\"endTime\":4070908800,\"locationId\":1921,\"ownerId\":1,\"price\":8.9,\"priceType\":2001,\"productId\":391776,\"sourceType\":200101,\"startTime\":1573903925,\"userLabel\":-1}	");
        list.add("	{\"class3Id\":114,\"creator\":243737,\"creatorType\":1,\"endTime\":4070908800,\"locationId\":2818,\"ownerId\":1,\"price\":8.9,\"priceType\":2001,\"productId\":391776,\"sourceType\":200101,\"startTime\":1573903925,\"userLabel\":-1}	");
        list.add("	{\"class3Id\":114,\"creator\":243737,\"creatorType\":1,\"endTime\":4070908800,\"locationId\":2824,\"ownerId\":1,\"price\":8.9,\"priceType\":2001,\"productId\":391776,\"sourceType\":200101,\"startTime\":1573903925,\"userLabel\":-1}	");
        list.add("	{\"class3Id\":114,\"creator\":243737,\"creatorType\":1,\"endTime\":4070908800,\"locationId\":3502,\"ownerId\":1,\"price\":8.9,\"priceType\":2001,\"productId\":391776,\"sourceType\":200101,\"startTime\":1573903925,\"userLabel\":-1}	");
        list.add("	{\"class3Id\":114,\"creator\":243737,\"creatorType\":1,\"endTime\":4070908800,\"locationId\":3751,\"ownerId\":1,\"price\":8.9,\"priceType\":2001,\"productId\":391776,\"sourceType\":200101,\"startTime\":1573903925,\"userLabel\":-1}	");
        list.add("	{\"class3Id\":114,\"creator\":243737,\"creatorType\":1,\"endTime\":4070908800,\"locationId\":4156,\"ownerId\":1,\"price\":8.9,\"priceType\":2001,\"productId\":391776,\"sourceType\":200101,\"startTime\":1573903925,\"userLabel\":-1}	");
        list.add("	{\"class3Id\":114,\"creator\":243737,\"creatorType\":1,\"endTime\":4070908800,\"locationId\":4327,\"ownerId\":1,\"price\":8.9,\"priceType\":2001,\"productId\":391776,\"sourceType\":200101,\"startTime\":1573903925,\"userLabel\":-1}	");
        list.add("	{\"class3Id\":114,\"creator\":243737,\"creatorType\":1,\"endTime\":4070908800,\"locationId\":4504,\"ownerId\":1,\"price\":8.9,\"priceType\":2001,\"productId\":391776,\"sourceType\":200101,\"startTime\":1573903925,\"userLabel\":-1}	");
        list.add("	{\"class3Id\":114,\"creator\":243737,\"creatorType\":1,\"endTime\":4070908800,\"locationId\":4507,\"ownerId\":1,\"price\":8.9,\"priceType\":2001,\"productId\":391776,\"sourceType\":200101,\"startTime\":1573903925,\"userLabel\":-1}	");
        list.add("	{\"class3Id\":114,\"creator\":243737,\"creatorType\":1,\"endTime\":4070908800,\"locationId\":4663,\"ownerId\":1,\"price\":8.9,\"priceType\":2001,\"productId\":391776,\"sourceType\":200101,\"startTime\":1573903925,\"userLabel\":-1}	");
        list.add("	{\"class3Id\":114,\"creator\":243737,\"creatorType\":1,\"endTime\":4070908800,\"locationId\":5128,\"ownerId\":1,\"price\":8.9,\"priceType\":2001,\"productId\":391776,\"sourceType\":200101,\"startTime\":1573903925,\"userLabel\":-1}	");
        list.add("	{\"class3Id\":114,\"creator\":243737,\"creatorType\":1,\"endTime\":4070908800,\"locationId\":5152,\"ownerId\":1,\"price\":8.9,\"priceType\":2001,\"productId\":391776,\"sourceType\":200101,\"startTime\":1573903925,\"userLabel\":-1}	");
        list.add("	{\"class3Id\":114,\"creator\":243737,\"creatorType\":1,\"endTime\":4070908800,\"locationId\":5653,\"ownerId\":1,\"price\":8.9,\"priceType\":2001,\"productId\":391776,\"sourceType\":200101,\"startTime\":1573903925,\"userLabel\":-1}	");
        list.add("	{\"class3Id\":114,\"creator\":243737,\"creatorType\":1,\"endTime\":4070908800,\"locationId\":5668,\"ownerId\":1,\"price\":8.9,\"priceType\":2001,\"productId\":391776,\"sourceType\":200101,\"startTime\":1573903925,\"userLabel\":-1}	");
        list.add("	{\"class3Id\":114,\"creator\":243737,\"creatorType\":1,\"endTime\":4070908800,\"locationId\":6130,\"ownerId\":1,\"price\":8.9,\"priceType\":2001,\"productId\":391776,\"sourceType\":200101,\"startTime\":1573903925,\"userLabel\":-1}	");
        list.add("	{\"class3Id\":114,\"creator\":243737,\"creatorType\":1,\"endTime\":4070908800,\"locationId\":6133,\"ownerId\":1,\"price\":8.9,\"priceType\":2001,\"productId\":391776,\"sourceType\":200101,\"startTime\":1573903925,\"userLabel\":-1}	");
        list.add("	{\"class3Id\":114,\"creator\":243737,\"creatorType\":1,\"endTime\":4070908800,\"locationId\":6136,\"ownerId\":1,\"price\":8.9,\"priceType\":2001,\"productId\":391776,\"sourceType\":200101,\"startTime\":1573903925,\"userLabel\":-1}	");
        list.add("	{\"class3Id\":114,\"creator\":243737,\"creatorType\":1,\"endTime\":4070908800,\"locationId\":6139,\"ownerId\":1,\"price\":8.9,\"priceType\":2001,\"productId\":391776,\"sourceType\":200101,\"startTime\":1573903925,\"userLabel\":-1}	");
        list.add("	{\"class3Id\":114,\"creator\":243737,\"creatorType\":1,\"endTime\":4070908800,\"locationId\":6142,\"ownerId\":1,\"price\":8.9,\"priceType\":2001,\"productId\":391776,\"sourceType\":200101,\"startTime\":1573903925,\"userLabel\":-1}	");
        list.add("	{\"class3Id\":114,\"creator\":243737,\"creatorType\":1,\"endTime\":4070908800,\"locationId\":6145,\"ownerId\":1,\"price\":8.9,\"priceType\":2001,\"productId\":391776,\"sourceType\":200101,\"startTime\":1573903925,\"userLabel\":-1}	");
        list.add("	{\"class3Id\":114,\"creator\":243737,\"creatorType\":1,\"endTime\":4070908800,\"locationId\":6148,\"ownerId\":1,\"price\":8.9,\"priceType\":2001,\"productId\":391776,\"sourceType\":200101,\"startTime\":1573903925,\"userLabel\":-1}	");
        list.add("	{\"class3Id\":114,\"creator\":243737,\"creatorType\":1,\"endTime\":4070908800,\"locationId\":6151,\"ownerId\":1,\"price\":8.9,\"priceType\":2001,\"productId\":391776,\"sourceType\":200101,\"startTime\":1573903925,\"userLabel\":-1}	");
        list.add("	{\"class3Id\":114,\"creator\":243737,\"creatorType\":1,\"endTime\":4070908800,\"locationId\":6154,\"ownerId\":1,\"price\":8.9,\"priceType\":2001,\"productId\":391776,\"sourceType\":200101,\"startTime\":1573903925,\"userLabel\":-1}	");
        list.add("	{\"class3Id\":114,\"creator\":243737,\"creatorType\":1,\"endTime\":4070908800,\"locationId\":6157,\"ownerId\":1,\"price\":8.9,\"priceType\":2001,\"productId\":391776,\"sourceType\":200101,\"startTime\":1573903925,\"userLabel\":-1}	");
        list.add("	{\"class3Id\":114,\"creator\":243737,\"creatorType\":1,\"endTime\":4070908800,\"locationId\":6160,\"ownerId\":1,\"price\":8.9,\"priceType\":2001,\"productId\":391776,\"sourceType\":200101,\"startTime\":1573903925,\"userLabel\":-1}	");
        list.add("	{\"class3Id\":114,\"creator\":243737,\"creatorType\":1,\"endTime\":4070908800,\"locationId\":6166,\"ownerId\":1,\"price\":8.9,\"priceType\":2001,\"productId\":391776,\"sourceType\":200101,\"startTime\":1573903925,\"userLabel\":-1}	");
        list.add("	{\"class3Id\":114,\"creator\":243737,\"creatorType\":1,\"endTime\":4070908800,\"locationId\":6169,\"ownerId\":1,\"price\":8.9,\"priceType\":2001,\"productId\":391776,\"sourceType\":200101,\"startTime\":1573903925,\"userLabel\":-1}	");
        list.add("	{\"class3Id\":114,\"creator\":243737,\"creatorType\":1,\"endTime\":4070908800,\"locationId\":6172,\"ownerId\":1,\"price\":8.9,\"priceType\":2001,\"productId\":391776,\"sourceType\":200101,\"startTime\":1573903925,\"userLabel\":-1}	");
        list.add("	{\"class3Id\":114,\"creator\":243737,\"creatorType\":1,\"endTime\":4070908800,\"locationId\":6175,\"ownerId\":1,\"price\":8.9,\"priceType\":2001,\"productId\":391776,\"sourceType\":200101,\"startTime\":1573903925,\"userLabel\":-1}	");
        list.add("	{\"class3Id\":114,\"creator\":243737,\"creatorType\":1,\"endTime\":4070908800,\"locationId\":6178,\"ownerId\":1,\"price\":8.9,\"priceType\":2001,\"productId\":391776,\"sourceType\":200101,\"startTime\":1573903925,\"userLabel\":-1}	");
        list.add("	{\"class3Id\":114,\"creator\":243737,\"creatorType\":1,\"endTime\":4070908800,\"locationId\":6337,\"ownerId\":1,\"price\":8.9,\"priceType\":2001,\"productId\":391776,\"sourceType\":200101,\"startTime\":1573903925,\"userLabel\":-1}	");
        list.add("	{\"class3Id\":114,\"creator\":243737,\"creatorType\":1,\"endTime\":4070908800,\"locationId\":6340,\"ownerId\":1,\"price\":8.9,\"priceType\":2001,\"productId\":391776,\"sourceType\":200101,\"startTime\":1573903925,\"userLabel\":-1}	");
        list.add("	{\"class3Id\":114,\"creator\":243737,\"creatorType\":1,\"endTime\":4070908800,\"locationId\":6343,\"ownerId\":1,\"price\":8.9,\"priceType\":2001,\"productId\":391776,\"sourceType\":200101,\"startTime\":1573903925,\"userLabel\":-1}	");
        list.add("	{\"class3Id\":114,\"creator\":243737,\"creatorType\":1,\"endTime\":4070908800,\"locationId\":6346,\"ownerId\":1,\"price\":8.9,\"priceType\":2001,\"productId\":391776,\"sourceType\":200101,\"startTime\":1573903925,\"userLabel\":-1}	");
        list.add("	{\"class3Id\":114,\"creator\":243737,\"creatorType\":1,\"endTime\":4070908800,\"locationId\":6349,\"ownerId\":1,\"price\":8.9,\"priceType\":2001,\"productId\":391776,\"sourceType\":200101,\"startTime\":1573903925,\"userLabel\":-1}	");
        list.add("	{\"class3Id\":114,\"creator\":243737,\"creatorType\":1,\"endTime\":4070908800,\"locationId\":6352,\"ownerId\":1,\"price\":8.9,\"priceType\":2001,\"productId\":391776,\"sourceType\":200101,\"startTime\":1573903925,\"userLabel\":-1}	");
        list.add("	{\"class3Id\":114,\"creator\":243737,\"creatorType\":1,\"endTime\":4070908800,\"locationId\":6355,\"ownerId\":1,\"price\":8.9,\"priceType\":2001,\"productId\":391776,\"sourceType\":200101,\"startTime\":1573903925,\"userLabel\":-1}	");
        list.add("	{\"class3Id\":114,\"creator\":243737,\"creatorType\":1,\"endTime\":4070908800,\"locationId\":257,\"ownerId\":1,\"price\":8.9,\"priceType\":2001,\"productId\":391776,\"sourceType\":200101,\"startTime\":1573903925,\"userLabel\":-1}	");
        list.add("	{\"class3Id\":114,\"creator\":243737,\"creatorType\":1,\"endTime\":4070908800,\"locationId\":102,\"ownerId\":1,\"price\":8.9,\"priceType\":2001,\"productId\":391776,\"sourceType\":200101,\"startTime\":1573903925,\"userLabel\":-1}	");
        list.add("	{\"class3Id\":114,\"creator\":243737,\"creatorType\":1,\"endTime\":4070908800,\"locationId\":7003,\"ownerId\":1,\"price\":8.9,\"priceType\":2001,\"productId\":391776,\"sourceType\":200101,\"startTime\":1573903925,\"userLabel\":-1}	");
        list.add("	{\"class3Id\":114,\"creator\":243737,\"creatorType\":1,\"endTime\":4070908800,\"locationId\":7861,\"ownerId\":1,\"price\":8.9,\"priceType\":2001,\"productId\":391776,\"sourceType\":200101,\"startTime\":1573903925,\"userLabel\":-1}	");
        list.add("	{\"class3Id\":114,\"creator\":243737,\"creatorType\":1,\"endTime\":4070908800,\"locationId\":7876,\"ownerId\":1,\"price\":8.9,\"priceType\":2001,\"productId\":391776,\"sourceType\":200101,\"startTime\":1573903925,\"userLabel\":-1}	");
        list.add("	{\"class3Id\":114,\"creator\":243737,\"creatorType\":1,\"endTime\":4070908800,\"locationId\":7990,\"ownerId\":1,\"price\":8.9,\"priceType\":2001,\"productId\":391776,\"sourceType\":200101,\"startTime\":1573903925,\"userLabel\":-1}	");
        list.add("	{\"class3Id\":114,\"creator\":243737,\"creatorType\":1,\"endTime\":4070908800,\"locationId\":8014,\"ownerId\":1,\"price\":8.9,\"priceType\":2001,\"productId\":391776,\"sourceType\":200101,\"startTime\":1573903925,\"userLabel\":-1}	");
        list.add("	{\"class3Id\":114,\"creator\":243737,\"creatorType\":1,\"endTime\":4070908800,\"locationId\":8299,\"ownerId\":1,\"price\":8.9,\"priceType\":2001,\"productId\":391776,\"sourceType\":200101,\"startTime\":1573903925,\"userLabel\":-1}	");
        list.add("	{\"class3Id\":114,\"creator\":243737,\"creatorType\":1,\"endTime\":4070908800,\"locationId\":8690,\"ownerId\":1,\"price\":8.9,\"priceType\":2001,\"productId\":391776,\"sourceType\":200101,\"startTime\":1573903925,\"userLabel\":-1}	");
        list.add("	{\"class3Id\":114,\"creator\":243737,\"creatorType\":1,\"endTime\":4070908800,\"locationId\":112,\"ownerId\":1,\"price\":8.85,\"priceType\":2001,\"productId\":1425409,\"sourceType\":200101,\"startTime\":1573903925,\"userLabel\":-1}	");
        list.add("	{\"class3Id\":114,\"creator\":243737,\"creatorType\":1,\"endTime\":4070908800,\"locationId\":267,\"ownerId\":1,\"price\":8.85,\"priceType\":2001,\"productId\":1425409,\"sourceType\":200101,\"startTime\":1573903925,\"userLabel\":-1}	");
        list.add("	{\"class3Id\":114,\"creator\":243737,\"creatorType\":1,\"endTime\":4070908800,\"locationId\":272,\"ownerId\":1,\"price\":8.85,\"priceType\":2001,\"productId\":1425409,\"sourceType\":200101,\"startTime\":1573903925,\"userLabel\":-1}	");
        list.add("	{\"class3Id\":114,\"creator\":243737,\"creatorType\":1,\"endTime\":4070908800,\"locationId\":277,\"ownerId\":1,\"price\":8.85,\"priceType\":2001,\"productId\":1425409,\"sourceType\":200101,\"startTime\":1573903925,\"userLabel\":-1}	");
        list.add("	{\"class3Id\":114,\"creator\":243737,\"creatorType\":1,\"endTime\":4070908800,\"locationId\":292,\"ownerId\":1,\"price\":8.85,\"priceType\":2001,\"productId\":1425409,\"sourceType\":200101,\"startTime\":1573903925,\"userLabel\":-1}	");
        list.add("	{\"class3Id\":114,\"creator\":243737,\"creatorType\":1,\"endTime\":4070908800,\"locationId\":577,\"ownerId\":1,\"price\":8.85,\"priceType\":2001,\"productId\":1425409,\"sourceType\":200101,\"startTime\":1573903925,\"userLabel\":-1}	");
        list.add("	{\"class3Id\":114,\"creator\":243737,\"creatorType\":1,\"endTime\":4070908800,\"locationId\":592,\"ownerId\":1,\"price\":8.85,\"priceType\":2001,\"productId\":1425409,\"sourceType\":200101,\"startTime\":1573903925,\"userLabel\":-1}	");
        list.add("	{\"class3Id\":114,\"creator\":243737,\"creatorType\":1,\"endTime\":4070908800,\"locationId\":1184,\"ownerId\":1,\"price\":8.85,\"priceType\":2001,\"productId\":1425409,\"sourceType\":200101,\"startTime\":1573903925,\"userLabel\":-1}	");
        list.add("	{\"class3Id\":114,\"creator\":243737,\"creatorType\":1,\"endTime\":4070908800,\"locationId\":1196,\"ownerId\":1,\"price\":8.85,\"priceType\":2001,\"productId\":1425409,\"sourceType\":200101,\"startTime\":1573903925,\"userLabel\":-1}	");
        list.add("	{\"class3Id\":114,\"creator\":243737,\"creatorType\":1,\"endTime\":4070908800,\"locationId\":1256,\"ownerId\":1,\"price\":8.85,\"priceType\":2001,\"productId\":1425409,\"sourceType\":200101,\"startTime\":1573903925,\"userLabel\":-1}	");
        list.add("	{\"class3Id\":114,\"creator\":243737,\"creatorType\":1,\"endTime\":4070908800,\"locationId\":1259,\"ownerId\":1,\"price\":8.85,\"priceType\":2001,\"productId\":1425409,\"sourceType\":200101,\"startTime\":1573903925,\"userLabel\":-1}	");
        list.add("	{\"class3Id\":114,\"creator\":243737,\"creatorType\":1,\"endTime\":4070908800,\"locationId\":1312,\"ownerId\":1,\"price\":8.85,\"priceType\":2001,\"productId\":1425409,\"sourceType\":200101,\"startTime\":1573903925,\"userLabel\":-1}	");
        list.add("	{\"class3Id\":114,\"creator\":243737,\"creatorType\":1,\"endTime\":4070908800,\"locationId\":1507,\"ownerId\":1,\"price\":8.85,\"priceType\":2001,\"productId\":1425409,\"sourceType\":200101,\"startTime\":1573903925,\"userLabel\":-1}	");
        list.add("	{\"class3Id\":114,\"creator\":243737,\"creatorType\":1,\"endTime\":4070908800,\"locationId\":1921,\"ownerId\":1,\"price\":8.85,\"priceType\":2001,\"productId\":1425409,\"sourceType\":200101,\"startTime\":1573903925,\"userLabel\":-1}	");
        list.add("	{\"class3Id\":114,\"creator\":243737,\"creatorType\":1,\"endTime\":4070908800,\"locationId\":2818,\"ownerId\":1,\"price\":8.85,\"priceType\":2001,\"productId\":1425409,\"sourceType\":200101,\"startTime\":1573903925,\"userLabel\":-1}	");
        list.add("	{\"class3Id\":114,\"creator\":243737,\"creatorType\":1,\"endTime\":4070908800,\"locationId\":2824,\"ownerId\":1,\"price\":8.85,\"priceType\":2001,\"productId\":1425409,\"sourceType\":200101,\"startTime\":1573903925,\"userLabel\":-1}	");
        list.add("	{\"class3Id\":114,\"creator\":243737,\"creatorType\":1,\"endTime\":4070908800,\"locationId\":3502,\"ownerId\":1,\"price\":8.85,\"priceType\":2001,\"productId\":1425409,\"sourceType\":200101,\"startTime\":1573903925,\"userLabel\":-1}	");
        list.add("	{\"class3Id\":114,\"creator\":243737,\"creatorType\":1,\"endTime\":4070908800,\"locationId\":3751,\"ownerId\":1,\"price\":8.85,\"priceType\":2001,\"productId\":1425409,\"sourceType\":200101,\"startTime\":1573903925,\"userLabel\":-1}	");
        list.add("	{\"class3Id\":114,\"creator\":243737,\"creatorType\":1,\"endTime\":4070908800,\"locationId\":4156,\"ownerId\":1,\"price\":8.85,\"priceType\":2001,\"productId\":1425409,\"sourceType\":200101,\"startTime\":1573903925,\"userLabel\":-1}	");
        list.add("	{\"class3Id\":114,\"creator\":243737,\"creatorType\":1,\"endTime\":4070908800,\"locationId\":4327,\"ownerId\":1,\"price\":8.85,\"priceType\":2001,\"productId\":1425409,\"sourceType\":200101,\"startTime\":1573903925,\"userLabel\":-1}	");
        list.add("	{\"class3Id\":114,\"creator\":243737,\"creatorType\":1,\"endTime\":4070908800,\"locationId\":4504,\"ownerId\":1,\"price\":8.85,\"priceType\":2001,\"productId\":1425409,\"sourceType\":200101,\"startTime\":1573903925,\"userLabel\":-1}	");
        list.add("	{\"class3Id\":114,\"creator\":243737,\"creatorType\":1,\"endTime\":4070908800,\"locationId\":4507,\"ownerId\":1,\"price\":8.85,\"priceType\":2001,\"productId\":1425409,\"sourceType\":200101,\"startTime\":1573903925,\"userLabel\":-1}	");
        list.add("	{\"class3Id\":114,\"creator\":243737,\"creatorType\":1,\"endTime\":4070908800,\"locationId\":4663,\"ownerId\":1,\"price\":8.85,\"priceType\":2001,\"productId\":1425409,\"sourceType\":200101,\"startTime\":1573903925,\"userLabel\":-1}	");
        list.add("	{\"class3Id\":114,\"creator\":243737,\"creatorType\":1,\"endTime\":4070908800,\"locationId\":5128,\"ownerId\":1,\"price\":8.85,\"priceType\":2001,\"productId\":1425409,\"sourceType\":200101,\"startTime\":1573903925,\"userLabel\":-1}	");
        list.add("	{\"class3Id\":114,\"creator\":243737,\"creatorType\":1,\"endTime\":4070908800,\"locationId\":5152,\"ownerId\":1,\"price\":8.85,\"priceType\":2001,\"productId\":1425409,\"sourceType\":200101,\"startTime\":1573903925,\"userLabel\":-1}	");
        list.add("	{\"class3Id\":114,\"creator\":243737,\"creatorType\":1,\"endTime\":4070908800,\"locationId\":5653,\"ownerId\":1,\"price\":8.85,\"priceType\":2001,\"productId\":1425409,\"sourceType\":200101,\"startTime\":1573903925,\"userLabel\":-1}	");
        list.add("	{\"class3Id\":114,\"creator\":243737,\"creatorType\":1,\"endTime\":4070908800,\"locationId\":5668,\"ownerId\":1,\"price\":8.85,\"priceType\":2001,\"productId\":1425409,\"sourceType\":200101,\"startTime\":1573903925,\"userLabel\":-1}	");
        list.add("	{\"class3Id\":114,\"creator\":243737,\"creatorType\":1,\"endTime\":4070908800,\"locationId\":6130,\"ownerId\":1,\"price\":8.85,\"priceType\":2001,\"productId\":1425409,\"sourceType\":200101,\"startTime\":1573903925,\"userLabel\":-1}	");
        list.add("	{\"class3Id\":114,\"creator\":243737,\"creatorType\":1,\"endTime\":4070908800,\"locationId\":6133,\"ownerId\":1,\"price\":8.85,\"priceType\":2001,\"productId\":1425409,\"sourceType\":200101,\"startTime\":1573903925,\"userLabel\":-1}	");
        list.add("	{\"class3Id\":114,\"creator\":243737,\"creatorType\":1,\"endTime\":4070908800,\"locationId\":6136,\"ownerId\":1,\"price\":8.85,\"priceType\":2001,\"productId\":1425409,\"sourceType\":200101,\"startTime\":1573903925,\"userLabel\":-1}	");
        list.add("	{\"class3Id\":114,\"creator\":243737,\"creatorType\":1,\"endTime\":4070908800,\"locationId\":6139,\"ownerId\":1,\"price\":8.85,\"priceType\":2001,\"productId\":1425409,\"sourceType\":200101,\"startTime\":1573903925,\"userLabel\":-1}	");
        list.add("	{\"class3Id\":114,\"creator\":243737,\"creatorType\":1,\"endTime\":4070908800,\"locationId\":6142,\"ownerId\":1,\"price\":8.85,\"priceType\":2001,\"productId\":1425409,\"sourceType\":200101,\"startTime\":1573903925,\"userLabel\":-1}	");
        list.add("	{\"class3Id\":114,\"creator\":243737,\"creatorType\":1,\"endTime\":4070908800,\"locationId\":6145,\"ownerId\":1,\"price\":8.85,\"priceType\":2001,\"productId\":1425409,\"sourceType\":200101,\"startTime\":1573903925,\"userLabel\":-1}	");
        list.add("	{\"class3Id\":114,\"creator\":243737,\"creatorType\":1,\"endTime\":4070908800,\"locationId\":6148,\"ownerId\":1,\"price\":8.85,\"priceType\":2001,\"productId\":1425409,\"sourceType\":200101,\"startTime\":1573903925,\"userLabel\":-1}	");
        list.add("	{\"class3Id\":114,\"creator\":243737,\"creatorType\":1,\"endTime\":4070908800,\"locationId\":6151,\"ownerId\":1,\"price\":8.85,\"priceType\":2001,\"productId\":1425409,\"sourceType\":200101,\"startTime\":1573903925,\"userLabel\":-1}	");
        list.add("	{\"class3Id\":114,\"creator\":243737,\"creatorType\":1,\"endTime\":4070908800,\"locationId\":6154,\"ownerId\":1,\"price\":8.85,\"priceType\":2001,\"productId\":1425409,\"sourceType\":200101,\"startTime\":1573903925,\"userLabel\":-1}	");
        list.add("	{\"class3Id\":114,\"creator\":243737,\"creatorType\":1,\"endTime\":4070908800,\"locationId\":6157,\"ownerId\":1,\"price\":8.85,\"priceType\":2001,\"productId\":1425409,\"sourceType\":200101,\"startTime\":1573903925,\"userLabel\":-1}	");
        list.add("	{\"class3Id\":114,\"creator\":243737,\"creatorType\":1,\"endTime\":4070908800,\"locationId\":6160,\"ownerId\":1,\"price\":8.85,\"priceType\":2001,\"productId\":1425409,\"sourceType\":200101,\"startTime\":1573903925,\"userLabel\":-1}	");
        list.add("	{\"class3Id\":114,\"creator\":243737,\"creatorType\":1,\"endTime\":4070908800,\"locationId\":6166,\"ownerId\":1,\"price\":8.85,\"priceType\":2001,\"productId\":1425409,\"sourceType\":200101,\"startTime\":1573903925,\"userLabel\":-1}	");
        list.add("	{\"class3Id\":114,\"creator\":243737,\"creatorType\":1,\"endTime\":4070908800,\"locationId\":6169,\"ownerId\":1,\"price\":8.85,\"priceType\":2001,\"productId\":1425409,\"sourceType\":200101,\"startTime\":1573903925,\"userLabel\":-1}	");
        list.add("	{\"class3Id\":114,\"creator\":243737,\"creatorType\":1,\"endTime\":4070908800,\"locationId\":6172,\"ownerId\":1,\"price\":8.85,\"priceType\":2001,\"productId\":1425409,\"sourceType\":200101,\"startTime\":1573903925,\"userLabel\":-1}	");
        list.add("	{\"class3Id\":114,\"creator\":243737,\"creatorType\":1,\"endTime\":4070908800,\"locationId\":6175,\"ownerId\":1,\"price\":8.85,\"priceType\":2001,\"productId\":1425409,\"sourceType\":200101,\"startTime\":1573903925,\"userLabel\":-1}	");
        list.add("	{\"class3Id\":114,\"creator\":243737,\"creatorType\":1,\"endTime\":4070908800,\"locationId\":6178,\"ownerId\":1,\"price\":8.85,\"priceType\":2001,\"productId\":1425409,\"sourceType\":200101,\"startTime\":1573903925,\"userLabel\":-1}	");
        list.add("	{\"class3Id\":114,\"creator\":243737,\"creatorType\":1,\"endTime\":4070908800,\"locationId\":6337,\"ownerId\":1,\"price\":8.85,\"priceType\":2001,\"productId\":1425409,\"sourceType\":200101,\"startTime\":1573903925,\"userLabel\":-1}	");
        list.add("	{\"class3Id\":114,\"creator\":243737,\"creatorType\":1,\"endTime\":4070908800,\"locationId\":6340,\"ownerId\":1,\"price\":8.85,\"priceType\":2001,\"productId\":1425409,\"sourceType\":200101,\"startTime\":1573903925,\"userLabel\":-1}	");
        list.add("	{\"class3Id\":114,\"creator\":243737,\"creatorType\":1,\"endTime\":4070908800,\"locationId\":6343,\"ownerId\":1,\"price\":8.85,\"priceType\":2001,\"productId\":1425409,\"sourceType\":200101,\"startTime\":1573903925,\"userLabel\":-1}	");
        list.add("	{\"class3Id\":114,\"creator\":243737,\"creatorType\":1,\"endTime\":4070908800,\"locationId\":6346,\"ownerId\":1,\"price\":8.85,\"priceType\":2001,\"productId\":1425409,\"sourceType\":200101,\"startTime\":1573903925,\"userLabel\":-1}	");
        list.add("	{\"class3Id\":114,\"creator\":243737,\"creatorType\":1,\"endTime\":4070908800,\"locationId\":6349,\"ownerId\":1,\"price\":8.85,\"priceType\":2001,\"productId\":1425409,\"sourceType\":200101,\"startTime\":1573903925,\"userLabel\":-1}	");
        list.add("	{\"class3Id\":114,\"creator\":243737,\"creatorType\":1,\"endTime\":4070908800,\"locationId\":6352,\"ownerId\":1,\"price\":8.85,\"priceType\":2001,\"productId\":1425409,\"sourceType\":200101,\"startTime\":1573903925,\"userLabel\":-1}	");
        list.add("	{\"class3Id\":114,\"creator\":243737,\"creatorType\":1,\"endTime\":4070908800,\"locationId\":6355,\"ownerId\":1,\"price\":8.85,\"priceType\":2001,\"productId\":1425409,\"sourceType\":200101,\"startTime\":1573903925,\"userLabel\":-1}	");
        list.add("	{\"class3Id\":114,\"creator\":243737,\"creatorType\":1,\"endTime\":4070908800,\"locationId\":257,\"ownerId\":1,\"price\":8.85,\"priceType\":2001,\"productId\":1425409,\"sourceType\":200101,\"startTime\":1573903925,\"userLabel\":-1}	");
        list.add("	{\"class3Id\":114,\"creator\":243737,\"creatorType\":1,\"endTime\":4070908800,\"locationId\":102,\"ownerId\":1,\"price\":8.85,\"priceType\":2001,\"productId\":1425409,\"sourceType\":200101,\"startTime\":1573903925,\"userLabel\":-1}	");
        list.add("	{\"class3Id\":114,\"creator\":243737,\"creatorType\":1,\"endTime\":4070908800,\"locationId\":7003,\"ownerId\":1,\"price\":8.85,\"priceType\":2001,\"productId\":1425409,\"sourceType\":200101,\"startTime\":1573903925,\"userLabel\":-1}	");
        list.add("	{\"class3Id\":114,\"creator\":243737,\"creatorType\":1,\"endTime\":4070908800,\"locationId\":7861,\"ownerId\":1,\"price\":8.85,\"priceType\":2001,\"productId\":1425409,\"sourceType\":200101,\"startTime\":1573903925,\"userLabel\":-1}	");
        list.add("	{\"class3Id\":114,\"creator\":243737,\"creatorType\":1,\"endTime\":4070908800,\"locationId\":7876,\"ownerId\":1,\"price\":8.85,\"priceType\":2001,\"productId\":1425409,\"sourceType\":200101,\"startTime\":1573903925,\"userLabel\":-1}	");
        list.add("	{\"class3Id\":114,\"creator\":243737,\"creatorType\":1,\"endTime\":4070908800,\"locationId\":7990,\"ownerId\":1,\"price\":8.85,\"priceType\":2001,\"productId\":1425409,\"sourceType\":200101,\"startTime\":1573903925,\"userLabel\":-1}	");
        list.add("	{\"class3Id\":114,\"creator\":243737,\"creatorType\":1,\"endTime\":4070908800,\"locationId\":8014,\"ownerId\":1,\"price\":8.85,\"priceType\":2001,\"productId\":1425409,\"sourceType\":200101,\"startTime\":1573903925,\"userLabel\":-1}	");
        list.add("	{\"class3Id\":114,\"creator\":243737,\"creatorType\":1,\"endTime\":4070908800,\"locationId\":8299,\"ownerId\":1,\"price\":8.85,\"priceType\":2001,\"productId\":1425409,\"sourceType\":200101,\"startTime\":1573903925,\"userLabel\":-1}	");
        list.add("	{\"class3Id\":114,\"creator\":243737,\"creatorType\":1,\"endTime\":4070908800,\"locationId\":8690,\"ownerId\":1,\"price\":8.85,\"priceType\":2001,\"productId\":1425409,\"sourceType\":200101,\"startTime\":1573903925,\"userLabel\":-1}	");

    }
}
