package kr.co.bit2;

import java.util.Arrays;
import java.util.List;

public class Example07 {
	public static void main(String[] args) {
		List<Member> list = Arrays.asList(
					new Member("김멤버", Member.MALE, 30),
					new Member("이멤버", Member.FEMALE, 28),
					new Member("박멤버", Member.MALE, 50),
					new Member("최멤버", Member.FEMALE, 50)
				);
										//필터로 조건에 해당하는 값만 추출
		double ageAvg = list.stream().filter(		
				m -> m.getGender() == Member.MALE)
				.mapToInt(Member :: getAge) //추출한 값을 int로 매핑
				.average().getAsDouble();
		System.out.println("남 / 평균: " + ageAvg);
				
		
		
	
		
	}
}
