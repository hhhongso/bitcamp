package kr.co.bit2;
//스트림의 강점: 순차처리, 병렬처리 가능 
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Example04 {
	public static void main(String[] args) {
		List<String> list = Arrays.asList("김학생", "이학생", "최학생", "정학생", "차학생");

		//순차처리
		Stream<String> stream = list.stream();
		stream.forEach(Example04 :: print);

		//병렬처리: 많은 데이터에 대한 동시 처리 가능 
		Stream<String> parallelStream = list.parallelStream();
		parallelStream.forEach(Example04 :: print);
	}				//forEach(특정 로직을 반복 실행)
	
	public static void print(String str) {
		System.out.println(str + ":" + Thread.currentThread().getName());
	}
}
