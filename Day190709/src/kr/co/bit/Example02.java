package kr.co.bit;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Example02 {
	private static List<Student> list = Arrays.asList(
				new Student("김학생", "남", 80),
				new Student("이학생", "여", 90),
				new Student("박학생", "남", 78),
				new Student("최학생", "여", 87)
			);
	
			//return type boolean인데 왜 double 이라고? : predicate -> 조건문을 이용, 원하는 T/F를 얻을 수 잇도록 필터링을 함 => 최종 return 값은 원하는 값이 무엇이든 넣을 수 있음
	public static double avg(Predicate<Student> predicate) {
		int count = 0, sum = 0; 
		for (Student student : list) {
			if(predicate.test(student)) {
				count++;
				sum += student.getScore();
			}
		}
		return (double) sum / count;
	}
	
	public static void main(String[] args) {
		double maleAvg = avg(t -> t.getGender().equals("남"));
		System.out.println("남자 평균점수: " + maleAvg);

		double femaleAvg = avg(t -> t.getGender().equals("여"));
		System.out.println("여자 평균점수: " + femaleAvg);
	}
}
