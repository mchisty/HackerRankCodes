package misc.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class LambdaTest {

	public static void main(String[] args) {
		System.out.println("==================== Runnable interface =====================");
		Runnable r1 = new Runnable() {
			@Override
			public void run() {
				System.out.println("Running without lambda");
			}
		};

		Runnable r2 = () -> System.out.println("Running lambda");
		r1.run();
		r2.run();
		List<Person> personList = new ArrayList<>();
		personList.add(new Person("Test1", 20, "123-192022"));
		personList.add(new Person("Best2", 24, "333-231522"));
		personList.add(new Person("Pest2", 28, "333-121223"));
		personList.add(new Person("Abc 1", 27, "000-231522"));
		personList.add(new Person("xyz 1", 23, "022-312789"));
		personList.add(new Person("DEF 1", 23, "011-231239"));
		personList.add(new Person("EFG", 22, "012-431237"));
		personList.add(new Person("FGH", 34, "013-431234"));
		personList.add(new Person("FGH 2", 39, "014-331232"));
		personList.add(new Person("DEF 2", 41, "015-531231"));
		personList.add(new Person("ABC 2", 42, "016-731230"));

		System.out.println("------------------------------------------------------------- ");
		System.out.println(" List without sort ");
		System.out.println("------------------------------------------------------------- ");
		personList.forEach(p -> p.printGivenName());

		System.out.println("------------------------------------------------------------- ");
		System.out.println(" List sorted ");
		System.out.println("------------------------------------------------------------- ");
		Collections.sort(personList, (Person p1, Person p2) -> p1.getGivenName().compareTo(p2.getGivenName()));
		personList.forEach(p -> p.printGivenName());

		System.out.println("------------------------------------------------------------- ");
		System.out.println(" Age > 25 (consumer inside) ");
		System.out.println("------------------------------------------------------------- ");

		Predicate<Person> predicate1 = p -> p.getAge() > 25;
		personList.stream().filter(predicate1).forEach(p -> p.printDetail());

		System.out.println("------------------------------------------------------------- ");
		System.out.println(" Age > 25 (consumer external) ");
		System.out.println("------------------------------------------------------------- ");
		Consumer<Person> c1 = p -> p.printDetail();
		personList.stream().filter(predicate1).forEach(c1);

		System.out.println("------------------------------------------------------------- ");
		System.out.println(" Age > 25 (with parallel stream, order changes) ");
		System.out.println("------------------------------------------------------------- ");
		personList.parallelStream().filter(predicate1).forEach(c1);

		Integer[] a = { 1, 3, 2, 5 };
		List<Integer> arrList = Arrays.asList(a);
		System.out.println("listOfIntegers sorted in reverse order:");

		arrList.stream().forEach(i -> System.out.print(i + " "));

	}

}