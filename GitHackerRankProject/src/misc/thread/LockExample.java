package misc.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * What is the differences between Lock interface and Synchrozed block in Java?
 * What are the advantages of Lock interfaces? <br/>
 * 
 * Answer: <br/>
 * 1. The main difference between synchronized and ReentrantLock is ability to
 * trying for lock interruptibly, and with timeout. Thread doesn’t need to block
 * infinitely, which was the case with synchronized. <br/>
 * 
 * Ref:
 * https://javarevisited.blogspot.com/2013/03/reentrantlock-example-in-java-synchronized-difference-vs-lock.html#ixzz6ARDIZaky
 * 
 * 2. Another significant difference between ReentrantLock and synchronized
 * keyword is fairness. synchronized keyword doesn't support fairness. Any
 * thread can acquire lock once released, no preference can be specified, on the
 * other hand you can make ReentrantLock fair by specifying fairness property in constructor ReentrantLock(boolean fair),
 * while creating instance of ReentrantLock. Fairness property provides lock to longest waiting thread, in case of contention.
 * 
 * Ref. https://docs.oracle.com/javase/7/docs/api/java/util/concurrent/locks/ReentrantLock.html#tryLock()
 * 
 * 
 * @author mchisty
 *
 */
public class LockExample {

	// -------------------------------------------------------------------------
	final static Counter c = new Counter(new ReentrantLock(true));
	final static Runnable r = () -> {
		System.out.printf("Count at thread %s is %d %n", Thread.currentThread().getName(), c.getCounter());
	};

	// -------------------------------------------------------------------------
	public static void main(String[] args) {

		Thread t1 = new Thread(r, "T1");
		Thread t2 = new Thread(r, "T2");
		Thread t3 = new Thread(r, "T3");

		t1.start();
		t2.start();
		t3.start();
	}
}

class Counter {
	private Lock l;
	private int counter = 0;

	public Counter(Lock lock) {
		this.l = lock;
	}

	public int getCounter() {
		try {
			l.lock();
			counter++;
			return counter;
		} finally {
			l.unlock();
		}

	}
}
