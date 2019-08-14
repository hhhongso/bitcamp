package mini;

import javax.swing.JPanel;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class GrapeTest extends JPanel implements ActionListener {
	private int x; 
	private JPanel[] p;
	private JButton[] btnGrape;
	public static final Color color = new Color(94, 50, 168);
	public static final Color selectedColor = new Color(255, 255, 255);
	
	
	public GrapeTest() {
		setLayout(new GridLayout(20, 1));
		p = new JPanel[20];
		for (int i = 0; i < p.length; i++) {
			p[i] = new JPanel();
			this.add(p[i]);
		}
		
		
		btnGrape = new JButton[20];
		
		for (int i = 0; i < btnGrape.length; i++) {
			for (int j = 0; j < p.length; j++) {
				btnGrape[j] = new JButton();				
				btnGrape[j].setBounds(12 + x, 10, 20, 20);
				x += 22;
				btnGrape[j].setBackground(color);
				btnGrape[j].add(p[j]);
				add(btnGrape[j]);
				
				btnGrape[j].addActionListener(this);
			}
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		for (int i = 0; i < btnGrape.length; i++) {
			if(e.getSource() == btnGrape[i]) {
				btnGrape[i].setBackground(selectedColor);			
		}
	}
	
				
	}
	
	public static void main(String[] args) {
		JFrame f = new JFrame();
		GrapeTest g = new GrapeTest();
		f.add(g);
		f.setBounds(700, 100, 500, 500);
		f.setResizable(false);
		f.setVisible(true);
			
	}



	
}
