package kr.co.bit.obj3;
/*
 *  static이 변수, 메소드에 붙어있다면 
 *  new 연산자로 불러오지 않고도 class 를 바로 불러올 수 있다. 
 *   
 */
public class AirCon {
	// 변수 정의 
	static String company; 
	static String color; 
	static int price; 
	static int size; 
	static int temp; 
	
	
	// 메소드 정의
	public static void powerOn() {
		System.out.println("전원을 켰다.");
	}
	public static void powerOff() {
		System.out.println("전원을 껐다.");
	}
	public static void tempUp() {
		temp++;
	}
	public static void tempDown() {
		temp--;
	}

}
