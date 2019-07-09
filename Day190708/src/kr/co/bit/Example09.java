package kr.co.bit;

import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;
import java.util.function.ObjIntConsumer;

//함수적 인터페이스 *(Consumer, Supplier, Function, Opreator, Predicate >>> 매개값 / 리턴값 유무 차이가 있어, 예측 가능성 
//Consumer 인터페이스[리턴타입 없음(void)]: 무조건 .accept() 함수 사용 !
//Supplier		  [리턴값만 존재]: 리턴타입에 따라 함수 달라짐 .get(), .getAsBoolean(), .getAsInt(), ...
//Function		  [매개변수, 리턴값 둘 다 존재]: .apply(), .applyAsDouble(int value); ==> int를 Double로 매핑 
//Operator		  [매개변수, 리턴값 둘 다 존재]: 연산 수행 후 그 결과값을 리턴한다. 
//Predicate		  [매개변수있음, 리턴값은 무조건 boolean]: .test() >>> 시그널 보내기에 활용 (속도 !)

public class Example09 {
	public static void main(String[] args) {
		Consumer<String> con1 = t -> System.out.println(t + "8");
		con1.accept("java");
		
		BiConsumer<String, String> con2 = (t, u) -> System.out.println(t + u);
		con2.accept("java", "8");
		
		DoubleConsumer con3 = d -> System.out.println("java" + d);
		con3.accept(8.0);
								//object T, int I
		ObjIntConsumer<String> con4 = (t, i) -> System.out.println(t + i);
		con4.accept("java", 8);
	}
}
