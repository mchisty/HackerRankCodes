package org.hackerrank.viator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

public class AbsolutePrime {

	public static void main(String[] args) {
		int n = 100;
		List<Integer> primeNumbers = new ArrayList<>();
		for (int i = n; i >= 2; --i) {
			if (isPrime(i)) {
				primeNumbers.add(i);
			}
		}
		int max = 0;
		SortedMap<Integer, Integer> map = new TreeMap<>();
		for (Integer i : primeNumbers) {
			int sum = getSumOfDigits(i);
			// max = Math.max(max, sum);
			// map.put(i, max);
			map.put(i, sum);
		}
		Iterator<Integer> it = map.keySet().iterator();
		while (it.hasNext()) {
			Integer key = it.next();
			System.out.println("Prime: " + key + ", sum: " + map.get(key));
		}
	}

	static int getSumOfDigits(int i) {
		int sum = 0;
		int tmp = i;
		while (tmp != 0) {
			sum += tmp % 10;
			tmp /= 10;
		}
		return sum;
	}

	public static boolean isPrime(int n) {
		if (n == 2) {
			return true;
		} else if (n == 1 || (n & 1) == 0) {
			return false;
		}
		for (int i = 3; i <= Math.sqrt(n); i += 2) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}

}
