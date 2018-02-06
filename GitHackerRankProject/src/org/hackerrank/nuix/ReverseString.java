package org.hackerrank.nuix;

public class ReverseString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "Hello";
		char[] array = s.toCharArray();
		char[] result = new char[array.length];
		for (int i = array.length - 1, j = 0; i >= 0; --i, ++j) {
			result[j] = array[i];
		}

		System.out.println(String.copyValueOf(result));

	}

}
