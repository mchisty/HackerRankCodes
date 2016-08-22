package org.hackerrank;

public class SolutionFoodFactory {
	public static void main(String[] args) {
		foodFactory myFoods = new foodFactory();
		Food food1 = myFoods.getFood("Fastfood");
		Food food2 = myFoods.getFood("Fruits");
		System.out.println("My name is: " + food1.getClass().getName());
		System.out.println("My name is: " + food2.getClass().getName());
		System.out.println("Our superclass is: " + food1.getClass().getSuperclass().getName());
		food1.serveFood();
		food2.serveFood();
	}
}

class Fastfood extends Food {
	@Override
	public void serveFood() {
		System.out.println("I'm serving Fastfood");
	}
}

class Fruits extends Food {
	@Override
	public void serveFood() {
		System.out.println("I'm serving Fruits");
	}
}

class foodFactory extends SolutionFoodFactory {
	public Food getFood(String string) {
		if (string.equals("Fastfood")) {
			return new Fastfood();
		} else if (string.equals("Fruits")) {
			return new Fruits();
		}
		return null;
	}
}

class Food extends SolutionFoodFactory {
	public void serveFood() {
		// TODO
	}
}
