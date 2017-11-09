package org.chisty.thread;

public class CounterThread extends Thread {
	protected Countersync counter = null;

	public CounterThread(Countersync c) {
		counter = c;
	}

	@Override
	public void run() {
		for (int i = 0; i < 3; ++i) {
			int n = counter.getCount() + 1;
			System.out.println(
					"" + this.getName() + ", counter.getCount(): " + counter.getCount() + " ----> Count val: " + n);
			counter.add(n);
		}
	}

}
