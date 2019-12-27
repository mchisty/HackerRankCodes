package org.hackerrank;

import java.io.IOException;

//TODO: Convert to JDK 8
public class MinimumSwap2 {

	// Complete the minimumSwaps function below.
	static int minimumSwaps(int[] arr) {
// 		Map<Integer, Integer> map = IntStream.range(0, arr.length-1).boxed().collect(Collectors.toMap(i -> i+1, i -> arr[i]));
//		map.forEach((k, v) -> System.out.println((k + ":" + v)));
//		boolean isVisited[] = new boolean[arr.length];
		
		int swapCount=0;
		for(int i=0; i<arr.length; ++i) {
			int expectedVal = i+1;
			System.out.println(expectedVal);
			while(arr[i]!=expectedVal) {
				swap(i,arr[i]-1,arr);
				swapCount++;
			}
		}
		return swapCount;
		
	}
	
	
	static void swap(int a, int b,int[]arr){
	    int temp = arr[a];
	    arr[a] = arr[b];
	    arr[b] = temp;

	}

	public static void main(String[] args) throws IOException {
		
//		int arr[] = {7, 1, 3, 2, 4, 5, 6}; // Expected: 5
//		int arr[] = {4, 3, 1, 2}; // Expected: 3
//		int arr[] = {2, 3, 4, 1, 5}; // Expected: 3
		int arr[] = {1, 3, 5, 2, 4, 6, 7}; // Expected: 3
		
		System.out.println("" + minimumSwaps(arr));
	}
}
