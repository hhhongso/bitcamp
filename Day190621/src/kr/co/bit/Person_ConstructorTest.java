package kr.co.bit;

public class Person_ConstructorTest {

	public static void main(String[] args) {
		Person person1 = new Person(); 
		System.out.println(person1.toString());
		Person person2 = new Person(20);
		System.out.println(person2.toString());
		Person person3 = new Person("°¡³ª´Ù");
		System.out.println(person3.toString());

	}

}
