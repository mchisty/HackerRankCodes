
package org.hackerrank.hash;

import java.util.Arrays;

/**
 * The Class MyHashMap.
 *
 * @param <K>
 *            the key type
 * @param <V>
 *            the value type
 */
public class MyHashMap<K, V> {

	/** The capacity. */
	private int CAPACITY = 100;

	/** The entries. */
	private MyEntry<K, V> entries[] = new MyEntry[CAPACITY];

	/** The size. */
	private int size = 0;

	/**
	 * Gets the index position.
	 *
	 * @param key
	 *            the key
	 * @return the index position
	 */
	private int getIndexPosition(K key) {
		return key.hashCode() % CAPACITY;
	}

	/**
	 * Put.
	 *
	 * @param key
	 *            the key
	 * @param val
	 *            the val
	 */
	public void put(K key, V val) {
		int index = getIndexPosition(key);
		MyEntry<K, V> current = entries[index];
		if (null == current) {
			entries[index] = new MyEntry<>(key, val);
			++size;
		} else {
			MyEntry<K, V> tmp = null;
			while (current != null) {
				tmp = current;
				if (key.equals(current.getKey())) {
					current.setValue(val);
					return;
				} else {
					current = current.getNextEntry();
				}
			}
			// The next entry is null
			tmp.setNextEntry(new MyEntry<>(key, val));
			++size;
		}
	}

	/**
	 * Gets the.
	 *
	 * @param key
	 *            the key
	 * @return the v
	 */
	public V get(K key) {
		MyEntry<K, V> entry = getEntry(key);
		return entry.getValue();
	}

	/**
	 * Gets the entry.
	 *
	 * @param key
	 *            the key
	 * @return the entry
	 */
	private MyEntry<K, V> getEntry(K key) {
		int index = getIndexPosition(key);
		MyEntry<K, V> current = entries[index];
		MyEntry<K, V> previousEntry = null;
		if (null == current) {
			return null;
		} else {
			while (current != null) {
				previousEntry = current;
				if (key.equals(current.getKey())) {
					return current;
				} else {
					current = current.getNextEntry();
				}
			}
		}
		return previousEntry;
	}

	/**
	 * Removes the.
	 *
	 * @param key
	 *            the key
	 * @return true, if successful
	 */
	public boolean remove(K key) {
		int index = getIndexPosition(key);
		MyEntry<K, V> current = entries[index];
		// MyEntry<K, V> previousEntry = null;
		if (null == current) {
			return false;
		} else {
			while (current != null) {
				// previousEntry = current;
				if (key.equals(current.getKey())) {
					current = null;
					--size;
					return true;
				} else {
					current = current.getNextEntry();
				}
			}
		}
		// previousEntry = null;
		--size;
		return true;
	}

	/**
	 * Gets the size.
	 *
	 * @return the size
	 */
	public int getSize() {
		return size;
	}

	/**
	 * Gets the entries.
	 *
	 * @return the entries
	 */
	public MyEntry<K, V>[] getEntries() {
		return entries;
	}

	/**
	 * Ensure capacity.
	 */
	// if CAPACITY exceeds, double its size and reassign entry array
	private void ensureCapacity() {
		if (size == CAPACITY) {
			CAPACITY = CAPACITY * 2;
			entries = Arrays.copyOf(entries, CAPACITY);
		}
	}

	/**
	 * Resize entries.
	 *
	 * @param pos
	 *            the pos
	 */
	private void resizeEntries(int pos) {
		for (int i = pos; i < entries.length; ++i) {
			entries[i] = entries[i + 1];
		}
	}
}
