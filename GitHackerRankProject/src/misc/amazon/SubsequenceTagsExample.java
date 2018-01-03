package misc.amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * This problem is very unclear. After spending 2-3 hours, still do not understand it. The solution below is incomplete
 * and incorrect.
 * 
 * @author mchisty
 *
 */
public class SubsequenceTagsExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// List<String> targetList = Arrays.asList("in", "the", "spain");
		// List<String> availableList = Arrays.asList("the", "spain", "that", "the", "rain", "in", "spain", "stays",
		// "forecast", "in", "the");

		List<String> targetList = Arrays.asList("2abc", "bcd", "cab");
		List<String> availableList = Arrays.asList("dbc", "2abc", "cab", "bcd", "bcb");

		SubsequenceTagsExample st = new SubsequenceTagsExample();
		List<Integer> result = st.subsequenceTags(targetList, availableList);
		System.out.println(result.toString());

	}

	private List<Integer> subsequenceTags(List<String> targetList, List<String> availableList) {
		// 1. Pick the element with first occurence. Lets call it start element
		List<Integer> positions = new ArrayList<>();
		for (String s : targetList) {
			if (availableList.contains(s)) {
				Integer index = availableList.indexOf(s);
				positions.add(index);
			}
		}

		final Integer minPositionOfStartElement = positions.stream().mapToInt(v -> v).min().getAsInt();
		final String startElement = availableList.get(minPositionOfStartElement);

		// 2. Check other elements
		List<Integer> positionOfOtherItems = new ArrayList<>();
		for (String s : targetList) {
			if (!s.equals(startElement) && availableList.contains(s)) {
				Integer index = availableList.indexOf(s);
				positionOfOtherItems.add(index);
			}
		}

		// 3. Get all index positions of start element
		List<Integer> allPositionsOfStartElement = new ArrayList<>();
		for (int i = 0; i < availableList.size(); ++i) {
			if (availableList.get(i).equals(startElement)) {
				final int j = i;
				if (positionOfOtherItems.stream().anyMatch(k -> k > j)) {
					allPositionsOfStartElement.add(i);
				}
			}
		}
		System.out.println("allPositionsOfStartElement: " + allPositionsOfStartElement.toString());

		List<Integer> resultList = new ArrayList<>();
		final Integer maxPositionOfOther = positionOfOtherItems.stream().mapToInt(v -> v).max().getAsInt();
		Integer startVal = maxPositionOfOther - minPositionOfStartElement + 1;
		System.out.println("startval:" + startVal);
		resultList.add(startVal);
		final Integer maxPositionOfStart = allPositionsOfStartElement.stream().mapToInt(v -> v).max().getAsInt();
		Integer endVal = maxPositionOfOther - maxPositionOfStart + 1;
		System.out.println("endval:" + endVal);
		resultList.add(endVal);
		Collections.sort(resultList);
		return resultList;
	}
}
