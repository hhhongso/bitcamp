import java.awt.Frame;
import java.awt.Graphics;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

//		idT: angel
//		pwT: 1004 ==> �α��� ����!�̶�� â ����. x�� ������ �ش� â�� ����. else �α��� ����

class LoginResult extends Frame implements WindowListener {
	private String id, pw;

	public LoginResult(String id, String pw){
		this.id = id; 
		this.pw = pw; 

		setBounds(900, 100, 200, 200);
		setTitle("�α��� ����?");
		setVisible(true);

		this.addWindowListener(this);

	}
	
	public void paint(Graphics g){
		if(id.equals("angel") && pw.equals("1004")){
			g.drawString("�α��� ����!", 50, 100);
		} else {
			g.drawString("�α��� ����!!!!", 50, 100);
		}
	}

//WindowListener�� �޼ҵ� ���� (Event Handler)
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

