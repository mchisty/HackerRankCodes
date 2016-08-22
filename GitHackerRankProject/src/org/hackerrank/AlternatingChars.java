package org.hackerrank;
// Sample input

import java.util.Scanner;

//5
//AAAA
//BBBBB
//ABABABAB
//BABABA
//AAABBB
//------------------------
// Sample output
//------------------------
//3
//4
//0
//0
//4
public class AlternatingChars {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		String[] stArr = new String[n];
		for (int i = 0; i < n; i++) {
			stArr[i] = in.next();
		}
		in.close();
		int count = 0;
		for (int k = 0; k < stArr.length; ++k) {
			String s = stArr[k];
			char c = s.charAt(0);
			char[] arr = s.toCharArray();
			for (int i = 1; i < arr.length; ++i) {
				if (c == arr[i]) {
					++count;
				} else {
					c = arr[i];
				}
			}
			System.out.println(count);
			count = 0;
		}
	}
}
