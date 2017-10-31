package misc.crackingcode;

/**
 * Implement a method to perform basic string compression using the counts of
 * repeated characters. For example, the string aabcccccaaa would become
 * a2bc5a3.
 * 
 */
public class CompressStringTest {
	/**
	 * The main method.
	 *
	 * @param args
	 *            the arguments
	 */
	public static void main(String[] args) {
		String sarr[] = { "a", "abc", "aabcccccaaa", "aabaaa" };
		for (String s : sarr) {
			System.out.println(s + ": " + getCompressedString(s));
		}
	}

	/**
	 * Gets the compressed string.
	 *
	 * @param s
	 *            the s
	 * @return the compressed string
	 */
	private static String getCompressedString(String s) {
		int count = 1;
		StringBuilder sb = new StringBuilder();
		char first = s.charAt(0);
		char c[] = s.toCharArray();
		for (int i = 1; i < c.length; ++i) {
			if (c[i] == first) {
				++count;
			} else {
				sb.append(first);
				if (count > 1) {
					sb.append(count);
				}
				first = c[i];
				count = 1;
			}
		}
		sb.append(first);
		if (count > 1) {
			sb.append(count);
		}
		return sb.toString();
	}
}
