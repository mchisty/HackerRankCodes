
package misc.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * The Class FunctionExample.
 */
public class FunctionExample {

	/** The Constant personNamesList. */
	final public static List<String> personNamesList = Arrays.asList("John", "Supreme", "", "efg", "Brad", "",
			"Benkley", "abc", "Michael", "XYZ", "Burton", "");

	/**
	 * The main method.
	 *
	 * @param args
	 *            the arguments
	 */
	public static void main(String[] args) {
		FunctionExample fex = new FunctionExample();
		List<Person> pList = fex.populateSamplePersonData();
		System.out.println("------------------------------------------------------");
		System.out.println("Function example 1: ");
		System.out.println("------------------------------------------------------");
		List<String> formattedList = new ArrayList<>();
		Function<Person, String> westernStyle = p -> {
			return "Name: " + p.getGivenName() + " ==> " + "Age: " + p.getAge() + "; " + "Phone: " + p.getPhone();
		};
		for (Person p : pList) {
			formattedList.add(westernStyle.apply(p));
		}
		formattedList.forEach(k -> System.out.println(k));
		System.out.println("------------------------------------------------------");
		System.out.println("Function example 2: ");
		System.out.println("------------------------------------------------------");
		fex.processPersonsWithFunction(pList, p -> p.getAge() >= 20 && p.getGivenName().startsWith("B"),
				tmp -> System.out.println(tmp));
	}

	/**
	 * Gets the persons list.
	 *
	 * @return the persons list
	 */
	private List<Person> populateSamplePersonData() {
		List<Person> pList = new ArrayList<>();
		Random r = new Random();
		for (int i = 0; i < 10; ++i) {
			int n = r.nextInt(9);
			String name = personNamesList.get(n);
			n = r.nextInt(9);
			Person p = new Person(name, (n + 5) * 4, "0419-001-12" + i);
			pList.add(p);
		}
		return pList;
	}

	/**
	 * Process persons with function.
	 *
	 * @param roster
	 *            the roster
	 * @param tester
	 *            the tester
	 * @param block
	 *            the block
	 */
	private void processPersonsWithFunction(List<Person> roster, Predicate<Person> tester, Consumer<String> block) {
		Function<Person, String> mapper = k -> {
			return "Name: " + k.getGivenName() + "; " + "Age: " + k.getAge() + "; " + "Phone: " + k.getPhone();
		};
		for (Person p : roster) {
			if (tester.test(p)) {
				String data = mapper.apply(p);
				block.accept(data);
			}
		}
	}
}
