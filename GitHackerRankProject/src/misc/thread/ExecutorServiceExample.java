package misc.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorServiceExample {

	public static void main(String[] args) {
		try {
			// ------------------------------------------------------------------------------------------------------------
			// Not Returning anything with Runnable
			// ------------------------------------------------------------------------------------------------------------
			ExecutorService executorService = Executors.newSingleThreadExecutor();

			executorService.execute(new Runnable() {
				public void run() {
					System.out.println("Asynchronous task");
				}
			});
			executorService.shutdown();
			// ------------------------------------------------------------------------------------------------------------
			// Return value with Runnable
			// ------------------------------------------------------------------------------------------------------------
			Future<?> future = executorService.submit(new Runnable() {
				public void run() {
					System.out.println("Asynchronous task");
				}
			});

			System.out.println(future.get()); // returns null if the task has finished correctly.

			// ------------------------------------------------------------------------------------------------------------
			// Return value with Callable
			// ------------------------------------------------------------------------------------------------------------

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
