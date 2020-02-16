package org.hackerrank;

import java.util.HashMap;
import java.util.Map;

/**
 * Two words are anagrams of one another if their letters can be rearranged to
 * form the other word.
 * 
 * In this challenge, you will be given a string. You must split it into two
 * contiguous substrings, then determine the minimum number of characters to
 * change to make the two substrings into anagrams of one another.
 * 
 * For example, given the string 'abccde', you would break it into two parts:
 * 'abc' and 'cde'. Note that all letters have been used, the substrings are
 * contiguous and their lengths are equal. Now you can change 'a' and 'b' in the
 * first substring to 'd' and 'e' to have 'dec' and 'cde' which are anagrams.
 * Two changes were necessary.
 * 
 * @author mchisty
 *
 */
public class AnagramTest {

	public static void main(String[] args) {
//		String s = "fdhlvosfpafhalll"; // Expected: 5
		String s = "mvdalvkiopaufl"; // Expected: 5
		System.out.println("Count: " + anagram(s));

	}

	static int anagram(String s) {
		if (s.length() % 2 != 0) {
			return -1;
		}
		int mid = s.length() / 2;
		return countManipulations(s.substring(0, mid), s.substring(mid));
	}



	static int countManipulations(String a, String b) {
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i = 0; i < a.length(); ++i) {
			Character c = a.charAt(i);
			int frequency = map.getOrDefault(c, 0) + 1;
			map.put(c, frequency);
		}

		for (int i = 0; i < b.length(); ++i) {
			Character c = b.charAt(i);
			if (map.containsKey(c) && map.get(c) > 0) {
				int frequency = map.get(c) - 1;
				map.put(c, frequency);
			}
		}

		int count = 0;
		for (Map.Entry<Character, Integer> entry : map.entrySet()) {
			count = count + entry.getValue();
		}
		return count;

	}

}
