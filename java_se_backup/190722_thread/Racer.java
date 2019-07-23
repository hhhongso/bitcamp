import java.awt.Color;
import java.awt.Canvas;
import java.awt.GridLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;


// Canvas�� Component. Panel�� Component ==> ������ ���� �Ұ�. 
					
class Racer extends Canvas implements Runnable { 
	private int x = 0;
	private String argName;
	private int[] runtime;

	private static int rank;

	public Racer(String argName){
//		setBackground(new Color(0, (int)(Math.random()*256), (int)(Math.random()*256)));
		this.argName = argName;

	}

	public void paint(Graphics g){
		Image img = Toolkit.getDefaultToolkit().getImage("horse.gif");
		g.drawImage(img, x, 0, 70, this.getSize().height, this);
						//��ǥ, �ʺ�, ����= ĵ������ ������� ���̸� �����´�. 
	}

	public void run(){
		for(int i = 0; i < this.getSize().width; i+=(int)(Math.random()*10)+10) {
			synchronized(Racer.class) {
				x = i;				
				//runtime[i] = t[i].getThreadCpuTime(Thread.currentThread());			
				repaint();

				try{
					Thread.sleep(100);
				} catch (InterruptedException e){
					e.printStackTrace();
				}
			}
			
		}
	rank++;
	System.out.println(rank + "����?: " + Thread.currentThread().getName() + "�Դϴ�!!!");


	}


} // ������
	