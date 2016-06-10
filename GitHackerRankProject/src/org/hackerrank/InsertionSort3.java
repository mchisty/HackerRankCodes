package org.hackerrank;

import java.util.Scanner;
//---------------
//Input:
//6
//1 4 3 5 6 2
// -------------------------------------------
//Output:
//1 4 3 5 6 2 
//1 3 4 5 6 2 
//1 3 4 5 6 2 
//1 3 4 5 6 2 
//1 2 3 4 5 6
// -------------------------------------------
//Input: 
//9
//9 8 6 7 3 5 4 1 2
// -------------------------------------------
//Output:
//8 9 6 7 3 5 4 1 2
//6 8 9 7 3 5 4 1 2
//6 7 8 9 3 5 4 1 2
//3 6 7 8 9 5 4 1 2
//3 5 6 7 8 9 4 1 2
//3 4 5 6 7 8 9 1 2
//1 3 4 5 6 7 8 9 2
//1 2 3 4 5 6 7 8 9
//-------------------

//5
//2 1 3 1 2
// -------------------------------------------
public class InsertionSort3 {
    public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	int n = in.nextInt();
	int[] ar = new int[n];
	for (int i = 0; i < n; i++) {
	    ar[i] = in.nextInt();
	}
	insertionSort(ar);
	in.close();
    }

    // -------------------------------------------
    public static void insertionSort(int[] A) {
	int count = 0;
	for (int i = 1; i < A.length; i++) {
	    int value = A[i];
	    int j = i - 1;
	    while (j >= 0 && A[j] > value) {
		A[j + 1] = A[j];
		j = j - 1;
		++count;
	    }
	    A[j + 1] = value;
	}
	System.out.println("Total moves: " + count);
    }

    // -------------------------------------------
    static void printArray(int[] ar) {
	for (int n : ar) {
	    System.out.print(n + " ");
	}
    }
}
