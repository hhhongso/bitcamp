import java.awt.Button;
import java.awt.Color;
import java.awt.Canvas;
import java.awt.Frame;
import java.awt.Panel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

class RGBTest {
	private Frame frame;		// frame Ŭ������ �ʵ��.  (inner class �ƴ�)
	private Button redB, greenB, blueB; 
	private DrCanvas canvas;

	public RGBTest(){
		frame = new Frame();

		redB = new Button("����");
		greenB = new Button("�ʷ�");
		blueB = new Button("�Ķ�");

		canvas = new DrCanvas();

		Panel p = new Panel();
		p.add(redB);
		p.add(greenB);
		p.add(blueB);

		frame.add("North", p);
		frame.add("Center", canvas);
//		canvas.setBackground(Color.YELLOW); �̷��� �ǰ�, Drcanvas Ŭ���� �ʿ��� ����൵ �ǰ� 

		frame.setBounds(700, 100, 300, 300);
		frame.setVisible(true);

		//�̺�Ʈ �߻�
		frame.addWindowListener(new WindowAdapter(){ //WindowAdapter�� ��� �޼ҵ尡 �� �ٵ�� �̷���� �߻� Ŭ����
			@Override
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		}); //anonymous inner class$1

		//��ư �̺�Ʈ �߻�				//�߻�޼ҵ尡 �ϳ��ۿ� ���� (���� ����� ����)
		redB.addActionListener(new ActionListener(){			//�ܹ߼�����, 1���� ����ǰ� ���� 
			@Override
			public void actionPerformed(ActionEvent e) {
				canvas.setBackground(Color.RED);
			}		
		});
		greenB.addActionListener(new ActionListener(){	
			@Override
			public void actionPerformed(ActionEvent e) {
				canvas.setBackground(Color.GREEN);
			}		
		});
		blueB.addActionListener(new ActionListener(){	
			@Override
			public void actionPerformed(ActionEvent e) {
				canvas.setBackground(Color.BLUE);
			}		
		});

/*		frame.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(e.getSource() == redB){
					canvas.setBackground(Color.RED);
				}
			}
		});
*/
	}

	class DrCanvas extends Canvas{ //Canvas: �ݵ�� ������־�� ��. �ƿ���Ŭ�������� ���, �̳�Ŭ�������� ��� ��� ����. �̳�Ŭ������ �ƿ��Ϳ� ���� ���� 
		public DrCanvas(){
			this.setBackground(Color.YELLOW);
		}
	} 

	public static void main(String[] args) {
		new RGBTest();
	}
}
