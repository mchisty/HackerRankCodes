package org.hackerrank;

import java.util.Scanner;

public class FindPoint {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		for (int i = 0; i < n; ++i) {
			int p[] = new int[2];
			int q[] = new int[2];
			p[0] = in.nextInt();
			p[1] = in.nextInt();
			q[0] = in.nextInt();
			q[1] = in.nextInt();

			int x1 = q[0] + (q[0] - p[0]);
			int y1 = q[1] + (q[1] - p[1]);
			System.out.println(x1 + " " + y1);
		}
		in.close();

	}

}
