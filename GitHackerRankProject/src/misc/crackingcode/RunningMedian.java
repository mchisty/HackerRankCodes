package misc.crackingcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class RunningMedian {
	public static void main(String[] args) {
		// int a = 1, b = 2;
		// float r = (a + b) / 2f;
		// System.out.println(r);
		// --------------------------------------
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int a[] = new int[n];
		for (int a_i = 0; a_i < n; a_i++) {
			a[a_i] = in.nextInt();
		}
		in.close();
		// --------------------------------
		RunningMedian r = new RunningMedian();
		List<Float> l = r.getAllMedians(a);
		l.stream().forEach(i -> System.out.println(i));
	}

	List<Float> getAllMedians(int a[]) {
		List<Float> medianList = new ArrayList<>();
		List<Integer> list = Arrays.stream(a).boxed().collect(Collectors.toList());
		for (int i = 1; i <= list.size(); ++i) {
			float m = getMedianVal(list.subList(0, i));
			medianList.add(m);
		}
		return medianList;
	}

	private Float getMedianVal(List<Integer> list) {
		if (list.size() == 1) {
			return list.get(0).floatValue();
		}
		Collections.sort(list);
		int size = list.size();
		if (size % 2 == 0) {
			int pos = size / 2;
			float median = (list.get(pos - 1) + list.get(pos)) / 2f;
			return median;
		} else {
			int pos = (size - 1) / 2;
			return list.get(pos).floatValue();
		}
	}
}
