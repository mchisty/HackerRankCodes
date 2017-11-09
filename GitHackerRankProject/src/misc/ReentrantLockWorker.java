
package misc;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockWorker implements Runnable {

	private String name;

	private ReentrantLock re;

	public ReentrantLockWorker(String n, ReentrantLock r) {
		this.name = n;
		this.re = r;
	}

	@Override
	public void run() {
		boolean done = false;
		SimpleDateFormat sd = new SimpleDateFormat("hh:mm:ss");
		while (!done) {
			boolean isFree = re.tryLock();
			if (isFree) {
				try {
					System.out.println("*** Lock acquired by task: " + name + " at the time: "
							+ sd.format(Calendar.getInstance().getTimeInMillis()));
					Thread.sleep(200);
					System.out.println("Lock Hold Count:" + re.getHoldCount());
					done = true;
				} catch (InterruptedException e) {
					e.printStackTrace();
				} finally {
					re.unlock();
					System.out.println("task: " + name + " work done, Releasing lock.");
					System.out.println("----------------------------------------------------");
				}
			} else {
				System.out.println("task name - " + name + " waiting for lock");
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
