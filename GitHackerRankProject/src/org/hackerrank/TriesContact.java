package org.hackerrank;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.function.Predicate;

// ------------------------
// Sample input
// ------------------------
// 4
// add hack
// add hackerrank
// find hac
// find hak

// ------------------------
// Sample output
// ------------------------
// 2
// 0

public class TriesContact {

	private final static String ADD = "add";
	private final static String FIND = "find";
	private final static Set<String> addContactNameList = new HashSet<>();

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		TriesContact tc = new TriesContact();
		for (int a0 = 0; a0 < n; a0++) {
			String op = in.next();
			String contact = in.next();
			if (op.equals(ADD)) {
				addContactNameList.add(contact);
			} else if (op.equals(FIND)) {
				// findContactNameList.put(contact, 0L);
				tc.printResult(contact);
			}
		}
		in.close();
		// tc.getResult().stream().forEach(p -> System.out.println(p));
	}

	private void printResult(String contact) {
		// Predicate<String> predicateNameStartsWith = p -> p.startsWith(contact);
		Predicate<String> predicateNameStartsWith = p -> p.substring(0, contact.length()).equals(contact);
		Long count = addContactNameList.parallelStream().filter(predicateNameStartsWith).count();
		System.out.println(count);
	}

}
