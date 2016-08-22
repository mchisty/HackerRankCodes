package org.hackerrank;

public class UnsignedFlipBitSolution {

	public static void main(String[] args) {
		// -----------------------

		// --------
		// Swap
		// ---------
		// int n = 3;
		// int a[] = { 5, 3, 4 };

		// int numberOfSwaps = 0;
		// for (int i = 0; i < n; i++) {
		// for (int j = 0; j < n - 1; j++) {
		// if (a[j] > a[j + 1]) {
		// numberOfSwaps++;
		// int tmp = a[j];
		// a[j] = a[j + 1];
		// a[j + 1] = tmp;
		// }
		// }
		//
		// if (numberOfSwaps == 0) {
		// break;
		// }
		// }
		//
		// System.out.println("Array is sorted in " + numberOfSwaps + "
		// swaps.");
		// System.out.println("First Element: " + a[0]);
		// System.out.println("Last Element: " + a[a.length - 1]);

		// ------------------------------

		// Scanner in = new Scanner(System.in);
		// int n = in.nextInt();
		// String array[] = new String[n];
		// for (int i = 0; i < n; ++i) {
		// array[i] = in.next();
		// }
		// in.close();
		//
		// for (String s : array) {
		// String unsignedNumber = get32BitUnsigned(s);
		// System.out.println("unsignedNumber:" + unsignedNumber);
		// String fliped = getFlippedBit(unsignedNumber);
		// System.out.println("flipped: " + fliped);
		// StringBuilder rev = new StringBuilder(fliped);
		// rev.reverse();
		// System.out.println("" + convertToDecimal(rev.toString()));
		//
		// }

		String s = "4294967295";
		String unsignedNumber = get32BitUnsigned(s);
		System.out.println("unsignedNumber:" + unsignedNumber);
		String fliped = getFlippedBit(unsignedNumber);
		System.out.println("flipped: " + fliped);
		StringBuilder rev = new StringBuilder(fliped);
		rev.reverse();
		System.out.println("" + convertToDecimal(rev.toString()));

	}

	private static String get32BitUnsigned(String number) {
		long n = Long.valueOf(number);
		StringBuilder sb = new StringBuilder();
		do {
			long tmp = n % 2;
			sb.append(tmp);
			n = n / 2;
		} while (n > 1);
		sb.append(n);
		while (sb.length() < 32) {
			sb.append("0");
		}
		return sb.reverse().toString();
	}

	private static String getFlippedBit(String s) {
		final char array[] = s.toCharArray();
		StringBuilder sb = new StringBuilder();
		char tmp = '0';
		for (char c : array) {
			if (c == '1') {
				tmp = '0';
			} else {
				tmp = '1';
			}
			sb.append(tmp);
		}
		return sb.toString();
	}

	private static long convertToDecimal(String s) {
		char array[] = s.toCharArray();
		long sum = 0;
		for (int i = 0; i < array.length; ++i) {
			double d = Math.pow(2, i);
			int k = Character.digit(array[i], 10);
			d = d * k;
			sum = sum + (long) d;
		}
		return sum;
	}

}
