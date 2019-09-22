package com.fcvscodemvn.concurrency;

import java.util.concurrent.*;

class MyCallable implements Callable<String> {

    private long waitTime;

    public MyCallable(int timeInMillis) {
        this.waitTime = timeInMillis;
    }

    @Override
    public String call() throws Exception {
        Thread.sleep(waitTime);
        // return the thread name executing this callable task
        return Thread.currentThread().getName();
    }

}

public class FutureTaskExample {

    public static void main(String[] args) {
        MyCallable callable1 = new MyCallable(1000);
        MyCallable callable2 = new MyCallable(2000);
        MyCallable callable3 = new MyCallable(3000);

        FutureTask<String> futureTask1 = new FutureTask<>(callable1);
        FutureTask<String> futureTask2 = new FutureTask<>(callable2);
        FutureTask<String> futureTask3 = new FutureTask<>(callable3);

        ExecutorService executor = Executors.newFixedThreadPool(2);
        executor.execute(futureTask1);
        executor.execute(futureTask2);
        executor.execute(futureTask3);

        // try {
        // System.out.println("waiting task 3 done...");
        // String ab = futureTask3.get();
        // System.out.println(ab);
        // } catch (InterruptedException e) {
        // e.printStackTrace();
        // } catch (ExecutionException e) {
        // e.printStackTrace();
        // }

        while (true) {
            try {
                if (futureTask1.isDone() && futureTask2.isDone()) {
                    System.out.println("Done");
                    // shut down executor service
                    executor.shutdown();
                    return;
                }

                if (!futureTask1.isDone()) {
                    // wait indefinitely for future task to complete
                    System.out.println("FutureTask1 output=" + futureTask1.get());
                }

                System.out.println("Waiting for FutureTask2 to complete");
                String s = futureTask2.get(200L, TimeUnit.MILLISECONDS);
                if (s != null) {
                    System.out.println("FutureTask2 output=" + s);
                }
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            } catch (TimeoutException e) {
                // do nothing
            }
        }

    }

}
