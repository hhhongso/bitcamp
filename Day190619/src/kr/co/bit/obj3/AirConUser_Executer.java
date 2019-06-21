package kr.co.bit.obj3;

public class AirConUser_Executer {

	public static void main(String[] args) {
		AirConUser airCon1 = new AirConUser(); //static이 없는 class 
		     // 인스턴스(객체,object) = 가리키는 대상
		// new 연산자를 사용해서 메모리상에 airCon객체를 생성한다. 
		
		/*
		 * AirCon airCon 			=				 new AirCon();
		 * 클래스(포인터=>클래스로					생성자함수 (포인터 -> 해당 배열(변수,함수)로 찾아감)
		 * 스택											동적영역
		 * => 변수의 공간을 확보  	
		 */
		airCon1.company = "LG에어컨"; // AirCon class의 함수에 static 키워드를 붙임으로서 execute 에서 바로 불러올 수 있도록 한다. 
		airCon1.color = "검은색";
		airCon1.price = 50000;
		airCon1.size = 3; 
		airCon1.temp = 20;
		
		System.out.println("airCon1의 온도는 " + airCon1.temp + ", airCon1의 색상은" + airCon1.color +
				",airCon1의 가격은 " + airCon1.price);
		

		
		// 두번째 객체 생성
		AirConUser airCon2 = new AirConUser();
		
		// airCon2. company ~ temp 의 값을 지정하지 않았음 
		// ==> 초기값을 그대로 불러온다 
		
		System.out.println("airCon2의 온도는 " + airCon2.temp + ", airCon2의 색상은" + airCon2.color +
				",airCon2의 가격은 " + airCon2.price);
			
		
	}

}
