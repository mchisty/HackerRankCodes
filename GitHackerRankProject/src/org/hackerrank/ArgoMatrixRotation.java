package org.hackerrank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

// Works fine, just timeout issue:
public class ArgoMatrixRotation {
    final static String TOP_TO_BOTTOM = "LEFT";
    final static String LEFT_TO_RIGHT = "BOTTOM";
    final static String BOTTOM_TO_TOP = "RIGHT";
    final static String RIGHT_TO_LEFT = "TOP";
    Map<String, List<Integer>> map = new HashMap<>();

    public ArgoMatrixRotation() {
    }

    // Row associates X direction. row = X
    // Column associates Y direction. col = Y
    /**
     * ----------------- > Y <br/>
     * 
     * | <br/>
     * | <br/>
     * | <br/>
     * | <br/>
     * | <br/>
     * | <br/>
     * 
     * 
     * \|/
     * 
     * X
     * 
     */
    public static void main(String[] args) {
	ArgoMatrixRotation mt = new ArgoMatrixRotation();
	// // mt.takeInput(in);
	// mt.readInputFromFile();
	// in.close();
	// mt.calculate();
	int startY = 0;
	int startX = 0;
	int row = 10;
	int col = 8;
	int numberOfRotations = 40;
	int[][] a = new int[row][col];
	Random r = new Random();
	// populate sample data
	for (int x = 0; x < row; ++x) {
	    for (int y = 0; y < col; ++y) {
		a[x][y] = r.nextInt(1000) + r.nextInt(500);
	    }
	}
	System.out.println("========================== Sample array ======================");
	for (int x = 0; x < row; ++x) {
	    for (int y = 0; y < col; ++y) {
		System.out.print("\t" + a[x][y]);
	    }
	    System.out.println();
	}
	System.out.println("==============================================================");
	// numberOfRotations = mt.getActualNumberOfRotations(row, col, numberOfRotations);
	int fullRotation = (row - 1) * 2 + (col - 1) * 2;
	System.out.println("number of max rotations (outer boundary):" + fullRotation);
	for (int n = 0; n < numberOfRotations; ++n) {
	    mt.performOneShift(a, startX, startY, row, col);
	}
	for (int x = 0; x < row; ++x) {
	    for (int y = 0; y < col; ++y) {
		System.out.print("\t" + a[x][y]);
	    }
	    System.out.println();
	}
	// ========================================================
	// Actual Scanner input
	// Scanner in = new Scanner(System.in);
	// int row = in.nextInt();
	// int col = in.nextInt();
	// int numberOfRotations = in.nextInt();
	// int[][] a = new int[row][col];
	// // input sample data
	// for (int x = 0; x < row; ++x) {
	// for (int y = 0; y < col; ++y) {
	// a[x][y] = in.nextInt();
	// }
	// }
	// numberOfRotations = mt.getActualNumberOfRotations(row, col, numberOfRotations);
	// for (int n = 0; n < numberOfRotations; ++n) {
	// mt.performOneShift(a, 0, 0, row, col);
	// }
	// for (int x = 0; x < row; ++x) {
	// for (int y = 0; y < col; ++y) {
	// System.out.print(a[x][y] + " ");
	// }
	// System.out.println();
	// }
    }

    int getActualNumberOfRotations(int row, int col, int numberOfRoations) {
	int fullRotation = (row - 1) * 2 + (col - 1) * 2;
	if (numberOfRoations > fullRotation) {
	    numberOfRoations = numberOfRoations % fullRotation;
	}
	return numberOfRoations;
    }

    private void performOneShift(int[][] a, int startX, int startY, int row, int col) {
	if (isOneShiftValidForCurrentPosition(startX, startY, row, col)) {
	    // Top to bottom
	    List<Integer> topToBottom = map.get(TOP_TO_BOTTOM);
	    int[] topToBottomOriginal = new int[topToBottom.size()];
	    int k = 0;
	    for (Integer i : topToBottom) {
		topToBottomOriginal[k++] = a[i - 1][startY];
	    }
	    // Left to right
	    List<Integer> leftToRight = map.get(LEFT_TO_RIGHT);
	    int[] leftToRightOriginal = new int[leftToRight.size()];
	    k = 0;
	    for (Integer i : leftToRight) {
		leftToRightOriginal[k++] = a[row - 1][i - 1];
	    }
	    // Bottom to top
	    List<Integer> bottomToTop = map.get(BOTTOM_TO_TOP);
	    int[] bottomToTopOriginal = new int[bottomToTop.size()];
	    k = 0;
	    for (Integer i : bottomToTop) {
		bottomToTopOriginal[k++] = a[i + 1][col - 1];
	    }
	    // Right to left
	    List<Integer> rightToLeft = map.get(RIGHT_TO_LEFT);
	    int[] rightToLeftOriginal = new int[rightToLeft.size()];
	    k = 0;
	    for (Integer i : rightToLeft) {
		rightToLeftOriginal[k++] = a[startX][i + 1];
	    }
	    // Update the values in a[][]
	    // top to bottom
	    k = 0;
	    for (Integer i : topToBottom) {
		a[i][startY] = topToBottomOriginal[k++];
	    }
	    // left to right
	    k = 0;
	    for (Integer i : leftToRight) {
		a[row - 1][i] = leftToRightOriginal[k++];
	    }
	    // bottom to top
	    k = 0;
	    for (Integer i : bottomToTop) {
		a[i][col - 1] = bottomToTopOriginal[k++];
	    }
	    // right to left
	    k = 0;
	    for (Integer i : rightToLeft) {
		a[startX][i] = rightToLeftOriginal[k++];
	    }
	    startX = startX + 1;
	    startY = startY + 1;
	    row = row - 1;
	    col = col - 1;
	    performOneShift(a, startX, startY, row, col);
	}
    }

    /**
     * The idea here is to check if, after shifting cell one position, it matches with one of the list items. If so,
     * then do the shifting; otherwise don't.
     */
    boolean isOneShiftValidForCurrentPosition(int currentX, int currentY, int expectedRow, int expectedCol) {
	map = getAllValidInnerPositions(currentX, currentY, expectedRow, expectedCol);
	if (map.get(TOP_TO_BOTTOM).isEmpty()) {
	    return false;
	} else if (map.get(LEFT_TO_RIGHT).isEmpty()) {
	    return false;
	} else if (map.get(BOTTOM_TO_TOP).isEmpty()) {
	    return false;
	} else if (map.get(RIGHT_TO_LEFT).isEmpty()) {
	    return false;
	}
	return true;
    }

    Map<String, List<Integer>> getAllValidInnerPositions(int currentX, int currentY, int expectedRow, int expectedCol) {
	map.clear();
	// Top to bottom
	List<Integer> a = new ArrayList<>();
	for (int i = currentX + 1; i < expectedRow; ++i) {
	    a.add(i);
	}
	map.put(TOP_TO_BOTTOM, a);
	// Left to right
	a = new ArrayList<>();
	for (int i = currentY + 1; i < expectedCol; ++i) {
	    a.add(i);
	}
	map.put(LEFT_TO_RIGHT, a);
	// Bottom to top
	a = new ArrayList<>();
	for (int i = expectedRow - 2; i >= currentX; --i) {
	    a.add(i);
	}
	map.put(BOTTOM_TO_TOP, a);
	// Right to left
	a = new ArrayList<>();
	for (int i = expectedCol - 2; i >= currentY; --i) {
	    a.add(i);
	}
	map.put(RIGHT_TO_LEFT, a);
	return map;
    }
}
