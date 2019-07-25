import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class JProgressBarEx extends JFrame implements Runnable {
	private JProgressBar jpb = new JProgressBar(JProgressBar.HORIZONTAL, 0, 100); 
	private JButton jbt1 = new JButton("����");
	private JButton jbt2 = new JButton("����");
	private boolean bb = true; 
	private int percent; 

	public JProgressBarEx(){
		Container con = this.getContentPane();
		con.setLayout(new BorderLayout());

		JLabel lb = new JLabel("���� �� �Դϴ�...");
		JPanel p = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		p.add(jbt1);
		p.add(jbt2);
		
		con.add("North", lb);
		con.add("Center", jpb);
		con.add("South", p);

		jpb.setStringPainted(true);
		jpb.setString("0%");

		setSize(300, 150); // setBounds���� 
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		jbt1.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				Thread t = new Thread(JProgressBarEx.this);
				t.start();
				
			}
		
		});

		jbt2.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {

			}
		
		});





	} //������ 

	@Override
	public void run(){
		
		for(int i = percent ; i <= 100; i++){
			if(!bb) break;

			percent++;
			jpb.setString(percent + "%");
			
			try {
			Thread.sleep(50);
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}



	public static void main(String[] args) {
		new JProgressBarEx();
	}
}
