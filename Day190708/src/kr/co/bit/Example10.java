package kr.co.bit;

import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.IntSupplier;

public class Example10 {
	public static void main(String[] args) {
		IntSupplier is1 = () -> (int)(Math.random()*6) +1;
		System.out.println("주사위 눈의 수: " + is1.getAsInt());
		
		
		Consumer<String> con1 = x -> System.out.println(x + 123);
		con1.accept("AAA");
		
		BiConsumer<String, Integer> con2 = (x, y) -> System.out.println(x + y + 123);
		con2.accept("AAA", 789);
		
		
	}
}
