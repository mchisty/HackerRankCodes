package org.hackerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyTest {

	// Scanner in = new Scanner(System.in);
	// int n1 = in.nextInt();
	// String s1[] = new String[n1];
	// for (int i = 0; i < n1; ++i) {
	// s1[i] = in.next();
	// }
	//
	// int n2 = in.nextInt();
	// String query[] = new String[n2];
	// for (int i = 0; i < n2; ++i) {
	// query[i] = in.next();
	// }
	// in.close();
	// int arr[] = { 1, 2, 4, 7 };
	// int k = 3;
	//

	public static void main(String[] args) {
		// -------------------------------------
		// ans = 0;
		// System.out.println("xy val (1,2): " + find(1, 2));
		// ans = 0;
		// System.out.println("xy val (2,3): " + find(2, 3));
		// -------------------------------------

		List<Person> plist = new ArrayList<Person>();
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		for (int a0 = 0; a0 < N; a0++) {
			String firstName = in.next();
			String emailID = in.next();
			if (isValidFirstName(firstName) && isValidEmail(emailID)) {
				Person p = new Person(firstName, emailID);
				plist.add(p);
			}
		}
		in.close();

		Collections.sort(plist);
		for (Person p : plist) {
			System.out.println(p.name + "");
		}
	}

	// --------------------------------------------------------------------------
	// Let's test with the Constraints
	// --------------------------------------------------------------------------
	static boolean isValidFirstName(String s) {
		if (s.length() > 20) {
			return false;
		}
		String pattern = "[a-z]+";
		return isMatch(s, pattern);
	}

	static boolean isValidEmail(String s) {
		if (s.length() > 50) {
			return false;
		}
		String pattern = "[a-z]+[.a-z]*@gmail.com";
		return isMatch(s, pattern);
	}

	static boolean isMatch(String s, String pattern) {
		Pattern p = Pattern.compile(pattern);
		Matcher m = p.matcher(s);
		return m.matches();
	}

	// --------------------------------------------------------------------------

	static int A[] = { 3, 2, 7 };
	static double ans = 0;

	static double find(int x, int y) {
		if (x > y) {
			return 1;
		}
		if (x < A.length) {
			ans = Math.pow(A[x], find(x + 1, y));
		}
		return ans;
	}

	static Integer findTheMax(List<Integer> countList) {
		int count = 0;
		for (Integer i : countList) {
			if (i > count) {
				count = i;
			}
		}
		return count;
	}

	static ArrayList<ArrayList<Integer>> subsets(int[] S) {
		if (S == null) {
			return null;
		}
		Arrays.sort(S);
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

		for (int i = 0; i < S.length; ++i) {
			for (int j = i + 1; j < S.length; ++j) {
				ArrayList<Integer> temp = new ArrayList<Integer>();
				temp.add(S[i]);
				temp.add(S[j]);
				result.add(temp);
			}
		}
		// System.out.println(result);
		return result;
	}

	static boolean isSumDivisible(List<Integer> a, int k) {
		int sum = 0;
		for (Integer i : a) {
			sum += i;
		}
		return sum % k == 0;
	}

}

class Person implements Comparable<Person> {
	String name;
	String email;

	Person(String n, String e) {
		name = n;
		email = e;
	}

	public int compareTo(Person p) {
		if (null == p) {
			return 1;
		}
		return name.compareTo(p.name);
	}

}
