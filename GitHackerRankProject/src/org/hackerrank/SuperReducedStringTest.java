package org.hackerrank;

public class SuperReducedStringTest {
    public static void main(String[] args) {
	String s = "acccaa"; // "baab"; // "abbbbacc"; // "aaabccddd"; //"aa"; //
	System.out.println("Original value: " + s);
	System.out.println("" + reduce(s));
    }

    static String reduce(String s) {
	if (null == s) {
	    return "Empty String";
	}
	if (s.length() == 0) {
	    return "Empty String";
	}
	boolean found = false;
	StringBuilder sb = new StringBuilder(s);
	for (int i = 0; i < sb.length() - 1; ++i) {
	    int j = i + 1;
	    if (sb.charAt(i) == sb.charAt(j)) {
		found = true;
		sb.delete(i, j + 1);
	    }
	}
	if (found) {
	    s = reduce(sb.toString());
	}
	if (s.length() == 2) {
	    if (s.charAt(0) == s.charAt(1)) {
		s = "Empty String";
	    }
	}
	return s;
    }
}
