package org.hackerrank;

public class BitwiseOperationTest {
    public static void main(String[] args) {
	final int x = 3;
	System.out.println("-----------------------------------------------------------------------------------");
	System.out.println("Left shift operation. For every bit shift, the number double up");
	System.out.println("Number is represented in 32 bit e.g. 3 = 00000000 00000000 00000000 00000011");
	System.out.println("-----------------------------------------------------------------------------------");
	for (int i = 1; i <= 5; ++i) {
	    System.out.println(x + " left shift (<<) " + i + " time(s): " + (x << i));
	}
	final int y = 9;
	System.out.println("-----------------------------------------------------------------------------------");
	System.out.println("Right shift operation. Every bit shift, the halves");
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
	    System.out.println("binary => " + Integer.toBinaryString(i) + " ^ " + Integer.toBinaryString(j) + " : "
		    + Integer.toBinaryString(i ^ j));
	}
	System.out.println("Maximum value of an integer: " + Integer.MAX_VALUE);
    }
}
