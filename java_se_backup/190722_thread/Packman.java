import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

class Packman extends Frame implements KeyListener, Runnable {
	private int x = 225, y = 275;
	private int sel = 2; // �� 8�� 
	private int mx, my;  

	private int[] foodx = new int[5];
	private int[] foody = new int[5]; 


	public Packman(){
		setTitle("�Ѹ�");
		setResizable(false);
		setBounds(1200, 100, 500, 500);
		setVisible(true);
		
		for(int i = 0; i < foodx.length; i++){
			foodx[i] = (int)(Math.random()*461)+20;
			foody[i] = (int)(Math.random()*461)+20;
		}

		addWindowListener(new WindowAdapter(){
			@Override
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}		
		});

		this.addKeyListener(this);

		Thread t = new Thread(this);
		t.start();
	} // constructor

	@Override
	public void paint(Graphics g){ 
		Image img = Toolkit.getDefaultToolkit().getImage("packman.jpg");
		Image img2 = Toolkit.getDefaultToolkit().getImage("eat.jpg");

//		g.drawImage(img, 100, 100, this);
		
	
		for(int i = 0; i < foodx.length; i++){
			g.drawImage(img2, foodx[i], foody[i], this);
		}

		g.drawImage(img, 
			x, y, x+50, y+50,			//x1, y1, x2, y2 ȭ����ġ
			sel*50, 0, sel*50+50, 50, 			//�̹���(�޸�)��ġ: ������ ���¾ְ� 100, 0, 150, 50
			this);
	}

	@Override
	public void run(){
		while(true){	
	
			if(sel % 2 ==0) sel++;
			else sel--; 

			x = x + mx; 
			y = y + my; 

			if(x < -50) x = 500; 
			else if (x > 500) x = -50;
			else if (y < -50) y = 500;
			else if (y > 500) y = -50;
			
			for(int i = 0; i < foodx.length; i++) {
				if((x+25 > foodx[i]-10 && y+25 > foody[i]-10) &&
					(x+25 < foodx[i]+30 && y+25 < foody[i]+30)) { 
					foodx[i] = 100; foody[i] = 100;
				}	
			} 
		
			repaint(); //keyListener�� �ƴ϶� run����  sel++ / sel-- & repaint()
			
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e){
				e.printStackTrace();
			}		
		} // while
	}


	@Override
	public void keyPressed(KeyEvent e){
		if(e.getKeyCode() == e.VK_ESCAPE){	
			System.exit(0); // e.VK_ESCAPE = 27;
		} else if(e.getKeyCode() == e.VK_LEFT){
			sel = 0;	mx = -10;	my = 0; 
		} else if(e.getKeyCode() == e.VK_RIGHT){
			sel = 2;	mx = 10;	my = 0; 
		} else if(e.getKeyCode() == e.VK_UP){
			sel = 4;	mx = 0;		my = -10; 
		} else if(e.getKeyCode() == e.VK_DOWN){
			sel = 6;	mx = 0;		my = 10; 
		}
	}
	
	@Override
	public void keyReleased(KeyEvent e){}
	
	@Override
	public void	keyTyped(KeyEvent e){}


	public static void main(String[] args) {
		new Packman();
	}
}