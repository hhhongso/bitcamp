package kr.co.bit;

public class Card {
	// 인스턴스 변수 : 변화하는 것
	String kind;  // 무늬
	int number;  // 숫자  
	
	public Card() { // 생성자 함수로 초기화 (컴파일러가 자동으로 진행)
		kind = null;
		number = 0; 
	}
	
	// 클래스 변수 : 변화하지 않는 것 => 메모리 공간 하나만 만든고 
	public static int width; // 가로
	public static int height; // 세로 
	
	static { // static 구조로 만들어 초기화 (컴파일러가 자동으로 진행; 100 -> 0;) 
		width = 100;
		height = 250;
	}

	public void set () { //함수 만들기
		int lv = 0; // 로컬 변수 선언  
		System.out.println(lv);
	}
	
	//main 진입점 필요 
	public static void main(String[] args) {
		Card card1 = new Card(); // Card 클래스 - new 연산자로 불러와 인스턴스 변수 사용 
		card1.kind = "spade";
		card1.number = 4; 
		System.out.println(card1.kind + "\t" + card1.number + "\t" + Card.height + "\t" + Card.width); // static 변수에 있는 변수는 new 연산자 없이 Card클래스.__ 로 바로 불러온다. 
		
		Card card2 = new Card();
		card2.kind = "heart"; // new 연산자로 불러와 새로운 인스턴스 변수(변화하는 내용)을 만들 수 있다 .
		card2.number = 8; 
		System.out.println(card2.kind + "\t" + card2.number + "\t" + Card.height + "\t" + Card.width); // static 변수에 있는 변수는 new 연산자 없이 Card클래스.__ 로 바로 불러온다.
		
	}
}
