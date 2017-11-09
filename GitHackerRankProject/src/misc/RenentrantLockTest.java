
package misc;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

public class RenentrantLockTest {

	public static void main(String[] args) {
		ReentrantLock re = new ReentrantLock(true);
		ExecutorService pool = Executors.newFixedThreadPool(2);
		Runnable r1 = new ReentrantLockWorker("r1", re);
		Runnable r2 = new ReentrantLockWorker("r2", re);
		Runnable r3 = new ReentrantLockWorker("r3", re);
		Runnable r4 = new ReentrantLockWorker("r4", re);
		Runnable r5 = new ReentrantLockWorker("r5", re);
		pool.execute(r1);
		pool.execute(r2);
		pool.execute(r3);
		pool.execute(r4);
		pool.execute(r5);
		pool.shutdown();
	}
}
