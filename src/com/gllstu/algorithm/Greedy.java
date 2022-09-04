package com.gllstu.algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * @author LinJun
 * @version 1.0
 */
public class Greedy {
    public static void main(String[] args) {
        HashMap<String, HashSet<String>> map = new HashMap<>();
        HashSet<String> set1 = new HashSet<>();
        set1.add("北京");
        set1.add("上海");
        set1.add("天津");
        HashSet<String> set2 = new HashSet<>();
        set2.add("广州");
        set2.add("北京");
        set2.add("深圳");
        HashSet<String> set3 = new HashSet<>();
        set3.add("成都");
        set3.add("上海");
        set3.add("杭州");
        HashSet<String> set4 = new HashSet<>();
        set4.add("上海");
        set4.add("天津");
        HashSet<String> set5 = new HashSet<>();
        set5.add("杭州");
        set5.add("大连");
        map.put("k1",set1);
        map.put("k2",set2);
        map.put("k3",set3);
        map.put("k4",set4);
        map.put("k5",set5);
        HashSet<String> all = new HashSet<>();
        all.addAll(set1);
        all.addAll(set2);
        all.addAll(set3);
        all.addAll(set4);
        all.addAll(set5);
        System.out.println(all);
        ArrayList<String> arrayList = new ArrayList<>();//存放选择的电台
        HashSet<String> temp = new HashSet<>();
        String max=null;
        while (all.size()!=0){
            max=null;
            for (String  key :map.keySet()) {
                temp.clear();
                HashSet<String> set = map.get(key);
                temp.addAll(set);
                temp.retainAll(all);
                if (temp.size()>0&&(max==null||temp.size()>map.get(max).size())){
                    max=key;
                }
            }
            if (max!=null){
                arrayList.add(max);
                all.removeAll(map.get(max));
            }
        }
        System.out.println(arrayList);
    }
}
