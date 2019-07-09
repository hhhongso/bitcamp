package kr.co.bit2;

import java.util.Arrays;
import java.util.List;

public class Example05 {
	public static void main(String[] args) {
		List<Student> slist = Arrays.asList(
					new Student("유학생", 10),
					new Student("선학생", 50),
					new Student("홍학생", 80)
				);
		
		//메소드 체이닝 - >연산도 수행한다.  //자바8 에서만 가능 (아닐 경우 iterator 사용해야 ) 
		double avg = slist.stream().mapToInt(Student :: getScore)
				.average().getAsDouble();
				
				System.out.println("평균점수: "+ avg);
 	}
}
