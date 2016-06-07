package org.hackerrank;

import java.util.Scanner;

public class NestedLogicTest {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int d_a = in.nextInt();
		int m_a = in.nextInt();
		int y_a = in.nextInt();
		in.nextLine();
		int d_e = in.nextInt();
		int m_e = in.nextInt();
		int y_e = in.nextInt();
		in.close();
		int d_diff = (d_a > d_e ? d_a - d_e : 0);
		int m_diff = (m_a > m_e ? m_a - m_e : 0);
		int y_diff = (y_a > y_e ? y_a - y_e : 0);
		int fineAmount = fineFormula(d_diff, m_diff, y_diff);
		System.out.println("" + fineAmount);
	}

	static int fineFormula(int d_diff, int m_diff, int y_diff) {
		int result = 0;
		if (y_diff > 0) {
			result = 10000;
		} else if (m_diff > 0) {
			result = 500 * m_diff;
		} else if (d_diff > 0) {
			result = 15 * d_diff;
		}
		return result;
	}

}
