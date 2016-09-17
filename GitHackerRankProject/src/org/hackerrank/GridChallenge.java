package org.hackerrank;

/**
 * Given a squared sized grid G of size N in which each cell has a lowercase letter. Denote the character in the i-th row and 
 * in the j-th column as G[i][j].
 * 
 * You can perform one operation as many times as you like: Swap two column adjacent characters in the same row G[i][j] and G[i][j+1] for all 
 * valid i,j.
 */
import java.util.Arrays;
import java.util.Scanner;

public class GridChallenge {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		for (int i = 0; i < T; ++i) {
			int N = in.nextInt();
			String line[] = new String[N];
			for (int j = 0; j < N; ++j) {
				line[j] = in.next();
			}
			System.out.println(getResult(line));
		}
		in.close();
	}

	private static String getResult(String[] lines) {
		// Sort the letters in each line and populate in char array
		int n = lines.length;
		char[][] carr = new char[n][n];
		for (int i = 0; i < n; ++i) {
			carr[i] = lines[i].toCharArray();
			Arrays.sort(carr[i]);
		}
		// ---------------------------------------------------------------
		for (int j = 0; j < n; ++j) {
			char c = Character.MIN_VALUE;
			for (int i = 0; i < n; ++i) {
				if (c > carr[i][j]) {
					return "NO";
				} else {
					c = carr[i][j];
				}
			}
		}
		return "YES";
	}
}
