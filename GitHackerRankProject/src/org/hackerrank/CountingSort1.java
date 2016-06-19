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
	int count = 0;
	for (int j = 0; j <= n; ++j) {
	    for (int i = 0; i < a.length; ++i) {
		if (j == a[i]) {
		    count = count + 1;
		}
	    }
	    System.out.print(count + " ");
	    count = 0;
	}
    }
}
