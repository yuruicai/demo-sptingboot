package com.yuruicai.test.server.countDownTest.CyclicBarrier;
/**
 * @Description:
 * @Author: yrc
 * @CreateDate: 2019/8/30 16:47
 * @UpdateDate: 2019/8/30 16:47
 */

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author Y
 * @create 2019-08-30 16:47
 * @desc  栅栏demo
 *初看起来CyclicBarrier和CountDownLatch内部都有一个计数器，它们的await操作都会造成线程等待，
 * 但是CountDownLatch需要在线程执行过程中使用 countDown 来使计数器递减直到0后所有调用await的线程才会恢复执行，
 * CyclicBarrier的 await 操作本身就算是一个计数操作，当有足够多的线程调用await方法时，所有在该方法处等待的线程都恢复执行。
 * 所以它们一个重要区别就是： CyclicBarrier 用于等待其他线程，而 CountDownLatch 用于等待 countDown 事件的发生。
 *
 * 另外一个重要的不同点就是 CountDownLatch 只能使用一次，而 CyclicBarrier 可以多次循环利用，
 * 循环利用是指可以通过调用reset方法来移除之前的栅栏，如果有线程在之前的栅栏处等待，
 * 则抛出一个BrokenBarrierException异常，我们看看怎么用：
 **/
public class Fighter extends Thread{

    private CyclicBarrier cyclicBarrier;

    public Fighter(CyclicBarrier cyclicBarrier, String name) {
        super(name);
        this.cyclicBarrier = cyclicBarrier;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000L);    //模拟上学中过程
            System.out.println(getName() + "放学了，向学校门跑去");

            cyclicBarrier.await();  //到达校门后等待，直到5个线程都执行到了这里

            System.out.println("人聚齐了，一起打架去喽～");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (BrokenBarrierException e) {
            throw new RuntimeException(e);
        }
    }
}
class CyclicBarrierDemo {

        public static void main(String[] args) {

            CyclicBarrier cyclicBarrier = new CyclicBarrier(5);

            new Fighter(cyclicBarrier, "狗哥").start();
            new Fighter(cyclicBarrier, "猫爷").start();
            new Fighter(cyclicBarrier, "王尼妹").start();
            new Fighter(cyclicBarrier, "狗剩").start();
            new Fighter(cyclicBarrier, "张大嘴巴").start();
        }
}
