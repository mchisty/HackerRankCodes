package org.hackerrank;

import java.util.ArrayList;
import java.util.List;
// Sample inout:
// 1000
//10000

// Output:
// 2223 2728 4950 5050 7272 7777 9999
public class MyTestWithMatrix {
	public static void main(String[] args) {
		// Scanner in = new Scanner(System.in);
		int low = 1; // in.nextInt();
		int high = 99999; // in.nextInt();
		// in.close();
		List<Integer> list = getMinDistance(low, high);
		if (list.isEmpty()) {
			System.out.println("INVALID RANGE");
		} else {
			for (Integer x : list) {
				System.out.print(x + " ");
			}
		}
	}

	static List<Integer> getMinDistance(int low, int high) {
		List<Integer> list = new ArrayList<>();
		// if (low >= 1 && low <= 9 && high > low) {
		// list.add(1);
		// list.add(9);
		// low = 10;
		// }
		for (int i = low; i <= high; ++i) {
			if (isKaprekarNumber(i)) {
				list.add(i);
			}
		}
		return list;
	}

	static boolean isKaprekarNumber(final int num) {
		if (num >= 1 && num <= 9) {
			return true;
		}
		String s = Integer.toString(num * num);
		final String tmp = Integer.toString(num);
		for (int i = 1; i < s.length(); ++i) {
			String left = s.substring(0, i);
			String right = s.substring(i);
			Integer start = Integer.valueOf(left);
			Integer end = Integer.valueOf(right);
			if (right.length() <= tmp.length() && start > 0 && end > 0 && start + end == num) {
				System.out.println("right: " + right);
				return true;
			}
		}
		return false;
	}
}
