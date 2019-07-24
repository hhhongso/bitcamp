import java.awt.Color;
import java.awt.Container;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class MSPaint extends JFrame {
	private JLabel x1L, x2L, y1L, y2L, z1L, z2L; 
	private JTextField x1T, x2T, y1T, y2T, z1T, z2T;
	private JCheckBox fill; 
	private JRadioButton line, circle, rect, roundRect, pen; 
	private JComboBox<String> combo; 
	private JButton drawB; 
	private DrCanvas can;

	public JTextField getX1T(){
		return x1T;
	}
	public JTextField getX2T(){
		return x2T;
	}
	public JTextField getY1T(){
		return y1T;
	}
	public JTextField getY2T(){
		return y2T;
	}
	public JTextField getZ1T(){
		return z1T;
	}
	public JTextField getZ2T(){
		return z2T;
	}

	public JComboBox<String> getCombo(){
		return combo;
	}

	public JCheckBox getFill(){
		return fill;
	}

	public JRadioButton getLine(){
		return line;
	}

	public JRadioButton getCircle(){
		return circle;
	}

	public JRadioButton getRect(){
		return rect;
	}

	public JRadioButton getRoundRect(){
		return roundRect;
	}

	public JRadioButton getPen(){
		return pen;
	}

/*	public String getX1T(){
		return x1T.getText();
	}

	public String getX2T(){
		return x2T.getText();
	}
	public String getY1T(){
		return y1T.getText();
	}
	public String getY2T(){
		return y2T.getText();
	}
	public String getZ1T(){
		return z1T.getText();
	}
	public String getZ2T(){
		return z2T.getText();
	}
 */

	public MSPaint(){
		x1L = new JLabel("X1");		y1L = new JLabel("Y1");		z1L = new JLabel("Z1");
		x2L = new JLabel("X2");		y2L = new JLabel("Y2");		z2L = new JLabel("Z2");
	
	//paint()가 콜백이라, 처음 실행 시 numberformatException ==> new 생성 시 초기값을 주어 Exception 제거 
		x1T = new JTextField("0", 4);	y1T = new JTextField("0", 4);	z1T = new JTextField("50", 4);
		x2T = new JTextField("0", 4);	y2T = new JTextField("0", 4);	z2T = new JTextField("50", 4);
		
		fill = new JCheckBox("채우기");
									//초기값에 선택되어 있도록 설정
		line = new JRadioButton("선", true);		rect = new JRadioButton("사각형");
		circle = new JRadioButton("원");		roundRect = new JRadioButton("둥근사각형");
		pen = new JRadioButton("연필");
		//라디오버튼은 1개만 선택되도록, 그룹핑 
		ButtonGroup group = new ButtonGroup();
		group.add(line);
		group.add(circle);
		group.add(rect);
		group.add(roundRect);
		group.add(pen);
				
		String[] color = {"빨강", "초록", "파랑", "보라", "하늘"};
		combo = new JComboBox<String>(color);
		drawB = new JButton("그리기");
						//DrCanvas에 MSPaint 값을 넘겨줌 
		can = new DrCanvas(this);
		
		Container c = this.getContentPane();
		JPanel p1 = new JPanel();
		p1.add(x1L);		p1.add(x1T);		
		p1.add(y1L);		p1.add(y1T);
		p1.add(x2L);		p1.add(x2T);
		p1.add(y2L);		p1.add(y2T);
		p1.add(z1L);		p1.add(z1T);
		p1.add(z2L);		p1.add(z2T);
		p1.add(fill);

		JPanel p2 = new JPanel();
		p2.add(line);
		p2.add(circle);
		p2.add(rect);
		p2.add(roundRect);
		p2.add(pen);
		p2.add(combo);
		p2.add(drawB);

		c.add("North", p1);
		c.add("South", p2);
		c.add("Center", can);

	/*	combo.addItem(Color.RED); 이렇게 하려면 컬러 이미지 > 이미지를 add*/ 

	/*	combo.addItem("빨강");
		combo.addItem("초록");
		combo.addItem("파랑");
		combo.addItem("보라");
		combo.addItem("하늘");  */
		

		setBounds(1000, 100, 700, 500);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		drawB.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {		
				can.repaint();
			}
		});
		
		can.addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent e){
				x1T.setText(e.getX()+"");
				y1T.setText(e.getY()+"");
			}		
		});

		can.addMouseMotionListener(new MouseAdapter(){
			public void mouseDragged(MouseEvent e){
					x2T.setText(e.getX()+"");
					y2T.setText(e.getY()+"");
					can.repaint();
			}
		});

		
		
		
	} // constructor


// 메인 ================================================================================
	public static void main(String[] args) {
		new MSPaint();

	}
}
