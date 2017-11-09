package misc;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * The Class ExecutableServiceTest. Executors are capable of running
 * asynchronous tasks and typically manage a pool of threads, so we don't have
 * to create new threads manually.
 */
public class ExecutableServiceTest {

	/**
	 * The main method.
	 *
	 * @param args
	 *            the arguments
	 */
	public static void main(String[] args) {
		ExecutableServiceTest et = new ExecutableServiceTest();
		et.executorTest1();
		et.executorTest2();
		et.executorTest3();
	}

	/**
	 * Executor test1.
	 */
	private void executorTest1() {
		ExecutorService executor = Executors.newSingleThreadExecutor();
		executor.submit(() -> {
			System.out.println("##### executorTest1 #####");
		});
		executor.shutdown();
	}

	/**
	 * Callable interfaces are just like Runnable interfaces but instead of
	 * being void they return a value. Callables can be submitted to executor
	 * services just like Runnables interfaces. But what about the Callable's
	 * result? Since submit() doesn't wait until the task completes, the
	 * executor service cannot return the result of the Callable directly.
	 * Instead the executor returns a special result of type Future which can be
	 * used to retrieve the actual result at a later point in time.
	 * 
	 */
	private void executorTest2() {
		try {
			System.out.println("##### executorTest2 #######");
			ExecutorService executor = Executors.newSingleThreadExecutor();
			Callable<String> c = () -> {
				Thread.sleep(1000);
				return "Hello Callable";
			};
			Future<String> future = executor.submit(c);
			System.out.println("Callable done? " + future.isDone());
			System.out.println("Value from callable: " + future.get());
			System.out.println("Callable done? " + future.isDone());
			executor.shutdown();
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
	}

	/**
	 * To test TimeoutException, we specified a maximum wait time of one second
	 * but the Callable actually needs two seconds before returning the result.
	 * 
	 * Expected output: To throw a TimeoutException
	 * 
	 */
	private void executorTest3() {
		try {
			System.out.println("##### executorTest3 #######");
			ExecutorService executor = Executors.newSingleThreadExecutor();
			Callable<String> c = () -> {
				// Try by commenting this line. No TimeoutException will be
				// shown
				Thread.sleep(2000);
				return "Hello Callable";
			};
			Future<String> future = executor.submit(c);
			future.get(1, TimeUnit.SECONDS);
			executor.shutdown();
		} catch (TimeoutException | InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
	}

}
