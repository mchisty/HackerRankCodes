package org.hackerrank;

import java.util.Scanner;

// TODO: Auto-generated Javadoc
/**
 * The Class MoreLinkedListDay24.
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
			// head = insertAtEnd(head, ele);
			head = m.insert1(head, ele);
		}
		sc.close();
		head = m.removeDuplicates(head);
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
	 * Removes the duplicates.
	 *
	 * @param head
	 *            the head
	 * @return the node
	 */
	// My solution to remove
	public Node removeDuplicates(Node head) {
		// Write your code here
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
}
