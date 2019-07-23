import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.GridLayout;

class AwtTest2 extends Frame {
	private Button newB, exitB; 

	public void init(){
		newB = new Button("���� �����");
		exitB = new Button("����");

		//FlowLayout(������� ��ġ. �߾����� ��ġ��) > button�� ���ڼ��� ���� ũ�� �޶��� >> ũ�⸦ ���� �Ϸ���, �յ��ġ
		Panel p = new Panel();
		p.setLayout(new GridLayout(1, 2, 5, 5)); //�յ��ġ(��Ĺ�ġ): (��, ��, ���ο���, ���ο���)
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
