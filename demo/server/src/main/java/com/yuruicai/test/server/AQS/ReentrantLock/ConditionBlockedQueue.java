package com.yuruicai.test.server.AQS.ReentrantLock;
/**
 * @Description:
 * @Author: yrc
 * @CreateDate: 2019/9/6 16:50
 * @UpdateDate: 2019/9/6 16:50
 */

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Y
 * @create 2019-09-06 16:50
 * @desc   通过可重入锁对增加删除  和 size方法进行加锁
 **/
public class ConditionBlockedQueue<E> {
    private Lock lock = new ReentrantLock();

    //等待队列
    private Condition notEmptyCondition = lock.newCondition();

    private Condition notFullCondition = lock.newCondition();

    private Queue<E> queue = new LinkedList<>();

    private int limit;

    public ConditionBlockedQueue(int limit) {
        this.limit = limit;
    }

    public int size() {
        lock.lock();
        try {
            return queue.size();
        } finally {
            lock.unlock();
        }
    }

    public boolean add(E e) throws InterruptedException {
        lock.lock();
        try {
            while (size() >= limit) {
                notFullCondition.await();
            }

            boolean result = queue.add(e);
            notEmptyCondition.signal();
            return result;
        } finally {
            lock.unlock();
        }
    }

    public E remove() throws InterruptedException{
        lock.lock();
        try {
            while (size() == 0) {
                notEmptyCondition.await();
            }
            E e = queue.remove();
            notFullCondition.signalAll();
            return e;
        } finally {
            lock.unlock();
        }
    }
}
