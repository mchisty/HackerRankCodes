package org.hackerrank;

import java.util.ArrayList;
import java.util.Arrays;

public class SubsetTest {

	public static void main(String[] args) {
		int a[] = { 1, 2, 4, 7 };

		ArrayList<ArrayList<Integer>> tmp = subsets(a);
		for (ArrayList<Integer> t : tmp) {
			System.out.println(t.toString());
		}

	}

	static ArrayList<ArrayList<Integer>> subsets(int[] S) {
		if (S == null) {
			return null;
		}
		Arrays.sort(S);
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

		for (int i = 0; i < S.length; i++) {
			ArrayList<ArrayList<Integer>> temp = new ArrayList<ArrayList<Integer>>();
			// get sets that are already in result
			for (ArrayList<Integer> a : result) {
				temp.add(new ArrayList<Integer>(a));
			}
			System.out.println("Step 1: temp values => " + temp);
			// add S[i] to existing sets
			for (int t1 = 0; t1 < temp.size(); ++t1) {
				// List<Integer> a = temp.get(t1);
				// a.add(S[i]);
				// System.out.println("Step 2: a values => " + a);
				temp.get(t1).add(S[i]);
				System.out.println("Step 2: a values => " + temp.get(t1));
			}

			// add S[i] only as a set
			ArrayList<Integer> single = new ArrayList<Integer>();
			single.add(S[i]);
			temp.add(single);
			System.out.println("Step 3: temp values again => " + temp);
			result.addAll(temp);
			System.out.println("Step 4: result values => " + result);
			System.out.println("-----------------------------------------------------------------------------");
		}

		// add empty set
		result.add(new ArrayList<Integer>());

		return result;
	}

}
