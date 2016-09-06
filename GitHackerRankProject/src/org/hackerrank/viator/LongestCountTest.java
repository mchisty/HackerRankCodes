package org.hackerrank.viator;

/**
 * Rule: if n is an odd number n = 3*n+1; if n is an even number n = n/2
 * 
 * Apply this rule to a number unless it becomes 1
 * 
 * E.G. Apply this to n=13. The steps are: 40->20->10->5->16->8->4->2-1 <br/>
 * Number of steps/count taken is 9
 * 
 * Goal:
 * Given a number n=1000000, write a program applying this rule to find the number between 1 and n
 * whose count (number of steps to reach to 1) is the largest.
 * 
 * Let's take a number n=5;
 * <code>
 * For n=1, we don't have to do anything (0 step)
 * For n=2, we have 1 (1 steps)
 * For n=3, we have 10->5->16->8->4->2->1 (7 steps)
 * For n=4, we have 2->1 (2 steps)
 * For n=5, we have 16->8->4->2->1 (5 steps)
 * 
 * The mamimum number of steps is 7 for the number 3. So the output should be 3 
 * </code>
 * 
 */

public class LongestCountTest {

	public static void main(String[] args) {
		LongestCountTest lt = new LongestCountTest();
		int result = lt.getLongestValue(1000000);
		System.out.println(result);
	}

	private int getLongestValue(int n) {
		int max = 0;
		int longestVal = 0;
		for (int i = 1; i <= n; ++i) {
			int tmp = getCountVal(i);
			if (tmp > max) {
				max = tmp;
				longestVal = i;
			}
		}
		System.out.println("Number of steps: " + max);
		return longestVal;
	}

	private int getCountVal(int n) {
		int count = 0;
		while (n > 1) {
			n = getNValue(n);
			++count;
		}
		return count;
	}

	private int getNValue(int n) {
		if (n % 2 == 0) {
			n = getEvenCalc(n);

		} else {
			n = getOddCalc(n);
		}
		return n;
	}

	private int getOddCalc(int n) {
		return 3 * n + 1;
	}

	private int getEvenCalc(int n) {
		return n / 2;
	}

}
