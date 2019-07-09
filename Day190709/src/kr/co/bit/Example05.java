package kr.co.bit;

import java.util.function.IntPredicate;

public class Example05 {
	public static void main(String[] args) {
		//2배수 검사 
		IntPredicate pa = a-> a % 2 == 0;
		
		//3배수 검사 
		IntPredicate pb = a -> a % 3 == 0;
		
		//5배수 검사 
		IntPredicate pc = a -> a % 5 == 0;
		
		IntPredicate pab;
		
		//2배수이면서 3배수이면서 5배수 검사 
		pab = pa.and(pb.and(pc));
		System.out.println("2와 3의 배수?: " + pab.test(8)); // predicate 는 리턴을 t/f로 돌려줌

		pab = pa.or(pb);
		System.out.println("2 혹은 3의 배수?: " + pab.test(8)); // predicate 는 리턴을 t/f로 돌려줌

		pab = pa.negate(); //인자값 없음 
		System.out.println("2의 배수가 아닌가?: " + pab.test(9)); // predicate 는 리턴을 t/f로 돌려줌
	}
}
