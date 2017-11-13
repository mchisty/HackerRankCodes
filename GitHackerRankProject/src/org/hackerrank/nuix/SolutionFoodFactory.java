
package org.hackerrank.nuix;

/**
 * A factory for creating SolutionFood objects.
 */
public class SolutionFoodFactory {

	/**
	 * The main method.
	 *
	 * @param args
	 *            the arguments
	 */
	public static void main(String[] args) {
		foodFactory myFoods = new foodFactory();
		Food food1 = myFoods.getFood("Fastfood");
		Food food2 = myFoods.getFood("Fruits");
		System.out.println("My name is: " + food1.getClass().getSimpleName());
		System.out.println("My name is: " + food2.getClass().getSimpleName());
		System.out.println("food1 superclass is: " + food1.getClass().getSuperclass().getSimpleName());
		System.out.println("food2 superclass is: " + food2.getClass().getSuperclass().getSimpleName());
		food1.serveFood();
		food2.serveFood();
	}
}

/**
 * The Class Fastfood.
 */
class Fastfood extends Food {

	@Override
	public void serveFood() {
		System.out.println("I'm serving Fastfood");
	}
}

/**
 * The Class Fruits.
 */
class Fruits extends Food {

	@Override
	public void serveFood() {
		System.out.println("I'm serving Fruits");
	}
}

/**
 * A factory for creating food objects.
 */
class foodFactory { // extends SolutionFoodFactory {

	public Food getFood(String string) {
		if (string.equals("Fastfood")) {
			return new Fastfood();
		} else if (string.equals("Fruits")) {
			return new Fruits();
		}
		return null;
	}
}

/**
 * The Class Food.
 */
class Food { // extends SolutionFoodFactory {

	public void serveFood() {
		// TODO
	}
}
