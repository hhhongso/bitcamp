package kr.co.bit;

import java.util.Arrays;
import java.util.List;
import java.util.function.ToIntFunction;

public class Example12 {

	private static List<Student> list = Arrays.asList(
					new Student("학생3", 50, 75),
					new Student("학생4", 80, 95)
			);
	
	public static int avg(ToIntFunction<Student> func) {
		int sum = 0;
		for (Student student : list) {
			sum += func.applyAsInt(student);
		}
		return sum / list.size();
	}
	
	public static void main(String[] args) {
		System.out.println("영어 평균: " + avg(s -> s.getEng())); // *** 기존 메소드를 재활용 할 수 있다. *** (인자에도 넣을 수 있으니까 !)
		System.out.println("수학 평균: " + avg(s -> s.getMath()));
		
	}
}
