package kr.co.bit;
/*
 * 오버로드 (파라미터 타입이 다르면 함수 이름을 동일하게 사용할 수 있다. )

다형성 : 하나의 사람(같은 클래스 이름)이 시간, 장소에 따라 다른 기능을 한다. 

1) 중복 (오버로드)
하나의 클래스에서 다양한 기능을 작업을 할 때 사용 
파라미터의 타입이나 개수가 달라야 한다. 
 파라미터의 이름은 오버로딩 성립에 영향을 주지 않음 ( 같은 타입에 이름만 다른건 X. )
 리턴타입은 오버로딩 성립에 영향을 주지 않는다. 
 public void printInfo (String A);
 public int printInfo(String A);


2) 중복 (오버라이드)
여러개의 클래스에서 다양한 기능을 작업을 동작할 때 사용 

 */
public class Args { // 하나의 클래스 안에 
	public void add(int x) {
		System.out.println("덧셈 1");
	}

	public void add(String str) { // 같은 함수, 다른 파라미터 (오버로드)
		System.out.println(str + "문자열 받아서 출력");
	}
	
	public void add (double sil) { // 같은 함수, 다른 파라미터 (오버로드)
		System.out.println(sil + "실수를 받아서 출력");
	}
	
	public static void main(String[] args) {
		Args arg = new Args ();
		arg.add(10);
		arg.add(1.5);
		arg.add("가나다");
		
	}
}
