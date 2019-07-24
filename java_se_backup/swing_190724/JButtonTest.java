import java.awt.*;
import javax.swing.*;

class JButtonTest extends JFrame {
	private Icon icon1 = new ImageIcon("rabbit1.gif");
	private Icon icon2 = new ImageIcon("rabbit2.gif");
	private Icon icon3 = new ImageIcon("rabbit3.gif");
	private Icon icon4 = new ImageIcon("rabbit4.gif");

	private JRadioButton[] jb = new JRadioButton[4];
	private ButtonGroup bg = new ButtonGroup();

	public JButtonTest(){
		super("TEST"); //setittle
		Container con = this.getContentPane();
		con.setLayout(new GridLayout(2,2));

		for(int i = 0; i < 4 ; i++){
			jb[i] = new JRadioButton(i+1 + "번 버튼", icon1);
			con.add(jb[i]);

			jb[i].setToolTipText(i+1 + "번째 버튼 클릭!");
			jb[i].setMnemonic(i+49); //단축기 추가하기: alt+ ascii 49 == 1
			jb[i].setRolloverIcon(icon2);
			jb[i].setPressedIcon(icon3);
			jb[i].setSelectedIcon(icon4);
			bg.add(jb[i]);

		}
		pack(); //컴포넌트 크기에 따라 사이즈 조절 
		setVisible(true);
	}

	public static void main(String[] args) {
		new JButtonTest();
	}
}
