package org.hackerrank;

/**
 * Sample input:
 * 
 * ojowrdcpavatfacuunxycyrmpbkvaxyrsgquwehhurnicgicmrpmgegftjszgvsgqavcrvdtsxlkxjpqtlnkjuyraknwxmnthfpt
 * <br/>
 * 685118368975
 * 
 * 
 * Expected output:
 * 
 * 41107102139
 * 
 * @author isadmlc
 *
 */
public class RepeatedString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RepeatedString rs = new RepeatedString();
		String s = "ojowrdcpavatfacuunxycyrmpbkvaxyrsgquwehhurnicgicmrpmgegftjszgvsgqavcrvdtsxlkxjpqtlnkjuyraknwxmnthfpt";
		long n = 685118368975L;
		long count = rs.getTotalCount(s, n);
		System.out.println(count);
	}

	private long getTotalCount(final String s, final long n) {
		if (s == null || s.isEmpty()) {
			return 0;
		}
		if (s.equals("a")) {
			return n;
		}

		final long number = n / s.length();
		long count = getNumberOfAsInString(s) * number;

		long remainder = (n % (s.length())); // Math.floorMod((int) n,
												// s.length());
		String remainingStr = s.substring(0, (int) remainder);

		// ---------------
		// get count
		// ---------------
		count = count + getNumberOfAsInString(remainingStr);

		return count;
	}

	private int getNumberOfAsInString(final String s) {
		int count = 0;
		int idx = 0;
		while ((idx = s.indexOf("a", idx)) != -1) {
			idx++;
			count++;
		}
		return count;
	}

}
