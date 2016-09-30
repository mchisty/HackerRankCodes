package misc.crackingcode;

import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class HashTableRansomNote {

	Map<String, Integer> magazineMap;
	// Map<String, Integer> noteMap;

	public static void main(String[] args) {
		// String magazine = "give me one grand today night";
		// String note = "give one grand today";
		// HashTableRansomNote h = new HashTableRansomNote();
		// System.out.println(h.solve(magazine, note));

		String[] magazine = { "give", "me", "one", "grand", "today", "night" };
		String[] note = { "give", "one", "grand", "today" };
		HashTableRansomNote h = new HashTableRansomNote();
		String result = h.solve(magazine, note) ? "Yes" : "No";
		System.out.println(result);

	}

	// public HashTableRansomNote(String magazine, String note) {
	// magazineMap = new HashMap<>();
	// noteMap = new HashMap<>();
	// // TODO
	// StringTokenizer stoken = new StringTokenizer(magazine, " \t");
	// int count = 0;
	// while (stoken.hasMoreTokens()) {
	// String key = stoken.nextToken();
	// if (magazineMap.containsKey(key)) {
	// count = magazineMap.get(key) + 1;
	// } else {
	// count = 0;
	// }
	// ++count;
	// magazineMap.put(key, count);
	// }

	// }

	public boolean solve(String magazine, String note) {
		magazineMap = new HashMap<>();
		StringTokenizer stoken = new StringTokenizer(magazine, " \t");
		int count = 0;
		while (stoken.hasMoreTokens()) {
			String key = stoken.nextToken();
			if (magazineMap.containsKey(key)) {
				count = magazineMap.get(key) + 1;
			} else {
				count = 0;
			}
			++count;
			magazineMap.put(key, count);
		}

		stoken = new StringTokenizer(note, " \t");
		while (stoken.hasMoreTokens()) {
			String key = stoken.nextToken();
			if (!magazineMap.containsKey(key)) {
				return false;
			}
		}

		return true;

	}

	// Using array

	public boolean solve(String[] magazine, String[] note) {
		int count = 1;
		Stream<String> words = Stream.of(magazine);
		magazineMap = words.collect(Collectors.toMap(k -> k, v -> count));
		for (String s : note) {
			if (!magazineMap.containsKey(s)) {
				return false;
			}
		}
		// magazineMap.forEach((k, v) -> System.out.println(k + " " + v));
		return true;

	}

}
