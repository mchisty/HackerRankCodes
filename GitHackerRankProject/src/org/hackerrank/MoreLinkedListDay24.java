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
			// head = m.insertAtEnd(head, ele);
			head = m.insertAtTail(head, ele);
		}
		sc.close();
		// int data = 3;
		// head = m.remove(head, data);
		// head = m.removeDuplicates(head);

		m.display(head);

		System.out.println("Insert node at nth position");
		m.insertNodeAtNthPostion(head, 5, 2);
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
	// My solution to insert at Tail
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

	Node insertNodeAtNthPostion(Node head, int data, int position) {
		if (head == null) {
			head = new Node(data);
			return head;
		}
		while (position > 0) {
			insertNodeAtNthPostion(head.next, data, --position);
		}
		System.out.println("current head.data: " + head.data);
		Node newNode = new Node(data);
		newNode.next = head.next;

		// head.data = data;
		head.next = newNode;
		return head;
		// -------------------------
		// Node trackedHeadNode = head;
		//
		// Node nodeToInsert = new Node(data);
		//
		// // Empty List - Returned newly created node or null
		// if (head == null) {
		// return nodeToInsert;
		// }
		//
		// // Inserting a Node ahead of the List
		// if (position == 0) {
		// nodeToInsert.next = head;
		// return nodeToInsert;
		// }
		//
		// // Traverse the Singly Linked List to 1 Position Prior
		// // Stop traversing if you reached the end of the List
		// int currPosition = 0;
		//
		// while (currPosition < position - 1 && head.next != null) {
		// head = head.next;
		// currPosition++;
		// }
		//
		// // Inserting a Node in-between a List or at the end of of a List
		// Node nodeAtPosition = head.next;
		// head.next = nodeToInsert;
		// head = head.next;
		// head.next = nodeAtPosition;
		//
		// return trackedHeadNode;
	}

}
