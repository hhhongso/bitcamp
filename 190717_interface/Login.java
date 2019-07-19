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
	private TextField idT, pwT; // �����͸� �����´�
	private Button loginB, cancelB; //�̺�Ʈ �߻�O => ���������� ����

	public Login(){
		setLayout(null);	//����Ʈ ���̾ƿ� �������� 

		Label idL = new Label("���̵�"); // �̺�Ʈ �߻� X. ȭ�鿡 �߱⸸ �ϸ�Ǵϱ� �ʵ�� ���� ���ص� �ȴ�. 
		Label pwL = new Label("��й�ȣ");

		idT = new TextField();
		pwT = new TextField();

		loginB = new Button("�α���");
		cancelB = new Button("���");
					//x,y��ǥ, �ʺ�, ����
		idL.setBounds(50, 80, 60, 30);
		idT.setBounds(120, 80, 100, 30);
		pwL.setBounds(50, 120, 60, 30);
		pwT.setBounds(120, 120, 100, 30);

		loginB.setBounds(80, 200, 60, 30); //���̾ƿ� �������ϱ� EWSNC ���� ���� ���� 
		cancelB.setBounds(150, 200, 60, 30);

		add(idL);			add(idT);
		add(pwL);			add(pwT);
		add(loginB);		add(cancelB);

		setTitle("�α���");
		setBounds(700, 100, 300, 300);
		setVisible(true);

		//event
		this.addWindowListener(this);
		loginB.addActionListener(this);
		cancelB.addActionListener(this);
	}

//ActionListener�� �޼ҵ� ���� (Event Handler)
public void actionPerformed(ActionEvent e){
	if(e.getSource() == loginB) {
		String id = idT.getText();
		String pw = pwT.getText();
		new LoginResult(id, pw);
	} 
	else if(e.getActionCommand() == "���"){
		idT.setText(" "); // �ƹ� ���ڳ� �־��� ��
		idT.setText(""); // ���ڸ� �ʱ�ȭ

		pwT.setText("any");	pwT.setText("");
	}

}
	
//WindowListener�� �޼ҵ� ���� (Event Handler)
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
