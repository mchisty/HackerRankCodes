package org.hackerrank;

import java.util.Arrays;
import java.util.Scanner;

public class GridChallenge {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		for (int i = 0; i < T; ++i) {
			int N = in.nextInt();
			String line[] = new String[N];
			for (int j = 0; j < N; ++j) {
				line[j] = in.next();
			}
			System.out.println(getResult(line));
		}
		in.close();

		// String s = "fedcba";
		// char[] carr = s.toCharArray();
		// Arrays.sort(carr);
		// String tmp = s.copyValueOf(carr);
		// System.out.println(tmp);

	}

	private static String getResult(String[] lines) {
		char c = Character.MIN_VALUE; // first char at first [0,0] position
		for (String s : lines) {
			char[] carr = s.toCharArray();
			Arrays.sort(carr);
			String tmp = String.copyValueOf(carr);
			if (c > tmp.charAt(0)) {
				return "NO";
				// break;
			} else {
				c = tmp.charAt(0);
			}

			System.out.println("sorted: " + tmp + ", c: " + c);
		}
		return "YES";
	}

}
