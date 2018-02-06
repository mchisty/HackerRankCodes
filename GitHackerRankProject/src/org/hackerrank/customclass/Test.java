
package org.hackerrank.customclass;

public class Test {

	private final static String passwordTest = "mypassword#Char123";

	public static void main(String[] args) throws InterruptedException {
		// Card card = new Card();
		// System.out.println(card.toString());
		// System.out.println("unknown WAS EXPECTED");
		// --------------------------
		// divide(4, 0);

		if (passwordTest.length() > 8) {
			for (int i = 0; i < 100; ++i) {
				Thread.sleep(500);
				System.out.println("Good password");
			}
		} else {
			System.out.println("Weak password");
		}
	}

	static int divide(int a, int b) {
		int c = -1;
		try {
			c = a / b;
		} catch (Exception e) {
			System.err.println("Exception ");
		} finally {
			System.err.println("Finally ");
		}
		return c;
	}
}
