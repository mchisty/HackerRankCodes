package misc.sorting;

public class MergeSortExample {

	static int[] a = { 90, 20, 85, 40 }; // { 90, 10, 80, 20, 85, 40 };
	static int[] c = a; // new int[a.length];

	public static void main(String[] args) {
		MergeSortExample ms = new MergeSortExample();
		// ms.mergeSort(0, a.length - 1);
		// c = ms.divideAndConquer(a);
		c = ms.divide1(a);

		for (int i = 0; i < c.length; ++i)
			System.out.print(c[i] + " ");

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
		merge(leftArray, rightArray, inputArray);
		return inputArray;
	}

	public void merge(int[] leftArray, int[] rightArray, int[] sortedArray) {
		int leftArrayLength = leftArray.length;
		int rightArrayLength = rightArray.length;
		int i = 0;
		int j = 0;
		int k = 0;
		while (i < leftArrayLength && j < rightArrayLength) {
			if (leftArray[i] < rightArray[j]) {
				sortedArray[k] = leftArray[i];
				i++;
			} else {
				sortedArray[k] = rightArray[j];
				j++;
			}
			k++;
		}
		// copy the rest of the first half if there is anything left
		while (i < leftArrayLength) {
			sortedArray[k] = leftArray[i];
			i++;
			k++;
		}
		// copy the rest of the second half if there is anything left
		while (j < rightArrayLength) {
			sortedArray[k] = rightArray[j];
			j++;
			k++;
		}
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
		merge(a, b, array);
		return array;
	}

	public void sort1(int[] a, int[] b, int[] tmp) {
		int leftSize = a.length;
		int rightSize = b.length;
		int i = 0, j = 0, k = 0;

		while (i < leftSize && j < rightSize) {
			if (a[i] <= b[j]) {
				tmp[k] = a[i];
				++i;
			} else {
				tmp[k] = b[j];
				++j;
			}
			++k;
		}

		while (i <= leftSize) {
			tmp[k++] = a[i++];
		}

		while (j <= rightSize) {
			tmp[k++] = a[j++];
		}

	}

}
