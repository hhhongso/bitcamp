package kr.co.bit;

public class Data_ParameterTest {
	
	public static void main(String[] args) {
		Data data = new Data();
		data.x = 10; // read only ==> 1000 으로 수정되지 않음 
		System.out.println("main():x = " + data.x); // 메인메소드

		change(data.x); //data.x = 10 이 대입되어 날아감 (함수를 수행)
		System.out.println("main():x = " + data.x); // data.x는 ____ 여서 수정이 불가. 그대로 10값으로 나옴 
		
	}
	
	public static void change(int x) { // data.x = int x= 10으로 날아왔음  (파라미터가 기본형으로 불러옴)
		x = 1000; //
		System.out.println("change():x = " + x); // change 함수 안에서 x = 1000; 
	}
}
