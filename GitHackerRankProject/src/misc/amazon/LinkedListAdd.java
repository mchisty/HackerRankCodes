package misc.amazon;

/**
 * 
 * You have two numbers represented by a linked list, where each node contains a
 * single digit. The digits are stored in reverse order, such that the Ts digit
 * is at the head of the list. Write a function that adds the two numbers and
 * returns the sum as a linked list.
 * 
 * <br/>
 * EXAMPLE <br/>
 * 
 * Input: (7-> 1 -> 6) + (5 -> 9 -> 2). That is, 617 + 295. <br/>
 * 
 * Output: 2 -> 1 -> 9. That is, 912.
 * 
 * 
 */
public class LinkedListAdd {
	MyLinkedList resultList = null;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedListAdd la = new LinkedListAdd();
		la.calculate();
	}

	void calculate() {
		MyLinkedList list1 = new MyLinkedList(7);
		list1.next = new MyLinkedList(1);
		list1.next.next = new MyLinkedList(6);
		// ---------------------------------
		MyLinkedList list2 = new MyLinkedList(5);
		list2.next = new MyLinkedList(9);
		list2.next.next = new MyLinkedList(2);
		MyLinkedList result = getSum(list1, list2, 0);
		while (result != null) {
			System.out.print(result.data);
			result = result.next;
		}
	}

	private MyLinkedList getSum(MyLinkedList l_1, MyLinkedList l_2, int carry) {
		// Use mod 10 to find the carry over
		if (l_1 == null && l_2 == null) {
			return null;
		}
		int value = carry;
		if (l_1 != null) {
			value += l_1.data;
		}
		if (l_2 != null) {
			value += l_2.data;
		}
		if (null == resultList) {
			resultList = new MyLinkedList(value % 10);
		}
		if (l_1 != null || l_2 != null) {
			resultList.next = getSum(l_1 == null ? null : l_1.next, l_2 == null ? null : l_2.next, value >= 10 ? 1 : 0);
		}
		return resultList;
	}

	private class MyLinkedList {
		int data;

		MyLinkedList next;

		public MyLinkedList(int data) {
			this.data = data;
			this.next = null;
		}
	}
}
