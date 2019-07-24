import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.TextComponent;
import java.util.ArrayList;

class DrCanvas extends Canvas {
	private MSPaint mp;
	private ArrayList<Integer> arx1; 
	private ArrayList<Integer> ary1; 
	private ArrayList<Integer> arx2; 
	private ArrayList<Integer> ary2; 

	public DrCanvas(MSPaint mp){
		this.mp = mp; 
		setBackground(new Color(0, 0, 0));

		arx1 = new ArrayList<Integer>();
		ary1 = new ArrayList<Integer>(); 
		arx2 = new ArrayList<Integer>();
		ary2 = new ArrayList<Integer>(); 

	}

	@Override
	public void paint(Graphics g){
		//��ǥ�� ������ x1T~z2T �� ��(���ڿ�) => Integer.parseInt(); 
		int x1 = Integer.parseInt(mp.getX1T().getText());
		int y1 = Integer.parseInt(mp.getY1T().getText());
		int x2 = Integer.parseInt(mp.getX2T().getText());
		int y2 = Integer.parseInt(mp.getY2T().getText());
		int z1 = Integer.parseInt(mp.getZ1T().getText());
		int z2 = Integer.parseInt(mp.getZ2T().getText());
		
		
		
		//���� ���� : JComboBox�� index ������ or item(���ڿ�) ������
		switch(mp.getCombo().getSelectedIndex()){
			case 0: setForeground(Color.RED);			break;
			case 1: setForeground(Color.GREEN);			break;
			case 2: setForeground(Color.BLUE);			break;
			case 3: setForeground(Color.MAGENTA);		break;
			case 4:setForeground(Color.CYAN);			break;
		}

		//���� ���� 
		if(mp.getFill().isSelected()){ //ä���
			if(mp.getLine().isSelected()) {
				g.drawLine(x1, y1, x2, y2);
			}
			else if(mp.getCircle().isSelected()){
				g.fillOval(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x2-x1), Math.abs(y2-y1));
			}
			else if(mp.getRect().isSelected()){
				g.fillRect(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x2-x1), Math.abs(y2-y1));
			}
			else if(mp.getRoundRect().isSelected()){
				g.fillRoundRect(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x2-x1), Math.abs(y2-y1), z1, z2); // z�� �ձ۰� ���������� ��
			}
		} else {
			if(mp.getLine().isSelected()){
				g.drawLine(x1, y1, x2, y2);
			}
			else if(mp.getCircle().isSelected()){
				g.drawOval(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x2-x1), Math.abs(y2-y1));
			}
			else if(mp.getRect().isSelected()){
				g.drawRect(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x2-x1), Math.abs(y2-y1));
			}
			else if(mp.getRoundRect().isSelected()){
				g.drawRoundRect(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x2-x1), Math.abs(y2-y1), z1, z2);
			}
			else if(mp.getPen().isSelected()){
				arx1.add(x1);
				ary1.add(y1);
				arx2.add(x2);
				ary2.add(y2);

				for(int i = 0; i < arx1.size() ; i++){		
					if(i == 0) g.drawLine(arx1.get(0), ary1.get(0), arx2.get(0), ary2.get(0));
					else 		g.drawLine(arx2.get(i-1), ary2.get(i-1), arx2.get(i), ary2.get(i));
			
				}

				
//				g.drawArc(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x2-x1), Math.abs(y2-y1), z1, z2); //� �׸���
			}
		}

		

	/*	int x1 = Integer.parseInt(mp.getX1T());
		int y1 = Integer.parseInt(mp.getX2T());
		int x2 = Integer.parseInt(mp.getY1T());
		int y2 = Integer.parseInt(mp.getY2T());
		int z1 = Integer.parseInt(mp.getZ1T());
		int z2 = Integer.parseInt(mp.getZ2T()); */


	}
}


/*
setBackground >> repaint ȿ�� ����. ���� �����ϸ鼭 repaint�� 
setForeground

setColor() >> repaint ȿ�� ����. ���� ����
2019-07-24*/