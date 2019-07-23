package kr.co.bit;

import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.text.SimpleDateFormat;
import java.util.Date;



public class Clock extends Frame implements Runnable {
	
	public Clock() {
		setFont(new Font("궁서체", Font.ITALIC, 30));
		setBounds(700, 100, 500, 500);
		setVisible(true);
		
		Thread t = new Thread(this);
		t.start();
	}
	
	public void paint(Graphics g) {
		SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
		 Date date = new Date();
		g.drawString(sdf.format(date), 100, 200);
		
	}

	
	public static void main(String[] args) {
		new Clock();
	}

	@Override
	public void run() {
		while(true) {
			repaint();
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}			
		}
		
	}
}
