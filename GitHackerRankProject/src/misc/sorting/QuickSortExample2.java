
package misc.sorting;

import java.util.stream.IntStream;

// TODO: Auto-generated Javadoc
/**
 * This approach takes middle element as pivot. The best case is O(n*log n) when middle element is chosen as pivot
 * 
 * @author isadmlc
 *
 */
public class QuickSortExample2 {

	/** The a. */
	static int[] a = { 90, 20, 85, 40 }; // { 90, 10, 80, 20, 85, 40 };

	/**
	 * The main method.
	 *
	 * @param args
	 *            the arguments
	 */
	public static void main(String[] args) {
		System.out.print("Initial value => ");
		IntStream.of(a).forEach(k -> System.out.print(" " + k));
		System.out.println();
		QuickSortExample2 q = new QuickSortExample2();
		q.quickSort(0, a.length - 1);
		System.out.print("Final value => ");
		IntStream.of(a).forEach(i -> System.out.print(" " + i));
	}

	/**
	 * Quick sort.
	 *
	 * @param low
	 *            the low
	 * @param high
	 *            the high
	 */
	public void quickSort(int low, int high) {
		int leftPos = low, rightPos = high;
		int pivotPos = (low + high) / 2;
		int pivot = a[pivotPos];
		System.out.println("low:" + low + ", high: " + high);
		System.out.println("pivot pos:" + pivotPos + ", pivot val: " + pivot);
		while (leftPos < rightPos) {
			System.out.println("left:" + leftPos + ", right: " + rightPos);
			// Ideal scenario, do nothing
			while (a[leftPos] < pivot) {
				leftPos++;
			}
			// Ideal scenario, do nothing
			while (a[rightPos] > pivot) {
				rightPos--;
			}
			// Not ideal: so swap left and right position values
			// (just make sure that left position <= right position)
			if (leftPos <= rightPos) {
				swap(leftPos, rightPos);
				++leftPos;
				--rightPos;
			}
			IntStream.of(a).forEach(k -> System.out.print(" " + k));
		}
		System.out.println("\n--------------------------------------------------------------");
		if (leftPos < high) {
			System.out.println("(leftPos < high)  ==> left:" + leftPos + ", right: " + rightPos + ", high: " + high);
			quickSort(leftPos, high);
		}
		if (rightPos > low) {
			System.out.println("(rightPos > low) ==> left:" + leftPos + ", right: " + rightPos + ", low: " + low);
			quickSort(low, rightPos);
		}
	}

	/**
	 * Swap.
	 *
	 * @param i
	 *            the i
	 * @param j
	 *            the j
	 */
	void swap(int i, int j) {
		int tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;
	}
}
