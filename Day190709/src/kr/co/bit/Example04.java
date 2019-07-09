package kr.co.bit;

import java.util.function.Function;

public class Example04 {
	public static void main(String[] args) {
				//input , output
		Function<Member, Address> functionA; 
		Function<Address, String> functionB; 
		Function<Member, String> functionAB;
		String city; 
		
		functionA = m -> m.getAddress();
		functionB = a -> a.getCity();
		
		functionAB = functionA.andThen(functionB); // function은 return type 이 있기 때문에 이와 같이 andThen으로 묶는 것이 가능하나, 단! A 의 output - B의 input 리턴타입이 같아야 가능
		city = functionAB.apply(
				new Member("이고객", "leeYI", new Address("한국", "서울"))
				);
		System.out.println("거주도시"+ city);
	
	}
}
