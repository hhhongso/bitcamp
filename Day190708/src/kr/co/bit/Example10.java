package kr.co.bit;

import java.util.function.IntSupplier;

public class Example10 {
	public static void main(String[] args) {
		IntSupplier is1 = () -> (int)(Math.random()*6) +1;
		System.out.println("주사위 눈의 수: " + is1.getAsInt());
	}
}
