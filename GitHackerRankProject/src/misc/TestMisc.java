package misc;

public class TestMisc {

	public static void main(String[] args) {

		String test = "dddddd";
		String first = "" + test.charAt(0);
		String regex = "[" + first + "]+";
		System.out.println("match ?" + test.matches(regex));

	}

}
