import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JFrame; //Ȯ�� ��Ű�� javax
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.Color;
import java.awt.Container;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

class WindowTest extends JFrame {
	private JButton newB, exitB;
	private JTextArea area; 

	public WindowTest(){
		
		newB = new JButton("���� �����");
		exitB = new JButton(new ImageIcon("pippy.gif")); // implementing class �� ��� 

		area = new JTextArea();	//JTextArea�� �ڵ����� ��ũ�ѹٸ� �������� ���� 
		JScrollPane scroll = new JScrollPane(area);

		JPanel p = new JPanel();
		p.add(newB);
		p.add(exitB);

		Container c = this.getContentPane();
		c.add("North",p);
		c.add("Center", scroll); // scroll���� area�� �ö�. ==> ��ġ��Ű�� ���� scroll�� �Ǿ��. 


		setBounds(700, 100, 300, 400);
		setVisible(true);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE); // defaut: HIDE_ON_CLOSE;
		addWindowListener(new WindowAdapter(){
			@Override
			public void windowClosing(WindowEvent e){
				//���� ���̾�α� 
				int result = JOptionPane.showConfirmDialog(WindowTest.this,
                                    "������ �����Ͻðڽ��ϱ�?",
                                    "����",
                                    JOptionPane.YES_NO_OPTION,
                                    JOptionPane.QUESTION_MESSAGE);
				if(result == JOptionPane.YES_OPTION) System.exit(0);
				//else: hide default >> do nothing ����  
			}
		}); 
	}
	public static void main(String[] args) {
		new WindowTest();
	}
}
