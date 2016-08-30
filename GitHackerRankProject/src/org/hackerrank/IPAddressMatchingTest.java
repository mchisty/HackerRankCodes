package org.hackerrank;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IPAddressMatchingTest {
	public final static String pattern = "^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])$";
	private final static Pattern p = Pattern.compile(pattern);

	public boolean isMatches(String ip) {
		Matcher m = p.matcher(ip);
		return m.matches();
	}

	public static void main(String arg[]) {
		String ip = "101.22.98.101";
		IPAddressMatchingTest test = new IPAddressMatchingTest();
		System.out.println(ip + " -> " + test.isMatches(ip));
		ip = "101.22.98.zbc";
		System.out.println(ip + " -> " + test.isMatches(ip));
	}
}
