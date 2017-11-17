
package org.hackerrank.hash;

public class TestMyHashMap {

	public static void main(String[] args) {
		MyHashMap<Integer, String> map = new MyHashMap<>();
		map.put(200, "Val_200");
		map.put(300, "Val_300");
		map.put(200, "Val_updated");
		map.put(400, "Val_400");
		map.put(500, "Val_500");
		for (MyEntry<Integer, String> mentry : map.getEntries()) {
			System.out.println("key: " + mentry.getKey() + ", value: " + mentry.getValue());
		}
		System.out.println("size: " + map.getSize());
		int key = 300;
		System.out.println("Removing: " + key + "=" + map.get(key));
		map.remove(key);
		System.out.println("After removal, size: " + map.getSize());
		key = 400;
		System.out.println("Removing: " + key + "=" + map.get(key));
		map.remove(key);
		System.out.println("After removal, size: " + map.getSize());
	}
}
