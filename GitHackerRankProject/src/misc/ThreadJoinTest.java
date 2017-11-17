
package misc;

/**
 * The Class ThreadJoinTest.
 */
public class ThreadJoinTest {

	/**
	 * The main method.
	 *
	 * @param args
	 *            the arguments
	 * @throws Exception
	 *             the exception
	 */
	public static void main(String[] args) throws Exception {
		ThreadJoinTest tj = new ThreadJoinTest();
		tj.joinTest();
		tj.priorityTest();
	}

	/**
	 * Say we have thread T1, T2 and T3, how can we ensure that thread T2 run
	 * after T1 and thread T3 run after T2? We can do this by using
	 * Thread.join() method.
	 * 
	 * In this example, after t1 completes its task then t2 and t3 starts
	 * executing.
	 *
	 * @throws InterruptedException
	 *             the interrupted exception
	 */
	void joinTest() throws InterruptedException {
		System.out.println("===== Thread join test ====== ");
		TestJoinMethod t1 = new TestJoinMethod("T1 thread");
		TestJoinMethod t2 = new TestJoinMethod("T2 thread");
		TestJoinMethod t3 = new TestJoinMethod("T3 thread");
		t1.start();
		t1.join();
		System.out.println("------------");
		t2.start();
		t2.join();
		System.out.println("------------");
		t3.start();
		t3.join();
		System.out.println("------------");
	}

	/**
	 * Each thread have a priority. Priorities are represented by a number
	 * between 1 and 10. In most cases, thread schedular schedules the threads
	 * according to their priority (known as preemptive scheduling). But it is
	 * not guaranteed because it depends on JVM specification that which
	 * scheduling it chooses.
	 */
	void priorityTest() {
		System.out.println("===== Thread priority test ====== ");
		TestJoinMethod t1 = new TestJoinMethod("T1 thread");
		TestJoinMethod t2 = new TestJoinMethod("T2 thread");
		t1.setPriority(Thread.MIN_PRIORITY);
		t2.setPriority(Thread.MAX_PRIORITY);
		t1.start();
		t2.start();
	}
}

class TestJoinMethod extends Thread {

	private String msg;

	public TestJoinMethod(String msg) {
		this.msg = msg;
	}

	@Override
	public void run() {
		for (int i = 1; i <= 5; i++) {
			try {
				Thread.sleep(50);
			} catch (Exception e) {
				System.out.println(e);
			}
			System.out.println(msg + ":\t" + i);
		}
	}
}
