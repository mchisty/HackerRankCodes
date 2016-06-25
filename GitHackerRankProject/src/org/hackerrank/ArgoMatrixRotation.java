package org.hackerrank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

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
    // Testing with hardcoded sample data
    // final int row = 10;
    // final int col = 8;
    // int numberOfRotations = 40;
    // int[][] a = new int[row][col];
    // Random r = new Random();
    // // populate sample data
    // for (int x = 0; x < row; ++x) {
    // for (int y = 0; y < col; ++y) {
    // a[x][y] = r.nextInt(1000) + r.nextInt(500);
    // }
    // }
    // System.out.println("========================== Sample array ======================");
    // for (int x = 0; x < row; ++x) {
    // for (int y = 0; y < col; ++y) {
    // System.out.print("\t" + a[x][y]);
    // }
    // System.out.println();
    // }
    // System.out.println("==============================================================");
    // numberOfRotations = mt.getActualNumberOfRotations(row, col, numberOfRotations);
    // for (int n = 0; n < numberOfRotations; ++n) {
    // mt.performOneShift(a, 0, 0, row, col);
    // }
    // Update number of rotations and start positions
    // numberOfRotations = numberOfRotations * 2;
    // for (int n = 0; n < numberOfRotations; ++n) {
    // mt.performOneShift(a, 1, 1, row - 1, col - 1);
    // }
    // // print values
    // for (int x = 0; x < row; ++x) {
    // for (int y = 0; y < col; ++y) {
    // System.out.print("\t" + a[x][y]);
    // }
    // System.out.println();
    // }
    public static void main(String[] args) {
	ArgoMatrixRotation mt = new ArgoMatrixRotation();
	// =======================================================================================
	// Actual Scanner input
	// =======================================================================================
	Scanner in = new Scanner(System.in);
	final int row = in.nextInt();
	final int col = in.nextInt();
	final int numberOfRotations = in.nextInt();
	int[][] a = new int[row][col];
	// input sample data
	for (int x = 0; x < row; ++x) {
	    for (int y = 0; y < col; ++y) {
		a[x][y] = in.nextInt();
	    }
	}
	in.close();
	final int fullRotation = (row - 1) * 2 + (col - 1) * 2;
	int actualRotations = mt.getActualNumberOfRotations(row, col, numberOfRotations);
	for (int n = 0; n < numberOfRotations; ++n) {
	    mt.performOneShift(a, 0, 0, row, col);
	}
	// -----------------------------------------------------------------------------------------------------
	// I discovered that if numberOfRotations >= fullRotation, the inner alternating metrices should rotate twice
	// E.G. For a 6x8 Matrix, the following metrices should rotate this way,
	// - item starting at [0,0], [2,2], [4,4], [6,6] etc should rotate R times
	// - item starting at [1,1], [3,3], [5,5], [7,7] etc should rotate R*2 times
	// -----------------------------------------------------------------------------------------------------
	// Update number of rotations and start positions
	if (numberOfRotations >= fullRotation) {
	    actualRotations = actualRotations * 2;
	}
	for (int n = 0; n < numberOfRotations; ++n) {
	    mt.performOneShift(a, 1, 1, row - 1, col - 1);
	}
	// print values
	for (int x = 0; x < row; ++x) {
	    for (int y = 0; y < col; ++y) {
		System.out.print(a[x][y] + " ");
	    }
	    System.out.println();
	}
    }

    int getActualNumberOfRotations(int row, int col, int numberOfRoations) {
	int fullRotation = (row - 1) * 2 + (col - 1) * 2;
	if (numberOfRoations >= fullRotation) {
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
	    // Update the next start position
	    startX = startX + 2;
	    startY = startY + 2;
	    row = row - 2;
	    col = col - 2;
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
