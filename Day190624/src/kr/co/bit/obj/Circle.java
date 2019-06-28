package kr.co.bit.obj;
/*
 * 부분클래스를 먼저 만들고 전체 클래스를 생성하여 포함시킨다. 
 */
public class Circle {
	public Point point; 
					// public Point point = new Point(); 가능하지만 C에서 많이 사용하는 방법, 자바에서는 아래와 같이 작성한다.  
	public Circle() {  // 전체 클래스
		point = new Point(); // 부분 클래스: 생성자 함수 안에서 point 클래스(부분)의 객체를 생성한다.  ///////// Macca 예제 확인 (O)
	}
	
	public static void main(String[] args) {
		Circle circle = new Circle();
		
		circle.point.y = 20;
		System.out.println(circle.point.x); // x는 값을 대입해주지 않았으니 초기화 값인 0이 출력됨
		System.out.println(circle.point.y); // 상속과 달리 포함관계를 적을 때에는 (전체클래스).(포함되는 부분 클래스).(변수) 의 순으로 
	
	}

}
