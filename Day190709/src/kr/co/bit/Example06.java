package kr.co.bit;

import java.util.function.BinaryOperator;

public class Example06 {
	public static void main(String[] args) {
		//바이너리오퍼레이터밖에안되용... 
		BinaryOperator<Fruit> bo; 
		Fruit fruit; 
		
		bo = BinaryOperator.minBy(
				(f1,f2) -> Integer.compare(f1.price, f2.price));
		fruit = bo.apply(new Fruit("딸기", 5000), new Fruit("수박", 10000));
		System.out.println(fruit.name);

		bo = BinaryOperator.maxBy((f1,f2) -> Integer.compare(f1.price, f2.price));
		fruit = bo.apply(new Fruit("딸기", 5000) , new Fruit("수박", 10000));
		System.out.println(fruit.name);
	}
}
