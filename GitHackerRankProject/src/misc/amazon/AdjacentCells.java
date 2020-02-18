package misc.amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AdjacentCells {

	public static void main(String[] args) {
//		int nuRows = 5;
//		int numColumns = 4;
//		List<List<Integer>> area = new ArrayList<List<Integer>>(
//				Arrays.asList(Arrays.asList(1, 1, 0, 0), Arrays.asList(0, 0, 1, 0), Arrays.asList(0, 0, 0, 0),
//						Arrays.asList(1, 0, 1, 1), Arrays.asList(1, 1, 1, 1)));

		int nuRows = 7;
		int numColumns = 7;
		List<List<Integer>> area = new ArrayList<List<Integer>>(
				Arrays.asList(Arrays.asList(1, 0, 0, 0, 0, 0, 0), Arrays.asList(0, 1, 0, 0, 0, 0, 0),
						Arrays.asList(0, 0, 1, 0, 0, 0, 0), Arrays.asList(0, 0, 0, 1, 0, 0, 0),
						Arrays.asList(0, 0, 0, 0, 1, 0, 0), Arrays.asList(0, 0, 0, 0, 0, 1, 0),
						Arrays.asList(0, 0, 0, 0, 0, 0, 1)));
		System.out.println(numberAmazonTreasureTrucks(nuRows, numColumns, area));
	}

//	int rows, int column, List<List<Integer>> grid
	static int numberAmazonTreasureTrucks(int rows, int column, List<List<Integer>> grid) {
		int count = 0;
		int activePos = 0;
		boolean flag = false;
		outer: for (int i = 0; i < grid.size(); ++i) {
			List<Integer> row = grid.get(i);
			inner: for (int j = activePos; j < row.size(); ++j) {
				int cell = row.get(j);
				if (cell == 1) {
					flag = true;
					continue;
				} else if (flag) {
					++count;
					flag = false;
					break inner;
				}
			}
		}
		if (flag)
			++count;

		return count;
	}

}
