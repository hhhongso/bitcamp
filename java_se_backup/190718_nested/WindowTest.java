import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class WindowTest extends Frame {
	public WindowTest(){
		setBounds(700, 100, 300, 400);
		setTitle("windowTEST");
		setVisible(true);

		//이벤트 발생
		this.addWindowListener(new WindowAdapter(){ //WindowAdapter는 모든 메소드가 빈 바디로 이루어진 추상 클래스
			@Override
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		}); //anonymous inner class$1

		this.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseEntered(MouseEvent e){
				System.out.println("마우스 IN");
			}
			@Override
			public void mouseExited(MouseEvent e){
				System.out.println("마우스 OUT");
			}
		
		});
	}



//main
	public static void main(String[] args) {
		new WindowTest();

	}
}


