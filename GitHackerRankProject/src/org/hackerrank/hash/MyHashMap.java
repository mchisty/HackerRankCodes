
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
	 * Put.
	 *
	 * @param key
	 *            the key
	 * @param val
	 *            the val
	 */
	public void put(K key, V val) {
		int index = getIndexPosition(key);
		MyEntry<K, V> existingEntry = entries[index];
		if (null == existingEntry) {
			entries[index] = new MyEntry<>(key, val);
			++size;
		} else {
			MyEntry<K, V> tmp = null;
			while (existingEntry != null) {
				tmp = existingEntry;
				if (key.equals(existingEntry.getKey())) {
					existingEntry.setValue(val);
					return;
				} else {
					existingEntry = existingEntry.getNextEntry();
				}
			}
			// The next entry is null
			tmp.setNextEntry(new MyEntry<>(key, val));
			++size;
		}
	}

	/**
	 * Put 1.
	 *
	 * @param key
	 *            the key
	 * @param val
	 *            the val
	 */
	public void put1(K key, V val) {
		int index = getIndexPosition(key);
		MyEntry<K, V> tmp = entries[index];
		MyEntry<K, V> firstElementInIndexChain = entries[index];
		while (tmp != null) {
			if (tmp.getKey().equals(key)) {
				tmp.setValue(val);
				return;
			}
			tmp = tmp.getNextEntry();
		}
		MyEntry<K, V> newEntry = new MyEntry<>(key, val);
		// New Entry added to the first in chain; rest of the items shifted down one
		// position
		newEntry.setNextEntry(firstElementInIndexChain);
		entries[index] = newEntry;
		++size;
	}

	/**
	 * Gets the entries.
	 *
	 * @return the entries
	 */
	public MyEntry<K, V>[] getEntries() {
		MyEntry<K, V> updatedEntries[] = new MyEntry[size];
		int i = 0;
		for (MyEntry<K, V> me : entries) {
			do {
				if (me != null) {
					updatedEntries[i++] = me;
					me = me.getNextEntry();
				}
			} while (me != null);
		}
		return updatedEntries;
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
