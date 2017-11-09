package org.chisty.thread;

/**
 * The Class CounterWithSynchronized.
 */
public class Countersync {

	/** The count. */
	private int count = 0;

	/**
	 * Adds the.
	 *
	 * @param value
	 *            the value
	 */
	public synchronized void add(int value) {
		this.count += value;
	}

	/**
	 * Gets the count.
	 *
	 * @return the count
	 */
	public synchronized int getCount() {
		return count;
	}
}
