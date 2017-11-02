
package misc.sorting;

import java.util.stream.IntStream;

/**
 * This approach takes middle element as pivot. The best case is O(n*log n) when
 * middle element is chosen as pivot
 * 
 * @author isadmlc
 *
 */
public class QuickSortExample2 {

	static int[] a = { 10, 80, 30, 85, 90, 60, 50, 70 };

	public static void main(String[] args) {
		System.out.print("Initial value => ");
		IntStream.of(a).forEach(k -> System.out.print(" " + k));
		System.out.println();
		QuickSortExample2 q = new QuickSortExample2();
		q.quickSort(0, a.length - 1);
		IntStream.of(a).forEach(i -> System.out.print(" " + i));
	}

	public void quickSort(int low, int high) {
		int i = low, j = high;
		int pivotPos = (low + high) / 2;
		int pivot = a[pivotPos];
		System.out.println("-------------------------------------------------");
		System.out.println("Pivot pos: " + pivotPos + " ; Pivot val: " + pivot);
		while (i <= j) {
			while (a[i] < pivot) {
				i++;
			}
			while (a[j] > pivot) {
				j--;
			}
			if (i <= j) {
				System.out.println("i:" + i + " a[i]: " + a[i] + "; j:" + j + " a[j]: " + a[j]);
				swap(i, j);
				i++;
				j--;
				System.out.print("After swapping => ");
				IntStream.of(a).forEach(k -> System.out.print(" " + k));
				System.out.println();
			}
		}
		if (i < high) {
			System.out.println("i: " + i + "; high: " + high);
			quickSort(i, high);
		}
		if (j > low) {
			System.out.println("low: " + low + "; j: " + j);
			quickSort(low, j);
		}
	}

	void swap(int i, int j) {
		int tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;
	}
}
