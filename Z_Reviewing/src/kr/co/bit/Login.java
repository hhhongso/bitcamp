package kr.co.bit;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;


public class Login extends JFrame {
	public Login() {
		setTitle("로그인?");
		setContentPane(new MyPanel());
		setBounds(700, 100, 300, 400);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		login.
	}
	
	class MyPanel extends JPanel{
		private JButton login, cancel;
		private JLabel id, pw; 
		private JTextArea idtxt, pwtxt;
		
		public MyPanel() {
			setLayout(new BorderLayout());
			login = new JButton("로그인");
			cancel = new JButton("취소");
			
			id = new JLabel("아이디");
			pw = new JLabel("패스워드");
			
			idtxt = new JTextArea();
			pwtxt = new JTextArea();
			
			JPanel p1 = new JPanel();		
			JPanel p2 = new JPanel();
			
			p1.add(login);
			p1.add(cancel);
			
			p2.setLayout(new GridLayout(2, 2, 5, 5));
			p2.add(id);
			p2.add(idtxt);
			p2.add(pw);
			p2.add(pwtxt);		
			
			add("South", p1);
			add("North", p2);
		}
		
		public void paintComponent(Graphics g) {
			Image img1 = Toolkit.getDefaultToolkit().getImage("packman.jpg");	
			g.drawImage(img1, 200, 200, this);
		}
	}
	
	public static void main(String[] args) {
		new Login();
	}
}
