package kr.co.bit;

public class CastingTest {

	public static void main(String[] args) {
		President president1 = new President(); // >> 인스턴스 생성하여 메모리 공간이 president 클래스로 포인터 >> 변수, 함수, 생성자, extends Person 까지 읽은 뒤 돌아온다.  		
		Person person1 = president1; // 축소
		president1 = (President) person1;  //확장
		president1.setNation("한국");
		System.out.println(president1.getNation());
		
		
		person1.setAddress("서울시"); // 부모클래스의 변수밖에 사용할 수 없음. [객체의 다형성 - 객체의 축소]	
		/*
		 * persident1 객체를 Person 클래스의 레퍼런스 변수(객체) 에 참조 시킴 
			 				가 자동으로 Person 타입으로 Upcasting 되면서 참조됨
			 즉, (Person) president1 라고 자동으로 컴파일러 되는 것 
		  	==> 객체가 Upcasting으로 들어가게 되면서 가지고 있던 변수, 함수, 타입 모두 버리고 부모클래스 타입으로의 형변환이 이루어진다. [축소]
		  	
		  	클래스와 클래스의 상속은 [확장] 하는 방식, 
		  	객체와    객체의    Upcasting은 [축소]의 방식 
		 */
		
		President president2 = (President) person1;
		/*
		 * 객체와 객체는 본래 상속이 불가함. 
		 * 부모객체가 자식객체에 들어가려고 하면 에러 발생, (President) 를 명기해줌으로써 캐스팅을 강제함 
		 * ==> 의도적으로 부모타입에서 자식타입으로 객체 상속시킴. [객체의 다형성 - 객체의 확장]	
		 */
		president2.setNation("대한민국"); //참조변수 president2 를 참조하여 가져온다. 
		System.out.println(president2.getNation());
		
		Person person2 = new Person();
		President president3 = (President) person2;
		/*
		 * 왜 이건 안되느냐 ? 
		 * new person()에 인스턴스 생성으로 부모 클래스의 메모리 공간을 만들어버렸기 때문에, 동적공간에서 부모의 변수와 함수를 모두 가리키고 있어  extends를 읽어들어오지 못함 ==> 객체와 객체 간의 Downcasting 절대 불가함 
		 * UPcasting 형변환을 하더라도, 부모 클래스의 인스턴스를 생성하지 않는다면, stack으로 메모리 공간을 가리키는 >? ===> 						가능    
		 * ==> 메모리 -> 동적공간을 가리키긴 하였으나, 자식이 누군지 알 수 없는 상태 
		 */
		president3.setNation("스페인");
		System.out.println(president3.getNation());
	}

}
