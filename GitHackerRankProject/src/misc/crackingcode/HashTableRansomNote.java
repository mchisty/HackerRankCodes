package misc.crackingcode;

import java.util.HashMap;
import java.util.Map;

public class HashTableRansomNote {

	public static void main(String[] args) {
		// String[] magazine = { "give", "me", "one", "grand", "today", "night"
		// };
		// String[] note = { "give", "one", "grand", "today" };
		// Expected: Yes
		// -------------------------------------------------------------

		String one = "o l x imjaw bee khmla v o v o imjaw l khmla imjaw x";
		String two = "imjaw l khmla x imjaw o l l o khmla v bee o o imjaw imjaw o";
		String[] magazine = one.split("\\s+");
		String[] note = two.split("\\s+");
		// Expected: No
		// -------------------------------------------------------------
		// String[] magazine = { "give", "me" };
		// String[] note = { "give", "me", "give", "me" };
		// Expected: Yes

		HashTableRansomNote h = new HashTableRansomNote();
		String result = h.solve(magazine, note) ? "Yes" : "No";
		System.out.println(result);

	}

	public boolean solve(String[] magazine, String[] ransom) {
		int count = 0;
		Map<String, Integer> magazineMap = new HashMap<>(30000);
		for (String s : magazine) {
			if (magazineMap.containsKey(s)) {
				count = magazineMap.get(s) + 1;
			} else {
				count = 0;
			}
			++count;
			magazineMap.put(s, count);
		}

		for (String s : ransom) {
			if (!magazineMap.containsKey(s)) {
				return false;
			}
			count = magazineMap.get(s);
			if (count == 0) {
				return false;
			} else {
				count = count - 1;
				magazineMap.put(s, count);
			}
		}
		return true;
	}

}
