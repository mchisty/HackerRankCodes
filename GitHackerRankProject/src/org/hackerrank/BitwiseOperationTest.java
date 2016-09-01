package org.hackerrank;

public class BitwiseOperationTest {
	public static void main(String[] args) {
		final int x = 3;
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println("Signed left shift operation. For every bit shift, the number doubles up");
		System.out.println("Number is represented in 32 bit e.g. 3 = 00000000 00000000 00000000 00000011");
		System.out.println("-----------------------------------------------------------------------------------");
		for (int i = 1; i <= 5; ++i) {
			System.out.println(x + " left shift (<<) " + i + " time(s): " + (x << i));
		}
		final int y = 9;
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println("Signed right shift operation. Every bit shift, the number halves");
		System.out.println("Number is represented in 32 bit e.g. 9 = 00000000 00000000 00000000 00001001");
		System.out.println("-----------------------------------------------------------------------------------");
		for (int i = 1; i <= 4; ++i) {
			System.out.println(y + " right shift (>>) " + i + " time(s): " + (y >> i));
		}
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println("Bitwise and (&) examples: ");
		System.out.println("-----------------------------------------------------------------------------------");
		for (int i = 1; i <= 4; ++i) {
			int j = 3;
			System.out.println("" + i + " & " + j + " : " + (i & j));
			System.out.println("binary => " + Integer.toBinaryString(i) + " & " + Integer.toBinaryString(j) + " : "
					+ Integer.toBinaryString(i & j));
		}
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println("Bitwise x-or (^) examples: ");
		System.out.println("-----------------------------------------------------------------------------------");
		for (int i = 1; i <= 4; ++i) {
			int j = 3;
			System.out.println("" + i + " ^ " + j + " : " + (i ^ j));
			System.out.println("[Explanation] binary => " + Integer.toBinaryString(i) + " ^ "
					+ Integer.toBinaryString(j) + " : " + Integer.toBinaryString(i ^ j));
		}
		int a = 0xA; // Hexadecimal A = Binary 1010
		int b = 0xB; // Hexadecimal B = Binary 1011
		System.out.println("" + a + " ^ " + b + " : " + (a ^ b));
		System.out.println("[Explanation] binary => " + Integer.toBinaryString(a) + " ^ " + Integer.toBinaryString(b)
				+ " : " + Integer.toBinaryString(a ^ b));
		System.out.println("hex => " + Integer.toHexString(a) + " ^ " + Integer.toHexString(b) + " : "
				+ Integer.toHexString(a ^ b));

		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println("The unsigned right shift operator (>>>) shifts a zero into the leftmost position,");
		System.out.println("If number is negative, then it adds 1 into left most position, otherwise it adds zero");
		System.out.println("-----------------------------------------------------------------------------------");
		for (int k = -2; k <= 2; ++k) {
			final int i = k * 5;
			final int j = 1;
			System.out.println("" + i + " >>> " + j + " =  " + (i >>> j));
			System.out.println("[Explanation] binary ===> " + Integer.toBinaryString(i) + " >>> "
					+ Integer.toBinaryString(j) + " = " + Integer.toBinaryString(i >>> j));
		}

	}
}
