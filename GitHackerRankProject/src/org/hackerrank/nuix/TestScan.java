package org.hackerrank.nuix;

import java.text.MessageFormat;
import java.util.Scanner;
import java.util.StringTokenizer;

public class TestScan {

	public static void main(String[] args) throws Exception {
		TestScan tc = new TestScan();
		// tc.showWhileLineNotEmpty();
		// tc.showWhileNumberNotEmpty();
		tc.showNumbersNP();
	}

	// void showWhileLineNotEmpty() {
	// Scanner in = new Scanner(System.in);
	// String line = null;
	// while (!(line = in.nextLine()).isEmpty()) {
	// System.out.println("Show string=>" + line);
	// }
	// in.close();
	// }
	//
	// void showWhileNumberNotEmpty() throws Exception {
	// try {
	// Scanner in = new Scanner(System.in);
	// String line = null;
	// while (!(line = in.nextLine()).isEmpty()) {
	// int p = Integer.parseInt(line);
	// System.out.println("Show number =>" + p);
	// }
	// in.close();
	// } catch (NumberFormatException e) {
	// throw new Exception("Must be a valid integer number", e);
	// }
	// }

	void showNumbersNP() throws NumberFormatException {
		try {
			Scanner in = new Scanner(System.in);
			String line = null;
			int p = 0;
			int n = 0;
			while (!(line = in.nextLine()).isEmpty()) {
				StringTokenizer stoken = new StringTokenizer(line, " \t");
				if (stoken.hasMoreElements()) {
					n = Integer.parseInt(stoken.nextToken());
				}
				if (stoken.hasMoreElements())
					p = Integer.parseInt(stoken.nextToken());
				System.out.println(power(n, p));
			}
			in.close();
		} catch (NumberFormatException e) {
			throw new NumberFormatException("Must be a valid integer number");
		} catch (Exception e) {
			System.err.println(new MessageFormat(e.getMessage()));
		}
	}

	int power(int n, int p) throws Exception {
		if (n < 0 || p < 0) {
			throw new Exception("n and p should be non-negative");
		}

		return (p == 0) ? 1 : n * power(n, p - 1);
	}
}
