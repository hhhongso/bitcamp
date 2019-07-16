import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.TextArea;

//Frame�� BorderLayout���� ����(�� �� �� �� �߾�). �������Ͽ��� 1���� �ö󰣴�. 2�� �̻� �ø� �� ���� �ø� �� ������
class AwtTest extends Frame {
	private Button newB, exitB; 
	private TextArea area; // Field:�� �� �Է� Area:���� �� �Է�

	public void init(){
		newB = new Button("���� �����");
		exitB = new Button("����");
		area = new TextArea();

		area.setForeground(Color.MAGENTA); // text ������ ����ִ� ��ü�� area. NOT Frame
//		area.setFont(new Font("Verdana", Font.BOLD, 30)); //�۲� ����: �۲�, ��Ÿ��, ũ��
		area.setFont(new Font("Verdana", 1, 30)); // int bold = 1 �̴� �̷��� �� ���� ������. ���������� ����õ

		this.add("North", newB); //��ư ���̱�: (����, ��ü). .ũ�Ⱑ �������� ����.
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
