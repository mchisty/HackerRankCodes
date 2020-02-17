package misc.amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Class SoluionSecretCodeShoppingCart.
 */
public class SoluionSecretCodeShoppingCart {

	/** The Constant ANYTHING. */
	private final static String APPLE = "apple", BANNANA = "bannana", ORANGE = "orange", ANYTHING = "anything";

	/**
	 * The main method.
	 *
	 * @param args
	 *            the arguments
	 */
	public static void main(String[] args) {
		List<String> l1 = Arrays.asList(APPLE, APPLE);
		List<String> l2 = Arrays.asList(BANNANA, ANYTHING, BANNANA);
		List<List<String>> codeList = new ArrayList<>();
		codeList.add(l1);
		codeList.add(l2);
		System.out.println("Codelist: ");
		codeList.stream().forEach(s -> System.out.println(s.toString()));
//		List<String> shoppingCart = Arrays.asList(ORANGE, APPLE, APPLE, BANNANA, ORANGE, BANNANA); // true, 1
		List<String> shoppingCart = Arrays.asList(BANNANA, ORANGE, APPLE, APPLE, BANNANA, BANNANA, BANNANA, ORANGE,
				BANNANA); // true, 1
//		List<String> shoppingCart = Arrays.asList(BANNANA, ORANGE, BANNANA, ORANGE, APPLE, APPLE); // false, 0
		// List<String> shoppingCart = Arrays.asList(BANNANA, ORANGE, BANNANA); // false, 0
		// List<String> shoppingCart = Arrays.asList(APPLE, APPLE); // false, 0
		// List<String> shoppingCart = Arrays.asList(BANNANA, ORANGE, BANNANA, ORANGE, APPLE, APPLE, BANNANA, ORANGE,
		// BANNANA); // true, 1

		SoluionSecretCodeShoppingCart s = new SoluionSecretCodeShoppingCart();
		System.out.println("Winner? : " + s.checkWinner(codeList, shoppingCart));
	}

	/**
	 * Check winner.
	 *
	 * @param codeList
	 *            the code list
	 * @param shoppingCart
	 *            the shopping cart
	 * @return the int
	 */
	int checkWinner(List<List<String>> codeList, List<String> shoppingCart) {
//		System.out.println("Shopping cart: " + shoppingCart.toString());
		int cartItemIndexPos = 0;
		boolean flag = true;

		final boolean flagList[] = new boolean[codeList.size()];

		outer: for (int codeGroupIndex = 0; codeGroupIndex < codeList.size(); ++codeGroupIndex) {
			List<String> items = codeList.get(codeGroupIndex);
			System.out.println("[b] items: " + items.toString());
			for (int i = 0; i < items.size();) {
				if (cartItemIndexPos >= shoppingCart.size()) {
					break;
				}
				if (i < items.size() - 1 && cartItemIndexPos < shoppingCart.size() - 1
						&& itemsMatch(items.get(i), shoppingCart.get(cartItemIndexPos))) {
					i += 1;
					cartItemIndexPos += 1;
					flag = (i == items.size() - 1);
					flagList[codeGroupIndex] = flag;
					// If full match found for current list-of-items, no need to check further. Continue with the next
					// list-of-items
					if (flag) {
						continue outer;
					}
				} else if (i == 0) {
					cartItemIndexPos += 1;
					flag = false;
				} else {
					i = 0;
					flag = false;
				}
			}

		}

		flag = true;
		for (boolean b : flagList) {
			flag = flag && b;
		}
		return flag ? 1 : 0;
	}

	/**
	 * Items match.
	 *
	 * @param codeItem
	 *            the code item
	 * @param cartItem
	 *            the cart item
	 * @return true, if successful
	 */
	private boolean itemsMatch(String codeItem, String cartItem) {
		if (codeItem.equals(cartItem)) {
			return true;
		}
		if (codeItem.equals(ANYTHING)
				&& (Arrays.asList(APPLE, BANNANA, ORANGE).stream().anyMatch(i -> i.equals(cartItem)))) {
			return true;
		}
		return false;
	}

}
