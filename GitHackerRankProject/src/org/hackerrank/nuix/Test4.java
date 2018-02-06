package org.hackerrank.nuix;

public class Test4 {

	class Inner {
		void test() {
			if (Test4.this.flag) {
				sample();
			}
		}
	}

	private boolean flag = true;

	public void sample() {
		System.out.println("Sample");
		String s = "123";
		Integer.parseInt(s);
	}

	public Test4() {
		(new Inner()).test();
	}

	public static void main(String[] args) {
		new Test4();

	}

}
