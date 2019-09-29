package com.fcvscodemvn.datastructure;

import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class UnmodifiableMapDemo {

    public static void main(String[] args) {
        Map<String, String> mp = new ConcurrentHashMap<>();
        mp.put("name", "jet");
        mp.put("age", "11");
        Map<String, String> ump = Collections.unmodifiableMap(mp);
        // ump.put("v","k");
        System.out.println(ump);
        mp.put("age", "12");
        System.out.println(ump);
    }

}
