package org.hackerrank;

public class StrangeCounter {

	public static void main(String[] args) {
		StrangeCounter sc = new StrangeCounter();
		long testTime = 1000000000000L; // 4;
		// sc.printValue(testTime); //
		System.out.println("==============================");
		long startValue = sc.getStartValue(testTime);
		// System.out.println("test time: " + testTime + ", start Value: " +
		// startValue);
		System.out.println("" + sc.getSpecificValue(testTime, startValue));
	}

	long getSpecificValue(final long testTime, final long startValue) {
		long result = 0L;
		long t = startValue - 2;
		long timeDiff = Math.abs(testTime - t);
		result = startValue - timeDiff;
		return result;
	}

	long getStartValue(long testTime) {
		long result = 0L;
		for (double i = 0; i <= testTime; ++i) {
			double val = 3 * Math.pow(2.0, i);
			// System.out.println("--> testtime: " + testTime + ", val: " +
			// val);
			if (val - 2 > testTime) {
				Double d = 3 * Math.pow(2.0, i - 1);
				result = d.longValue();
				break;
			}
		}
		return result;
	}

	// ====================================================================================

	void printTimeValue(long count) {
		long value = 3;
		long begin = 1;
		for (long k = 0; k < count; ++k) {
			System.out.println("-----------------------------------");
			for (long i = value; i >= 1; --i) {
				// System.out.println("t: " + begin + ", v: " + i);
				++begin;
			}
			value *= 2;
			System.out.println("t: " + begin + ", v: " + value + " = 3 * " + (value / 3));
		}
	}

	void printValue(final long time) {
		long value = 3;
		long t = 1;
		boolean flag = false;
		long result = 0;
		while (!flag) {
			for (long i = value; i >= 1; --i) {
				if (t == time) {
					flag = true;
					result = i;
				}
				++t;
			}
			value *= 2;
		}
		System.out.println("" + result);
	}

}
