package bitProject.cafe;

import javax.swing.JFrame;

public class Frame extends JFrame{
	public Frame() {
		Order order = new Order();
		getContentPane().add(order);
		
		order.event();
		setBounds(700, 100, 700, 400);
		setVisible(true);
		
	}
	
	public static void main(String[] args) {
		new Frame();
	}
}
