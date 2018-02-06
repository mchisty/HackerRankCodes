package misc.amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This problem is very unclear. After spending 2-3 hours, still do not understand it. The solution below is incomplete
 * and incorrect.
 * 
 * @author mchisty
 *
 */
public class SubsequenceTagsExample {

	public static void main(String[] args) {
		List<String> targetList = Arrays.asList("in", "the", "spain");
		List<String> availableList = Arrays.asList("the", "spain", "that", "the", "rain", "in", "spain", "stays",
				"forecast", "in", "the");

		// List<String> targetList = Arrays.asList("2abc", "bcd", "cab");
		// List<String> availableList = Arrays.asList("dbc", "2abc", "cab", "bcd", "bcb");

		SubsequenceTagsExample st = new SubsequenceTagsExample();
		st.subsequenceTags(targetList, availableList);
		// List<Integer> result = st.subsequenceTags(targetList, availableList);
		// System.out.println(result.toString());

		// Map<String, List<Integer>> map = st.getAllIndexpositionsOfItems(targetList, availableList);
		// map.entrySet().stream().forEach(c -> System.out.println(c.getKey() + " ==> " + c.getValue().toString()));

		// st.printSubsets(targetList, availableList);
	}

	// private void printSubsets(List<String> targetList, List<String> availableList) {
	// int n = availableList.size();
	// for (int i = 0; i < (1 << n); i++) {
	// List<String> subset = new ArrayList<>();
	// for (int j = 0; j < n; j++) {
	// // (1<<j) is a number with jth bit 1
	// // so when we 'and' them with the
	// // subset number we get which numbers
	// // are present in the subset and which
	// // are not
	// int tmp = (i & (1 << j));
	// if (tmp > 0) {
	// subset.add(availableList.get(j));
	// }
	// }
	// if (isSublistValid(targetList, subset))
	// System.out.println(subset.toString());
	// }
	// }

	private Map<String, Boolean> reinitializeMap(List<String> targetList, Map<String, Boolean> map) {
		for (String t : targetList) {
			map.put(t, Boolean.FALSE);
		}
		return map;
	}

	private List<Integer> subsequenceTags(List<String> targetList, List<String> availableList) {

		Map<String, Boolean> map = new HashMap<String, Boolean>();
		List<Integer> positions = null;

		// Loop through the available list
		int minDistance = Integer.MAX_VALUE;
		int start = 0, end = 0, d = 0;

		for (int i = 0; i < availableList.size(); ++i) {
			positions = new ArrayList<>();
			// Initialize maps with targetList
			for (String t : targetList) {
				map.put(t, Boolean.FALSE);
			}
			// -------------------------------------------------------------
			String a = availableList.get(i);
			int count = 0;
			if (map.containsKey(a) && map.get(a) == false) {
				map.put(a, Boolean.TRUE);
				if (d <= minDistance) {
					start = i;
					positions.add(start);
				}
				++count;
			}
			// ------------------------------------------------------------
			for (int j = 0; j < availableList.size(); ++j) {
				String b = availableList.get(j);
				if (map.containsKey(b) && map.get(b) == false) {
					map.put(b, Boolean.TRUE);
					++count;
				}
				if (count == targetList.size()) {
					d = Math.abs(start - end);
					if (d <= minDistance) {
						end = j;
						minDistance = d;
						positions.add(end);
					}
				}
			}
		}

		System.out.println("positions: " + positions.toString());
		System.out.println("Min distance: " + minDistance);

		return positions;
	}

	// private boolean isSublistValid(List<String> targetList, List<String> subList) {
	// if (subList.size() < targetList.size()) {
	// return false;
	// }
	// for (String t : targetList) {
	// if (!subList.contains(t)) {
	// return false;
	// }
	// }
	// return true;
	// }

	/**
	 * Take first item from target list, get all of its positions from available list and put it in a map. <br/>
	 * Repeat this process for all the items.
	 * 
	 * @param targetList
	 * @param availableList
	 * @return a map containing the items of targetList as keys, with their index positions as values
	 */

	// private Map<String, List<Integer>> getAllIndexpositionsOfItems(List<String> targetList,
	// List<String> availableList) {
	// Map<String, List<Integer>> map = new HashMap<>();
	// for (int i = 0; i < targetList.size(); ++i) {
	// String item = targetList.get(i);
	// List<Integer> positions = new ArrayList<>();
	// for (int j = 0; j < availableList.size(); ++j) {
	// String a = availableList.get(j);
	// if (item.equals(a)) {
	// positions.add(j);
	// }
	// }
	// map.put(item, positions);
	// }
	// return map;
	// }
	//
	// // -------------------------------------------------------------------------------------------------------------
	//
	// private List<Integer> subsequenceTags(List<String> targetList, List<String> availableList) {
	// // 1. Pick the element with first occurence. Lets call it start element
	// List<Integer> positions = new ArrayList<>();
	// for (String s : targetList) {
	// if (availableList.contains(s)) {
	// Integer index = availableList.indexOf(s);
	// positions.add(index);
	// }
	// }
	//
	// final Integer minPositionOfStartElement = positions.stream().mapToInt(v -> v).min().getAsInt();
	// final String startElement = availableList.get(minPositionOfStartElement);
	//
	// // 2. Check other elements
	// List<Integer> positionOfOtherItems = new ArrayList<>();
	// for (String s : targetList) {
	// if (!s.equals(startElement) && availableList.contains(s)) {
	// Integer index = availableList.indexOf(s);
	// positionOfOtherItems.add(index);
	// }
	// }
	//
	// // 3. Get all index positions of start element
	// List<Integer> allPositionsOfStartElement = new ArrayList<>();
	// for (int i = 0; i < availableList.size(); ++i) {
	// if (availableList.get(i).equals(startElement)) {
	// final int j = i;
	// if (positionOfOtherItems.stream().anyMatch(k -> k > j)) {
	// allPositionsOfStartElement.add(i);
	// }
	// }
	// }
	// System.out.println("allPositionsOfStartElement: " + allPositionsOfStartElement.toString());
	//
	// List<Integer> resultList = new ArrayList<>();
	// final Integer maxPositionOfOther = positionOfOtherItems.stream().mapToInt(v -> v).max().getAsInt();
	// Integer startVal = maxPositionOfOther - minPositionOfStartElement + 1;
	// System.out.println("startval:" + startVal);
	// resultList.add(startVal);
	// final Integer maxPositionOfStart = allPositionsOfStartElement.stream().mapToInt(v -> v).max().getAsInt();
	// Integer endVal = maxPositionOfOther - maxPositionOfStart + 1;
	// System.out.println("endval:" + endVal);
	// resultList.add(endVal);
	// Collections.sort(resultList);
	// return resultList;
	// }
}
