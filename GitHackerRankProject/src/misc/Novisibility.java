
package misc;

/**
 * Two threads, the main thread and the ReaderThread thread, access the shared
 * variables 'ready' and 'number'. The main thread starts the reader thread and
 * then sets number to 42 and ready to true. The reader thread spins until it
 * sees ready is true, and then prints out number.
 * 
 * <br/>
 * 
 * While it may seem obvious that NoVisibility will print 42, it is in fact
 * possible that it will print zero, or never terminate at all! Because it does
 * not use adequate synchronization, there is no guarantee that the values of
 * ready and number written by the main thread will be visible to the reader
 * thread.
 * 
 * =============================================================================
 * 
 * Source: Java concurrency in practice. Chapter 3. Sharing Objects
 * 
 */
public class Novisibility {

	private static boolean ready = false;

	private static int number = 0;

	// private static class ReaderThread extends Thread {
	// @Override
	// public void run() {
	// System.out.println("In reader");
	// while (!ready) {
	// Thread.yield();
	// }
	// System.out.println(number);
	// }
	// }
	//
	// public static void main(String[] args) {
	// ReaderThread rt = new ReaderThread();
	// rt.start();
	// try {
	// Thread.sleep(100);
	// } catch (InterruptedException e) {
	// e.printStackTrace();
	// }
	// number = 42;
	// ready = true;
	// // System.out.println("ready val: " + ready);
	// }
	public static void main(String[] args) {
		Runnable r = () -> {
			System.out.println("In reader");
			while (!ready) {
				Thread.yield();
			}
			System.out.println(number);
		};
		Thread rt = new Thread(r);
		rt.start();
		// try {
		// Thread.sleep(10);
		// } catch (InterruptedException e) {
		// e.printStackTrace();
		// }
		number = 42;
		ready = true;
	}
}
