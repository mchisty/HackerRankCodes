package misc;

public class Table {

	/**
	 * 
	 * Method synchronization example with synchronized keyword. If same
	 * instance of a class (e.g. Table) is used (invoked) by other
	 * classes/thread e.g. {@link TestSynchronized}, then the method (e.g.
	 * printTable) that is accessible by other classes, should be synchronized.
	 * 
	 * 
	 * In the following scenarios, synchronization is not required:
	 * 
	 * - if separate instances of Table is created <br/>
	 * - if values are read-only (i.e. no insert/update operations are done in
	 * the printTable method)
	 * 
	 * Note: Also test by removing the synchronized keyword to test the
	 * different result
	 * 
	 */
	public synchronized void printTable(String str) {
		for (int i = 1; i <= 1000; i++) {
			System.out.println(str);
			// try {
			// Thread.sleep(50);
			// } catch (Exception e) {
			// System.out.println(e);
			// }

		}
	}
}
