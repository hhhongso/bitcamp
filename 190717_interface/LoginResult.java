import java.awt.Frame;
import java.awt.Graphics;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

//		idT: angel
//		pwT: 1004 ==> 로그인 성공!이라는 창 띄우기. x를 누르면 해당 창만 종료. else 로그인 실패

class LoginResult extends Frame implements WindowListener {
	private String id, pw;

	public LoginResult(String id, String pw){
		this.id = id; 
		this.pw = pw; 

		setBounds(900, 100, 200, 200);
		setTitle("로그인 성공?");
		setVisible(true);

		this.addWindowListener(this);

	}
	
	public void paint(Graphics g){
		if(id.equals("angel") && pw.equals("1004")){
			g.drawString("로그인 성공!", 50, 100);
		} else {
			g.drawString("로그인 실패!!!!", 50, 100);
		}
	}

//WindowListener의 메소드 구현 (Event Handler)
	public void	windowActivated(WindowEvent e){}
	public void	windowClosed(WindowEvent e){}
	public void	windowClosing(WindowEvent e){
		setVisible(false);
		//this.dispose();
	}
	public void	windowDeactivated(WindowEvent e){}
	public void	windowDeiconified(WindowEvent e) {}
	public void	windowIconified(WindowEvent e){}
	public void	windowOpened(WindowEvent e){}
}

