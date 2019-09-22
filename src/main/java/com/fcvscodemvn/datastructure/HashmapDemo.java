package com.fcvscodemvn.datastructure;

import java.util.HashMap;
import java.util.Map;

public class HashmapDemo {
    public static void main(String[] args) {
        Map<String, Object> mp = new HashMap<String, Object>() {
            {
                put("text", "Time out");
                put("expect_user_talk", true);
            }
        };
        System.out.println(mp);
    }
}