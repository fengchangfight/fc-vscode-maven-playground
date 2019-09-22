package com.fcvscodemvn.basic;

/**
 * @author fengchang 线程排序骚操作
 */
public class ArraySortThread implements Runnable {
    private int number;

    public ArraySortThread(int number) {
        this.number = number;
    }

    public static void main(String[] args) {
        int[] numbers = new int[] { 102, 38, 339, 1, 25564, 34 };
        for (int num : numbers) {
            new Thread(new ArraySortThread(num)).start();
        }
    }

    @Override
    public void run() {
        try {
            Thread.sleep(this.number);
            System.out.println(this.number);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
