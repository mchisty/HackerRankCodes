package misc.amazon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// TODO: Auto-generated Javadoc
/**
 * <code>
 * 
 * Input:
 * ========
 * Type			Price
 * mx5.large		1.50
 * mx3.small		0.50
 * mx3.small		1.00
 * mx3.small		0.20
 * mx4.med			0.90
 * mx5.large		1.20
 * mx1				0.10
 * mx2				0.20
 * mx3				0.30
 * mx4				0.40
 * mx5				0.50
 * mx6				0.60
 * 
 * TODO: 
 * Show the top k types with highest revenues
 * 
 * Output:
 * =========
 * So the output will be,
 * 
 *  mx5.large
 *  mx3.small
 *  mx4.med
 *  mx6
 *  mx5
 *  mx4
 *  mx3
 *  mx2
 *  mx1
 *  
 * Explanation:
 * =============  
 * mx3.small = 0.50 + 1.00 + 0.20 = 1.70  
 * mx4.med = 0.90 
 * mx5.large = 1.50+1.20 = 2.70
 * mx6 = 0.60 
 * mx5 = 0.50 
 * mx4 = 0.40 
 * mx3 = 0.30 
 * mx2 = 0.20 
 * mx1 = 0.10 
 * 
 *  
 * </code>
 * 
 *
 */

public class FindTopRevenues {

	/** The list. */
	private List<AmazonItem> list;

	/**
	 * The main method.
	 *
	 * @param args
	 *            the arguments
	 */
	public static void main(String[] args) {
		FindTopRevenues ft = new FindTopRevenues();
		int k = 3;
		ft.showHigestItemsByRevenueTotal(k);
	}

	/**
	 * Instantiates a new find top revenues.
	 */
	public FindTopRevenues() {
		list = new ArrayList<>();
		list.add(new AmazonItem("mx5.large", 1.50));
		list.add(new AmazonItem("mx3.small", 0.50));
		list.add(new AmazonItem("mx3.small", 1.00));
		list.add(new AmazonItem("mx3.small", 0.20));
		list.add(new AmazonItem("mx4.med", 0.90));
		list.add(new AmazonItem("mx5.large", 1.20));
		list.add(new AmazonItem("mx1", 0.10));
		list.add(new AmazonItem("mx2", 0.20));
		list.add(new AmazonItem("mx3", 0.30));
		list.add(new AmazonItem("mx4", 0.40));
		list.add(new AmazonItem("mx5", 0.50));
		list.add(new AmazonItem("mx6", 0.60));
	}

	/**
	 * Show higest items by revenue total.
	 *
	 * @param k
	 *            the k
	 */
	private void showHigestItemsByRevenueTotal(int k) {
		// Step 1: Store in map
		Map<String, Double> map = new HashMap<>();
		Double sum = 0.0;
		for (AmazonItem ai : list) {
			if (!map.containsKey(ai.getType())) {
				sum = ai.getPrice();
			} else {
				sum = map.get(ai.getType());
				sum += ai.getPrice();
			}
			map.put(ai.getType(), sum);
		}

		// map.forEach((type, revenue) -> System.out.println(type + ", " +
		// revenue));

		// Step 2: Store from map -> list
		List<UpdatedItem> topList = new ArrayList<>();
		for (Map.Entry<String, Double> entry : map.entrySet()) {
			topList.add(new UpdatedItem(entry.getKey(), entry.getValue()));
		}

		// Step 3: Sort the list
		topList.sort((UpdatedItem a1, UpdatedItem a2) -> a2.totalRevenue.compareTo(a1.totalRevenue));
		System.out.println("-----------------------------------");
		System.out.println("Display all items as sorted ");
		System.out.println("-----------------------------------");
		topList.forEach(l -> System.out.println(l.getType() + " ==> " + l.getTotalRevenue()));

		System.out.println("-----------------------------------");
		System.out.println("Display top k items as sorted ");
		System.out.println("-----------------------------------");
		// To show top k items
		topList.stream().limit(k).forEach(l -> System.out.println(l.getType() + " ==> " + l.getTotalRevenue()));
	}

	/**
	 * The Class UpdatedItem.
	 */
	private class UpdatedItem {

		/** The type. */
		private String type;

		/** The total revenue. */
		private Double totalRevenue;

		/**
		 * Instantiates a new updated item.
		 *
		 * @param type
		 *            the type
		 * @param totalRevenue
		 *            the total revenue
		 */
		public UpdatedItem(String type, Double totalRevenue) {
			super();
			this.type = type;
			this.totalRevenue = totalRevenue;
		}

		/**
		 * Gets the type.
		 *
		 * @return the type
		 */
		public String getType() {
			return type;
		}

		/**
		 * Gets the total revenue.
		 *
		 * @return the total revenue
		 */
		public Double getTotalRevenue() {
			return totalRevenue;
		}

	}

	/**
	 * The Class AmazonItem.
	 */
	private class AmazonItem {

		/** The type. */
		private String type;

		/** The price. */
		private Double price;

		/**
		 * Instantiates a new amazon item.
		 *
		 * @param type
		 *            the type
		 * @param price
		 *            the price
		 */
		public AmazonItem(String type, Double price) {
			this.type = type;
			this.price = price;
		}

		/**
		 * Gets the type.
		 *
		 * @return the type
		 */
		public String getType() {
			return type;
		}

		/**
		 * Gets the price.
		 *
		 * @return the price
		 */
		public Double getPrice() {
			return price;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see java.lang.Object#hashCode()
		 */
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((price == null) ? 0 : price.hashCode());
			result = prime * result + ((type == null) ? 0 : type.hashCode());
			return result;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see java.lang.Object#equals(java.lang.Object)
		 */
		@Override
		public boolean equals(Object obj) {
			if (this == obj) {
				return true;
			}
			if (obj == null) {
				return false;
			}
			if (getClass() != obj.getClass()) {
				return false;
			}
			AmazonItem other = (AmazonItem) obj;
			if (price == null) {
				if (other.price != null) {
					return false;
				}
			} else if (!price.equals(other.price)) {
				return false;
			}
			if (type == null) {
				if (other.type != null) {
					return false;
				}
			} else if (!type.equals(other.type)) {
				return false;
			}
			return true;
		}

	}

}
