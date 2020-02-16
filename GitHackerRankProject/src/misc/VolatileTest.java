package misc;

/**
 * 
 * If the counter variable is not declared volatile there is no guarantee about
 * when the value of the counter variable is written from the CPU cache back to
 * main memory. This means, that the counter variable value in the CPU cache may
 * not be the same as in main memory. 
 * 
 * Declaring a variable volatile thus guarantees the visibility for other
 * threads of writes to that variable.
 * 
 * In the scenario given here, where one thread (t2) modifies the counter, and
 * another thread (t1) reads the counter (but never modifies it), declaring the
 * counter variable volatile is enough to guarantee visibility for t1 of writes
 * to the counter variable.
 * 
 * Try by both commenting and un-commenting the volatile option: if non volatile
 * option is used, chances are quite likely that the main thread with hang and
 * fall into a loop. With volatile option, this will never happen and the main
 * thread will execute completely.
 * 
 * Src: 
 * http://tutorials.jenkov.com/java-concurrency/volatile.html
 * https://dzone.com/articles/java-volatile-keyword-0
 * 
 */


public class VolatileTest {

	/** The counter. */
//	private volatile int counter = 0; // With volatile
	private int counter = 0; // Without volatile

	/** Thread r1 */
	Runnable r1 = () -> {
		int local_value = counter;
		while (local_value < 5) {
			if (local_value != counter) {
				System.out.println("==> Got Change for counter :" + counter);
				local_value = counter;
			}
		}
	};

	/** Thread r2 */
	Runnable r2 = () -> {
		while (counter < 5) {
			counter++;
			System.out.println("Incrementing counter to :" + counter);
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	};

	/**
	 * Instantiates a new volatile test.
	 */
	public VolatileTest() {
		try {
			Thread t1 = new Thread(r1);
			Thread t2 = new Thread(r2);
			t1.start();
			t2.start();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 * @throws InterruptedException the interrupted exception
	 */
	public static void main(String[] args) throws InterruptedException {
		new VolatileTest();
	}

}
