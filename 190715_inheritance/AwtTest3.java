import java.awt.Button;
import java.awt.Frame;

class AwtTest3 extends Frame {
	private Button newB, exitB; 

	public void init(){
		setLayout(null); // �⺻ BorderLayout(��������)�� ���ֹ���. 

		newB = new Button("���� �����");
		exitB = new Button("����");

//		newB.setLocation(50, 100); //����� ���� ��ġ (��ǥ)
//		newB.setSize(80, 50); // ����� ���� ũ��(�ʺ�, ����)
		newB.setBounds(50, 100, 80, 50);
		add(newB);

		exitB.setBounds(50, 150, 50, 50);
		add(exitB);

		setTitle("�̴ϰ���");
		setBounds(700, 100, 300, 400);
		setVisible(true);
	}

	public static void main(String[] args) {
		new AwtTest3().init();

	}
}
