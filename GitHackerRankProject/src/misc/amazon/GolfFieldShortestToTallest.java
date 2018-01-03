package misc.amazon;

import java.util.ArrayList;
import java.util.List;

public class GolfFieldShortestToTallest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int fieldValues[][] = { { 1, 1, 0, 2 }, { 3, 1, 1, 1 }, { 4, 1, 2, 0 } };
		GolfFieldShortestToTallest gf = new GolfFieldShortestToTallest();
		List<Integer> list = gf.getShortestValuesInAscendingOrder(fieldValues);
		list.stream().sorted().forEach(i -> System.out.println(i));

	}
	// ===================
	// Pseudo code
	// ===================

	// 1. Scan through all elements in fieldValues to find the shortest values (should not be 1 or 0). Store all
	// shortest values in a list/array in ascending order
	// 2. Take a value from i-th position in shortest values list, make it the goal (initial goal to reach it)
	// ----------------------------------------------------------------------------------------------------------------
	// 3. Start from [x,y] position. Check the followings:
	// a. can you go top i.e. decrease y position and check if it is a valid index position,
	// b. if position is valid, then check if it is accessible i.e. if it NOT already visited and does it contain 1 or
	// the shortest value. If not, go to next step at (c); OTHERWISE, update the position.
	// If the value is 1, repeat from step (3). If the value is target, update the index position, mark it as
	// visited = true, update the new goal/target value, go to step (2) and repeat.
	// ----------------------------------------------------------------------------------------------------------------
	// c. Restore original position. Now check if you can go left i.e. decrease y position and check if it
	// is a valid position
	// d. if position is valid, then check is it accessible i.e. if it NOT already visited and does it contain 1 or the
	// shortest value. If not, go to next step at (e); otherwise, update the position.
	// If the value is 1, repeat from step (3). If it is a target value, update the index position, mark it as visited =
	// true, update the goal/target value from the shortest list/array, go to step 2 and repeat.
	// ----------------------------------------------------------------------------------------------------------------
	// e. Restore original position. Now check if you can go bottom i.e. increase y position and check if
	// it is a valid position
	// f. if position is valid, then check is it accessible i.e. if it NOT already visited and does it contain the
	// shortest value. If not, go to next step at (g); otherwise, update the position, mark it as visited = true, update
	// the goal/target value, go to step 2 and repeat.
	// ----------------------------------------------------------------------------------------------------------------
	// g. Restore original position. Now check if you can go right i.e. increase x position and check if
	// it is a valid position
	// h. if position is valid, then check is it accessible i.e. if it NOT already visited and does it contain the
	// shortest value. If not, return -1; otherwise, update the position, mark it as visited = true, update
	// the goal/target value, go to step 2 and repeat.
	// ----------------------------------------------------------------------------------------------------------------
	int distance(int rows, int cols, int[][] fieldValues) {
		return -1;
	}

	private List<Integer> getShortestValuesInAscendingOrder(int[][] fieldValues) {
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < fieldValues.length; ++i) {
			for (int j = 0; j < fieldValues[i].length; ++j) {
				if (fieldValues[i][j] != 0 && fieldValues[i][j] != 1) {
					list.add(fieldValues[i][j]);
				}
			}
		}
		list.stream().sorted();
		return list;
	}

}
