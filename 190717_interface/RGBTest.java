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

		redB = new Button("����");
		greenB = new Button("�ʷ�");
		blueB = new Button("�Ķ�");

		Panel p = new Panel();
		p.setLayout(new GridLayout(1, 3, 10, 1));
		p.add(redB);
		p.add(greenB);
		p.add(blueB);
		this.add("North", p);

//�̺�Ʈ ó��
		this.addWindowListener(this);
		redB.addActionListener(this);
		greenB.addActionListener(this);
		blueB.addActionListener(this);

	} //init()

//ActionListener�� �޼ҵ� ���� 
	public void actionPerformed(ActionEvent e){
		if(e.getSource() == redB){ // .getSource(): �̺�Ʈ�� �߻���Ų ��ü�� ��ġ���� �����´�. 
			this.setBackground(Color.RED); //�г� �κ��� ������ ������ �ʴ´�. 
		} else if(e.getSource() == greenB){
			this.setBackground(Color.GREEN);
		} else if(e.getSource() == blueB){
			this.setBackground(Color.BLUE);
		}
	}

//WindowListener�� �޼ҵ� ����
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
