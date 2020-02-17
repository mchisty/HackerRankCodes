package misc.amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SubStringDistinctTest {

	public static void main(String[] args) {
		SubStringDistinctTest st = new SubStringDistinctTest();
		int num = 4;
		// awaglknagawunagwkwagl, abcd
		List<String> list = st.subStringsKDist("awaglknagawunagwkwagl", num);
		System.out.println(list.toString());
	}

	public List<String> subStringsKDist(String inputStr, int num) {
		Set<String> subs = new HashSet<>();
		for (int i = 0; i < inputStr.length() - num + 1; ++i) {
			String tmp = inputStr.substring(i, i + num);
			// Approach 1
//			if (isContainUniqueChar(tmp)) {
//				subs.add(tmp);
//			}
			// Approach 2
			if (isUniqueCharacters(tmp)) {
				subs.add(tmp);
			}
		}
		return new ArrayList<>(subs);
	}

	// Approach 1
	private static boolean isContainUniqueChar(String input) {
		Set<Character> set = new HashSet<>();
		char[] characters = input.toCharArray();

		for (Character c : characters) {
			if (!set.add(c)) {
				return false;
			}
		}
		return true;
	}

	// Approach 2
	// ascii value of 'a' = 97 and 'z' = 122
	final static int MAX_CHAR = 122;
	static boolean isUniqueCharacters(String str) {
		if (str.length() > MAX_CHAR)
			return false;

		boolean[] chars = new boolean[MAX_CHAR];
		Arrays.fill(chars, false);

		for (int i = 0; i < str.length(); i++) {
			int index = (int) str.charAt(i);

			/*
			 * If the value is already true, string has duplicate characters, return false
			 */
			if (chars[index] == true)
				return false;

			chars[index] = true;
		}

		/* No duplicates encountered, return true */
		return true;
	}

}
