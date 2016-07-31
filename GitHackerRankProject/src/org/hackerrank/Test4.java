package org.hackerrank;

public final class Test4 {
    class Inner {
	Class c;
	Object o;

	void test() {
	    if (Test4.this.flag)
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

    public Test4() {
	(new Inner()).test();
    }

    public static void main(String args[]) {
	new Test4();
    }
}