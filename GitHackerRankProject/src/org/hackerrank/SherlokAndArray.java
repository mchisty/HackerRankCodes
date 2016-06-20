package org.hackerrank;
// Sample input

import java.util.Scanner;

//2
//3
//1 2 3
//4
//1 2 3 3
//--------------------
// Sample output
//NO
//YES
//--------------------
public class SherlokAndArray {
    public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	int t = in.nextInt();
	for (int x = 0; x < t; x++) {
	    int size = in.nextInt();
	    int[] a = new int[size];
	    for (int i = 0; i < size; ++i) {
		a[i] = in.nextInt();
	    }
	    System.out.println(getResult(a));
	}
	in.close();
	// int[] b = { 1, 1, 1, 1, 2, 2 };
	// System.out.println(getResult(b));
    }

    static String getResult(int[] a) {
	if (a.length == 1) {
	    return "YES";
	}
	boolean flag = false;
	for (int i = 1; i < a.length; ++i) {
	    flag = isEqual(a, i);
	    if (flag) {
		break;
	    }
	}
	// flag = isEqual(a, 2);
	return flag ? "YES" : "NO";
    }

    static boolean isEqual(int[] a, int midPos) {
	int sumLeft = 0;
	int sumRight = 0;
	for (int i = 0, j = midPos + 1; i < midPos || j < a.length; ++i, ++j) {
	    if (i < midPos) {
		sumLeft = sumLeft + a[i];
	    }
	    if (j < a.length) {
		sumRight = sumRight + a[j];
		// System.out.println(a[j] + " = " + sumRight);
	    }
	}
	return sumLeft == sumRight;
    }
}
