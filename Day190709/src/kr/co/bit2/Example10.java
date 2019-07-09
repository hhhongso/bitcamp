package kr.co.bit2;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Example10 {
	public static void main(String[] args) {
		int[] intArray = {1, 2, 3, 4, 5};
		
		IntStream intStream = Arrays.stream(intArray);
		intStream.asDoubleStream().forEach(e -> System.out.println(e));
		
		intStream = Arrays.stream(intArray);
		intStream.boxed().forEach( //.boxed(): 출력형식이 Wrapper class의 Integer
				e -> System.out.println(e.intValue())); // .intValue()는 wrapper class 에서만 사용 가능한 함수 
		
		
	}
}


