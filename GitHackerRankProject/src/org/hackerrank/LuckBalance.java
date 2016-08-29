package org.hackerrank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class LuckBalance {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int k = scanner.nextInt();
		int total = 0;
		List<Integer> importantContests = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			int luckValue = scanner.nextInt();
			int importance = scanner.nextInt();
			total += luckValue;
			if (importance == 1) {
				importantContests.add(luckValue);
			}
		}
		scanner.close();
		Collections.sort(importantContests);
		// importantContests.stream().forEach(i -> System.out.print(i + " "));

		int luckToFlip = 0;
		int mustWinImprCount = importantContests.size() - k;
		for (int i = 0; i < mustWinImprCount; i++) {
			luckToFlip += importantContests.get(i);
		}
		System.out.println("luckToFlip: " + luckToFlip);
		int result = total - luckToFlip - luckToFlip;
		System.out.println("\n\n" + result);

		// -----------------------------------------
	}

}
