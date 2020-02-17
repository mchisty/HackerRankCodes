package misc.amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TotalDistance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nuRows = 3;
		int numColumns = 3;
		List<List<Integer>> area = new ArrayList<List<Integer>>(
				Arrays.asList(Arrays.asList(1, 0, 0), Arrays.asList(1, 0, 0), Arrays.asList(1, 0, 0)));

		System.out.println(minimumDistance(nuRows, numColumns, area));
	}

	static int minimumDistance(int nuRows, int numColumns, List<List<Integer>> area) {
		int count = 0;
		// Scan row-by-row
		outer: for (List<Integer> rowList : area) {
			// Scan cell
			inner: for (Integer cell : rowList) {
				if (cell == 1) {
					count++;
				} else {
					break inner;
				}
			}
		}

		return count;
	}

}
