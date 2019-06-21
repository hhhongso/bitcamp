package kr.co.bit;

public class Data_ParameterTest1 {
	
	
	public static void main(String[] args) {
		Data data = new Data();
		data.x = 10; // read and write
		System.out.println("main():x = " + data.x); 

		change(data); //인스턴스(객체)를 날림 
		System.out.println("main():x = " + data.x);

	}
	public static void change(Data data) { // 클래스로 파라미터 선언 (함수의 파라미터에 클래스 객체를 끌어옴) 
		data.x = 1000; //함수 안에서 메인에 있는 Data 클래스의 객체를 수정  
		System.out.println("change():x = " + data.x); //
	}

}
