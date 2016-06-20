package org.hackerrank;
// Sample input

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
	// Scanner in = new Scanner(System.in);
	// int t = in.nextInt();
	// for (int x = 0; x < t; x++) {
	// int size = in.nextInt();
	// int[] a = new int[size];
	// for (int i = 0; i < size; ++i) {
	// a[i] = in.nextInt();
	// }
	// System.out.println(getResult(a));
	// }
	// in.close();
	int[] b = { 1, 2, 3 };
	System.out.println(getResult(b));
    }

    static String getResult(int[] a) {
	if (a.length == 1) {
	    return "YES";
	}
	boolean flag = false;
	flag = isEqual(a);
	return flag ? "YES" : "NO";
    }

    static boolean isEqual(int[] a) {
	int sumRight = 0;
	boolean flag = false;
	for (int i = 1; i < a.length; ++i) {
	    sumRight = sumRight + a[i];
	}
	int sumLeft = 0;
	for (int i = 0; i < a.length; ++i) {
	    if (i + 1 < a.length) {
		sumRight = sumRight - a[i + 1];
	    }
	    if (i >= 0) {
		sumLeft = sumLeft + a[i];
	    }
	    if (sumLeft == sumRight) {
		flag = true;
		break;
	    }
	}
	return flag;
    }
}
