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
		//좌표값 얻어오기 x1T~z2T 의 값(문자열) => Integer.parseInt(); 
		int x1 = Integer.parseInt(mp.getX1T().getText());
		int y1 = Integer.parseInt(mp.getY1T().getText());
		int x2 = Integer.parseInt(mp.getX2T().getText());
		int y2 = Integer.parseInt(mp.getY2T().getText());
		int z1 = Integer.parseInt(mp.getZ1T().getText());
		int z2 = Integer.parseInt(mp.getZ2T().getText());
		
		
		
		//색깔 선택 : JComboBox의 index 얻어오기 or item(문자열) 얻어오기
		switch(mp.getCombo().getSelectedIndex()){
			case 0: setForeground(Color.RED);			break;
			case 1: setForeground(Color.GREEN);			break;
			case 2: setForeground(Color.BLUE);			break;
			case 3: setForeground(Color.MAGENTA);		break;
			case 4:setForeground(Color.CYAN);			break;
		}

		//도형 선택 
		if(mp.getFill().isSelected()){ //채우기
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
				g.fillRoundRect(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x2-x1), Math.abs(y2-y1), z1, z2); // z로 둥글게 꺾어지도록 함
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

				
//				g.drawArc(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x2-x1), Math.abs(y2-y1), z1, z2); //곡선 그리기
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
setBackground >> repaint 효과 있음. 색깔 지정하면서 repaint함 
setForeground

setColor() >> repaint 효과 없음. 색깔만 지정
2019-07-24*/