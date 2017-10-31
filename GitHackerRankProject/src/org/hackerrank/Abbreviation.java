package org.hackerrank;

import java.util.Arrays;
import java.util.Scanner;

/*
 * <code>
 * 10
Kqiwysuaqm
K
GHVYEZVTD
GEZDVKS
FSnPUSEbC
SPUSCL
HLWNgBte
HLWNB
XHlds
XH
TWEMGGSSGq
TEMGGSS
RPLFYv
FRSXZI
NKgIIET
NTWEQ
GYTJXMKLvu
GYTJXMKL
HIFuOPyb
HIFOP
 * 
 * Output:
YES
NO
NO
YES
YES
NO
NO
NO
YES
YES
 * </code>
 * 
 */
public class Abbreviation {

	public static void main(String[] args) {

		// String a = "GHVYEZVTD"; // "bBccC";
		// String b = "GEZDVKS";// "BBC";
		// System.out.println(getResult(a, b));

		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		String a[] = new String[n];
		String b[] = new String[n];
		for (int i = 0; i < n; ++i) {
			a[i] = in.next();
			b[i] = in.next();
		}
		in.close();
		for (int i = 0; i < n; ++i) {
			System.out.println(getResult(a[i], b[i]));
		}

	}

	private static String getResult(String a, String b) {
		if (a.length() < b.length()) {
			return "NO";
		}
		StringBuilder sb = new StringBuilder(a.toUpperCase());
		// System.out.println("Updated a: " + sb.toString() + ", b: " + b);
		Arrays.sort(sb.toString().toCharArray());
		Arrays.sort(b.toCharArray());
		String res = sb.indexOf(b) == -1 ? "NO" : "YES";
		return res;

	}

}
