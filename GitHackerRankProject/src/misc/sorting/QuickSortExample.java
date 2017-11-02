
package misc.sorting;

import java.util.stream.IntStream;

/**
 * The key process in quickSort is partition.
 * 
 * Target of partition is: given an array and an element x of array as pivot,
 * put x at its correct position in sorted array and put all smaller elements
 * (smaller than x) before x, and put all greater elements (greater than x)
 * after x.
 * 
 * This approach takes last element as pivot. If the last element is chosen as
 * pivot and if the array is already sorted, then the worst case time complexity
 * arises. The worst case time complexity is O(n^2)
 * 
 * Note: The best case is O(n*log n) when middle element is chosen as
 * pivot. @see {@link QuickSortExample2}
 * 
 * @author isadmlc
 *
 */
public class QuickSortExample {

	/**
	 * The main method.
	 *
	 * @param args
	 *            the arguments
	 */
	public static void main(String[] args) {
		QuickSortExample qe = new QuickSortExample();
		int[] a = { 10, 80, 30, 90, 40, 50, 70 };
		qe.quickSort(a, 0, a.length - 1);
		IntStream.of(a).forEach(i -> System.out.print(" " + i));
	}

	/**
	 * Gets the pivot index.
	 *
	 * @param a
	 *            the a
	 * @param low
	 *            the low
	 * @param high
	 *            the high
	 * @return the pivot index
	 */
	// ----------------------------------------------------------------
	private int getPivotIndex(int[] a, int low, int high) {
		displayValues(a, low, high, high);
		final int pivot = a[high];
		int i = low - 1;
		for (int j = low; j < high; ++j) {
			if (a[j] <= pivot) {
				i = i + 1;
				int tmp = a[i];
				a[i] = a[j];
				a[j] = tmp;
			}
		}
		i = i + 1;
		int tmp = a[i];
		a[i] = a[high];
		a[high] = tmp;
		return i;
	}

	/**
	 * Quick sort.
	 *
	 * @param a
	 *            the a
	 * @param low
	 *            the low
	 * @param high
	 *            the high
	 */
	// ----------------------------------------------------------------
	void quickSort(int[] a, int low, int high) {
		if (low < high) {
			int pivotalIndex = getPivotIndex(a, low, high);
			quickSort(a, low, pivotalIndex - 1);
			quickSort(a, pivotalIndex + 1, high);
		}
	}

	/**
	 * Display values.
	 *
	 * @param a
	 *            the a
	 * @param low
	 *            the low
	 * @param high
	 *            the high
	 * @param pivotalIndex
	 *            the pivotal index
	 */
	void displayValues(final int[] a, final int low, int high, final int pivotalIndex) {
		System.out.println("i:" + pivotalIndex);
		System.out.println("low: " + low + ", high: " + high + ", pivot: " + a[pivotalIndex]);
		IntStream.of(a).forEach(i -> System.out.printf("%d,", i));
		System.out.println("\n----------------------------------------------------------------");
	}
}
