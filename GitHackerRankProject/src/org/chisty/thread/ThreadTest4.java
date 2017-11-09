package org.chisty.thread;

public class ThreadTest4 implements Runnable {

	int id;

	public ThreadTest4(int id) {
		this.id = id;
	}

	@Override
	public void run() {
		System.out.println(id);
	}

	public static void main(String[] args) {
		Thread t1 = new Thread(new ThreadTest4(1));
		Thread t2 = new Thread(new ThreadTest4(2));
		t2.start();
		t1.run(); // Note: This line. Interesting ! When using run, looks like
		// this is always executed before the other thread that calls start
		// method
		System.out.println("main");

	}

}
