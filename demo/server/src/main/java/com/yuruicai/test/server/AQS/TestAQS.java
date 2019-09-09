package com.yuruicai.test.server.AQS;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * @Description:
 * @Author: yrc
 * @CreateDate: 2019/9/4 16:54
 * @UpdateDate: 2019/9/4 16:54
 */

public class TestAQS {

    private static class Sync extends AbstractQueuedSynchronizer {

        @Override
        protected boolean tryAcquire(int arg) {
            return compareAndSetState(0, 1);
        }

        @Override
        protected boolean tryRelease(int arg) {
            setState(0);
            return true;
        }

        @Override
        protected boolean isHeldExclusively() {
            return getState() == 1;
        }
    }
    private Sync sync = new Sync();


    public void lock() {
        sync.acquire(1);
    }

    public void unlock() {
        sync.release(1);
    }
}
