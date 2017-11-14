
package org.hackerrank.hash;

public class TestMyHashMap {

	public static void main(String[] args) {
		MyHashMap<Integer, String> map = new MyHashMap<>();
		map.put(200, "Val_200");
		map.put(300, "Val_300");
		map.put(200, "Val_updated");
		map.put(500, "Val_400");
		int key = 200;
		System.out.println("key: " + key + ", value: " + map.get(key));
		key = 300;
		System.out.println("key: " + key + ", value: " + map.get(key));
		System.out.println("size: " + map.getSize());
		map.remove(key);
		System.out.println("After removal, size: " + map.getSize());
		// -------------------------------------------------
		// long end = System.currentTimeMillis();
		// long time = (end - start);
		// // System.out.println("Time to execute: " + time);
		// System.out.println("======= Test with java hashmap ==========");
		// HashMap<Integer, String> hm = new HashMap<>();
		// hm.put(200, "Val_200000");
		// hm.put(300, "Val_30000000");
		//
		// System.out.println("size: " + hm.size());
		// key = 200;
		// System.out.println("key: " + key + ", value: " + hm.get(key));
		// key = 300;
		// System.out.println("key: " + key + ", value: " + hm.get(key));
	}
}
