
package misc.sorting;

public class MergeSortExample {

	static int[] initialArray = { 90, 11, 85, 101 };

	static int[] c = initialArray; // new int[a.length];

	public static void main(String[] args) {
		MergeSortExample ms = new MergeSortExample();
		c = ms.divideAndConquer(initialArray);
		// -------------------------------------
		// c = ms.divide1(initialArray);
		for (int i = 0; i < c.length; ++i) {
			System.out.print(c[i] + " ");
		}
	}

	public int[] divideAndConquer(int[] inputArray) {
		int n = inputArray.length;
		if (n == 1) {
			return inputArray;
		}
		int mid = n / 2;
		int[] leftArray = new int[mid];
		int[] rightArray = new int[n - mid];
		System.arraycopy(inputArray, 0, leftArray, 0, leftArray.length);
		System.arraycopy(inputArray, leftArray.length, rightArray, 0, rightArray.length);
		divideAndConquer(leftArray);
		divideAndConquer(rightArray);
		sort1(leftArray, rightArray, inputArray);
		return inputArray;
	}

	// ===============================================================
	private int[] divide1(int[] array) {
		int n = array.length;
		if (n == 1) {
			return array;
		}
		int mid = n / 2;
		int[] a = new int[mid];
		int[] b = new int[n - mid];
		System.arraycopy(array, 0, a, 0, a.length);
		System.arraycopy(array, a.length, b, 0, b.length);
		divide1(a);
		divide1(b);
		// merge(a, b, array);
		sort1(a, b, array);
		return array;
	}

	public void sort1(int[] a1, int[] b1, int[] tmp) {
		int leftSize = a1.length;
		int rightSize = b1.length;
		int i = 0, j = 0, k = 0;
		while (i < leftSize && j < rightSize) {
			if (a1[i] < b1[j]) {
				tmp[k] = a1[i];
				i++;
			} else {
				tmp[k] = b1[j];
				j++;
			}
			k++;
		}
		while (i < leftSize) {
			tmp[k++] = a1[i++];
		}
		while (j < rightSize) {
			tmp[k++] = b1[j++];
		}
	}
}
