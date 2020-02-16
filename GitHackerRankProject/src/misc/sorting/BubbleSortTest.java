package misc.sorting;

public class BubbleSortTest {

	public static void main(String[] args) {

		int arr[] = { 3, 2, 1 };
		// TODO Auto-generated method stub
		countSwaps(arr);

	}

	private static void countSwaps(int[] a) {
		int count = 0;
		int inputLength = a.length;
		int temp;
		boolean is_sorted;
		for (int i = 0; i < inputLength; i++) {
			is_sorted = true;
			for (int j = 1; j < (inputLength - i); j++) {
				if (a[j - 1] > a[j]) {
					temp = a[j - 1];
					a[j - 1] = a[j];
					a[j] = temp;
					is_sorted = false;
					count++;
				}

			}
			if (is_sorted)
				break;
		}

		System.out.println("Array is sorted in " + count + " swaps.");
		System.out.println("First Element: " + a[0]);
		System.out.println("Last Element:" + a[a.length - 1]);

	}

}
