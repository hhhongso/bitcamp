package kr.co.bit;

public class InstanceOfTest {

	public static void main(String[] args) {
		President president1 = new President();
		Person person1 = president1; //축소 (Upcasting): 변수, 함수 등은 모두 형변환되며, 단, president 가 가진 메모리 공간은 여전히 존재한다. 
		
		if(person1 instanceof President) { // person1 객체가  President타입으로 형변환이 가능한지 ?
			President president2 = (President) person1;  // 확장(Downcasting)
			System.out.println("person1을 President 타입으로 캐스팅 성공");
		} else {
			System.out.println("캐스팅 불가");
		}
		
		Person person2 = new Person();
		
		if (person2 instanceof President) {
			President president3 = (President) person2;
			System.out.println("person2을 President 타입으로 캐스팅 성공");
		} else {
			System.out.println("캐스팅 불가");
		}

	}

}
