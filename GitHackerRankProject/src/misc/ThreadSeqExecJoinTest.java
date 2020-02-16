package misc;

/**
 * You have thread T1, T2, and T3, how will you ensure that thread T2 run after
 * T1 and thread T3 run after T2? <br/>
 * 
 * Solution: Using join() method
 * 
 * Tips: Try without using join() i.e. comment the join() method and different
 * results will be produced
 * 
 * Ref:
 * https://javarevisited.blogspot.com/2018/07/java-multi-threading-interview-questions-answers-from-investment-banks.html
 * 
 * @author mchisty
 *
 */
public class ThreadSeqExecJoinTest {

	final static Runnable r = () -> {
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Thread name: " + Thread.currentThread().getName());
	};

	public static void main(String[] args) {
		Thread t1 = new Thread(r);
		Thread t2 = new Thread(r);
		Thread t3 = new Thread(r);
		Thread t4 = new Thread(r);

		// -------------------
		// T1 thread
		// -------------------
		t1.start();
		try {
			t1.join();
		} catch (Exception ex) {
			System.out.println("Exception has " + "been caught" + ex);
		}

		// -------------------
		// T2 thread
		// -------------------
		t2.start();
		try {
			t2.join();
		} catch (Exception ex) {
			System.out.println("Exception has been" + " caught" + ex);
		}

		// -------------------
		// T3 thread
		// -------------------
		t3.start();
		try {
			t3.join();
		} catch (Exception ex) {
			System.out.println("Exception has been" + " caught" + ex);
		}

		// -------------------
		// T4 thread
		// -------------------
		t4.start();
		try {
			t4.join();
		} catch (Exception ex) {
			System.out.println("Exception has been" + " caught" + ex);
		}
		
		//------------------------------------------------------------------------
		// Without join: Try without join by un-commenting the following code
		//------------------------------------------------------------------------
//		t1.start();
//		t2.start();
//		t3.start();
//		t4.start();
		
	}

}
