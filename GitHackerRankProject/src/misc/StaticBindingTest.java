
package misc;

import java.util.Collection;
import java.util.HashSet;

public class StaticBindingTest {

	public static void main(String[] args) {
		StaticBindingTest st = new StaticBindingTest();
		Collection c = new HashSet();
		st.sort(c);
	}

	public Collection sort(Collection c) {
		System.out.println("Inside Collection sort method");
		return c;
	}

	public Collection sort(HashSet h) {
		System.out.println("Inside HashSet sort method");
		return h;
	}
}
