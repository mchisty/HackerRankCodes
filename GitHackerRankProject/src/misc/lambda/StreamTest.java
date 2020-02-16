
package misc.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * The Class StreamTest.
 */
public class StreamTest {

	/** The Constant strList. */
	final public static List<String> strList = Arrays.asList("John", "Supreme", "", "efg", "Brad", "", "Benkley", "abc",
			"Michael", "XYZ", "Burton", "");

	/** The Constant numList. */
	final static List<Integer> numList = Arrays.asList(50, 22, -10, 0, 98, 88, 15, -10, 99, 100, 205, 34);

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		System.out.println("----------------------------------------------------------------------------------");
		System.out.println("The original list: " + strList.toString());
		System.out.println("----------------------------------------------------------------------------------");
		StreamTest st = new StreamTest();
		st.printEmptyStringsCount();
		st.printStringsWithSpecificLength(4);
		st.printNonEmptyStringList();
		st.printSortedNumbers();
		st.printWithParallelStream();
		st.testStreamPrintArray();
		st.testListToArray();
		// --------------------------------------------
		MyInterface m = st::printSomething;
		m.doSomething("Instance method reference");
	}

	/**
	 * Prints the empty strings count.
	 */
	void printEmptyStringsCount() {
		Predicate<String> p = s -> s.isEmpty();
		Long count = strList.stream().filter(p).count();
		System.out.println("Empty item count: " + count);
	}

	/**
	 * Prints the strings with specific length.
	 *
	 * @param length the length
	 */
	void printStringsWithSpecificLength(int length) {
		Predicate<String> p = s -> (s.length() == length);
		Long count = strList.stream().filter(p).count();
		System.out.printf("Number of elements with length %d is: %d", length, count);
		System.out.println();
	}

	/**
	 * Prints the non empty string list.
	 */
	void printNonEmptyStringList() {
		Predicate<String> p = s -> !s.isEmpty();
		List<String> updatedList = strList.stream().filter(p).collect(Collectors.toList());
		System.out.println("Nonempty elements are: " + updatedList.toString());
	}

	/**
	 * Prints the sorted numbers. Using Consumer.
	 * 
	 */
	void printSortedNumbers() {
		Consumer<Integer> c = i -> System.out.print(i + ", ");
		System.out.print("Sorted List (Approach 1): ");
		numList.stream().sorted().forEach(c);
		System.out.println();
		System.out.print("Sorted List (Approach 2): ");
		numList.stream().sorted().forEach(System.out::println);
		System.out.println();
	}

	/**
	 * Prints the with parallel stream.
	 */
	void printWithParallelStream() {
		Predicate<String> p = s -> s.isEmpty();
		Long count = strList.parallelStream().filter(p).count();
		System.out.println("Empty list count (with parallel processing): " + count);
		// ===========================================================================================================
		List<Person> pList = populateSamplePersonData();
		count = pList.parallelStream().filter(s -> null != s.getGivenName()).filter(s -> s.getAge() > 25).count();
		System.out.println("Persons count with nonempty name and age>25 (with parallel processing): " + count);
		System.out.print("Persons age: ");
		pList.stream().forEach(k -> System.out.print(" " + k.getAge()));
		int totalAge = pList.parallelStream().filter(s -> null != s.getGivenName()).mapToInt(Person::getAge).sum();
		System.out.println(" ==> Total age: " + totalAge);
		// ===========================================================================================================
		Double averageAge = pList.parallelStream().filter(s -> null != s.getGivenName()).mapToInt(Person::getAge)
				.average().getAsDouble();
		System.out.println("Persons age average with nonempty name (with parallel processing): " + averageAge);
		// ===========================================================================================================
		p = s -> !s.isEmpty();
		List<String> updatedList = strList.parallelStream().filter(p).collect(Collectors.toList());
		System.out.println("List with nonempty elements (with parallel processing stream): " + updatedList.toString());
	}

	/**
	 * Test stream print array.
	 */
	void testStreamPrintArray() {
		int a[] = { 1, 2, 3, 4, 5 };
		Arrays.stream(a).forEach(i -> System.out.print(" " + i));
		System.out.println();
	}

	/**
	 * Test list to array.
	 */
	void testListToArray() {
		List<Integer> b = Arrays.asList(100, 200, 300, 400, 500);
		int arr[] = b.stream().mapToInt(i -> i).toArray();
		System.out.println("Converting Integer List to Integer array");
		IntStream.of(arr).forEach(i -> System.out.print(i + " "));
	}

	/**
	 * Prints the something.
	 *
	 * @param name the name
	 */
	private void printSomething(String name) {
		System.out.println();
		System.out.println("A double colon test, known as " + name);
	}

	public static List<Person> populateSamplePersonData() {
		List<Person> pList = new ArrayList<>();
		Random r = new Random();
		for (int i = 0; i < 10; ++i) {
			int n = r.nextInt(9);
			String name = strList.get(n);
			n = r.nextInt(9);
			Person p = new Person(name, (n + 5) * 4, "0419-001-12" + i,
					StreamTest.generateRandomWord() + "@gmail.com");
			pList.add(p);
		}
		return pList;
	}

	public static String generateRandomWord() {
		String randomStrings = null;
		Random random = new Random();
		char[] word = new char[random.nextInt(8) + 3];
		for (int j = 0; j < word.length; j++) {
			word[j] = (char) ('a' + random.nextInt(26));
		}
		randomStrings = new String(word);
		return randomStrings;
	}
}
