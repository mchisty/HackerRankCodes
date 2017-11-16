
package org.hackerrank.hash;

import java.util.Arrays;

public class MyHashMap<K, V> {

	private int CAPACITY = 100;

	private MyEntry<K, V> entries[] = new MyEntry[CAPACITY];

	private int size = 0;

	private int getIndexPosition(K key) {
		return key.hashCode() % CAPACITY;
	}

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
				if (key.equals(current.key)) {
					current.value = val;
					return;
				} else {
					current = current.nextEntry;
				}
			}
			// The next entry is null
			tmp.nextEntry = new MyEntry<>(key, val);
			++size;
		}
	}

	public V get(K key) {
		MyEntry<K, V> entry = getEntry(key);
		return entry.value;
	}

	private MyEntry<K, V> getEntry(K key) {
		int index = getIndexPosition(key);
		MyEntry<K, V> current = entries[index];
		MyEntry<K, V> previousEntry = null;
		if (null == current) {
			return null;
		} else {
			while (current != null) {
				previousEntry = current;
				if (key.equals(current.key)) {
					return current;
				} else {
					current = current.nextEntry;
				}
			}
		}
		return previousEntry;
	}

	// ------------------------------------------------------------------
	public boolean remove(K key) {
		int index = getIndexPosition(key);
		MyEntry<K, V> current = entries[index];
		// MyEntry<K, V> previousEntry = null;
		if (null == current) {
			return false;
		} else {
			while (current != null) {
				// previousEntry = current;
				if (key.equals(current.key)) {
					current = null;
					--size;
					return true;
				} else {
					current = current.nextEntry;
				}
			}
		}
		// previousEntry = null;
		--size;
		return true;
	}

	// if CAPACITY exceeds, double its size and reassign entry array
	private void ensureCapacity() {
		if (size == CAPACITY) {
			CAPACITY = CAPACITY * 2;
			entries = Arrays.copyOf(entries, CAPACITY);
		}
	}

	private void resizeEntries(int pos) {
		for (int i = pos; i < entries.length; ++i) {
			entries[i] = entries[i + 1];
		}
	}

	public int getSize() {
		return size;
	}

	class MyEntry<K, V> {

		private K key;

		private V value;

		private MyEntry<K, V> nextEntry;

		MyEntry(K key, V value) {
			super();
			this.key = key;
			this.value = value;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((key == null) ? 0 : key.hashCode());
			result = prime * result + ((nextEntry == null) ? 0 : nextEntry.hashCode());
			result = prime * result + ((value == null) ? 0 : value.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj) {
				return true;
			}
			if (obj == null) {
				return false;
			}
			if (getClass() != obj.getClass()) {
				return false;
			}
			MyEntry other = (MyEntry) obj;
			if (key == null) {
				if (other.key != null) {
					return false;
				}
			} else if (!key.equals(other.key)) {
				return false;
			}
			if (nextEntry == null) {
				if (other.nextEntry != null) {
					return false;
				}
			} else if (!nextEntry.equals(other.nextEntry)) {
				return false;
			}
			if (value == null) {
				if (other.value != null) {
					return false;
				}
			} else if (!value.equals(other.value)) {
				return false;
			}
			return true;
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

	/**
	 * @return the entries
	 */
	public MyEntry<K, V>[] getEntries() {
		return entries;
	}
}
