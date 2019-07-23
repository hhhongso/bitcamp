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

		//�̺�Ʈ �߻�
		this.addWindowListener(new WindowAdapter(){ //WindowAdapter�� ��� �޼ҵ尡 �� �ٵ�� �̷���� �߻� Ŭ����
			@Override
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		}); //anonymous inner class$1

		this.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseEntered(MouseEvent e){
				System.out.println("���콺 IN");
			}
			@Override
			public void mouseExited(MouseEvent e){
				System.out.println("���콺 OUT");
			}
		
		});
	}



//main
	public static void main(String[] args) {
		new WindowTest();

	}
}


