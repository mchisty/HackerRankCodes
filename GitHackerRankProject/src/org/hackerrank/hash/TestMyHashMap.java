package org.hackerrank.hash;

import java.util.HashMap;

public class TestMyHashMap {

	public static void main(String[] args) {

		MyHashMap<Integer, String> map = new MyHashMap<>();

		// final int RANGE = 1000;
		// for (int i = 0; i < RANGE; ++i) {
		// map.put(i, "value_" + i);
		// }

		map.put(200, "Val_200000");
		map.put(300, "Val_30000000");

		long start = System.currentTimeMillis();
		System.out.println("size: " + map.getSize());
		int key = 200;
		System.out.println("key: " + key + ", value: " + map.get(key));
		key = 300;
		System.out.println("key: " + key + ", value: " + map.get(key));

		map.remove(300);
		System.out.println("************** after removal ***************");
		System.out.println("after removal. size is: " + map.getSize());
		System.out.println("key: " + key + ", value: " + map.get(key));

		// -------------------------------------------------
		long end = System.currentTimeMillis();
		long time = (end - start);
		// System.out.println("Time to execute: " + time);
		System.out.println("======= Test with java hashmap ==========");
		HashMap<Integer, String> hm = new HashMap<>();
		hm.put(200, "Val_200000");
		hm.put(300, "Val_30000000");

		System.out.println("size: " + hm.size());
		key = 200;
		System.out.println("key: " + key + ", value: " + hm.get(key));
		key = 300;
		System.out.println("key: " + key + ", value: " + hm.get(key));

		hm.remove(300);
		System.out.println("************** after removal using java hashmap ***************");
		System.out.println("after removal. size is: " + hm.size());
		System.out.println("key: " + key + ", value: " + hm.get(key));

	}

}
