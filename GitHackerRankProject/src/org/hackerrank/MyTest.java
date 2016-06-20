package org.hackerrank;

import java.util.Scanner;

public class MyTest {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		int[] min = new int[T];
		int[] max = new int[T];
		for (int i = 0; i < T; ++i) {
			min[i] = in.nextInt();
			max[i] = in.nextInt();
		}
		in.close();

		for (int i = 0; i < T; ++i) {
			System.out.println(getResult(min[i], max[i]));
		}
		
//		int n = 16;
//		System.out.println(isqrt(n));
		
		
	}

	static boolean isPerfectSqr(int n) {
		int tmp = isqrt(n) ; //(int) Math.sqrt(n);
		return tmp * tmp == n;
	}

	static int getResult(int min, int max) {
		int count = 0;
		for (int i = min; i <= max; ++i) {
			if (isPerfectSqr(i)) {
				++count;
			}
		}
		return count;
	}
	
	static int isqrt(int num) {
	    int res = 0;
	    int bit = 1 << 14; // The second-to-top bit is set: 1L<<30 for long
	    // "bit" starts at the highest power of four <= the argument.
	    while (bit > num)
	        bit >>= 2;
	    while (bit != 0) {
	        if (num >= res + bit) {
	            num -= res + bit;
	            res = (res >> 1) + bit;
	        }
	        else
	            res >>= 1;
	        bit >>= 2;
	    }
	    return res;
	}

}
