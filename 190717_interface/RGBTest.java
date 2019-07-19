import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

class RGBTest extends Frame implements ActionListener, WindowListener {
	private Button redB, greenB, blueB; 

	public void init(){
		setBounds(700, 100, 300, 300);
		setTitle("RGB TEST");
		setVisible(true);

		redB = new Button("빨강");
		greenB = new Button("초록");
		blueB = new Button("파랑");

		Panel p = new Panel();
		p.setLayout(new GridLayout(1, 3, 10, 1));
		p.add(redB);
		p.add(greenB);
		p.add(blueB);
		this.add("North", p);

//이벤트 처리
		this.addWindowListener(this);
		redB.addActionListener(this);
		greenB.addActionListener(this);
		blueB.addActionListener(this);

	} //init()

//ActionListener의 메소드 구현 
	public void actionPerformed(ActionEvent e){
		if(e.getSource() == redB){ // .getSource(): 이벤트를 발생시킨 객체의 위치값을 가져온다. 
			this.setBackground(Color.RED); //패널 부분은 색깔이 변하지 않는다. 
		} else if(e.getSource() == greenB){
			this.setBackground(Color.GREEN);
		} else if(e.getSource() == blueB){
			this.setBackground(Color.BLUE);
		}
	}

//WindowListener의 메소드 구현
	public void	windowActivated(WindowEvent e){}
	public void	windowClosed(WindowEvent e){}
	public void	windowClosing(WindowEvent e){
		System.exit(0);
	}
	public void	windowDeactivated(WindowEvent e){}
	public void	windowDeiconified(WindowEvent e) {}
	public void	windowIconified(WindowEvent e){}
	public void	windowOpened(WindowEvent e){}

	
//main method	
	public static void main(String[] args)	{
		RGBTest t = new RGBTest();
		t.init();
		System.out.println(t.redB);
	}
}
