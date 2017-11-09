package misc;

/**
 * Testing synchronization on a method of the {@link Table} class
 */
public class TestSynchronized {

	/**
	 * The main method.
	 *
	 */
	public static void main(String[] args) {
		final Table t = new Table();
		method1(t);
		method2(t);
	}

	/**
	 * Method1.
	 *
	 * @param t
	 *            the Table
	 */
	static void method1(Table t) {
		Runnable r1 = () -> {
			t.printTable("Method 1");
		};
		new Thread(r1).start();
	}

	/**
	 * Method2.
	 *
	 * @param t
	 *            the Table
	 */
	static void method2(Table t) {
		Runnable r2 = () -> {
			t.printTable("* Method 2");
		};
		new Thread(r2).start();
	}

}
