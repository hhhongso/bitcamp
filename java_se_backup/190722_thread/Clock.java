import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import java.text.SimpleDateFormat;
import java.util.Date;

class Clock extends Frame implements Runnable {
	public Clock(String title){
		setFont(new Font("���ü", Font.BOLD, 36));
		setTitle(title);
		setBounds(1200, 100, 300, 100);
		setVisible(true);

		addWindowListener(new WindowAdapter(){
			@Override
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}		
		});

		// thread ����
		//()�� ����ִٸ� t��� thread ��ü�� ���� ��. �츮�� Clock(this = runnable�� ���� Ŭ����)��  thread�� ������. 
		Thread t = new Thread(this); 

		// thread ����
		t.start();
	}

	//Runnable�� �޼ҵ� �籸��: run()�ۿ� ���� 
	//run()�Ͽ� ���� �ð����� ���� ��, �ٽ� main ���� ��������. x ��
	@Override
	public void run() {
		while(true){
			repaint(); //������ �ִ� �������� ������. => �������� ����. => too much data. ������ ���� GC�� 
			try{
				Thread.sleep(1000); // 1s = 1000ms
			} catch (InterruptedException e){
				e.printStackTrace();
			}
			//����ó��: !!!�������̵� �޼ҵ忡�Դ� throws �� �� ���� !!! 
		}
	}

	public void paint(Graphics g){					//a: �������� ����. HH: 24�ð���
		SimpleDateFormat sdf = new SimpleDateFormat("a hh:mm:ss");
		
		//���⿡ while()=> ���ѷ����� ���� �����Ͱ� ���ļ� ��Ÿ����, exit �� ���� ����. ==> ������� ó��.
			Date date = new Date();
			g.drawString(sdf.format(date), 30, 80);
		
	}


	public static void main(String[] args) {
		new Clock("�ð�");
	}
}
