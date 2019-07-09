package kr.co.bit2;
/*
 * 정렬 sorted
정렬하고자 하는 객체에 전처리를 해주어야 -> comparable<> 으로 상속시켜주어야 함.

 */
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

public class Example11 {
	public static void main(String[] args) {
		IntStream intStream = Arrays.stream(new int[] {5, 3, 4, 1, 2});
		intStream.sorted().forEach(n -> System.out.print(n + ","));
		System.out.println();
		
		//일반 객체 요소일 경우 
		List<Student> stdList = Arrays.asList(
					new Student("김학생", 30),
					new Student("이학생", 28),
					new Student("박학생", 20),
					new Student("한학생", 18),
					new Student("차학생", 27)
				);
		stdList.stream().sorted().forEach(n -> System.out.print(n.getScore() + ","));
		System.out.println();
									//내림차순으로 정렬
		stdList.stream().sorted(Comparator.reverseOrder()).forEach(n -> System.out.print(n.getScore() + ","));
				
	}
}
