package org.hackerrank.hash;

import java.util.Arrays;

public class MyHashMap<K, V> {
	private int CAPACITY = 20;
	MHEntry<K, V> entries[] = new MHEntry[CAPACITY];
	private int size = 0;

	public void put(K key, V val) {
		for (MHEntry<K, V> mh : entries) {
			if (mh.getKey().equals(key)) {
				mh.setValue(val);
				break;
			}
		}
		// Now test capacity before insertion
		ensureCapacity();
		entries[++size] = new MHEntry<K, V>(key, val);
	}

	// if CAPACITY exceeds, double its size and reassign entry array
	private void ensureCapacity() {
		if (size == CAPACITY) {
			CAPACITY = CAPACITY * 2;
			entries = Arrays.copyOf(entries, CAPACITY);
		}
	}

	public V getValue(K key) {
		for (MHEntry<K, V> mh : entries) {
			if (mh.getKey().equals(key)) {
				return mh.getValue();
			}
		}
		return null;
	}

	public void remove(K key) {
		for (int i = 0; i < entries.length; ++i) {
			MHEntry<K, V> mh = entries[i];
			if (mh.getKey().equals(key)) {
				mh = null;
				resizeEntries(i);
				--size;
				break;
			}
		}
	}

	private void resizeEntries(int pos) {
		for (int i = pos; i < entries.length; ++i) {
			entries[i] = entries[i + 1];
		}
	}
}
