
package misc;

import misc.lambda.Person;

public class PassByValRefExample {

	private int x;

	private Person p;

	public static void main(String[] args) {
		PassByValRefExample pv = new PassByValRefExample();
		pv.passByValue(pv.x);
		System.out.println("original x:" + pv.x);
		System.out.println("---------------------------------------------------");
		System.out.println("Original name (before): " + pv.p.getGivenName() + "; email: " + pv.p.getEmail());
		pv.passByReference();
		System.out.println("--------------------------------------------------------");
	}

	public PassByValRefExample() {
		x = 100;
		p = new Person("John", "john@doe.com");
	}

	// Pass by value when primitive
	private void passByValue(int x1) {
		x1 = 200;
		System.out.println("x1:" + x1);
	}

	// Pass by reference when object
	private void passByReference() {
		Person p1 = p;
		p1.setGivenName("Oleg Tyrell");
		p1.setEmail("oleg@gmail.com");
		System.out.println("p1 name: " + p1.getGivenName() + "; p1 email: " + p1.getEmail());
		System.out.println("Original name (updated): " + p.getGivenName() + "; email: " + p.getEmail());
	}
}
