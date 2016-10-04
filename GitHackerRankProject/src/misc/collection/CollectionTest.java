package misc.collection;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class CollectionTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CollectionTest ct = new CollectionTest();
		System.out.println("--- Testing LinkedHashMap --- ");
		ct.testLinkedHashMap();
		System.out.println("--- Testing HashMap --- ");
		ct.testHashMap();
	}

	void testLinkedHashMap() {
		Map<Integer, String> lm = new LinkedHashMap<>();
		lm.put(5, "E");
		lm.put(3, "C");
		lm.put(2, "B");
		lm.put(1, "A");
		lm.put(4, "D");
		lm.forEach((k, v) -> System.out.println(k + ": " + v));
	}

	void testHashMap() {
		Map<Integer, String> lm = new HashMap<>();
		lm.put(5, "E");
		lm.put(3, "C");
		lm.put(2, "B");
		lm.put(1, "A");
		lm.put(4, "D");
		lm.forEach((k, v) -> System.out.println(k + ": " + v));
	}

}
