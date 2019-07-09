package kr.co.bit2;
//.distinct() : 중복제거
import java.util.Arrays;
import java.util.List;

public class Example08 {
	public static void main(String[] args) {
		List<String> names = Arrays.asList(
				"김학생", "이교수", "정관리자", "차가수", "홍배우", "지교사", "양개발자", "이연습생");
		
		// stream pipeline을 쓰기 위한 stream을 출력 -> distinct
		names.stream().distinct().forEach(e -> System.out.println(e));
		System.out.println();
		
		// 필터링 조건: 시작하는 실제 문장이 [x] 로 시작 
		names.stream().filter(e -> e.startsWith("정")).forEach(e -> System.out.println(e));
		
		names.stream().filter(e -> e.endsWith("수")).forEach(e -> System.out.println(e));
	}
}
