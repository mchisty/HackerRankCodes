package misc.amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MinimumTimeToMergeSubfiles {

	final static List<Integer> sumList = new ArrayList<Integer>();

	public static void main(String[] args) {
		int numOfSubfiles = 4;
		List<Integer> files = new ArrayList<Integer>(Arrays.asList(4, 8, 6, 12));
		files.sort(Comparator.naturalOrder());
		System.out.println(minimumTime(numOfSubfiles, files));
	}

	static int minimumTime(int numOfSubfiles, List<Integer> files) {
		if (numOfSubfiles > 1) {
			int sum = files.get(0) + files.get(1);
			sumList.add(sum);
			files.remove(0); // removes first item
			files.remove(0); // removes second item
			files.add(sum);
			files.sort(Comparator.naturalOrder());
			numOfSubfiles -= 1;
			return minimumTime(numOfSubfiles, files);
		}

		return sumList.stream().mapToInt(Integer::intValue).sum();

	}

}
