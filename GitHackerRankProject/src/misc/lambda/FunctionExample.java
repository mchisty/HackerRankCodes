
package misc.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Function;

// TODO: Auto-generated Javadoc
/**
 * The Class FunctionExample.
 */
public class FunctionExample {

	/**
	 * The main method.
	 *
	 * @param args
	 *            the arguments
	 */
	public static void main(String[] args) {
		FunctionExample fex = new FunctionExample();
		Function<Person, String> westernStyle = p -> {
			return "Name: " + p.getGivenName() + " " + "Age: " + p.getAge() + "; " + "Phone: " + p.getPhone();
		};
		List<Person> pList = fex.getPersonsList();
		List<String> formattedList = new ArrayList<>();
		for (Person p : pList) {
			formattedList.add(westernStyle.apply(p));
		}
		formattedList.forEach(k -> System.out.println(k));
	}

	/**
	 * Gets the persons list.
	 *
	 * @return the persons list
	 */
	private List<Person> getPersonsList() {
		List<Person> pList = new ArrayList<>();
		Random r = new Random();
		for (int i = 0; i < 10; ++i) {
			int n = r.nextInt(9);
			String name = StreamTest.strList.get(n);
			n = r.nextInt(9);
			Person p = new Person(name, (n + 5) * 5, "0419-001-12" + i);
			pList.add(p);
		}
		return pList;
	}
}
