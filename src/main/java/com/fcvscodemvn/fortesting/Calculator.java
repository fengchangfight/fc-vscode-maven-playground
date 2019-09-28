package com.fcvscodemvn.fortesting;

public class Calculator {
    public static int add(int v1, int v2) {
        return v1 + v2;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            System.out.println(i);
        }
    }
}