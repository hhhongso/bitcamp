import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

class WindowExit implements WindowListener {

	public void	windowActivated(WindowEvent e){}
	public void	windowClosed(WindowEvent e){}
	public void	windowClosing(WindowEvent e){
		System.exit(0); // ���α׷� ���� ����(��������)	// (1)���ε� ���� �ǳ�, ������ ���� 
	}
	public void	windowDeactivated(WindowEvent e){}
	public void	windowDeiconified(WindowEvent e) {}
	public void	windowIconified(WindowEvent e){}
	public void	windowOpened(WindowEvent e){}
}

/*
windowListener�� ������ â�� �ִ� ���¿��� ����Ǵ� ��. 
=> WindowListner�� �籸�� �ϴ� Ŭ������, �������̽� �籸���� ���Ҹ� �ϱ� ������, 
void main ���� �ǹ̰� ����. 
*/