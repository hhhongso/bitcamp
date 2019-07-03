package kr.co.bit;
/*
 * 기본형 변수를 클래스 안에 넣음 > 오토박싱 
new 연산자를 통하지 않더라도 수행 가능하나, new로 객체를 생성하여 넣어주는 것을 권장(보다 쉽게 파악할 수 있다. )
⇒ 기본형(공간 하나, 값을 보관하는 역할) 에서, 클래스를 사용함[형변환]으로써, 여러개의 공간을 사용할 수 있으며, 메소드를 사용할 수 있도록 한다.  [객체 사용 가능]

오토언박싱 
객체에 들어있던 변수를 꺼내오는 것
⇒ 기본형으로 돌아옴 [객체 사용 불가]
 */
public class AutoBoxingTest {

	public static void main(String[] args) {
		//1.4: 이전 버전이 보다 직관적. 
		int var_int1 = 3; 
		Integer intObj1 = new Integer(var_int1);
		System.out.println(intObj1);
		
		//1.5 update
		intObj1 = var_int1; 
		System.out.println(3.14);

		Double intObj2 = new Double(5.1264f);
		System.out.println(3+intObj2);
		// 문자열에 해당하는 부분을, 객체로 바꿈으로써 정수형으로 형변환
		int var_int2 = intObj2.intValue(); // intValue(): Integer 클래스에서 int형 을 뽑아내는 함수.
		System.out.println(var_int2);
		//1.5 update
		//var_int2 = intObj2;
	}

}
