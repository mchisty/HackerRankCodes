package misc.lambda;

import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

public class StreamMapTest {

	final static List<Person> personList = StreamTest.populateSamplePersonData();
	public static void main(String[] args) {
		sortPersonByAgeWithMapToInt();
	}

	/**
	 * Using mapToInt
	 */
	static void sortPersonByAgeWithMapToInt() {
		int sortedAge[] = personList.stream().sorted(Comparator.comparingInt(Person::getAge)).mapToInt(p->p.getAge()).toArray();
		IntStream.of(sortedAge).forEach(p -> System.out.println("Age:" + p));
	}


}
