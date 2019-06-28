package kr.co.bit;

public class Person {
	protected int age; 
	protected String name; 
	protected String address;
	
	int x; 

	public Person() {
		//this(0, null, null,0);
	} 
	
	public Person(int age, String name, String address, int x) {
		this.age = age;
		this.name = name;
		this.address = address;
		this.x = x;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Person [age=" + age + ", name=" + name + ", address=" + address + "]";
	}

	public void sleep() {
		System.out.println("사람은 보통 10시간을 잔다. ");
	}
	
	public void showSleepStyle() {
		System.out.println("사람들의 수면 스타일은 다양하다. ");
	}
	
}
