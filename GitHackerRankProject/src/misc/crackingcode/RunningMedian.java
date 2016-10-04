package misc.crackingcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 *
 * <code>
 6
 
12
4
5
3
8
7
 * </code>
 * 
 * Output: <code>

12.0
8.0
5.0
4.5
5.0
6.0

 </code>
 *
 */
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
		// r.calculateMediansWithBruteForceSolution(a);
		// --------------------------------
		r.calculateMediansWithOptimizedSolution(a);

	}

	void calculateMediansWithOptimizedSolution(int[] a) {
		for (int i = 0; i < a.length; ++i) {
			add(a[i]);
			showMedian();
		}
	}

	PriorityQueue<Integer> minHeap = new PriorityQueue<>(10, (Integer i1, Integer i2) -> i2 - i1); // Descending
	PriorityQueue<Integer> maxHeap = new PriorityQueue<>(10); // Ascending

	void add(int a) {
		if (maxHeap.isEmpty()) {
			maxHeap.add(a);
		} else {
			int current = maxHeap.peek();
			if (a < current) {
				minHeap.add(a);
			} else {
				maxHeap.add(a);
			}
		}
		// balance
		balanceQueues();
	}

	void balanceQueues() {
		if (maxHeap.size() + 1 < minHeap.size()) {
			int num = minHeap.poll();
			maxHeap.add(num);
		} else if (minHeap.size() + 1 < maxHeap.size()) {
			int num = maxHeap.poll();
			minHeap.add(num);
		}
	}

	void showMedian() {
		int size = maxHeap.size() + minHeap.size();
		if (size % 2 == 0) {
			int num1 = maxHeap.peek();
			int num2 = minHeap.peek();
			float median = (num1 + num2) / 2f;
			System.out.println(median);
		} else {
			float median = maxHeap.size() > minHeap.size() ? maxHeap.peek() : minHeap.peek();
			System.out.println(median);
		}

	}

	void calculateMediansWithBruteForceSolution(int[] a) {
		List<Float> l = getAllMedians(a);
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
