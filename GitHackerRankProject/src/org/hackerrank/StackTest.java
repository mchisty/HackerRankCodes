package org.hackerrank;

public class StackTest {

	/**
	 * The solution is pretty straight forward. Define [, {, ( as opening type brackets and ), }, ] as closing type brackets. Whenever an opening type
	 * bracket appears, we just push it onto the stack. Whenever a closing type bracket appears, we check if the top of the stack contains the opening
	 * type of the same bracket or not
	 *
	 */

	public static void main(String[] args) {
		String s = "{[(])}"; // "{[()]}";
		System.out.println(isBalanced(s));

	}

	public static boolean isBalanced(String s) {
		Stack stack = new Stack(s);
		for (int i = 0; i < s.length(); i++) {

			// Push
			if (s.charAt(i) == '[') {
				stack.push('[');
			} else if (s.charAt(i) == '{') {
				stack.push('{');
			} else if (s.charAt(i) == '(') {
				stack.push('(');
			}

			// Pop
			else if (s.charAt(i) == ')') {
				if (stack.isEmpty()) {
					return false;
				}
				if (stack.pop() != '(') {
					return false;
				}
			}

			else if (s.charAt(i) == '}') {
				if (stack.isEmpty()) {
					return false;
				}
				if (stack.pop() != '{') {
					return false;
				}
			}

			else if (s.charAt(i) == ']') {
				if (stack.isEmpty()) {
					return false;
				}
				if (stack.pop() != '[') {
					return false;
				}
			}

		}
		return stack.isEmpty();
	}

}

// -------------------------------------------------------------

class Stack {
	private char stackArray[];
	private int arraySize;
	private int pos = -1;

	Stack(String s) {
		arraySize = s.length();
		stackArray = new char[arraySize];
		pos = -1;
	}

	void push(char item) {
		pos += 1;
		stackArray[pos] = item;
	}

	public int getPos() {
		return pos;
	}

	int pop() {
		return stackArray[pos--];
	}

	public char[] getStackArray() {
		return stackArray;
	}

	boolean isEmpty() {
		return pos == -1;
	}

}
