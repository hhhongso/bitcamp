package kr.co.bit;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.ToIntFunction;

public class Example11 {
	
	private static List<Student> list = Arrays.asList(
					new Student("학생1", 80, 70),
					new Student("학생2", 90, 100)
			);
								//함수적 인터페이스의 제네릭 타입에 Student Class를 입력하였기 때문에 , 아래 t가 Student type 으로 규정됨  
	public static void printString(Function<Student, String> func) {
		for(Student student : list) {
			System.out.print(func.apply(student) + " "); // .apply 메소드가 무엇을 할지는 모르나, 일단 그 결과값을 출력한다. 
		}
		System.out.println();
	
	}
	
													//들어간 값이 무엇이든 간에, int값으로 출력한다. 
	public static void printInt(ToIntFunction<Student> func) {
		for (Student student : list) {
			System.out.print(func.applyAsInt(student)+ " "); // .applyAs 메소드가 무엇을 할지는 모르나, 일단 그 결과값을 출력한다. [기능은 정의되지 않은 상태]
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		System.out.println("학생 이름: ");
		printString(t -> t.getName()); // t에 t.getName이 매핑되어 출력  [기능을 정의] >>함수에 있는 기능을, 인자처럼 전달하는 것<< 
		
		System.out.println("영어점수: ");
		printInt(t -> t.getEng());
		
		System.out.println("수학점수: ");
		printInt(t -> t.getMath());
	}
}
