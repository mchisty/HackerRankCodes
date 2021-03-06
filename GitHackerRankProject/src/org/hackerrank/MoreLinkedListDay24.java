package org.hackerrank;

import java.util.Scanner;

// TODO: Auto-generated Javadoc
/**
 * The Class MoreLinkedListDay24.
 * 
 * <br/>
 * 
 * Task: A removeDuplicates function is declared in your editor, which takes a
 * pointer to the node of a linked list as a parameter. Complete
 * removeDuplicates so that it deletes any duplicate nodes from the list and
 * returns the head of the updated list.
 * 
 * Note: The data elements of the linked list argument will always be in
 * non-decreasing order.
 * 
 */
public class MoreLinkedListDay24 {
	/**
	 * Instantiates a new more linked list day24.
	 */
	public MoreLinkedListDay24() {
	}

	/**
	 * The main method.
	 *
	 * @param args
	 *            the arguments
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Node head = null;
		int T = sc.nextInt();
		MoreLinkedListDay24 m = new MoreLinkedListDay24();
		for (int i = 0; i < T; ++i) {
			int ele = sc.nextInt();
			head = m.insertAtEnd(head, ele);
			// head = m.insertAtTail(head, ele);
		}
		sc.close();
		int data = 4;
		// head = m.remove(head, data);
		// head = m.removeDuplicates(head);

		// m.display(head);

		int Nth = 0;
		// System.out.println("\nInsert node at " + Nth + "th position");
		// head = m.insertAtHead(head, data);
		// head = m.insertNodeAtNthPostion(head, data, Nth);
		// head = m.removeNodeAtNthPostion(head, Nth);
		// m.displayReverseOrder(head);
		head = m.getReversedNode(head);
		m.display(head);
	}

	/**
	 * Display.
	 *
	 * @param head
	 *            the head
	 */
	public void display(Node head) {
		Node start = head;
		while (start != null) {
			System.out.print(start.data + " ");
			start = start.next;
		}
	}

	/**
	 * Insert at end: without recursion.
	 *
	 * @param head
	 *            the head
	 * @param data
	 *            the data
	 * @return the node
	 */
	public Node insertAtEnd(final Node head, int data) {
		Node newNode = new Node(data);
		if (head == null) {
			return newNode;
		} else if (head.next == null) {
			head.next = newNode;
		} else {
			Node start = head;
			while (start.next != null) {
				start = start.next;
			}
			start.next = newNode;
		}
		return head;
	}

	/**
	 * Insert at end: using recursion.
	 *
	 * @param head
	 *            the head
	 * @param data
	 *            the data
	 * @return the node
	 */
	public Node insertAtTail(Node head, int data) {
		if (head == null) {
			head = new Node(data);
			return head;
		}
		if (head.next == null) {
			head.next = new Node(data);
		} else {
			insertAtTail(head.next, data);
		}
		return head;
	}

	/**
	 * Insert at head.
	 *
	 * @param head
	 *            the head
	 * @param data
	 *            the data
	 * @return the node
	 */
	public Node insertAtHead(Node head, int data) {
		if (head == null) {
			head = new Node(data);
			return head;
		}
		Node tmp = head;
		head = new Node(data);
		head.next = tmp;
		return head;
	}

	/**
	 * Removes the duplicates. Assume data is already sorted in ascending order.
	 *
	 * @param head
	 *            the head
	 * @return the node
	 */
	// My solution to remove
	public Node removeDuplicates(Node head) {
		if (head.next == null) {
			return head;
		}
		if (head.data == head.next.data) {
			head.next = head.next.next;
			removeDuplicates(head);
		} else {
			removeDuplicates(head.next);
		}
		return head;
	}

	// ---------------------------------------------
	// Additional methods: just for fun
	/**
	 * Removes the.
	 *
	 * @param head
	 *            the head
	 * @param data
	 *            the data
	 * @return the node
	 */
	// ---------------------------------------------
	Node remove(final Node head, int data) {
		// A temporary variable used for calculation
		Node tmp = head;
		if (tmp.data == data) {
			return head.next;
		}
		while (tmp.next != null) {
			if (tmp.next.data == data) {
				tmp.next = tmp.next.next;
				return head; /* head didn't change */
			}
			tmp = tmp.next;
		}
		return head;
	}

	/**
	 * Insert node at nth postion.
	 *
	 * @param head
	 *            the head
	 * @param data
	 *            the data
	 * @param position
	 *            the position
	 * @return the node
	 */
	Node insertNodeAtNthPostion(Node head, int data, int position) {
		Node newNode = new Node(data);
		if (head == null) {
			return newNode;
		}

		if (position == 0) {
			newNode.next = head;
			return newNode;
		}
		// -----------------------------------------------------------------------
		// Interesting point: head is copied in current. Now whatever action is
		// done on current, the changes are reflected in the head
		// -----------------------------------------------------------------------
		Node current = head;
		while (position - 1 > 0) {
			current = current.next;
			position--;
		}
		newNode.next = current.next;
		current.next = newNode;
		return head;
	}

	/**
	 * Removes the node at nth postion.
	 *
	 * @param head
	 *            the head
	 * @param position
	 *            the position
	 * @return the node
	 */
	Node removeNodeAtNthPostion(Node head, int position) {
		if (position == 0) {
			return head.next;
		}
		Node current = head;

		while (position - 1 > 0) {
			current = current.next;
			position--;
		}
		current.next = current.next.next;
		return head;
	}

	void displayReverseOrder(Node head) {
		if (head != null) {
			displayReverseOrder(head.next);
			System.out.println(head.data);
		}
	}

	Node getReversedNode(Node head) {
		// With recursion
		// if (head == null || head.next == null) {
		// return head;
		// }
		// Node second = head.next;
		// head.next = null;
		// Node tmp = getReversedNode(second);
		// System.out.println("second: " + second.data + ", head:" + head.data);
		// second.next = head;
		// return tmp;
		// -------------------------------------
		// Without recursion
		if (head == null || head.next == null) {
			return head;
		}

		Node p1 = head;
		Node p2 = p1.next;

		head.next = null;
		while (p1 != null && p2 != null) {
			Node t = p2.next;
			p2.next = p1;
			p1 = p2;
			p2 = t;
		}

		return p1;

	}

}
