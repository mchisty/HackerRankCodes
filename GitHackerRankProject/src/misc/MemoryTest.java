
package misc;

public class MemoryTest {

	public static void main(String[] args) {
		final String s = "ABC";
		showValue("s", s);
		String b = s;
		showValue("b", b);
		String c = new String(s);
		showValue("c", c);
	}

	private static void showValue(String varibaleName, Object obj) {
		System.out.println(varibaleName + ": " + System.identityHashCode(obj));
	}
}
