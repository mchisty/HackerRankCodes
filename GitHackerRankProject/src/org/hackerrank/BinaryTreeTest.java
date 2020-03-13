package org.hackerrank;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// TODO: Auto-generated Javadoc
// Input:
// 6
/**
 * The Class BinaryTreeTest.
 */
// 14 25 31 39 21 28 36 47 24 41 32

public class BinaryTreeTest {

	/**
	 * The main method.
	 *
	 * @param args
	 *            the arguments
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int a[] = new int[T];
		for (int i = 0; i < T; ++i) {
			int data = sc.nextInt();
			a[i] = data;
		}
		sc.close();
		BNode root = null;
		for (int i = 0; i < T; ++i) {
			root = insert(root, a[i]);
		}

		System.out.println("\n---------------------------------------------------------");

		System.out.println("root: " + root.data);
		System.out.println("###### Inorder traversal ###### ");
		printInOrder(root);
		System.out.println();
		System.out.println("###### Pre-order traversal ###### ");
		printPreOrder(root);
		System.out.println();

		int value = 35; // 14 25 31 39 21 28 36 47 24 41 32
		int closestValue = getClosestNode(root, value).data;
		System.out.println("\nClosest to " + value + " is " + closestValue);
		System.out.println("\n-------------- BFS --------------");
		traverseLevelOrder(root);

	}

	/**
	 * Insert.
	 * @param root
	 *            the root
	 * @param data
	 *            the data
	 * @return the b node
	 */
	public static BNode insert(BNode root, int data) {
		if (root == null) {
			root = new BNode(data);
		} else {
			BNode tmp = null;
			if (data <= root.data) {
				tmp = insert(root.left, data);
				root.left = tmp;
			} else {
				tmp = insert(root.right, data);
				root.right = tmp;
			}
		}

		return root;
	}

	/**
	 * Prints the in order.
	 *
	 * @param node
	 *            the node
	 */
	public static void printInOrder(BNode node) {
		if (node != null) {
			printInOrder(node.left);
			System.out.print(node.data + " ");
			printInOrder(node.right);
		}
	}

	public static void printPreOrder(BNode node) {
		if (node != null) {
			System.out.print(node.data + " ");
			printPreOrder(node.left);
			printPreOrder(node.right);
		}
	}

	/**
	 * BFS: This is another common type of traversal that visits all the nodes of a
	 * level before going to the next level.
	 * 
	 * This kind of traversal is also called level-order and visits all the levels
	 * of the tree starting from the root, and from left to right.
	 * 
	 * 
	 */
	public static void traverseLevelOrder(BNode root) {
		if (root == null) {
			return;
		}

		Queue<BNode> nodes = new LinkedList<>();
		nodes.add(root);

		while (!nodes.isEmpty()) {
			BNode node = nodes.remove();
			System.out.print(" " + node.data);
			if (node.left != null) {
				nodes.add(node.left);
			}
			if (node.right != null) {
				nodes.add(node.right);
			}
		}
	}

	/**
	 * Gets the closest node.
	 *
	 * @param head
	 *            the head
	 * @param data
	 *            the data
	 * @return the closest node
	 */
	public static BNode getClosestNode(BNode head, final int data) {
		BNode closestNode = null;
		int minDiff = Integer.MAX_VALUE;
		while (head != null) {
			int dist = Math.abs(head.data - data);
			if (dist < minDiff) {
				minDiff = dist;
				closestNode = head;
			}
			if (minDiff == 0) {
				break;
			}
			// if right is greater, then shift left
			if (head.data > data) {
				head = head.left;
			}
			// if left is greater, then shift right
			else {
				head = head.right;
			}
		}
		return closestNode;
	}

}

class BNode {
	BNode left;
	BNode right;
	int data;

	public BNode(int value) {
		this.data = value;
	}
}
