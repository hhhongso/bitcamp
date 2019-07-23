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
	private Frame frame;		// frame 클래스를 필드로.  (inner class 아님)
	private Button redB, greenB, blueB; 
	private DrCanvas canvas;

	public RGBTest(){
		frame = new Frame();

		redB = new Button("빨강");
		greenB = new Button("초록");
		blueB = new Button("파랑");

		canvas = new DrCanvas();

		Panel p = new Panel();
		p.add(redB);
		p.add(greenB);
		p.add(blueB);

		frame.add("North", p);
		frame.add("Center", canvas);
//		canvas.setBackground(Color.YELLOW); 이래도 되고, Drcanvas 클래스 쪽에서 잡아줘도 되고 

		frame.setBounds(700, 100, 300, 300);
		frame.setVisible(true);

		//이벤트 발생
		frame.addWindowListener(new WindowAdapter(){ //WindowAdapter는 모든 메소드가 빈 바디로 이루어진 추상 클래스
			@Override
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		}); //anonymous inner class$1

		//버튼 이벤트 발생				//추상메소드가 하나밖에 없음 (따로 어댑터 없음)
		redB.addActionListener(new ActionListener(){			//단발성으로, 1번만 진행되고 끝남 
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

	class DrCanvas extends Canvas{ //Canvas: 반드시 상속해주어야 함. 아우터클래스에서 상속, 이너클래스에서 상속 모두 가능. 이너클래스는 아우터에 접근 가능 
		public DrCanvas(){
			this.setBackground(Color.YELLOW);
		}
	} 

	public static void main(String[] args) {
		new RGBTest();
	}
}
