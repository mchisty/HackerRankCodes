package org.hackerrank;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// Timeout issue
public class CompterGameCoPrime {
	// int x[] = { 2, 5, 6, 7 };
	// int y[] = { 4, 9, 10, 12 };

	public static void main(String[] args) throws Exception {

		// Scanner in = new Scanner(System.in);
		// int n = in.nextInt();
		// int x[] = new int[n];
		// int y[] = new int[n];
		// for (int i = 0; i < n; ++i) {
		// x[i] = in.nextInt();
		// }
		// for (int i = 0; i < n; ++i) {
		// y[i] = in.nextInt();
		// }
		// in.close();
		//
		// printIfNotCoPrime(x, y);
		// System.out.println(count);

		// ---------------- Reading from file
		File file = new File("C:\\Temp\\sample_input05.txt");
		FileInputStream fin = new FileInputStream(file);
		InputStreamReader iread = new InputStreamReader(fin);
		BufferedReader br = new BufferedReader(iread);

		String line1 = br.readLine();
		String line2 = br.readLine();
		String line3 = br.readLine();
		int n = Integer.parseInt(line1);
		StringTokenizer stoken = new StringTokenizer(line2, "\t ");
		int x[] = new int[n];
		int i = 0;
		while (stoken.hasMoreTokens()) {
			x[i] = Integer.parseInt(stoken.nextToken());
			i = i + 1;
		}
		i = 0;
		int y[] = new int[n];
		stoken = new StringTokenizer(line3, "\t ");
		while (stoken.hasMoreTokens()) {
			y[i] = Integer.parseInt(stoken.nextToken());
			i = i + 1;
		}

		br.close();
		long start = System.currentTimeMillis();
		printIfNotCoPrime(x, y);
		long end = System.currentTimeMillis();
		System.out.println((end - start) + " millesceonds");
		System.out.println(count);

	}

	static int count = 0;

	static void printIfNotCoPrime(int x[], int y[]) {
		int tmpX = 0;
		int tmpY = 0;
		boolean flag = false;

		// Step 1: Found one co-prime, store it as temp
		for (int i = 0; i < x.length; ++i) {
			for (int j = 0; j < y.length; ++j) {
				if (isNotCoPrime(x[i], y[j])) {
					tmpX = x[i];
					tmpY = y[j];
					flag = true;
					break;
				}
			}
			if (flag) {
				++count;
				break;
			}
		}

		// Step 2: Update array elements. We don't handle duplicates here
		int[] newX = new int[x.length - 1];
		int[] newY = new int[y.length - 1];
		for (int i = 0, j = 0; i < x.length && j < newX.length; ++i) {
			if (x[i] != tmpX) {
				newX[j] = x[i];
				j = j + 1;

			}
		}
		for (int i = 0, j = 0; i < y.length && j < newY.length; ++i) {
			if (y[i] != tmpY) {
				newY[j] = y[i];
				j = j + 1;
			}
		}

		if (newX.length > 1 || newY.length > 1) {
			printIfNotCoPrime(newX, newY);
		}

	}

	// --------------
	public static int GetGCDByModulus(int value1, int value2) {
		while (value1 != 0 && value2 != 0) {
			if (value1 > value2) {
				value1 %= value2;
			} else {
				value2 %= value1;
			}
		}

		return Math.max(value1, value2);
	}

	public static boolean isNotCoPrime(int value1, int value2) {
		int gcd = GetGCDByModulus(value1, value2);
		// System.out.println(gcd);
		return gcd != 1;
	}

}
