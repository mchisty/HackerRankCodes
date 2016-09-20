package misc.crackingcode;

/**
 * Write a method to replace all spaces in a string with '%20'. You may assume
 * that the string has sufficient space at the end of the string to hold the
 * additional characters, and that you are given the "true" length of the string
 *
 */
public class ReplaceWhiteSpaceTest {
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		String s = "This is a  test";
		// System.out.println(getUpdatedString(s.toCharArray(), 20));
		System.out.println(getUpdatedString(s));
	}

	/**
	 * Gets the updated string.
	 *
	 * @param c the c
	 * @param length the length
	 * @return the updated string
	 */
	// Does not work
	private static String getUpdatedString(char[] c, int length) {
		int spcaeCount = 0, newLength, i;
		for (i = 0; i < length; ++i) {
			if (c[i] == ' ') {
				spcaeCount++;
			}
		}
		newLength = length + spcaeCount * 2;
		c[newLength] = '\0';
		for (i = length - 1; i >= 0; i--) {
			if (c[i] == ' ') {
				c[newLength - 1] = '0';
				c[newLength - 2] = '2';
				c[newLength - 3] = '%';
				newLength = newLength - 3;
			} else {
				c[newLength - 1] = c[i];
				newLength = newLength - 1;
			}
		}
		return new String(c);
	}

	/**
	 * Gets the updated string.
	 *
	 * @param s the s
	 * @return the updated string
	 */
	// My solution
	private static String getUpdatedString(String s) {
		StringBuilder sb = new StringBuilder();
		for (char c : s.toCharArray()) {
			if (c == ' ') {
				sb.append("%20");
			} else {
				sb.append(c);
			}
		}
		return sb.toString();
	}
}
