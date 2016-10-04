package misc.crackingcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * Given two strings, and , that may or may not be of the same length, determine
 * the minimum number of character deletions required to make and anagrams. Any
 * characters can be deleted from either of the strings.
 * 
 * 
 * Note: The second string manipulation is interesting. The count is set as -1
 * instead of 1 if an element is inserted from second string. As because the
 * count will keep on decrementing, so we start from count=-1. In final stage,
 * we do the calculation using Math.abs
 *
 */
public class MakingAnagrams {

	/**
	 * The main method.
	 *
	 * @param args
	 *            the arguments
	 */
	public static void main(String[] args) {
		String s1 = "bugexikjevtubidpulaelsbcqlupwetzyzdvjphn";
		String s2 = "lajoipfecfinxjspxmevqxuqyalhrsxcvgsdxxkacspbchrbvvwnvsdtsrdk";
		// Expected output=40
		System.out.println("" + numberNeeded(s1, s2));

	}

	/**
	 * Number needed.
	 *
	 * @param s1
	 *            the s1
	 * @param s2
	 *            the s2
	 * @return the int
	 */
	public static int numberNeeded(String s1, String s2) {
		Map<Character, Integer> map = new HashMap<>();
		char[] carr = s1.toCharArray();
		int count = 0;
		for (int i = 0; i < carr.length; ++i) {
			if (!map.containsKey(carr[i])) {
				map.put(carr[i], 1);
			} else {
				count = map.get(carr[i]);
				map.put(carr[i], ++count);
			}
		}

		carr = s2.toCharArray();
		for (int i = 0; i < carr.length; ++i) {
			if (!map.containsKey(carr[i])) {
				map.put(carr[i], -1); // Note this: interesting, count starts
										// from -1. Not 1 or 0
			} else {
				count = map.get(carr[i]);
				map.put(carr[i], --count);
			}
		}

		List<Integer> values = new ArrayList<>(map.values());
		int total = 0;
		for (Integer v : values) {
			total += Math.abs(v);
		}
		return total;
	}

}
