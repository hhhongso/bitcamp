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
		exitB = new Button("끝! ");
		this.add("North", exitB);


		setBounds(700, 100, 500, 500);
		setTitle("WindowTest 0717");
		setVisible(true);

		//이벤트 처리: 
		//EventSource.addEventListener(EventHandler의 위치) ⇒ 위치만 찍으면 알아서 찾아감
		//eventsource위치, handler 위치가 모두 나 자신 클래스 >this 
		//다른 클래스가 경로라면 new 하여 객체 생성 
		this.addMouseListener(this);	
		this.addMouseMotionListener(this);
		this.addWindowListener(new WindowExit());
		
		//끝내기 버튼에서 액션 시작	//구현 handler는 내 자신 클래스에 있음 
		exitB.addActionListener(this);
	}	

	public void actionPerformed(ActionEvent e){
		System.exit(0);
	}

	public void paint(Graphics g){
		g.drawString("x: " + x + "	y: "+ y, x, y); //setVisible() > callback실행. 초기값(0,0)
	}

	public void mouseClicked(MouseEvent e){
		System.out.println("마우스 클릭");
		x = e.getX();		y = e.getY();
		System.out.println("x좌표: " + x + "	y좌표: "+ y);
//		System.out.println(e.getPoint());	
		repaint();	//call-back함수인 paint를 다시 불러옴 
	}

	public void	mouseEntered(MouseEvent e){
		System.out.println("마우스 IN");	
	}
	public void	mouseExited(MouseEvent e){
		System.out.println("마우스 OUT");
	}
	public void	mousePressed(MouseEvent e){}
	public void	mouseReleased(MouseEvent e){}

	public void	mouseDragged(MouseEvent e) {
		System.out.println("마우스 DRAG");
	}
	public void	mouseMoved(MouseEvent e) {}

	public static void main(String[] args) {
		new WindowTest();
	}
}
