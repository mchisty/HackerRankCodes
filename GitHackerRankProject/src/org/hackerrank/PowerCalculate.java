package org.hackerrank;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PowerCalculate {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		// int t = in.nextInt();
		// int[] n = new int[t];
		// int[] c = new int[t];
		// int[] m = new int[t];
		// for (int a0 = 0; a0 < t; a0++) {
		// n[a0] = in.nextInt();
		// c[a0] = in.nextInt();
		// m[a0] = in.nextInt();
		// }
		// -------------------------------------------
		String line = null;
		List<Integer> nList = new ArrayList<>();
		List<Integer> pList = new ArrayList<>();
		// boolean flag = true;
		// while (in.hasNextInt()) {
		// int n = in.nextInt();
		// int p = in.nextInt();
		// nList.add(n);
		// pList.add(p);
		// }
		// -------------------------------------------
		// while ((line = in.nextLine()).length() != 0) {
		// StringTokenizer stoken = new StringTokenizer(line, "\r\t ");
		// if (stoken.hasMoreTokens()) {
		// nList.add(Integer.parseInt(stoken.nextToken()));
		// pList.add(Integer.parseInt(stoken.nextToken()));
		// }
		// }
		Integer n = 0, p = 0;
		while (in.hasNextInt()) {
			n = in.nextInt();
			p = in.nextInt();
			nList.add(n);
			pList.add(p);
			line = in.next();
			if (line.length() == 0) {
				break;
			}
		}
		in.close();
		System.out.println("---------------------------------------");
		for (int i = 0; i < nList.size(); ++i) {
			System.out.println(nList.get(i) + ", " + pList.get(i));
		}
	}
}

class MyCalculator {
	int power(int n, int p) throws Exception {
		if (n < 0 || p < 0)
			throw new Exception("n and p should be non-negative");
		if (p == 0)
			return 1;
		return n * power(n, p - 1);
	}
}