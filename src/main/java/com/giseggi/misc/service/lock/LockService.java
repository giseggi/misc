package com.giseggi.misc.service.lock;

import java.util.concurrent.locks.Lock;

public interface LockService {

    public Lock obtainLock(String lockKey);

    public void unlock(Lock lock);
}
