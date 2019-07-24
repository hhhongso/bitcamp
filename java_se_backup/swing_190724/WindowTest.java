import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JFrame; //확장 패키지 javax
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
		
		newB = new JButton("새로 만들기");
		exitB = new JButton(new ImageIcon("pippy.gif")); // implementing class 를 사용 

		area = new JTextArea();	//JTextArea는 자동으로 스크롤바를 제공하지 않음 
		JScrollPane scroll = new JScrollPane(area);

		JPanel p = new JPanel();
		p.add(newB);
		p.add(exitB);

		Container c = this.getContentPane();
		c.add("North",p);
		c.add("Center", scroll); // scroll위에 area가 올라감. ==> 위치시키는 것이 scroll이 되어야. 


		setBounds(700, 100, 300, 400);
		setVisible(true);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE); // defaut: HIDE_ON_CLOSE;
		addWindowListener(new WindowAdapter(){
			@Override
			public void windowClosing(WindowEvent e){
				//종료 다이얼로그 
				int result = JOptionPane.showConfirmDialog(WindowTest.this,
                                    "정말로 종료하시겠습니까?",
                                    "종료",
                                    JOptionPane.YES_NO_OPTION,
                                    JOptionPane.QUESTION_MESSAGE);
				if(result == JOptionPane.YES_OPTION) System.exit(0);
				//else: hide default >> do nothing 으로  
			}
		}); 
	}
	public static void main(String[] args) {
		new WindowTest();
	}
}
