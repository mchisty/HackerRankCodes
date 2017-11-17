
package org.hackerrank.hash;

public class MyEntry<K, V> {

	private K key;

	private V value;

	private MyEntry<K, V> nextEntry;

	MyEntry(K key, V value) {
		super();
		this.key = key;
		this.value = value;
	}

	/**
	 * @return the key
	 */
	public K getKey() {
		return key;
	}

	/**
	 * @param key
	 *            the key to set
	 */
	public void setKey(K key) {
		this.key = key;
	}

	/**
	 * @return the value
	 */
	public V getValue() {
		return value;
	}

	/**
	 * @param value
	 *            the value to set
	 */
	public void setValue(V value) {
		this.value = value;
	}

	/**
	 * @return the nextEntry
	 */
	public MyEntry<K, V> getNextEntry() {
		return nextEntry;
	}

	/**
	 * @param nextEntry
	 *            the nextEntry to set
	 */
	public void setNextEntry(MyEntry<K, V> nextEntry) {
		this.nextEntry = nextEntry;
	}
}
