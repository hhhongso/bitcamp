package kr.co.bit;

import java.util.function.IntBinaryOperator;

public class Example07 {
	public static void main(String[] args) {
		IntBinaryOperator operator;
		
		//기존방식으로, 정적 메소드 참조 
		operator = (x, y) -> Calculator.staticMethod(x, y);
		System.out.println("결과1: " + operator.applyAsInt(1, 2));
		
		//곧바로 스태틱 메소드 참조
		operator = Calculator :: staticMethod;
		System.out.println("결과2: " + operator.applyAsInt(5, 2));
		
		//기존 방식으로, 인스턴스 메소드 참조
		Calculator obj = new Calculator();
		operator = (x, y) -> obj.instanceMethod(x, y);
		System.out.println("결과3: " + operator.applyAsInt(5, 8));
		
		//인스턴스 메소드는 정적 메소드와 달리, 선언 시 클래스명이 아닌 인스턴스명으로 참조한다. 
		operator = obj :: instanceMethod;
		System.out.println("결과4: " + operator.applyAsInt(7, 8));
	}
}
