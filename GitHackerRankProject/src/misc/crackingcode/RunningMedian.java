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
 * Input: <code>
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

	/** The min heap. */
	PriorityQueue<Integer> minHeap = new PriorityQueue<>(10, (Integer i1, Integer i2) -> i2 - i1); // Descending

	/** The max heap. */
	PriorityQueue<Integer> maxHeap = new PriorityQueue<>(10); // Ascending

	/**
	 * The main method.
	 *
	 * @param args
	 *            the arguments
	 */
	public static void main(String[] args) {
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

	/**
	 * Calculate medians with optimized solution.
	 *
	 * @param a
	 *            the a
	 */
	void calculateMediansWithOptimizedSolution(int[] a) {
		for (int i = 0; i < a.length; ++i) {
			add(a[i]);
			showMedian();
		}
	}

	/**
	 * Adds the.
	 *
	 * @param newItem
	 *            the new item
	 */
	void add(int newItem) {
		if (maxHeap.isEmpty()) {
			maxHeap.add(newItem);
		} else {
			int head = maxHeap.peek();
			if (newItem < head) {
				minHeap.add(newItem);
			} else {
				maxHeap.add(newItem);
			}
		}
		// balance
		balanceQueues();
	}

	/**
	 * Balance queues.
	 */
	void balanceQueues() {
		if (maxHeap.size() + 1 < minHeap.size()) {
			int headMinheap = minHeap.poll();
			maxHeap.add(headMinheap);
		} else if (minHeap.size() + 1 < maxHeap.size()) {
			int headMaxheap = maxHeap.poll();
			minHeap.add(headMaxheap);
		}
	}

	/**
	 * Show median.
	 */
	void showMedian() {
		int size = maxHeap.size() + minHeap.size();
		if (size % 2 == 0) {
			int headMax = maxHeap.peek();
			int headMin = minHeap.peek();
			float median = (headMax + headMin) / 2f;
			System.out.println(median);
		} else {
			float median = maxHeap.size() > minHeap.size() ? maxHeap.peek() : minHeap.peek();
			System.out.println(median);
		}
	}

	// ------------------------------------------------------------------------------
	// Note: Not a recommended approach
	// ------------------------------------------------------------------------------
	/**
	 * Calculate medians with brute force solution.
	 *
	 */
	void calculateMediansWithBruteForceSolution(int[] a) {
		List<Float> l = getAllMedians(a);
		l.stream().forEach(i -> System.out.println(i));
	}

	/**
	 * Gets the all medians.
	 *
	 * @param a
	 *            the a
	 * @return the all medians
	 */
	List<Float> getAllMedians(int a[]) {
		List<Float> medianList = new ArrayList<>();
		List<Integer> list = Arrays.stream(a).boxed().collect(Collectors.toList());
		for (int i = 1; i <= list.size(); ++i) {
			float m = getMedianVal(list.subList(0, i));
			medianList.add(m);
		}
		return medianList;
	}

	/**
	 * Gets the median val.
	 *
	 * @param list
	 *            the list
	 * @return the median val
	 */
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
