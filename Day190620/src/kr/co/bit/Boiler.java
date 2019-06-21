package kr.co.bit;

public class Boiler {

	static int heihgt;
	private String maker; 
	public int temp; 
	private String color; 
	/* private: 같은 패키지 안에서, 해당 클래스 안에서만 사용 가능, 외부 클래스로 불러갈 수 없음 . // 패키지가 다르면 import 해야와 함
	 * public: 공개. 외부 클래스에도 마음대로 불러갈 수 있음 
	 */
	
	public void set() { // private 변수를 그대로 쓸 수는 없지만, 함수를 통해 불러올 수 있다. 
		maker = "A";
		System.out.println(maker);
	}
	public void tempUp() { // 1도씩 올리는 함수
		temp++;		
	}
	public void tempUp(int amount) { // 외부에서 입력받은 amount 만큼 올리는 함수 (오버로드) 
		temp = temp + amount; 
	}
	public static void main(String[] args) {
		Boiler boiler = new Boiler ();
		boiler.tempUp();
		System.out.println(boiler.temp);
		
		boiler.tempUp(10);
		System.out.println(boiler.temp);
		
	}
}
