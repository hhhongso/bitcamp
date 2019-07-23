import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.TextArea;

//Frame은 BorderLayout으로 지정(동 서 남 북 중앙). 동서남북에는 1개만 올라간다. 2개 이상 올릴 시 먼저 올린 건 가려짐
class AwtTest extends Frame {
	private Button newB, exitB; 
	private TextArea area; // Field:한 줄 입력 Area:여러 줄 입력

	public void init(){
		newB = new Button("새로 만들기");
		exitB = new Button("종료");
		area = new TextArea();

		area.setForeground(Color.MAGENTA); // text 설정을 잡아주는 주체는 area. NOT Frame
//		area.setFont(new Font("Verdana", Font.BOLD, 30)); //글꼴 조정: 글꼴, 스타일, 크기
		area.setFont(new Font("Verdana", 1, 30)); // int bold = 1 이니 이렇게 쓸 수도 있지만. 직관적으로 비추천

		this.add("North", newB); //버튼 붙이기: (방향, 객체). .크기가 정해지지 않음.
		this.add("South", exitB);
		add("Center", area);


		setTitle("TEST");
		setBounds(700, 100, 300, 400);
		setVisible(true);
	}

	public static void main(String[] args)	{
		new AwtTest().init();
	}
}
