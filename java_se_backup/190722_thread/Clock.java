import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import java.text.SimpleDateFormat;
import java.util.Date;

class Clock extends Frame implements Runnable {
	public Clock(String title){
		setFont(new Font("고딕체", Font.BOLD, 36));
		setTitle(title);
		setBounds(1200, 100, 300, 100);
		setVisible(true);

		addWindowListener(new WindowAdapter(){
			@Override
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}		
		});

		// thread 생성
		//()가 비어있다면 t라는 thread 객체를 만든 것. 우리는 Clock(this = runnable을 가진 클래스)을  thread로 만들자. 
		Thread t = new Thread(this); 

		// thread 시작
		t.start();
	}

	//Runnable의 메소드 재구현: run()밖에 없음 
	//run()하여 일정 시간동안 들어온 뒤, 다시 main 으로 빠져나감. x ∞
	@Override
	public void run() {
		while(true){
			repaint(); //기존에 있던 페인팅은 버려짐. => 겹쳐지지 않음. => too much data. 버려진 것은 GC로 
			try{
				Thread.sleep(1000); // 1s = 1000ms
			} catch (InterruptedException e){
				e.printStackTrace();
			}
			//예외처리: !!!오버라이드 메소드에게는 throws 할 수 없다 !!! 
		}
	}

	public void paint(Graphics g){					//a: 오전오후 구분. HH: 24시간제
		SimpleDateFormat sdf = new SimpleDateFormat("a hh:mm:ss");
		
		//여기에 while()=> 무한루프에 빠져 데이터가 겹쳐서 나타나며, exit 할 수도 없음. ==> 스레드로 처리.
			Date date = new Date();
			g.drawString(sdf.format(date), 30, 80);
		
	}


	public static void main(String[] args) {
		new Clock("시계");
	}
}
