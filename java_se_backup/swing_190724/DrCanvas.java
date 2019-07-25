import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image; 

import java.awt.Graphics;
import java.awt.TextComponent;
import java.util.ArrayList;


class DrCanvas extends Canvas {
	private MSPaint mp;
	private Image bufferImage; 
	private Graphics bufferG;
	private ArrayList<Integer> arx1; 
	private ArrayList<Integer> ary1; 
	private ArrayList<Integer> arx2; 
	private ArrayList<Integer> ary2;
	
	private ArrayList<ShapeDTO> list;

	public DrCanvas(MSPaint mp){
		this.mp = mp; 
		setBackground(new Color(0, 0, 0));

		arx1 = new ArrayList<Integer>();
		ary1 = new ArrayList<Integer>(); 
		arx2 = new ArrayList<Integer>();
		ary2 = new ArrayList<Integer>();
	}
	
	@Override	
	//�޸��ʿ� �׸� �׸��� => paint()�� �Ѿ. ĵ���� ũ���� �̹����� set�Ͽ�, �� �ȿ� �׸��� �׸���.
	//g.drawImage() > �� ���� �̹����� ĵ���� ���� �ø���. 
	public void update(Graphics g){		
		Dimension d = this.getSize();	//ĵ���� ũ�� ��������. (!= ������ ũ��)
		if(bufferG == null) {
			bufferImage = this.createImage(d.width, d.height);
			bufferG = bufferImage.getGraphics(); //bufferImage�� �׸��� �׸� �� �ֵ��� ����
		}

		bufferG.setColor(this.getBackground());
		bufferG.fillRect(0, 0, d.width, d.height);		
		
		//arrayList���� ShapeDTO�� �ٽ� �������� 		
		list = mp.getArrayList();
		for(int i = 0; i < list.size(); i++){
			int x1 = list.get(i).getX1();
			int y1 = list.get(i).getY1();
			int x2 = list.get(i).getX2();
			int y2 = list.get(i).getY2();
			int z1 = list.get(i).getZ1();
			int z2 = list.get(i).getZ2();

			switch(list.get(i).getColor()){
						//bufferG���� foreground �Լ��� ���� 
			case 0: bufferG.setColor(Color.RED);			break;
			case 1: bufferG.setColor(Color.GREEN);			break;
			case 2: bufferG.setColor(Color.BLUE);			break;
			case 3: bufferG.setColor(Color.MAGENTA);		break;
			case 4: bufferG.setColor(Color.CYAN);			break;
			
		}
			if(list.get(i).getFill()) {
				if(list.get(i).getShape() == 0){	bufferG.drawLine(x1, y1, x2, y2);
				}else if(list.get(i).getShape() == 1){	bufferG.fillOval(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x2-x1), Math.abs(y2-y1));
				}else if(list.get(i).getShape() == 2){	bufferG.fillRect(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x2-x1), Math.abs(y2-y1));
				}else if(list.get(i).getShape() == 3){	bufferG.fillRoundRect(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x2-x1), Math.abs(y2-y1), z1, z2);
				}
			} else if(!list.get(i).getFill()){ 
				if(list.get(i).getShape() == 0){	bufferG.drawLine(x1, y1, x2, y2);
				}else if(list.get(i).getShape() == 1){	bufferG.drawOval(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x2-x1), Math.abs(y2-y1));
				}else if(list.get(i).getShape() == 2){	bufferG.drawRect(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x2-x1), Math.abs(y2-y1));
				}else if(list.get(i).getShape() == 3){	bufferG.drawRoundRect(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x2-x1), Math.abs(y2-y1), z1, z2);
				}
			}
		}

		//��ǥ�� ������ x1T~z2T �� ��(���ڿ�) => Integer.parseInt(); 
		int x1 = Integer.parseInt(mp.getX1T().getText());
		int y1 = Integer.parseInt(mp.getY1T().getText());
		int x2 = Integer.parseInt(mp.getX2T().getText());
		int y2 = Integer.parseInt(mp.getY2T().getText());
		int z1 = Integer.parseInt(mp.getZ1T().getText());
		int z2 = Integer.parseInt(mp.getZ2T().getText());

		

	//		dto.ShapeDTO(dto.getX1(), dto.getY1(), dto.getX2(), dto.getY2(), 
	//			dto.getZ1(), dto.getZ2(), dto.getFill(), dto.getShape(), dto.getColor());
		
		//���� ���� : JComboBox�� index ������ or item(���ڿ�) ������
		switch(mp.getCombo().getSelectedIndex()){
						//bufferG���� foreground �Լ��� ���� 
			case 0: bufferG.setColor(Color.RED);			break;
			case 1: bufferG.setColor(Color.GREEN);			break;
			case 2: bufferG.setColor(Color.BLUE);			break;
			case 3: bufferG.setColor(Color.MAGENTA);		break;
			case 4: bufferG.setColor(Color.CYAN);			break;
			
		}

		//���� ���� 
		if(mp.getFill().isSelected()){ //ä���
			if(mp.getLine().isSelected()) {
				bufferG.drawLine(x1, y1, x2, y2);
				
			}
			else if(mp.getCircle().isSelected()){
				bufferG.fillOval(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x2-x1), Math.abs(y2-y1));
			
			}
			else if(mp.getRect().isSelected()){
				bufferG.fillRect(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x2-x1), Math.abs(y2-y1));
		
			}
			else if(mp.getRoundRect().isSelected()){
				bufferG.fillRoundRect(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x2-x1), Math.abs(y2-y1), z1, z2); // z�� �ձ۰� ���������� ��

			}
		} else {
			if(mp.getLine().isSelected()){
				bufferG.drawLine(x1, y1, x2, y2);

			}
			else if(mp.getCircle().isSelected()){
				bufferG.drawOval(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x2-x1), Math.abs(y2-y1));

			}
			else if(mp.getRect().isSelected()){
				bufferG.drawRect(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x2-x1), Math.abs(y2-y1));
	
			}
			else if(mp.getRoundRect().isSelected()){
				bufferG.drawRoundRect(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x2-x1), Math.abs(y2-y1), z1, z2);

			}
			else if(mp.getPen().isSelected()){
				arx1.add(x1);
				ary1.add(y1);
				arx2.add(x2);
				ary2.add(y2);

				for(int i = 0; i < arx1.size() ; i++){		
					if(i == 0) bufferG.drawLine(arx1.get(0), ary1.get(0), arx2.get(0), ary2.get(0));
					else 		bufferG.drawLine(arx2.get(i-1), ary2.get(i-1), arx2.get(i), ary2.get(i));			
				}

			}
		}


		paint(g);
	}


	@Override
	public void paint(Graphics g){
		g.drawImage(bufferImage, 0, 0, this);
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