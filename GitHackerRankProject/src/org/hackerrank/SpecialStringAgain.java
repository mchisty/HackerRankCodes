package org.hackerrank;

public class SpecialStringAgain {

	public static void main(String[] args) {

		String s = "aaaa"; // "mnonopoo"; // // "abcbaba";
		int n = s.length();
		System.out.println("Text to operate: " + s);
		System.out.println(substrCount(n, s));

	}

	public static long substrCount(int length, String s) {
		long counter = 0;
		for (int i = 0; i < length; i++) {
			System.out.println("i in for loop:" + i);
			// if the current symbol is in the middle of palindrome, e.g. aba
			int offset = 1;
			while (i - offset >= 0 && i + offset < length && s.charAt(i - offset) == s.charAt(i - 1)
					&& s.charAt(i + offset) == s.charAt(i - 1)) {
				counter++;
				offset++;
			}
			// if this is repeatable characters aa
			int repeats = 0;
			while (i + 1 < length && s.charAt(i) == s.charAt(i + 1)) {
				System.out.println("=> i in while loop:" + i);
				repeats++;
				i++;
			}
			System.out.println("Counter before:" + counter);
			counter += repeats * (repeats + 1) / 2;
			System.out.println("Counter after:" + counter);
		}
		return counter + length;
	}

//	static long substrCount(int n, String s) {
//		long count = 0;
//		for (int i = 0; i < n; ++i) {
//			int j = i + 1;
//			while (j <= n) {
//				String key = s.substring(i, j);
//				if (key.length() == 1 || isValid(key)) {
//					++count;
//				}
//				++j;
//			}
//		}
//
//		return count;
//
//	}

	private static boolean isValid(String s) {
		boolean isEven = (s.length() % 2 == 0);
		int halfPosition = s.length() / 2;
		String left = s.substring(0, halfPosition);
		String right = s.substring(isEven ? halfPosition : halfPosition + 1, s.length());
		if (!left.equals(right)) {
			return false;
		}
		String first = "" + s.charAt(0);
		String regex = "[" + first + "]+";
		return left.matches(regex);
	}

}
