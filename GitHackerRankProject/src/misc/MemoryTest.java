
package misc;

public class MemoryTest {

	public static void main(String[] args) {
		checkIdentityAndEquality();
		checkImmutability();
	}

	private static void checkImmutability() {
		String a = "test";
		String b = a;
		System.out.println("-----------------------------------");
		System.out.println("Initial a:" + a + "; Initial b:" + b);
		a = a.toUpperCase();
		System.out.println("a updated:" + a + "; Value of b:" + b);
	}

	private static void checkIdentityAndEquality() {
		final String a = "ABC";
		showValue("a", a);
		String b = a;
		showValue("b", b);
		String c = new String(a);
		showValue("c", c);
		String d = c.intern();
		showValue("d", d);
		System.out.println("-----------------------------------");
		System.out.println("a==b? " + (a == b) + " ==> a.equals(b): " + a.equals(b));
		System.out.println("b==c? " + (b == c) + " ==> b.equals(c): " + b.equals(c));
		System.out.println("d==a? " + (d == a) + " ==> d.equals(a): " + d.equals(a));
		System.out.println("d==c? " + (d == c) + " ==> d.equals(c): " + d.equals(c));
		System.out.println("d==b? " + (d == b) + " ==> d.equals(b): " + d.equals(b));
	}

	private static void showValue(String varibaleName, Object obj) {
		System.out.println(varibaleName + ": " + System.identityHashCode(obj));
	}
}
