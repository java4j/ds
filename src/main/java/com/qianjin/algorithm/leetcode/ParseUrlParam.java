package com.qianjin.algorithm.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定url查询参数，解析成Map<String, Object>对象返回
 * 比如a=1&b=2&c=3&c=4，返回
 * {
 * a:1,
 * b:2,
 * c:[3,4]
 * }
 */
public class ParseUrlParam {
    /**
     * 解析url参数
     *
     * @param url
     * @return
     */
    public static Map<String, Object> parse(String url) {
        String[] ss = url.split("&");
        Map<String, Object> map = new HashMap<>();
        for (String s : ss) {
            String[] temp = s.split("=");
            String key = temp[0];
            String value = temp[1];
            if (map.get(key) != null) {
                // 已经存在，则需要改成列表
                List list;
                if (map.get(key) instanceof String) {
                    list = new ArrayList<>();
                    list.add(map.get(key));
                } else {
                    list = (List) map.get(map.get(key));
                }
                list.add(value);
                map.put(key, list);
            } else {
                // 不存在，则直接加入
                map.put(key, value);
            }
        }
        for (Map.Entry<String, Object> temp : map.entrySet()) {
            System.out.println(temp.getKey() + ":" + temp.getValue());
        }
        return map;
    }

    public static void main(String[] args) {
        parse("a=1&b=2&c=3&c=4&d=5&a=2");
    }
}
