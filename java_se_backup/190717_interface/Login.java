import java.awt.Button;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

class Login extends Frame implements ActionListener, WindowListener {
	private TextField idT, pwT; // 데이터를 꺼내온다
	private Button loginB, cancelB; //이벤트 발생O => 전역변수로 설정

	public Login(){
		setLayout(null);	//디폴트 레이아웃 깨버리고 

		Label idL = new Label("아이디"); // 이벤트 발생 X. 화면에 뜨기만 하면되니까 필드로 설정 안해도 된다. 
		Label pwL = new Label("비밀번호");

		idT = new TextField();
		pwT = new TextField();

		loginB = new Button("로그인");
		cancelB = new Button("취소");
					//x,y좌표, 너비, 길이
		idL.setBounds(50, 80, 60, 30);
		idT.setBounds(120, 80, 100, 30);
		pwL.setBounds(50, 120, 60, 30);
		pwT.setBounds(120, 120, 100, 30);

		loginB.setBounds(80, 200, 60, 30); //레이아웃 깨줬으니까 EWSNC 말고 직접 설정 
		cancelB.setBounds(150, 200, 60, 30);

		add(idL);			add(idT);
		add(pwL);			add(pwT);
		add(loginB);		add(cancelB);

		setTitle("로그인");
		setBounds(700, 100, 300, 300);
		setVisible(true);

		//event
		this.addWindowListener(this);
		loginB.addActionListener(this);
		cancelB.addActionListener(this);
	}

//ActionListener의 메소드 구현 (Event Handler)
public void actionPerformed(ActionEvent e){
	if(e.getSource() == loginB) {
		String id = idT.getText();
		String pw = pwT.getText();
		new LoginResult(id, pw);
	} 
	else if(e.getActionCommand() == "취소"){
		idT.setText(" "); // 아무 문자나 넣어준 뒤
		idT.setText(""); // 문자를 초기화

		pwT.setText("any");	pwT.setText("");
	}

}
	
//WindowListener의 메소드 구현 (Event Handler)
	public void	windowActivated(WindowEvent e){}
	public void	windowClosed(WindowEvent e){}
	public void	windowClosing(WindowEvent e){
		System.exit(0);
	}
	public void	windowDeactivated(WindowEvent e){}
	public void	windowDeiconified(WindowEvent e) {}
	public void	windowIconified(WindowEvent e){}
	public void	windowOpened(WindowEvent e){}

//main 
	public static void main(String[] args) {
		new Login();
	}
}
