package org.hackerrank;

import java.util.Scanner;

// Input:
// 6
// 3 5 4 7 2 1
public class BinaryTreeTest {
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
	printInOrder(root);
    }

    public static BNode insert(BNode root, int data) {
	if (root == null) {
	    root = new BNode(data);
	} else {
	    BNode cur;
	    if (data <= root.data) {
		cur = insert(root.left, data);
		root.left = cur;
	    } else {
		cur = insert(root.right, data);
		root.right = cur;
	    }
	}
	// printInOrder(root);
	// System.out.println();
	return root;
    }

    public static void printInOrder(BNode node) {
	if (node != null) {
	    printInOrder(node.left);
	    System.out.print(node.data + " ");
	    printInOrder(node.right);
	}
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
