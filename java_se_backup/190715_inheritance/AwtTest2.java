import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.GridLayout;

class AwtTest2 extends Frame {
	private Button newB, exitB; 

	public void init(){
		newB = new Button("새로 만들기");
		exitB = new Button("종료");

		//FlowLayout(순서대로 배치. 중앙으로 배치됨) > button의 글자수에 따라 크기 달라짐 >> 크기를 같게 하려면, 균등배치
		Panel p = new Panel();
		p.setLayout(new GridLayout(1, 2, 5, 5)); //균등배치(행렬배치): (행, 렬, 가로여백, 세로여백)
		p.setBackground(new Color(255, 255, 50));
		p.add(newB);
		p.add(exitB);
		this.add("North", p);

		setTitle("TEST222");
		setBounds(700, 100, 300, 400);
		setVisible(true);
	}


	public static void main(String[] args) {
		new AwtTest2().init();
	}
}
