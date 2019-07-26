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

import java.util.*;


class MSPaint extends JFrame {
	private JLabel x1L, x2L, y1L, y2L, z1L, z2L; 
	private JTextField x1T, x2T, y1T, y2T, z1T, z2T;
	private JCheckBox fill; 
	private JRadioButton line, circle, rect, roundRect, pen; 
	private JComboBox<String> combo; 
	private JButton drawB; 
	private DrCanvas can;

	private ArrayList<ShapeDTO> list1;
	private ShapeDTO dto;


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

	public ArrayList<ShapeDTO> getArrayList(){
		return list1;
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
	
	//paint()�� �ݹ��̶�, ó�� ���� �� numberformatException ==> new ���� �� �ʱⰪ�� �־� Exception ���� 
		x1T = new JTextField("0", 4);	y1T = new JTextField("0", 4);	z1T = new JTextField("50", 4);
		x2T = new JTextField("0", 4);	y2T = new JTextField("0", 4);	z2T = new JTextField("50", 4);
		
		fill = new JCheckBox("ä���");
									//�ʱⰪ�� ���õǾ� �ֵ��� ����
		line = new JRadioButton("��", true);		rect = new JRadioButton("�簢��");
		circle = new JRadioButton("��");		roundRect = new JRadioButton("�ձٻ簢��");
		pen = new JRadioButton("����");
		//������ư�� 1���� ���õǵ���, �׷��� 
		ButtonGroup group = new ButtonGroup();
		group.add(line);
		group.add(circle);
		group.add(rect);
		group.add(roundRect);
		group.add(pen);
				
		String[] color = {"����", "�ʷ�", "�Ķ�", "����", "�ϴ�"};
		combo = new JComboBox<String>(color);
		drawB = new JButton("�׸���");
						//DrCanvas�� MSPaint ���� �Ѱ��� 
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

	/*	combo.addItem(Color.RED); �̷��� �Ϸ��� �÷� �̹��� > �̹����� add*/ 

	/*	combo.addItem("����");
		combo.addItem("�ʷ�");
		combo.addItem("�Ķ�");
		combo.addItem("����");
		combo.addItem("�ϴ�");  */
		
		list1 = new ArrayList<ShapeDTO>();
		
		setBounds(1000, 100, 700, 500);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

/*		drawB.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {		
				can.repaint();
			}
		});
*/		
		can.addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent e){
				x1T.setText(e.getX()+"");
				y1T.setText(e.getY()+"");
			}

			public void mouseReleased(MouseEvent e){
				int shape = 100; 
				if(line.isSelected()){
					shape = ShapeDTO.LINE;
				} else if(circle.isSelected()){
					shape = ShapeDTO.CIRCLE;
				} else if(rect.isSelected()){
					shape = ShapeDTO.RECT;
				} else if(roundRect.isSelected()){
					shape = ShapeDTO.ROUNDRECT;
				} else if(pen.isSelected()){
					shape = ShapeDTO.PEN;
				} 
				list1.add(new ShapeDTO(Integer.parseInt(x1T.getText()), Integer.parseInt(y1T.getText()), Integer.parseInt(x2T.getText()), Integer.parseInt(y2T.getText()), 
				Integer.parseInt(z1T.getText()), Integer.parseInt(z2T.getText()), fill.isSelected(), shape, combo.getSelectedIndex()));
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


// ���� ================================================================================
	public static void main(String[] args) {
		new MSPaint();

	}
}
