package org.chisty.thread;

public class ThreadTest3 extends Thread {
	int id;

	public ThreadTest3(int id) {
		this.id = id;
		start();
	}

	@Override
	// void run() { // Note: We must use public; otherwise compiletime error
	// shows up
	public void run() {
		System.out.println(id);
	}

	public static void main(String[] args) {
		Thread t = new Thread(new ThreadTest3(2));
		t.start();
		t.run(); // Note: This line. Interesting!!
		System.out.println("main");
	}

}
