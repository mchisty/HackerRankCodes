
package misc;

import java.util.Collection;
import java.util.HashSet;

public class StaticBindingTest {

	public static void main(String[] args) {
		Collection c = new HashSet();
		StaticBindingTest st = new StaticBindingTest();
		st.sort(c);
		HashSet c1 = new HashSet();
		st.sort(c1);
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
