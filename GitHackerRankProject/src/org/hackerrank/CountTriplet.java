package org.hackerrank;

import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

/**
 * The Class CountTriplet.
 */
public class CountTriplet {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
//		List<Long> numbers = new ArrayList<Long>();
////		// 1 2 2 4; r=2
////		numbers.add(1L);
////		numbers.add(2L);
////		numbers.add(2L);
////		numbers.add(4L);
////		long count = countTriplets(numbers, 2);
////		System.out.println("Count: " + count);
//
//		// 1 3 9 9 27 81; r=3
//		numbers.add(1L);
//		numbers.add(3L);
//		numbers.add(9L);
//		numbers.add(9L);
//		numbers.add(27L);
//		numbers.add(81L);
//		long count = countTriplets(numbers, 3);
//		System.out.println("Count: " + count);
//
////		// 1 5 5 25 125; r=5
////		numbers.add(1L);
////		numbers.add(5L);
////		numbers.add(5L);
////		numbers.add(25L);
////		numbers.add(125L);
////		long count = countTriplets(numbers, 5);
////		System.out.println("Count: " + count);

		// ------------------------------------------------------------------------------------------------------
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
		String[] nr = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
		int n = Integer.parseInt(nr[0]);
		long r = Long.parseLong(nr[1]);
		List<Long> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" ")).map(Long::parseLong)
				.collect(toList());
		long ans = countTriplets(arr, r);
		bufferedWriter.write(String.valueOf(ans));
		bufferedWriter.newLine();
		bufferedReader.close();
		bufferedWriter.close();
	}

// Map solution
	static long countTriplets(List<Long> arr, long r) {
		Map<Long, Long> map2 = new HashMap<Long, Long>();
		Map<Long, Long> map3 = new HashMap<Long, Long>();
		long count = 0L;

		for (Long a : arr) {
			count = count + map3.getOrDefault(a, 0L);
			if (map2.containsKey(a)) {
				map3.put(a * r, map3.getOrDefault(a * r, 0L) + map2.get(a));
			}

			map2.put(a * r, map2.getOrDefault(a * r, 0L) + 1);
		}

		return count;
	}

}
