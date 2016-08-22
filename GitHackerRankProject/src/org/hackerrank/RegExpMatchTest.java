package org.hackerrank;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExpMatchTest {
    public static void main(String[] args) {
	String s = "aaa";
	String pattern = "a*|b";
	// System.out.println("Matches either ? " + isMatch(s, pattern));
	// ---------------------------------------------------
	s = "534343";
	pattern = "\\d*";
	System.out.println("Matches digit only? " + s + " => " + isMatch(s, pattern));
	s = "23423323f";
	System.out.println("Matches digit only? " + s + " => " + isMatch(s, pattern));
	System.out.println("-------------------------------------------------------------");
	s = "chisty";
	pattern = "\\D*";
	System.out.println("Matches nondigit only? " + s + " => " + isMatch(s, pattern));
	s = "d99ffrt";
	System.out.println("Matches nondigit only? " + s + " => " + isMatch(s, pattern));
	System.out.println("-------------------------------------------------------------");
	s = "Test by chisty";
	pattern = "by";
	System.out.println("Matches lookingAt? " + s + " => " + isLookingAt(s, pattern));
	pattern = "Test";
	System.out.println("Matches lookingAt? " + s + " => " + isLookingAt(s, pattern));
	System.out.println("-------------------------------------------------------------");
	s = "aaaeee";
	pattern = "[a-z]*e+";
	System.out.println("Matches? " + s + " => " + isMatch(s, pattern));
	s = "abc@e.com";
	pattern = "[a-z]+@[a-z]+.[a-z]+";
	System.out.println("Matches? " + s + " => " + isMatch(s, pattern));
	System.out.println("-------------------------------------------------------------");
	// --------------------------------------------------------------------------
	// Let's test with the Constraints with first name:
	// --------------------------------------------------------------------------
	// - First name consists of lower case letters only.
	// - The length of the first name is no longer than 20.
	pattern = "[a-z]{1,20}";
	s = "Chisty";
	System.out.println("Matches? " + s + " => " + isMatch(s, pattern));
	System.out.println("-------------------------------------------------------------");
	// - Each of the email IDs consists of lower case letters [a-z], @ and . only.
	// - The length of the email ID is no longer than 50.
	// pattern = "[[a-z]+[@gmail.com]{1}]{1,20}";
	pattern = "[a-z]+[.a-z]*@gmail.com";
	s = "gmail.alice@gmail.com";
	System.out.println("Matches? " + s + " => " + isMatch(s, pattern));
	System.out.println("-------------------------------------------------------------");
	pattern = "(.)\2+";
	s = "acaa";
	System.out.println("Repated Matches? " + s + " => " + isMatch(s, pattern));
	System.out.println("-------------------------------------------------------------");
	pattern = "^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])$";
	s = "121.234.12.12"; // "00.12.123.123123.123"; // 122.23 Hello.IP
	System.out.println("IP address Matches? " + s + " => " + isMatch(s, pattern));
	System.out.println("-------------------------------------------------------------");
	pattern = "[L|R|M]*";
	s = "LLLMMMR";
	System.out.println("Matches? " + s + " => " + isMatch(s, pattern));
	s = "lrm";
	System.out.println("Matches? " + s + " => " + isMatch(s, pattern));
	System.out.println("-------------------------------------------------------------");
    }

    static boolean isMatch(String s, String pattern) {
	Pattern p = Pattern.compile(pattern);
	Matcher m = p.matcher(s);
	return m.matches();
    }
    // -----------------------------------

    static boolean isLookingAt(String s, String pattern) {
	Pattern p = Pattern.compile(pattern);
	Matcher m = p.matcher(s);
	return m.lookingAt();
    }
}
