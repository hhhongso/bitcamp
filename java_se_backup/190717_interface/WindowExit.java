import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

class WindowExit implements WindowListener {

	public void	windowActivated(WindowEvent e){}
	public void	windowClosed(WindowEvent e){}
	public void	windowClosing(WindowEvent e){
		System.exit(0); // 프로그램 강제 종료(정상종료)	// (1)으로도 종료 되나, 비정상 종료 
	}
	public void	windowDeactivated(WindowEvent e){}
	public void	windowDeiconified(WindowEvent e) {}
	public void	windowIconified(WindowEvent e){}
	public void	windowOpened(WindowEvent e){}
}

/*
windowListener는 윈도우 창이 있는 상태에서 진행되는 것. 
=> WindowListner를 재구현 하는 클래스는, 인터페이스 재구현의 역할만 하기 때문에, 
void main 점이 의미가 없다. 
*/