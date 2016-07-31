package org.hackerrank;

public class IPAddressMatch {
    public static void main(String[] args) {
	// TODO Auto-generated method stub
	// String IP = "121.234.12.12";
	// MyRegex mr = new MyRegex(IP);
	// System.out.println(mr.isMatches());
	new IPAddressMatch().divide(4, 0);
	StringBuilder s = new StringBuilder("Hello");
	s.reverse().toString();
    }

    public void divide(int a, int b) {
	try {
	    int c = a / b;
	} catch (Exception e) {
	    System.out.println("Exception");
	} finally {
	    System.out.println("Finally");
	}
    }
}
