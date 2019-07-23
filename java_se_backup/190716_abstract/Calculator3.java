
import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.NumberFormat;
import java.text.DecimalFormat;


class Calculator3 extends Frame implements ActionListener {
	private Button[] btn;
	private Panel[] p;
	private int[] num;
	private Label lb1, lb2;
	private StringBuffer lb1Result, lb2Result;
	private String[] op = {"+", "-", "*", "/", ".", "=", "CE", "BACK"};
						//	10	11	 12	  13	14	15	  16	17
	private double result; //DecimalFormat
	private int calcOp = 0;
//	private DecimalFormat 
	private NumberFormat nf = new DecimalFormat("#,###.#####");

	
	public Calculator3() {		
		lb1Result = new StringBuffer();
		lb2Result = new StringBuffer("0");
		this.setResizable(false);
		setBounds(700, 100, 300, 400);
		setTitle("미니 계산기");
		setVisible(true);
		
		p = new Panel[8];
		btn = new Button[18];
		num = new int[10];
		
		lb1 = new Label("UPlabel");
		lb2 = new Label("0", Label.RIGHT); 

		lb1.setFont(new Font("고딕체", Font.BOLD, 12));
		lb2.setFont(new Font("고딕체", Font.BOLD, 20));

		lb1.setAlignment(Label.RIGHT);



// 패널, 버튼, 라벨 배열 생성 =================================================================================================
		for (int i = 0; i < p.length; i++) {
			p[i] = new Panel(); 
		} //패널 0~8 생성
		
		for (int i = 0; i < btn.length; i++) {
			if(i < 9) {
				num[i] = i;
				String a = Integer.toString(num[i]);
				btn[i] = new Button(Integer.toString(num[i]));				
			} //버튼1~10까지 숫자 버튼 배열 생성
			else if (i >= 10) {
				String b = op[i-10];
				btn[i] = new Button(b);		
			} //버튼10~18까지 연산자, CE, Back버튼 배열 생성
		}
		btn[9] = new Button("9");
		
// 버튼, 라벨 배열을 패널에 넣기 ==========================================================================================	
		p[0].setBackground(Color.DARK_GRAY);
		p[0].setLayout(new GridLayout(7, 1, 5, 5));
		this.add(p[0]);
		
		p[1].setBackground(new Color(252, 239, 237));
		p[1].setLayout(new GridLayout(1, 1, 5, 5));	
		p[1].add(lb1);
		
		p[2].setBackground(new Color(252, 239, 237));
		p[2].setLayout(new GridLayout(1, 1, 5, 5));
		p[2].add(lb2);		
		
		p[3].setLayout(new GridLayout(1, 2, 5, 5));
		p[3].add(btn[16]);
		p[3].add(btn[17]);
		btn[16].setBackground(new Color(255, 245, 173));
		btn[17].setBackground(new Color(173, 255, 247));		
		
		p[4].setLayout(new GridLayout(1, 4, 5, 5));
		p[4].add(btn[7]);
		p[4].add(btn[8]);
		p[4].add(btn[9]);
		p[4].add(btn[13]);
		
		p[5].setLayout(new GridLayout(1, 4, 5, 5));
		p[5].add(btn[4]);
		p[5].add(btn[5]);
		p[5].add(btn[6]);
		p[5].add(btn[12]);
		
		p[6].setLayout(new GridLayout(1, 4, 5, 5));
		p[6].add(btn[1]);
		p[6].add(btn[2]);
		p[6].add(btn[3]);
		p[6].add(btn[11]);
		
		p[7].setLayout(new GridLayout(1, 4, 5, 5));
		p[7].add(btn[14]);
		p[7].add(btn[0]);
		p[7].add(btn[15]);
		p[7].add(btn[10]);		
		
		for (int i = 1; i < p.length; i++) {
			p[0].add(p[i]);
		} //1~7 패널을 배경 패널 p0에 넣어주기
//윈도우 창닫기 이벤트 처리		
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

//버튼 이벤트 처리		
		for (int i = 0; i < btn.length; i++) {
			btn[i].addActionListener(this);		
		}
	} //생성자

//버튼 이벤트 오버라이드==================================================================================================	
@Override
public void actionPerformed(ActionEvent e) {
	if(e.getSource() == btn[1] ||
		e.getActionCommand().equals("2") ||
		e.getActionCommand().equals("3") ||
		e.getActionCommand().equals("4") ||
		e.getActionCommand().equals("5") ||
		e.getActionCommand().equals("6") ||
		e.getActionCommand().equals("7") ||
		e.getActionCommand().equals("8") ||
		e.getActionCommand().equals("9") ||
		e.getActionCommand().equals("0")) {

		if((lb2Result+"").equals("0")) {
			lb2Result.delete(0, lb2Result.length());
		}

		lb2Result.append(e.getActionCommand());
		lb2.setText(lb2Result+"");

	}
/*	for (int i = 0; i < 10; i++) {
		if(i < 10) {
			if(e.getSource() == btn[i]) lb2Result.append(i);
		} 
	} */
//	"+", "-", "*", "/",
//	10	11	 12	  13	
	
	else if(e.getActionCommand() == "+") {	
		calc();

		lb1Result.append(lb2Result+"+");
		lb2Result.delete(0, lb2Result.length());
		lb2Result.append("0");
		calcOp = '+'; //43

		lb2.setText(nf.format(result));
		lb1.setText(lb1Result+"");	

	} else if(e.getActionCommand() == "-"){
		
		calc();

		lb1Result.append(lb2Result+"-");
		lb2Result.delete(0, lb2Result.length());
		lb2Result.append("0");
		calcOp = '-';

		lb2.setText(nf.format(result));
		lb1.setText(lb1Result+"");	

	} else if(e.getActionCommand() == "*"){
		
		calc();

		lb1Result.append(lb2Result+"*");		
		lb2Result.delete(0, lb2Result.length());
		lb2Result.append("0");
		calcOp = '*';

		lb2.setText(nf.format(result));
		lb1.setText(lb1Result+"");	

	} else if(e.getActionCommand() == "/"){
		
		calc();

		lb2Result.delete(0, lb2Result.length());
		lb2Result.append("0");
		calcOp = '/';
		lb2.setText(nf.format(result));
		lb1.setText(lb1Result+"");	

	} else if(e.getSource() == btn[14]){
		if(lb2Result.indexOf(".") == -1){	//-1: 값이 없음 
			lb2Result.append(".");
			lb2.setText(lb2Result+"");
		}
	}
	else if(e.getSource() == btn[15]) {		// = 
		
		calc();
		lb1Result.delete(0, lb1Result.length());
		lb2Result.delete(0, lb2Result.length());
		lb2Result.append("0");

		lb1.setText("");
		lb2.setText(nf.format(result));

		result = calcOp = 0; 

	}
 
	else if (e.getSource() == btn[16]) { //CE
		lb1Result.delete(0, lb1Result.length());
		lb2Result.delete(0, lb2Result.length());
		lb1Result.append("0");
		lb2Result.append("0");

		lb1.setText("");
		lb2.setText("0");

			
		}
	else if (e.getSource() == btn[17]) { //Backspace
		if(lb2Result.length() == 1) {
			lb2Result.delete(0, 1);
			lb2Result.append("0");
			
		} else {
			lb2Result.delete(lb2Result.length()-1, lb2Result.length());

		}
		lb2.setText(lb2Result+"");
	}

}

	public void calc(){
	// calcop를 비교, 어떤 연산자인지 확인. 
	// (op=0일떄)입력된 값을 result에 넣는다. / calcOp에 따라 계산 
	// 연산자를 calcOP에 넣는다.
	
		//result의 중간결과갑 내기 
		if(calcOp == 0){
			result = Double.parseDouble(lb2Result+""); 
		} else if(calcOp == '+') { result = result + Double.parseDouble(lb2Result+"");
		} else if(calcOp == '-'){ result = result - Double.parseDouble(lb2Result+"");
		} else if(calcOp == '*'){ result = result * Double.parseDouble(lb2Result+"");
		} else if(calcOp == '/'){ result = result / Double.parseDouble(lb2Result+"");
		}

	}

// main ======================================================================================================
	public static void main(String[] args) {
		new Calculator3();
	}



	
}
	