package misc.lambda;

public class Person {
	public Person() {
	}

	private String givenName;
	private int age = 0;
	private String phone;

	public Person(String givenName, int age, String phone) {
		super();
		this.givenName = givenName;
		this.age = age;
		this.phone = phone;
	}

	public String getGivenName() {
		return givenName;
	}

	public void setGivenName(String givenName) {
		this.givenName = givenName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void printGivenName() {
		System.out.println(givenName);
	}

	public void printDetail() {
		System.out.println(getGivenName() + ",\t " + getAge() + ",\t" + getPhone());
	}
}
