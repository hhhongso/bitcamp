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

//Ŭ������ �⺻ Frame: BorderLayout(EWSNC)
class RunRace extends Frame implements ActionListener {
	private int count; 
	private Button button;
	private Racer[] ra;


	public RunRace(String[] args){
		count = Integer.parseInt(args[0]); 
		button = new Button("���");

		ra = new Racer[count];
		Panel p1 = new Panel(new GridLayout(count, 1, 5, 5));
		for(int i = 0; i < ra.length; i++) {
			ra[i] = new Racer(args[i+1]); // canvas�� ��ӹ޾��� == ��, count��ŭ canvas�� ������ ��. 
			ra[i].setName(args[i+1]);
			p1.add(ra[i]);
		}

		Panel p2 = new Panel(new FlowLayout(FlowLayout.RIGHT)); // �������� �߽��� new Flow1Layout ����
		//Panel�� FlowLayout(������� ��ġ: ����� �߽�����)
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



	} // ������ 

	public void actionPerformed(ActionEvent e){
		button.setEnabled(false); // ��ư�� �� ���� ������ �Ѵ�. [��ư ��Ȱ��ȭ]
		//������ ����, ��� ��ư ������ ������ ����
		Thread[] t = new Thread[count];
		for(int i = 0 ; i < count ; i++){
			t[i] = new Thread(ra[i], ra[i].getName()); //�̸� args[i+1]

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
			System.out.println("�� ���� ���� �̸��� ������ �ٸ��ϴ� !");
			System.exit(0);
		}

		RunRace rr = new RunRace(args);

	}
}
