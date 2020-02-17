package misc.amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TotalDistance {

	public static void main(String[] args) {
		int nuRows = 3;
		int numColumns = 3;
		List<List<Integer>> area = new ArrayList<List<Integer>>(
//				Arrays.asList(Arrays.asList(1, 0, 0), Arrays.asList(1, 0, 0), Arrays.asList(1, 9, 1)));
				Arrays.asList(Arrays.asList(1, 1, 0), Arrays.asList(0, 1, 1), Arrays.asList(0, 1, 9)));

		System.out.println(minimumDistance(nuRows, numColumns, area));
	}

	static int minimumDistance(int nuRows, int numColumns, List<List<Integer>> area) {
		int count = 0;
		int activePos = 0;
		outer: for (int i = 0; i < area.size(); ++i) {
			List<Integer> row = area.get(i);
			inner: for (int j = activePos; j < row.size(); ++j) {
				int cell = row.get(j);
				if (cell == 1) {
					activePos = j;
					System.out.println("i:" + i + ", j: " + activePos + ", cell value:" + cell);
					++count;

				} else if (cell == 9) {
					activePos = j;
					System.out.println("i:" + i + ", j: " + activePos + ", cell value:" + cell);
					break outer;
				}
				else {
					break inner;

				}
			}
		}

		return count;
	}


}
