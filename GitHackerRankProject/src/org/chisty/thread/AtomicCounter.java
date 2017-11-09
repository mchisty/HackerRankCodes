package org.chisty.thread;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicCounter {
	private AtomicInteger count = new AtomicInteger(0);

	public void add() {
		count.incrementAndGet();
	}

	public int getCount() {
		return count.get();
	}

}
