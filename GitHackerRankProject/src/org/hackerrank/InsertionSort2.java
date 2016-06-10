package org.hackerrank;

import java.util.Scanner;
//---------------
// Input:
//6
//1 4 3 5 6 2
//---------------
// Output:
//1 4 3 5 6 2 
//1 3 4 5 6 2 
//1 3 4 5 6 2 
//1 3 4 5 6 2 
//1 2 3 4 5 6
//---------------------
// Input: 
//9
//9 8 6 7 3 5 4 1 2
//---------------------
// Output:
//8 9 6 7 3 5 4 1 2
//6 8 9 7 3 5 4 1 2
//6 7 8 9 3 5 4 1 2
//3 6 7 8 9 5 4 1 2
//3 5 6 7 8 9 4 1 2
//3 4 5 6 7 8 9 1 2
//1 3 4 5 6 7 8 9 2
//1 2 3 4 5 6 7 8 9
//---------------------

public class InsertionSort2 {
    // My solution: the lengthy way
    public static void insertionSortPart2(int[] ar) {
	for (int size1 = 2; size1 < ar.length; ++size1) {
	    int size2 = ar.length - size1;
	    int ar1[] = new int[size1];
	    int ar2[] = new int[size2];
	    int i = 0;
	    for (; i < ar1.length; ++i) {
		ar1[i] = ar[i];
	    }
	    ar1 = getSortedArray(ar1);
	    for (int k = 0; i < ar.length; ++i, ++k) {
		ar2[k] = ar[i];
	    }
	    int result[] = new int[ar.length];
	    i = 0;
	    for (; i < ar1.length; ++i) {
		result[i] = ar1[i];
	    }
	    for (int k = 0; k < ar2.length; ++i, ++k) {
		result[i] = ar2[k];
	    }
	    printArray(result);
	    ar = result;
	}
	ar = getSortedArray(ar);
	printArray(ar);
    }

    public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	int s = in.nextInt();
	int[] ar = new int[s];
	for (int i = 0; i < s; i++) {
	    ar[i] = in.nextInt();
	}
	insertionSortPart2(ar);
	in.close();
    }

    private static void printArray(int[] ar) {
	for (int n : ar) {
	    System.out.print(n + " ");
	}
	System.out.println("");
    }

    // -------------------------------------
    // public static void insertIntoSorted(int[] ar) {
    // int pos = ar.length - 1;
    // do {
    // if (ar[pos] < ar[pos - 1]) {
    // int tmp = ar[pos];
    // ar[pos] = ar[pos - 1];
    // // printArray(ar);
    // ar[pos - 1] = tmp;
    // pos = pos - 1;
    // }
    // if (pos == 0) {
    // break;
    // }
    // } while (ar[pos] < ar[pos - 1]);
    // // printArray(ar);
    // }
    public static int[] getSortedArray(int[] ar) {
	int pos = ar.length - 1;
	do {
	    if (ar[pos] < ar[pos - 1]) {
		int tmp = ar[pos];
		ar[pos] = ar[pos - 1];
		ar[pos - 1] = tmp;
		pos = pos - 1;
	    }
	    if (pos == 0) {
		break;
	    }
	} while (ar[pos] < ar[pos - 1]);
	return ar;
    }
}
