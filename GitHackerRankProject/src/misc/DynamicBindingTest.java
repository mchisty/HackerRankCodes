
package misc;

public class DynamicBindingTest {

	public static void main(String[] args) {
		Vehicle v = new Car();
		v.print();
	}
}

class Vehicle {

	public void print() {
		System.out.println("Vehicle printed");
	}
}

class Car extends Vehicle {

	@Override
	public void print() {
		System.out.println("Car printed");
	}
}
