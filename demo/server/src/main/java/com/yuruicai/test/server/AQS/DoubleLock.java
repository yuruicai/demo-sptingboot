package com.yuruicai.test.server.AQS;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

import static sun.misc.VM.getState;

/**
 * @Description:  共享模式下同步状态获取与释放
 * @Author: yrc
 * @CreateDate: 2019/9/5 17:36
 * @UpdateDate: 2019/9/5 17:36
 */


public class DoubleLock {

    private static class Sync extends AbstractQueuedSynchronizer {

        public Sync() {
            super();
            setState(2);    //设置同步状态的值
        }

        @Override
        protected int tryAcquireShared(int arg) {
            while (true) {
                int cur = getState();
                int next = getState() - arg;
                if (compareAndSetState(cur, next)) {
                    return next;
                }
            }
        }

        @Override
        protected boolean tryReleaseShared(int arg) {
            while (true) {
                int cur = getState();
                int next = cur + arg;
                if (compareAndSetState(cur, next)) {
                    return true;
                }
            }
        }
    }

    private Sync sync = new Sync();

    public void lock() {
        sync.acquireShared(1);
    }

    public void unlock() {
        sync.releaseShared(1);
    }
}
