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

		frame.setLayout(card); // 디폴트 깨지고 cardLayout으로 층층이 쌓아짐.			null 이면 디폴트를 깨는 것 

		Panel[] p = new Panel[5];
		Color[] c = {Color.RED, Color.GREEN, Color.BLUE, Color.MAGENTA, Color.CYAN};
		String[] name = {"빨강", "초록", "파랑", "보라", "시안"};
		for(int i = 0; i < p.length; i++){
			p[i] = new Panel();
			p[i].setBackground(c[i]);
			frame.add(p[i], name[i]); // 패널에 이름 붙이기 
		
		//클릭 이벤트도 for문안에서 
			p[i].addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e){
			//	card.show(frame, "보라");
			//	card.next(frame); // 순서대로 next함 
				card.show(frame, name[(int)(Math.random()*5)]); //랜덤으로. ()*4+1 = 1이 디폴트라 [0]=red가 안나옴 

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
