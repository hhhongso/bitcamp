package kr.co.bit2;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

public class Example03 {
	public static void main(String[] args) {
		List<Student> list = Arrays.asList(
					new Student("최학생", 88),
					new Student("한학생", 91)				
			);
		
		//기존 방식 [직렬화] Iterator & 반복문
		Iterator<Student> it = list.iterator();
		while(it.hasNext()) {
			Student std = it.next();
			System.out.println(std.getName() + "-" +std.getScore());
		}
		
		//스트림 객체 사용 : 로직의 간소화 : stream에 foreach를 바로 제공  > for문을 돌릴 필요가 없음 !
		Stream<Student> stream = list.stream();
		stream.forEach(s -> System.out.println(s.getName() + "-" + s.getScore())); //람다식에서의 consumer API
 				
	}
}
