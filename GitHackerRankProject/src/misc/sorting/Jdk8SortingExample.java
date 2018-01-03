package misc.sorting;

import java.util.Arrays;
import java.util.List;

public class Jdk8SortingExample {

	public static void main(String[] args) {
		System.out.println("-------- With array -------- \n");
		int a[] = { 90, 10, 80, 20, 85, 40 };
		Arrays.sort(a);
		for (int i : a) {
			System.out.print(i + " ");
		}
		System.out.println("-------- With List -------- \n");

		List<Integer> alist = Arrays.asList(90, 10, 80, 20, 85, 40);
		alist.stream().sorted().forEach(i -> System.out.print(i + " "));

	}

}
