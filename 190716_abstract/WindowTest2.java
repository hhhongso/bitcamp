import java.awt.Graphics;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.Image;

class WindowTest2 extends Frame {
	public void init(){
		setTitle("오버액션토끼");
		setBounds(700, 100, 500, 500);
		setVisible(true);
	}

	public void paint(Graphics g){
		g.drawString("이미지", 100, 80);

		//이미지 불러오기: Toolkit은 추상 클래스. sub class가 없음. 
		Toolkit t = Toolkit.getDefaultToolkit();
		Image img = t.getImage("C:/java_se/190716_abstract/rabbit.png"); //폴더 경로가 다르다면 직접 입력: 절대경로

		//이미지 그리기
//		g.drawImage(img, 80, 150, this);
				//변수,	위치:좌표	, 어디에 그릴까?:참조값 
		
		g.drawImage(img, 
			0, 0, 800, 800, //화면 위치
			0, 280, 282, 0, //이미지 위치 
			this);

/*		g.drawImage(img, 
			0, 0, 500, 500, //화면 위치
			280, 282, 0, 0, //이미지 위치 
			this);
			*/
	}


	public static void main(String[] args) {
		new WindowTest2().init();
	}
}
