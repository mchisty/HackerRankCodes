
package misc;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class ThreadTest {

	public static void main(String[] args) {
		// ---------------------------------------
		// Typical style (without Executors)
		// ---------------------------------------
		Runnable r = () -> {
			String threadName = Thread.currentThread().getName();
			System.out.println("Hello (old style): " + threadName);
		};
		r.run();
		// ---------------------------------------
		// Updated style (with Executors)
		// ---------------------------------------
		ExecutorService executor = Executors.newSingleThreadExecutor();
		executor.submit(() -> {
			String threadName = Thread.currentThread().getName();
			System.out.println("Hello (new style):" + threadName);
		});
		// ---------------------------------------
		// Another thread with typical approach
		// ---------------------------------------
		Thread thread = new Thread(r, "SecondThread");
		thread.start();
		System.out.println("Done!");
		// ---------------------------------------
		// Executors need to be shutdown explicitly
		// ---------------------------------------
		try {
			System.out.println("Shutting down executor");
			executor.shutdown();
			executor.awaitTermination(2, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			System.err.println("tasks interrupted");
		} finally {
			if (!executor.isTerminated()) {
				System.err.println("cancel non-finished tasks");
			}
			executor.shutdownNow();
			System.out.println("shutdown finished");
		}
		// ---------------------------------------
		// Using Callable instead Runnable
		// ---------------------------------------
		Callable<Integer> callableTask = () -> {
			String threadName = Thread.currentThread().getName();
			System.out.println("(Callable) Hello " + threadName);
			return 12345;
		};
		ExecutorService executor1 = Executors.newFixedThreadPool(1);
		Future<Integer> future = executor1.submit(callableTask);
		System.out.println("future done? " + future.isDone());
		try {
			Integer result = future.get();
			System.out.println("future done? " + future.isDone());
			System.out.print("result: " + result);
			executor1.shutdown();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
	}
}
