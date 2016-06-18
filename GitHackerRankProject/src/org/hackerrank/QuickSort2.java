package org.hackerrank;

import java.util.ArrayList;
import java.util.Arrays;

//Input:
//7
//5 8 1 3 7 9 2
//-----------------------
//Output:
//2 3
//1 2 3
//7 8 9
//1 2 3 5 7 8 9
/**
 * The Class QuickSort2.
 */
// ----------------------------------------------------
public class QuickSort2 {
    /**
     * The main method.
     *
     * @param args
     *            the arguments
     */
    public static void main(String[] args) {
	// Scanner in = new Scanner(System.in);
	// int n = in.nextInt();
	// int[] ar = new int[n];
	// for (int i = 0; i < n; i++) {
	// ar[i] = in.nextInt();
	// }
	// in.close();
	int[] ar = { 5, 8, 1, 3, 7, 9, 2 };// , 3, 7, 9, 2 };
	quickSort(ar);
    }

    /**
     * Quick sort.
     *
     * @param ar
     *            the ar
     */
    static void quickSort(int[] ar) {
	quickSort(ar, 0, ar.length - 1);
    }

    /**
     * Quick sort.
     *
     * @param ar
     *            the ar
     * @param minpos
     *            the minpos
     * @param maxpos
     *            the maxpos
     */
    static void quickSort(int ar[], int minpos, int maxpos) {
	System.out.println("minpos:" + minpos + ", maxpos:" + maxpos);
	if (minpos >= maxpos)
	    return;
	// System.out.println("---------------------------------------------------");
	// System.out.println("Original Array: " + Arrays.toString(ar));
	int pos = partition(ar, minpos, maxpos);
	// System.out.println("After partition Array: " + Arrays.toString(ar));
	// System.out.println("Got partition position: " + pos + ", value ar[pos]: " + ar[pos] + ", minpos:" + minpos
	// + ", maxpos:" + maxpos);
	// System.out.println("---------------------------------------------------");
	quickSort(ar, minpos, pos - 1);
	quickSort(ar, pos + 1, maxpos);
	printArray(ar, minpos, maxpos);
    }

    /**
     * Partition.
     *
     * @param ar
     *            the ar
     * @param minpos
     *            the minpos
     * @param maxpos
     *            the maxpos
     * @return the int
     */
    static int partition(int ar[], int minpos, int maxpos) {
	int pivot = ar[minpos];
	// System.out.println("inital pivot: " + pivot);
	ArrayList<Integer> leftlist = new ArrayList<Integer>();
	ArrayList<Integer> rightlist = new ArrayList<Integer>();
	for (int i = minpos + 1; i <= maxpos; i++) {
	    if (ar[i] > pivot)
		rightlist.add(ar[i]);
	    else
		leftlist.add(ar[i]);
	}
	copy(leftlist, ar, minpos);
	int ppos = leftlist.size() + minpos;
	ar[ppos] = pivot;
	// System.out.println("ar[ppos]: " + ar[ppos] + ", pivot value: " + pivot);
	copy(rightlist, ar, ppos + 1);
	return ppos; // minpos + leftlist.size();
    }

    /**
     * Copy.
     *
     * @param list
     *            the list
     * @param ar
     *            the ar
     * @param startIdx
     *            the start idx
     */
    static void copy(ArrayList<Integer> list, int ar[], int startIdx) {
	for (int num : list) {
	    ar[startIdx++] = num;
	}
	System.out.println(Arrays.toString(ar));
    }

    /**
     * Prints the array.
     *
     * @param ar
     *            the ar
     * @param start
     *            the start
     * @param end
     *            the end
     */
    static void printArray(int[] ar, int start, int end) {
	for (int i = start; i <= end; i++) {
	    System.out.print(ar[i] + " ");
	}
	System.out.println("");
    }
}
