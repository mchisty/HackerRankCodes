package org.hackerrank.infomedia;

import java.util.Scanner;

public class JumpingJack {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();
		in.close();
		System.out.println(maxStep(n, k));
	}
	
	static int maxStep(int n, int k) {
		int x = 1;
		int y = 0;
		int tmp = 0;
		y = 0;
		for (x = 1; x <= n; ++x) {
			tmp = y + x; 
			if (tmp != k) {
				y = tmp;
			}
		}
		
		return y;
    }

}
