import java.awt.Color;
import java.awt.CardLayout;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class Card {
	private Frame frame; //BorderLayout default(E W S N C)
	private CardLayout card; 

	public void init(){
		frame = new Frame();
		card = new CardLayout();

		frame.setLayout(card); // ����Ʈ ������ cardLayout���� ������ �׾���.			null �̸� ����Ʈ�� ���� �� 

		Panel[] p = new Panel[5];
		Color[] c = {Color.RED, Color.GREEN, Color.BLUE, Color.MAGENTA, Color.CYAN};
		String[] name = {"����", "�ʷ�", "�Ķ�", "����", "�þ�"};
		for(int i = 0; i < p.length; i++){
			p[i] = new Panel();
			p[i].setBackground(c[i]);
			frame.add(p[i], name[i]); // �гο� �̸� ���̱� 
		
		//Ŭ�� �̺�Ʈ�� for���ȿ��� 
			p[i].addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e){
			//	card.show(frame, "����");
			//	card.next(frame); // ������� next�� 
				card.show(frame, name[(int)(Math.random()*5)]); //��������. ()*4+1 = 1�� ����Ʈ�� [0]=red�� �ȳ��� 

			}
		});
		}	

		


		frame.setBounds(700, 100, 200, 200);
		frame.setVisible(true);

		frame.addWindowListener(new WindowAdapter(){
			@Override
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}		
		});
	}

	public static void main(String[] args) {
		new Card().init();
	}
}
