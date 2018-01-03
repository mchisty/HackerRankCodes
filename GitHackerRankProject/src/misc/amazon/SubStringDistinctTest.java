package misc.amazon;

import java.util.ArrayList;
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
			if (isDistinct(tmp)) {
				subs.add(tmp);
			}
		}
		return new ArrayList<>(subs);
	}

	private static boolean isDistinct(String input) {
		Set<Character> set = new HashSet<>();
		char[] characters = input.toCharArray();

		for (Character c : characters) {
			if (!set.add(c)) {
				return false;
			}
		}
		return true;
	}

}
