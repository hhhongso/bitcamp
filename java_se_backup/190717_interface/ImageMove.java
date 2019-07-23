import java.awt.Button;
import java.awt.Color;
import java.awt.Image;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.Toolkit;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

class ImageMove extends Frame implements ActionListener, WindowListener {
	private Button newB, leftB, upB, downB, rightB;
	private int x, y; 

	public ImageMove(){
		setBounds(700, 100, 500, 500);
		setTitle("이미지 이동");
		setVisible(true);

		x = 100;		y = 100; 

		newB = new Button("초기화");
		leftB = new Button("←");
		rightB = new Button("→");
		upB = new Button("↑");
		downB = new Button("↓");

		Panel p = new Panel();
		p.setLayout(new GridLayout(1, 5, 2, 2));
		p.add(newB);
		p.add(leftB);
		p.add(rightB);
		p.add(upB);
		p.add(downB);
		this.add("North",p);

		this.addWindowListener(this);
		newB.addActionListener(this);
		leftB.addActionListener(this);
		rightB.addActionListener(this);
		upB.addActionListener(this);
		downB.addActionListener(this);
		}

		public void paint(Graphics g){
			Toolkit t = Toolkit.getDefaultToolkit();
			Image img = t.getImage("C:/java_se/190716_abstract/rabbit.png");
							//좌표	//이미지 크기
			g.drawImage(img, x, y, 300, 300, this); 
		}

//ActionListener의 메소드 구현 (Event Handler)
	public void actionPerformed(ActionEvent e){
		//if(e.getSource() == newB){ // .getSource(): 이벤트를 발생시킨 객체의 위치값을 가져온다. 
//			초기화

		// 버튼의 타이틀로 확인: "초기화" 문자열 자체가 아닌, 해당 문자열의 참조값을 비교하는 것. .equals()가 아니라 == 으로 가능
		if(e.getActionCommand() == "초기화")		x = y = 100;		
		else if(e.getSource() == leftB){
			x -= 10;	y+=10;
			if(x < -80) 	x = 500;
		} else if(e.getSource() == rightB){
			x += 10;			
			if(x > 500) 	x = -80;
		} else if(e.getSource() == upB){
			y-= 10;			
			if(y < -30)		y = 500;
		} else if(e.getSource() == downB){
			y+= 10;
			if(y > 470) 	y = -80;
		}
		System.out.println("x:" + x + "	y: " + y);
		repaint();

	}


//WindowListener의 메소드 구현 (Event Handler)
	public void	windowActivated(WindowEvent e){}
	public void	windowClosed(WindowEvent e){}
	public void	windowClosing(WindowEvent e){
		System.exit(0);
	}
	public void	windowDeactivated(WindowEvent e){}
	public void	windowDeiconified(WindowEvent e) {}
	public void	windowIconified(WindowEvent e){}
	public void	windowOpened(WindowEvent e){}

//main 점
	public static void main(String[] args) {
		new ImageMove();
	}
}



/*
class Object{
	public boolean equals(Object obj){ >> 참조값(주소값) 비교
	}
}

class String extends Object {
	public boolean equals(Object obj){ >> 문자열 비교
	}
}
*/