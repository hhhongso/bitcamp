import java.awt.Button;
import java.awt.Frame;

class AwtTest3 extends Frame {
	private Button newB, exitB; 

	public void init(){
		setLayout(null); // 기본 BorderLayout(동서남북)을 없애버림. 

		newB = new Button("새로 만들기");
		exitB = new Button("종료");

//		newB.setLocation(50, 100); //사용자 지정 위치 (좌표)
//		newB.setSize(80, 50); // 사용자 지정 크기(너비, 높이)
		newB.setBounds(50, 100, 80, 50);
		add(newB);

		exitB.setBounds(50, 150, 50, 50);
		add(exitB);

		setTitle("미니계산기");
		setBounds(700, 100, 300, 400);
		setVisible(true);
	}

	public static void main(String[] args) {
		new AwtTest3().init();

	}
}
