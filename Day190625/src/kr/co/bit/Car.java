package kr.co.bit;

public class Car {
	public Engine engine; //포함
	public Door[] door; //포함: Door 클래스가 아니라 이쪽에서 만든다. 
	
	public Car() {
		engine = new Engine(); // 포함 - 불러오기
		door = new Door[4]; // 포함 - 불러오기
		for(int i = 0; i< door.length; i++) {
			door[i] = new Door(); 				// 초기화
		}
	}
	

}
