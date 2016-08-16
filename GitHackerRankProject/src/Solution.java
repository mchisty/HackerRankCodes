package org.hackerrank;

public class FoodTest {
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

class foodFactory extends FoodTest {
    public Food getFood(String string) {
	// HashMap<K, V> h
	// TODO Auto-generated method stub
	Food f = null;
	if (string.equals("FastFood")) {
	    f = new Food("X");
	} else {
	    f = new Food("Y");
	}
	return f;
    }

    @Override
    public String toString() {
	return "Food";
    }
}

class Food extends FoodTest {
    String name;

    public Food(String n) {
	this.name = n;
    }

    public void serveFood() {
	// TODO Auto-generated method stub
    }

    @Override
    public String toString() {
	return "Food [getClass()=" + getClass() + ", toString()=" + super.toString() + "]";
    }
}
