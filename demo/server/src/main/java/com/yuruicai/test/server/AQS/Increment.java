package com.yuruicai.test.server.AQS;
/**
 * @Description:
 * @Author: yrc
 * @CreateDate: 2019/9/5 17:22
 * @UpdateDate: 2019/9/5 17:22
 */

public class Increment {
    private int i;

    private TestAQS lock = new TestAQS();

    public void increase() {
        lock.lock();
        i++;
        lock.unlock();
    }

    public int getI() {
        return i;
    }

    public static void test(int threadNum, int loopTimes) {
        Increment increment = new Increment();

        Thread[] threads = new Thread[threadNum];

        for (int i = 0; i < threads.length; i++) {
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < loopTimes; i++) {
                        increment.increase();
                    }
                }
            });
            threads[i] = t;
            t.start();
        }

        //main线程等待其他线程都执行完成
        for (Thread t : threads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println(threadNum + "个线程，循环" + loopTimes + "次结果：" + increment.getI());
    }

    public static void main(String[] args) {
        test(20, 1);
        test(20, 10);
        test(20, 100);
        test(20, 1000);
        test(20, 10000);
        test(20, 100000);
        test(20, 1000000);
    }
}
