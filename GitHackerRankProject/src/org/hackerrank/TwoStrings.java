package org.hackerrank;

import java.util.Scanner;

public class TwoStrings {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for (int x = 0; x < t; ++t) {
			String s1 = in.next();
			String s2 = in.next();
			System.out.println(test(s1, s2));
		}
		in.close();

	}

	static String test(String s1, String s2) {
		char[] alphabets = "abcdefghijklmnopqrstuvwxyz".toCharArray();
		for (char c : alphabets) {
			if (s1.indexOf(c) != -1 && s2.indexOf(c) != -1) {
				return "YES";
			}
		}
		return "NO";
	}

}
