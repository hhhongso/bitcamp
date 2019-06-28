package kr.co.bit.obj;

public class Car {
	public Engine engine; 
	public Door[] door; 
	
	public Car() {
		engine = new Engine();
		door = new Door[4];			// ==> door ������ ����(�迭��)�� ����
		
		for(int i = 0; i < door.length; i++) { 		// ������ door�� ������ ��Ī��Ŵ (?)
			door[i] = new Door(); 
		}
	}
	
	public static void main(String[] args) {
		Car car = new Car();
		System.out.println(car.engine.kind);
		car.door[0].door = 1;
		car.door[1].door = 2;
		car.door[2].door = 3;
		car.door[3].door = 4;
		for(int i = 0 ; i < car.door.length; i++) {
			System.out.println("����: " + car.door[i].door);			
		}
	}
}
