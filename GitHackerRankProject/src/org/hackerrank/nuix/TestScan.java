package org.hackerrank.nuix;

import java.util.Scanner;

public class TestScan {

	public static void main(String[] args) throws Exception {
		TestScan tc = new TestScan();
		// tc.showWhileLineNotEmpty();
		tc.showWhileNumberNotEmpty();
	}

	void showWhileLineNotEmpty() {
		Scanner in = new Scanner(System.in);
		String line = null;
		while (!(line = in.nextLine()).isEmpty()) {
			System.out.println("Show string=>" + line);
		}
		in.close();
	}

	void showWhileNumberNotEmpty() throws Exception {
		try {
			Scanner in = new Scanner(System.in);
			String line = null;
			while (!(line = in.nextLine()).isEmpty()) {
				int p = Integer.parseInt(line);
				System.out.println("Show number =>" + p);
			}
			in.close();
		} catch (NumberFormatException e) {
			throw new Exception("Must be a valid integer number", e);
		}
	}
}
