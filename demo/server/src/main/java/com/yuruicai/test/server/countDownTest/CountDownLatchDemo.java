package com.yuruicai.test.server.countDownTest;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.CountDownLatch;

/**
 * @author Y
 * @create 2019-08-30 16:13
 * 小贴士：
 * 由于队列`queue`的方法`size`和`remove`方法需要在多线程中调用，所以需要一个锁来保护这些操作，
 * 我们这里用了`CountDownLatchDemo.class`来作为锁～ 大家以后编码过程中必须时时注意有没有共享
 * 可变变量被多个线程访问，如果有的化一定要采取措施保护起来。
 * @desc
 **/
public class CountDownLatchDemo {
    public static void main(String[] args) {
        Queue<Runnable> runnableQueue = new LinkedList<>();
        CountDownLatch countDownLatch = new CountDownLatch(5); //创建CountDownLatch对象

        for (int i = 0; i < 5; i++) {

            int num = i;
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(1000L);    //模拟耗时操作
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                    System.out.println("第" + num + "个小任务执行完成");
                    countDownLatch.countDown(); //每个任务执行完成之后，都调用这个方法
                }
            };

            runnableQueue.add(runnable);
        }


        for (int i = 0; i < 2; i++) {   //创建两个线程来执行上边的5个任务
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        Runnable runnable = null;
                        synchronized (CountDownLatchDemo.class) {   //runnableQueue的相关操作需要进行同步处理
                            if (runnableQueue.size() < 1) {
                                break;
                            }

                            runnable = runnableQueue.remove();
                        }
                        runnable.run(); //执行该任务
                    }
                }
            }).start();
        }

        try {
            countDownLatch.await(); //在runnableQueue中的所有任务都执行完成之前，此方法将阻塞
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("等待所有任务执行完成之后才执行");
    }
}
