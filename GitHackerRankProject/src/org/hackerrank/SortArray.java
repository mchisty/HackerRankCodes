package org.hackerrank;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class SortArray {

	static Stack<Character> sc = new Stack<Character>();
	static Queue<Character> q = new LinkedList<Character>();

	static void pushCharacter(char c) {
		sc.push(c);
	}

	static void enqueueCharacter(char c) {
		q.add(c);
	}

	static Character popCharacter() {
		return sc.pop();
	}

	static Character dequeueCharacter() {
		return q.poll();
	}

	public static void main(String[] args) {
		// int a[] = { 7, 8, 1, 15, 3, 2, 6, 9, 11 };
		// System.out.println(maximumDifference(a));
		String input = "racecar";
		char[] s = input.toCharArray();

		for (char c : s) {
			pushCharacter(c);
			enqueueCharacter(c);
		}

		// Pop/Dequeue the chars at the head of both data structures and compare
		// them:
		boolean isPalindrome = true;
		for (int i = 0; i < s.length / 2; i++) {
			if (popCharacter() != dequeueCharacter()) {
				isPalindrome = false;
				break;
			}
		}

		// Finally, print whether string s is palindrome or not.
		System.out.println("The word, " + input + ", is " + ((!isPalindrome) ? "not a palindrome." : "a palindrome."));

	}

	static int maximumDifference(int elements[]) {
		int max = elements[0];
		int min = elements[0];
		for (int i = 0; i < elements.length; ++i) {
			if (max < elements[i]) {
				max = elements[i];
			} else if (min > elements[i]) {
				min = elements[i];

			}

		}
		return Math.abs(max - min);
	}

}
