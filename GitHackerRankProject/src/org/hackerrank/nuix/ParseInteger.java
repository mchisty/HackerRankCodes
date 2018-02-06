package org.hackerrank.nuix;

public class ParseInteger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i = parseInt("ds");
		System.out.println(i);

	}

	public static int parseInt(String s) throws NumberFormatException {
		int num = 0;
		for (int i = 0; i < s.length(); i++) {
			if ((s.charAt(i) >= 48) && (s.charAt(i) <= 57)) {
				num = num * 10 + (s.charAt(i) - 48);
			} else {
				throw new NumberFormatException();
			}

		}
		return num;
	}

}
