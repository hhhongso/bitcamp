package kr.co.bit;

public class PersonMain {

	public static void main(String[] args) {

		Person person1 = new Student();
		Person person2 = new President();
		Person person3 = new Employee();
						//자식 객체가 부모 객체 에 들어갈 수 있음 

		Person person4 = new Person();  
		//Student student1 = person4; 
			// 자식 객체에 부모 객체가 들어가는 것은 불가능하다. 
			// 즉, 객체와 객체끼리는, DownCasting이 불가능하다. 
		
		Student student2 = (Student)person4; // (자식클래스)를 붙여 캐스팅을 강제할 수 있다. 
		
		
	}

}
