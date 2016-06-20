package org.hackerrank;

public class SherlockAndSquares {

	public static void main(String[] args) {
		System.out.println(squaresCount(4, 20));

	}

	// Soltuion:
	// http://comproguide.blogspot.com.au/2014/04/counting-number-of-perfect-squares-in.html
	// The obvious solution is to check if each number in the given range is a
	// perfect square or not. This runs O(n) time. For a small range of numbers,
	// this works fine. But for a big range, this takes a lot of time.
	//
	// We can improve this as follows.

	// First we find the square roots of lower bound and and upper bounds. The
	// difference between them gives the required number.
	//
	// For example consider the range [2,11]
	//
	// sqrt(2) = 1.414
	// sqrt(11) = 3.316
	//
	// If you round them off, and take the difference (3-1), it is 2 which is
	// the required answer.
	static int squaresCount(int a, int b) {
		int lower = (int) Math.sqrt(a);
		int sqLower = lower * lower;
		if (sqLower == a) {
			lower = lower - 1;
		}
		int upper = (int) (Math.sqrt(b));

		return upper - lower;
	}

}
