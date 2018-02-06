package org.hackerrank.nuix;

public final class Test3 {
	class Inner {
		Class c;
		Object o;

		void test() {
			if (Test3.this.flag)
				;
			{
				sample();
			}
		}
	}

	private final boolean flag = true;

	public void sample() {
		System.out.println("Sample");
	}

	public Test3() {
		(new Inner()).test();
	}

	public static void main(String args[]) {
		new Test3();
	}
}