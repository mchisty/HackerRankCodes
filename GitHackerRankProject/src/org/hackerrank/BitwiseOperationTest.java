package org.hackerrank;

public class BitwiseOperationTest {
    public static void main(String[] args) {
	final int x = 3;
	System.out.println("Left shift operation. For every bit shift, the number double up");
	System.out.println("Number is represented in 32 bit e.g. 3 = 00000000 00000000 00000000 00000011");
	for (int i = 1; i <= 5; ++i) {
	    System.out.println(x + " << " + i + ": " + (x << i));
	}
	final int y = 9;
	System.out.println("Right shift operation. Every bit shift, the halves");
	System.out.println("Number is represented in 32 bit e.g. 3 = 00000000 00000000 00000000 00001001");
	for (int i = 1; i <= 4; ++i) {
	    System.out.println(y + " >> " + i + ": " + (y >> i));
	}
	System.out.println("Maximum value of an integer: " + Integer.MAX_VALUE);
    }
}
