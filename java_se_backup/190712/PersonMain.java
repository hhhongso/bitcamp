//가상화 작업================
class Person {
	private String name;
	private int age;

	public void setName(String n) { //setter: 파라미터 값은 있으나, 리턴타입이 없음
		name = n;
	}
	
	public void setAge(int a) {
		age = a;
	}

	public void setData(String n, int a) { // overload
		name = n; 
		age = a; 
	}

	public void setData(){} // overload
	
	public String getName(){ //getter: 파라미터 값이 없이, 리턴타입만 존재 
		return name;
	}

	public int getAge(){
		return age;
	}

	Person(){} //new > 객체 생성 시, 생성자가 없으면 자동으로 컴파일. ** 생성자는 리턴 타입이 없다. **
}

//=========================>> 컴파일 시, Person.class, PersonMain.class 두 개가 생성. 
public class PersonMain {
	public static void main(String[] args) {
		Person aa; 
		aa = new Person();
		System.out.println("객체 aa = " + aa); //객체의 참조주소
		System.out.println("객체 aa = " + aa.toString()); //상기 코드는 사실 .toString이 생략되어 있는 것.
		System.out.println("객체 aa = " + aa.hashCode()); //참조주소를 10진수로 보여주는 함수.
		
		//호출
		aa.setName("홍길동");
		System.out.println("이름: " + aa.getName());

		aa.setAge(25);
		System.out.println("나이: " + aa.getAge());

		System.out.println();		// -----------------------------------------새로운 객체 생성 -----------------------------
		Person bb = new Person();
		System.out.println("객체 bb = " + bb);
		System.out.println("객체 bb = " + bb.hashCode());
		
		bb.setName("코난");
		System.out.println("이름: " + bb.getName());

		bb.setAge(10);
		System.out.println("나이: " + bb.getAge());

		System.out.println();
		Person cc = new Person();
		cc.setData("또치", 30);
		System.out.println("객체 cc = " + cc.hashCode());
		System.out.println("이름: " + cc.getName());
		System.out.println("나이: " + cc.getAge());

		System.out.println();
		Person dd = new Person();
		dd.setData();
		System.out.println("객체 dd = " + dd.hashCode());
		System.out.println("이름: " + dd.getName());
		System.out.println("나이: " + dd.getAge());

		System.out.println();
		aa = cc; 
		System.out.println("객체 aa = " + aa.hashCode());


	}
}

/*
int aa; 정수형 변수
int[] aa; 정수형 배열 
double aa; 실수형 변수
Person aa; 객체
Person[] ar; 객체 배열
*/