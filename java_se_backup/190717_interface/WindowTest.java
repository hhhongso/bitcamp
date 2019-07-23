import java.awt.Button;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;


class WindowTest extends Frame implements MouseListener, MouseMotionListener, ActionListener {
	private Button exitB; 
	private int x, y; 

	
	public WindowTest(){
		exitB = new Button("��! ");
		this.add("North", exitB);


		setBounds(700, 100, 500, 500);
		setTitle("WindowTest 0717");
		setVisible(true);

		//�̺�Ʈ ó��: 
		//EventSource.addEventListener(EventHandler�� ��ġ) �� ��ġ�� ������ �˾Ƽ� ã�ư�
		//eventsource��ġ, handler ��ġ�� ��� �� �ڽ� Ŭ���� >this 
		//�ٸ� Ŭ������ ��ζ�� new �Ͽ� ��ü ���� 
		this.addMouseListener(this);	
		this.addMouseMotionListener(this);
		this.addWindowListener(new WindowExit());
		
		//������ ��ư���� �׼� ����	//���� handler�� �� �ڽ� Ŭ������ ���� 
		exitB.addActionListener(this);
	}	

	public void actionPerformed(ActionEvent e){
		System.exit(0);
	}

	public void paint(Graphics g){
		g.drawString("x: " + x + "	y: "+ y, x, y); //setVisible() > callback����. �ʱⰪ(0,0)
	}

	public void mouseClicked(MouseEvent e){
		System.out.println("���콺 Ŭ��");
		x = e.getX();		y = e.getY();
		System.out.println("x��ǥ: " + x + "	y��ǥ: "+ y);
//		System.out.println(e.getPoint());	
		repaint();	//call-back�Լ��� paint�� �ٽ� �ҷ��� 
	}

	public void	mouseEntered(MouseEvent e){
		System.out.println("���콺 IN");	
	}
	public void	mouseExited(MouseEvent e){
		System.out.println("���콺 OUT");
	}
	public void	mousePressed(MouseEvent e){}
	public void	mouseReleased(MouseEvent e){}

	public void	mouseDragged(MouseEvent e) {
		System.out.println("���콺 DRAG");
	}
	public void	mouseMoved(MouseEvent e) {}

	public static void main(String[] args) {
		new WindowTest();
	}
}
