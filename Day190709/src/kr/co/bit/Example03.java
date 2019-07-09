package kr.co.bit;

import java.util.function.Consumer;

public class Example03 {
	public static void main(String[] args) {
		Consumer<Member> consumerA = m -> System.out.println(
				"consumerA: " + m.getName()); 

		Consumer<Member> consumerB = m -> System.out.println(
				"consumerB: " + m.getId()); 

		//두 개의 기능 합치기 : A를 실행 후 그 제어권을 B에게 넘긴다. 
		// * 제네릭 타입이 같아야 함 
		Consumer<Member> consumerAB = consumerA.andThen(consumerB);
		consumerAB.accept(new Member("김고객", "kkkkkim", null));
	}
}
