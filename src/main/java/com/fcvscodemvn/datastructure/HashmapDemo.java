package com.fcvscodemvn.datastructure;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HashmapDemo {
    public static void maptrick() {
        Map<String, List<String>> complexMap = new HashMap<>();

        List<String> kkval = complexMap.computeIfAbsent("kk", rk -> new ArrayList());

        kkval.add("hell");

        System.out.println(kkval);
    }

    public static void initMap() {
        Map<String, Object> mp = new HashMap<String, Object>() {
            {
                put("text", "Time out");
                put("expect_user_talk", true);
            }
        };

        System.out.println(mp);
    }

    public static void main(String[] args) {
        initMap();
        System.out.println("==========");
        maptrick();
    }
}