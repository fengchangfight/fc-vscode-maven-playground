package com.fcvscodemvn.basic;

import java.util.Arrays;

public class ArrayCopyDemo {
    public static void main(String[] args) {
        int[] src = { 1, 2, 3, 4 };

        int[] y = new int[src.length];

        int[] z = Arrays.copyOf(src, src.length);

        System.arraycopy(src, 0, y, 0, src.length);

        for (int el : y) {
            System.out.println(el);
        }
        System.out.println("==========");
        for (int el : z) {
            System.out.println(el);
        }
    }
}
