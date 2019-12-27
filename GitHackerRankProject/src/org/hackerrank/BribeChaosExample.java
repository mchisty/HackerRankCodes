package org.hackerrank;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.IntStream;

import misc.lambda.Person;

/**
 * There are a number of people queued up, and each person wears a sticker
 * indicating their initial position in the queue. Initial positions increment
 * by 1 from 1 at the front of the line to n at the back.
 *
 * My Goal: <br/>
 * My goal was to convert it into JDK8+ stream; not to focus on the solution. I
 * got the solution from discussion board; took it and converted into JDK8
 * stream. Howver, I found that "For-each loops do not keep track of index and For-each cannot process two decision making statements at once "
 * 
 * <br/>
 * 
 * URL: https://www.geeksforgeeks.org/for-each-loop-in-java/
 * 
 */
public class BribeChaosExample {

	/**
	 * Minimum bribes.
	 *
	 * @param q the q
	 */
	static void minimumBribes(int[] q) {
		int count = 0;
		for (int i = 0; i < q.length; ++i) {
			int pos = i + 1;
			int diff = q[i] - pos;
//			System.out.println("pos: " + pos + ", diff: " + diff);
			if (diff > 2) {
				System.out.println("Too chaotic");
				return;
			} else {
				for (int j = Math.max(0, q[i] - 2); j < i; ++j)
					if (q[j] > q[i])
						count++;
			}
		}

		System.out.println("" + count);
		
		//--------------------------------------------
//		System.out.println("With lambda ------------------------------" );
//		IntStream.range(1, q.length+1).forEach( i -> System.out.println("pos: " + (i) + ", diff: " + (q[i-1]-i )));
		
	}

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {

//		int[] arr = { 2, 1, 5, 3, 4 };
//		int[] arr= {2 ,5 ,1 ,3 ,4};
//		int[] arr = { 1, 2, 5, 3, 7, 8, 6, 4 };
		int[] arr = { 1, 4, 3, 2, 5, 6 };
		minimumBribes(arr);

	}
}
