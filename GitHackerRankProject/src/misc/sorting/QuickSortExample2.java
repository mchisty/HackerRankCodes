
package misc.sorting;

import java.util.stream.IntStream;

// TODO: Auto-generated Javadoc
/**
 * This approach takes middle element as pivot. The best case is O(n*log n) when
 * middle element is chosen as pivot
 * 
 * @author isadmlc
 *
 */
public class QuickSortExample2 {

	/** The a. */
	static int[] a = { 90, 10, 80, 20, 85, 40 };

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
		while (leftPos < rightPos) {
			while (a[leftPos] < pivot) {
				leftPos++;
			}
			while (a[rightPos] > pivot) {
				rightPos--;
			}
			if (leftPos <= rightPos) {
				// System.out.println("leftPos:" + leftPos + " a[leftPos]: " +
				// a[leftPos] + " <=======> rightPos:"
				// + rightPos + " a[rightPos]: " + a[rightPos] + ". high: " +
				// high + ", low: " + low);
				swap(leftPos, rightPos);
				leftPos++;
				rightPos--;
			}
		}
		if (leftPos < high) {
			// System.out.println("\t---> left pos: " + leftPos + "; high: " +
			// high);
			quickSort(leftPos, high);
		}
		if (rightPos > low) {
			// System.out.println("\t---> right pos: " + rightPos + "; low: " +
			// low);
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
