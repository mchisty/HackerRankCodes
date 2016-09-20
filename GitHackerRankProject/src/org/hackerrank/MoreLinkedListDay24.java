package org.hackerrank;

import java.util.Scanner;

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
			// head = m.insert1(head, ele);
		}
		sc.close();
		int data = 3;
		head = m.remove(head, data);
		// head = m.removeDuplicates(head);
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
	 * Insert at end.
	 *
	 * @param head
	 *            the head
	 * @param data
	 *            the data
	 * @return the node
	 */
	public Node insertAtEnd(final Node head, int data) {
		Node current = new Node(data);
		if (head == null) {
			return current;
		} else if (head.next == null) {
			head.next = current;
		} else {
			Node start = head;
			while (start.next != null) {
				start = start.next;
			}
			start.next = current;
		}
		return head;
	}

	/**
	 * Insert1.
	 *
	 * @param head
	 *            the head
	 * @param data
	 *            the data
	 * @return the node
	 */
	// My solution to insert
	public Node insert1(Node head, int data) {
		if (head == null) {
			head = new Node(data);
			return head;
		}
		if (head.next == null) {
			head.next = new Node(data);
		} else {
			insert1(head.next, data);
		}
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
}
