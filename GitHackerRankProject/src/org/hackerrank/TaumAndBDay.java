package org.hackerrank;

import java.util.Scanner;

public class TaumAndBDay {
	public TaumAndBDay() {
	}

	public static void main(String[] args) {
		TaumAndBDay tb = new TaumAndBDay();
		// -------------------------------------------
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		long B[] = new long[t];
		long W[] = new long[t];
		long X[] = new long[t];
		long Y[] = new long[t];
		long Z[] = new long[t];
		for (int i = 0; i < t; ++i) {
			B[i] = in.nextLong();
			W[i] = in.nextLong();
			X[i] = in.nextLong();
			Y[i] = in.nextLong();
			Z[i] = in.nextLong();
		}
		in.close();
		// ----------------------------------
		for (int i = 0; i < t; ++i) {
			long k = tb.getOptimalPrice(B[i], W[i], X[i], Y[i], Z[i]);
			System.out.println(k);
		}
	}

	long getOptimalPrice(long B, long W, long X, long Y, long Z) {
		final long BX = B * X;
		final long WY = W * Y;
		final long sum1 = BX + WY;
		long BY = 0L, WX = 0L;
		long sum2 = 0L;
		if (X < Y) {
			WX = W * (X + Z);
			sum2 = BX + WX;
			if (sum2 < sum1) {
				return sum2;
			}
		} else if (Y < X) {
			BY = B * (Y + Z);
			sum2 = BY + WY;
			if (sum2 < sum1) {
				return sum2;
			}
		}
		return sum1;
	}
}
