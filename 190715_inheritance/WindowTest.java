/* 윈도우 창 만들기*/

import java.awt.Frame;
import java.awt.Color;
import java.awt.Graphics;

class WindowTest extends Frame {
	public WindowTest(){
		super("내가 만든 윈도우"); // Frame 클래스[상속관계]의 생성자함수로 title 설정.			.setTitle() 으로도 가능.
//		new Frame("내가 만든 윈도우3").setVisible(true);
		
		System.out.println("도형 만들기");

		//윈도우 창 디폴트 바탕색: white / 글자색: black
//		setBackground(Color.ORANGE); // Color의 필드는 static 상수라, new로 객체생성하지 않아도 된다.
		
		setBackground(new Color(208, 245, 97)); // 사용자 색상 설정 시: Color 클래스의 생성자 함수 호출을 통하여 설정.
		//글자색
		setForeground(new Color(255, 0, 0));

//		this.setSize(300, 400); //윈도우 창 크기 설정: Window 클래스 - Frame - WindowTest 순으로 상속. 
		setBounds(700,100,300,400); // 윈도우 창 띄우는 위치, 크기 설정.
		setVisible(true); //true면 보여주기. false면 숨기기. ex)로그인 창 팝업 
	} 
	
	@Override // Call back Method: 구현만 해 둔 후, 어떤 일정한 시점이 되면, JVM(운영체제)이 호출 		ex)void main(), run()
	public void paint(Graphics g){ //paint()의 경우, setVisible() 이 그 시점. 
		g.drawString("도형 만들기", 100, 100);	//위치 설정
		g.drawLine(100, 150, 200, 250); //양 끝 점 x, y좌표 찍어
		g.drawRect(100, 250, 100, 100); // x좌표, y좌표로 중심점 설정, 너비, 길이
		g.drawOval(150, 250, 100, 100); // 중심점에서 너비와 높이를 설정 => Rect영역 안의 내적원을 그린다. 
	}


	public static void main(String[] args){
		WindowTest wt = new WindowTest();

	}
}



// POJO(Plain Old Java Object): 그 누구의 상속도 받지 않은, 일반적인 클래스.
//WindowTest is a Frame [ Frame은 java에서 제공: window창을 만들어주는 클래스]

