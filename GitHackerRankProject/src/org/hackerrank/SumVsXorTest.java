package org.hackerrank;

public class SumVsXorTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long n = 1000000000000000L;
		// long count = 0;
		// for (long x = 0; x <= n; ++x) {
		// count += getCount(n, x);
		//
		// }
		long count = getCount(n);
		System.out.println(count);
	}

	// My solution: Timeout
	private static long getCountMysol1(long n, long x) {
		long xor = n ^ x;
		long plus = n + x;
		long count = (xor == plus) ? 1 : 0;
		return count;
	}

	// Hackerrank solution: works fine. But don't undersatnd the logic
	private static long getCount(long n) {
		long count = 0;
		while (n > 0) {
			if (0 == (n & 0x1)) {
				count++;
			}
			n >>= 1;
		}
		System.out.println("count: " + count);
		return (1L << count);
	}

}
