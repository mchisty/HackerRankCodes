package org.hackerrank;

import java.util.Scanner;

public class CountingSort1 {
    public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	int n = in.nextInt();
	int[] a = new int[n];
	for (int i = 0; i < n; i++) {
	    a[i] = in.nextInt();
	}
	in.close();
	for (int i = 0; i < a.length - 1; ++i) {
	    int num = a[i];
	    for (int j = i + 1; j < a.length; ++j) {
		if (a[j] == num) {
		}
	    }
	}
    }
}
