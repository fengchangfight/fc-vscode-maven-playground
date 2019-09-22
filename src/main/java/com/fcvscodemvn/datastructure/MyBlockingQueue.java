package com.fcvscodemvn.datastructure;

import java.util.*;

public class MyBlockingQueue<E> {
    private List queue = new LinkedList();
    private final int size;

    public MyBlockingQueue(final int size) {
        this.size = size;
    }

    public synchronized boolean offer(E element) {
        while (this.queue.size() == this.size) {
            try {
                wait();
            } catch (InterruptedException ex) {

            }
        }
        boolean status = this.queue.add(element);
        if (this.queue.size() == 1) {
            notifyAll();
        }
        return status;

    }

    public synchronized E poll() {
        while (this.queue.size() == 0) {
            try {
                wait();
            } catch (InterruptedException ex) {

            }
        }

        E el = (E) this.queue.remove(0);

        if (this.queue.size() == size - 1) {
            notifyAll();
        }

        return el;
    }

    public static void main(String[] args) {
        MyBlockingQueue<String> blockingQueue = new MyBlockingQueue<String>(10);

        Producer producer = new Producer(blockingQueue);
        Consumer consumer = new Consumer(blockingQueue);
        new Thread(producer).start();
        // starting consumer to consume messages from queue
        try {
            Thread.sleep(10);
        } catch (InterruptedException exd) {
            exd.toString();
        }
        new Thread(consumer).start();
        System.out.println("Producer and Consumer has been started");

    }
}

class Message {
    private String msg;

    public Message(String str) {
        this.msg = str;
    }

    public String getMsg() {
        return msg;
    }

}

class Producer implements Runnable {
    // change with BlockingQueue when works with java doc implementation of
    // ArrayBlockingQueue
    private MyBlockingQueue<String> queue;

    // change the argument with BlockingQueue when works with java doc
    // implementation of ArrayBlockingQueue
    public Producer(MyBlockingQueue<String> q) {
        this.queue = q;
    }

    @Override
    public void run() {
        // produce messages
        for (int i = 10; i > 0; i--) {
            // Message msg = new Message(""+i);
            try {
                Thread.sleep(i);
                queue.offer(String.valueOf(i));
                System.out.println("Produced " + String.valueOf(i));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}

class Consumer implements Runnable {
    // change with BlockingQueue when works with java doc implementation of
    // ArrayBlockingQueue
    private MyBlockingQueue<String> queue;

    // change the argument with BlockingQueue when works with java doc
    // implementation of ArrayBlockingQueue
    public Consumer(MyBlockingQueue<String> q) {
        this.queue = q;
    }

    @Override
    public void run() {
        try {

            // consuming messages until exit message is received
            for (int i = 10; i > 0; i--) {
                Object data = queue.poll();
                if (data != null) {
                    Thread.sleep(i);
                    System.out.println("Consumed " + data.toString());
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
