package org.hackerrank;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BeautifyBinaryString {

	public static void main(String[] args) {
		final String INPUT = "01100";
		// -------------------
		final String REGEX = "010";
		Pattern p = Pattern.compile(REGEX);
		Matcher m = p.matcher(INPUT);
		int count = 0;
		while (m.find()) {
			count++;
		}
		System.out.println("Count: " + count);

	}

}
