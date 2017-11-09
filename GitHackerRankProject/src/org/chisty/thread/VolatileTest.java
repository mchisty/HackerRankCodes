
package org.chisty.thread;

public class VolatileTest {

	// private static double n = 10;
	private volatile static double n = 10;

	public static void main(String[] args) throws InterruptedException {
		Runnable r1 = () -> {
			n = Math.pow(n, 2);
			System.out.println("changed by r1: " + n);
		};
		Thread t1 = new Thread(r1);
		t1.start();
		Runnable r2 = () -> {
			n = n - 50;
			System.out.println("changed by r2: " + n);
		};
		Thread t2 = new Thread(r2);
		// ---------------------------------------------
		t2.start();
		System.out.println(
				"With volatile --> r1 changed the value and flushed into memory with volatile. It will be read by r2. Expected result is 50 from r2. ");
	}
}
