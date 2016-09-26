package misc.thread;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

public class BlockingDequeExample {

	public static void main(String[] args) throws InterruptedException {
		BlockingDeque<Integer> dq = new LinkedBlockingDeque<Integer>();
		dq.add(2);
		dq.add(3);
		dq.add(4);
		dq.add(5);

		dq.addFirst(1);
		dq.addLast(99);
		dq.forEach(i -> System.out.print(i + " "));
		dq.takeLast();
		dq.takeLast();
		dq.takeLast();
		System.out.println("\nAfter removal .... ");
		dq.forEach(i -> System.out.print(i + " "));

	}

	private void test() {

	}

}
