/* ������ â �����*/

import java.awt.Frame;
import java.awt.Color;
import java.awt.Graphics;

class WindowTest extends Frame {
	public WindowTest(){
		super("���� ���� ������"); // Frame Ŭ����[��Ӱ���]�� �������Լ��� title ����.			.setTitle() ���ε� ����.
//		new Frame("���� ���� ������3").setVisible(true);
		
		System.out.println("���� �����");

		//������ â ����Ʈ ������: white / ���ڻ�: black
//		setBackground(Color.ORANGE); // Color�� �ʵ�� static �����, new�� ��ü�������� �ʾƵ� �ȴ�.
		
		setBackground(new Color(208, 245, 97)); // ����� ���� ���� ��: Color Ŭ������ ������ �Լ� ȣ���� ���Ͽ� ����.
		//���ڻ�
		setForeground(new Color(255, 0, 0));

//		this.setSize(300, 400); //������ â ũ�� ����: Window Ŭ���� - Frame - WindowTest ������ ���. 
		setBounds(700,100,300,400); // ������ â ���� ��ġ, ũ�� ����.
		setVisible(true); //true�� �����ֱ�. false�� �����. ex)�α��� â �˾� 
	} 
	
	@Override // Call back Method: ������ �� �� ��, � ������ ������ �Ǹ�, JVM(�ü��)�� ȣ�� 		ex)void main(), run()
	public void paint(Graphics g){ //paint()�� ���, setVisible() �� �� ����. 
		g.drawString("���� �����", 100, 100);	//��ġ ����
		g.drawLine(100, 150, 200, 250); //�� �� �� x, y��ǥ ���
		g.drawRect(100, 250, 100, 100); // x��ǥ, y��ǥ�� �߽��� ����, �ʺ�, ����
		g.drawOval(150, 250, 100, 100); // �߽������� �ʺ�� ���̸� ���� => Rect���� ���� �������� �׸���. 
	}


	public static void main(String[] args){
		WindowTest wt = new WindowTest();

	}
}



// POJO(Plain Old Java Object): �� ������ ��ӵ� ���� ����, �Ϲ����� Ŭ����.
//WindowTest is a Frame [ Frame�� java���� ����: windowâ�� ������ִ� Ŭ����]

