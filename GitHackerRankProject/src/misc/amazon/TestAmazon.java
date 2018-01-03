package misc.amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestAmazon {

	final static String ORANGE = "orange";
	final static String BANANA = "banana";
	final static String APPLE = "apple";
	final static String ANYTHING = "anything";

	public static void main(String[] args) {
		List<String> cart1 = Arrays.asList(ORANGE, APPLE, APPLE, BANANA, ORANGE, BANANA);
		List<String> cart2 = Arrays.asList(BANANA, ORANGE, BANANA, APPLE, APPLE);
		List<String> cart3 = Arrays.asList(APPLE, BANANA, APPLE, BANANA, ORANGE, BANANA);

		final List<List<String>> codeList = new ArrayList<>();
		codeList.add(Arrays.asList(APPLE, APPLE));
		codeList.add(Arrays.asList(BANANA, ANYTHING, BANANA));

		TestAmazon ta = new TestAmazon();
		int val = ta.checkWinner(codeList, cart3);
		System.out.println(val);
	}

	public TestAmazon() {

	}

	public int checkWinner(List<List<String>> codeList, List<String> shoppingCart) {
		boolean flag = false;
		// ---------------------
		List<String> updatedCodes = new ArrayList<>();
		for (List<String> group : codeList) {
			updatedCodes.addAll(group);
		}
		flag = partition(updatedCodes, shoppingCart);

		return flag ? 1 : 0;
	}

	public boolean partition(List<String> group, List<String> cart) {
		if (cart.size() < group.size()) {
			return false;
		}
		for (int i = 0; i < cart.size(); ++i) {
			for (int j = i + 1; j <= cart.size(); ++j) {
				List<String> sub = cart.subList(i, j);
				if (sub.size() <= group.size() && sub.equals(group)) {
					System.out.println("Matching group:" + group + " And in cart:" + sub);
					return true;
				} else if (sub.size() == group.size() && group.contains(ANYTHING) && matchByExactIndexPos(group, sub)) {
					System.out.println("Other match anything group: " + group + "; cart: " + sub);
					return true;
				}
			}
		}

		return false;

	}

	private boolean matchByExactIndexPos(List<String> group, List<String> sub) {
		boolean flag = true;
		for (int i = 0; i < group.size(); ++i) {
			if (!group.get(i).equals(sub.get(i)) && !group.get(i).equals(ANYTHING)) {
				flag = false;
			}
		}
		return flag;
	}

}
