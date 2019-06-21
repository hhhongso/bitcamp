package kr.co.bit.obj3;

public class AirConExecute {

	public static void main(String[] args) {
		AirCon.company = "삼성에어컨"; // AirCon class의 함수에 static 키워드를 붙임으로서 execute 에서 바로 불러올 수 있도록 한다. 
		AirCon.color = "흰색";
		AirCon.price = 10000;
		AirCon.size = 7; 
		AirCon.temp = 0;
		
		System.out.println("내가 " + AirCon.company +"을 샀다. 색깔은 " + AirCon.color + "이고, " 
		+ "가격은 " + AirCon.price + "원 이고, " + AirCon.size + "평이다. " + "온도는 " + AirCon.temp + "도 이다.");

		AirCon.powerOn();
		AirCon.powerOff();
		AirCon.tempUp();
		System.out.println(AirCon.temp + "도로 올랐다!");
		AirCon.tempDown();
		System.out.println(AirCon.temp + "도로 내려갔다.");
	}

}
