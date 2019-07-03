package kr.co.bit;

class Student {
	SchoolType stype; 
	
	public Student(SchoolType stype) {
		this.stype = stype;
	}
}
//나열형(열거형) 클래스 : 서로 연관된 상수들의 집합 
enum SchoolType { // enum의 값은 숫자로 판단, 문자열이지만 숫자로 사용된다. 즉 public static int ELE = 1 / MID = 2/ HIGH = 3 / UNIV = 4와 동일한 기능
	ELE, MID, HIGH, UNIV
}


public class EnumTest {
	public static void main(String[] args) {
		Student student = new Student(SchoolType.ELE);
		
		System.out.println("상수값 출력한 경우");
		System.out.println(student.stype);
		
		if(student.stype == SchoolType.ELE) {
			System.out.println("초등학생");
		}
		
		/* 오류발생 
		 * if(student.stype == 1) {
			System.out.println("초등학생");
		}
		*/
	}

}
