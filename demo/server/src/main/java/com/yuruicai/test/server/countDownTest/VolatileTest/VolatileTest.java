package com.yuruicai.test.server.countDownTest.VolatileTest;

import java.util.concurrent.locks.ReentrantLock;

public class VolatileTest {
    public static volatile int race = 0;
    private static ReentrantLock lock = new ReentrantLock();
    public static /*synchronized*/ void increase() {
            race++;
    }

    private static final int THREADS_COUNT = 20;

    public static void main(String[] args) {
        Thread[] threads = new Thread[THREADS_COUNT];
        for (int i = 0; i < THREADS_COUNT; i++) {
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 10000; j++) {
                        lock.lock();
                        try {
                            increase();
                        }finally {
                            lock.unlock();
                        }
                    }
                }
            });
            threads[i].start();
        }
        while (Thread.activeCount() > 1) {
            Thread.yield();
        }
        System.out.println(race);
    }
}
