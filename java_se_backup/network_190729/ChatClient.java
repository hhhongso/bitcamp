import javax.swing.*;
import java.awt.*;

class ChatClient extends JFrame {
	private JTextArea output;
	private JTextField inputT;	
	private JButton sendB;

	public ChatClient(){		
		JPanel p1 = new JPanel();
		GridBagLayout gbl = new GridBagLayout();
		GridBagConstraints gbc = new GridBagConstraints();
		p1.setLayout(gbl);
		
		output = new JTextArea(); // 편집불가 
		output.setEditable(false);

		inputT = new JTextField(15); // p1		
		gbc.weightx = 1.0; // 여백 독점
		gbc.fill = GridBagConstraints.BOTH;
		p1.add(inputT, gbc);		
 		
		sendB = new JButton("보내기"); // p1
		gbc.weightx = 0.0; // 여백 지정하지 않음
		p1.add(sendB, gbc);
		
		gbl.setConstraints(p1, gbc);

		JScrollPane scroll = new JScrollPane(output);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
	

		Container con = this.getContentPane();
		con.add("Center", scroll);
		con.add("South", p1);

		setResizable(true); 
		setBounds(700, 100, 300, 300);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new ChatClient();
	}
}
