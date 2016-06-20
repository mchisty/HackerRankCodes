package org.hackerrank;

import java.util.BitSet;

/**
 * You have an array with all the numbers from 7 to N, where N is at most
 * 32,000. The array may have duplicate entries and you do not know what N is.
 * With only 4 kilobytes of memory available, how would you print all duplicate
 * elements in the array? 
 * 
 */


public class BitTest {

	public static void main(String[] args) {
		System.out.println("-------------------------------------------------------------");
		System.out.println("Hexadecimal table : ");
		System.out.println("-------------------------------------------------------------");
		for(int i=1; i<=100; ++i) {
			System.out.print(i + "=" + Integer.toHexString(i).toUpperCase() + "\t");
			if(i%10==0) {
				System.out.println();
			}
		}
		System.out.println("-------------------------------------------------------------");
		
		int x = 1;
		int y= 2;
		System.out.println("hex values: "  + Integer.toHexString(x) + " and " + Integer.toHexString(y));
		System.out.println("x & y: " + (x&y));
		
		int num = 40;
		int divisor = 0x1F;
		System.out.println(num + " -> To binary: " + Integer.toBinaryString(num) + " -> To hex: " + Integer.toHexString(num).toUpperCase());
		System.out.println(divisor + " -> To binary: " + Integer.toBinaryString(divisor) + " -> To hex: " + Integer.toHexString(divisor).toUpperCase());


		int bitNumber = (num & divisor); // mod 32
		System.out.println("Bitwise AND between integer and hexadecimal: " + bitNumber);
		
		System.out.println("-------------------------------------------------------------");
		System.out.println("Left shift test. Doubles up each time");
		num =1;
		System.out.println(num + "<< : " + (num<<8));
		
	}

}

class MyBitSet {
	int[] bitArray;

	public MyBitSet(int size) {
		bitArray = new int[size >> 5]; // divide by 32
	}
	
	boolean get(int pos) {
		int wordNumber = (pos >>5); // divide by 32
		int bitNumber = (pos & 0x1F); // mod 32
		return (bitArray[wordNumber] & (1 << bitNumber)) !=0;
	}

}
