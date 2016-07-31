package org.hackerrank;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyRegex extends IPAddressMatch {
    public final static String pattern = "^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])$";
    static String s = "";
    private final static Pattern p = Pattern.compile(pattern);

    public MyRegex(String IP) {
	this.s = IP;
    }

    public static boolean isMatches() {
	Matcher m = p.matcher(s);
	return m.matches();
    }
}
