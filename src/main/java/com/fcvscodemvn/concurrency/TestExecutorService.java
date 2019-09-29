package com.fcvscodemvn.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestExecutorService {
    static class Job implements Runnable {
        @Override
        public void run() {
            System.out.println("Real run..." + Thread.currentThread().getId());
        }
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            executorService.execute(new Job());
        }
    }
}
