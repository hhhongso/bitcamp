package kr.co.bit.obj3;

public class AirConUser {
	// 변수 정의 
		String company; //공간 생성
		String color; 
		int price; 
		int size; 
		int temp; 
		
		/*
		 * public AirCon() { //컴파일러가 진행하는 부분 => 초기값을 넣는다 (초기화)
		 * 	company = null; 
		 *  color = null; 
		 *  price = 0; 
		 *  0
		 *  0
		 *  
		 * }
		 * 
		 * ===> 공간을 생성 & 바로 값을 넣는 것 == 초기화  ===> 생성자 함수가 하는 일 Constructor
		 * ===> 공간을 생성 // 값을 그 다음에 넣는 것 == 대입.
		 */
		// 메소드 정의
		public void powerOn() {
			System.out.println("전원을 켰다.");
		}
		public void powerOff() {
			System.out.println("전원을 껐다.");
		}
		public void tempUp() {
			temp++;
		}
		public void tempDown() {
			temp--;
		}

}
