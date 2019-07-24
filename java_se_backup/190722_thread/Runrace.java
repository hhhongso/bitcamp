import java.awt.Button;
import java.awt.Frame;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Panel;
import java.awt.Toolkit;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

//클래스의 기본 Frame: BorderLayout(EWSNC)
class RunRace extends Frame implements ActionListener {
	private int count; 
	private Button button;
	private Racer[] ra;


	public RunRace(String[] args){
		count = Integer.parseInt(args[0]); 
		button = new Button("출발");

		ra = new Racer[count];
		Panel p1 = new Panel(new GridLayout(count, 1, 5, 5));
		for(int i = 0; i < ra.length; i++) {
			ra[i] = new Racer(args[i+1]); // canvas를 상속받았음 == 곧, count만큼 canvas를 생성한 것. 
			ra[i].setName(args[i+1]);
			p1.add(ra[i]);
		}

		Panel p2 = new Panel(new FlowLayout(FlowLayout.RIGHT)); // 오른쪽이 중심이 new Flow1Layout 생성
		//Panel은 FlowLayout(순서대로 배치: 가운데를 중심으로)
		p2.add(button); 

		this.add("Center", p1);
		this.add("South", p2);

		setResizable(false);
		setBounds(1200, 100, 600, 500);
		setVisible(true);

		addWindowListener(new WindowAdapter(){
			@Override
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}		
		});

		button.addActionListener(this); 



	} // 생성자 

	public void actionPerformed(ActionEvent e){
		button.setEnabled(false); // 버튼은 한 번만 누르게 한다. [버튼 비활성화]
		//스레드 생성, 출발 버튼 누르면 스레드 실행
		Thread[] t = new Thread[count];
		for(int i = 0 ; i < count ; i++){
			t[i] = new Thread(ra[i], ra[i].getName()); //이름 args[i+1]

			t[i].setPriority((int)(Math.random()*10)+1);
			t[i].start();
			
		}
	}

	public static void main(String[] args) {
		if(args.length < 2){
			System.out.println("Usage: java RunRace count name1, ... ");
			System.exit(0);
		}

		if(Integer.parseInt(args[0]) != args.length-1) {
			System.out.println("말 마리 수와 이름의 갯수가 다릅니다 !");
			System.exit(0);
		}

		RunRace rr = new RunRace(args);

	}
}
