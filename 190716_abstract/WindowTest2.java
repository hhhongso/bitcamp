import java.awt.Graphics;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.Image;

class WindowTest2 extends Frame {
	public void init(){
		setTitle("�����׼��䳢");
		setBounds(700, 100, 500, 500);
		setVisible(true);
	}

	public void paint(Graphics g){
		g.drawString("�̹���", 100, 80);

		//�̹��� �ҷ�����: Toolkit�� �߻� Ŭ����. sub class�� ����. 
		Toolkit t = Toolkit.getDefaultToolkit();
		Image img = t.getImage("C:/java_se/190716_abstract/rabbit.png"); //���� ��ΰ� �ٸ��ٸ� ���� �Է�: ������

		//�̹��� �׸���
//		g.drawImage(img, 80, 150, this);
				//����,	��ġ:��ǥ	, ��� �׸���?:������ 
		
		g.drawImage(img, 
			0, 0, 800, 800, //ȭ�� ��ġ
			0, 280, 282, 0, //�̹��� ��ġ 
			this);

/*		g.drawImage(img, 
			0, 0, 500, 500, //ȭ�� ��ġ
			280, 282, 0, 0, //�̹��� ��ġ 
			this);
			*/
	}


	public static void main(String[] args) {
		new WindowTest2().init();
	}
}
