import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
//import java.io.IOException;

class TryNotepad extends JFrame implements ActionListener {
	private JTextArea area; 
	private MenuPane menu;  
	File file;
	JFileChooser chooser;

	public TryNotepad(){
		area = new JTextArea();
		JScrollPane scroll = new JScrollPane(area);	// scroll.add(area);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		

		menu = new MenuPane();
		this.setJMenuBar(menu); //���� ���� ���������� �ʾƵ�, �̹� menubar �� ������ ���� 
		getContentPane().add("Center", scroll);
			
		setBounds(700, 100, 700, 500);
		setVisible(true);
		this.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e) { exitDialog();}
		});
		
	}// constructor

	public void event(){		
		menu.getNewM().addActionListener(this);
		menu.getOpenM().addActionListener(this);
		menu.getSaveM().addActionListener(this);
		menu.getExitM().addActionListener(this);
		menu.getCutM().addActionListener(this);
		menu.getCopyM().addActionListener(this);
		menu.getPasteM().addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {	//�������̵� �Լ����� throsw �Ұ�.	
		
		if(e.getSource() == menu.getNewM()){ area.setText(""); } 
		else if(e.getSource() == menu.getOpenM()){	
			openDialog();
			fileRead();  //ȣ��
		}
		else if(e.getSource() == menu.getSaveM()){ 
			saveDialog();
			fileWrite();
		}  //�������, ���ϸ� 
		else if(e.getSource() == menu.getExitM()){
			exitDialog();
		}
		else if(e.getSource() == menu.getCutM()){ area.cut(); }
		else if(e.getSource() == menu.getCopyM()){ area.copy();}
		else if(e.getSource() == menu.getPasteM()){ area.paste();}

		}

// newM ==================================================================================
	public void openDialog(){		
		chooser = new JFileChooser();
		int result = chooser.showOpenDialog(this);	
		if(result == JFileChooser.APPROVE_OPTION){ file = chooser.getSelectedFile();}
		JOptionPane.showMessageDialog(this, file);
	}
	
	public void fileRead() { //�����ο� throws�� �����, ȣ�� �κп����� throws���־�� �Ѵ�. 
		if(file == null) { return; }
		
		String line = null;
		area.setText("");
			try{
				BufferedReader br = new BufferedReader(new FileReader(file));
				while((line = br.readLine()) != null){ area.append(line+ "\n"); } //setText()�� �����. 
						//readLine()�� �� ���� �ձ����� �� �ٷ� ���� �о�´�.  
				br.close();
			} catch (Exception e) {	e.printStackTrace(); }
	}

// saveM ==================================================================================
	public void saveDialog(){
		chooser = new JFileChooser();
		int result = chooser.showSaveDialog(this);
		if(result == JFileChooser.APPROVE_OPTION) { file = chooser.getSelectedFile();}
		JOptionPane.showMessageDialog(this, file);
	}

	public void fileWrite(){
		if(file == null) { return; }

		try{
			BufferedWriter bw = new BufferedWriter(new FileWriter(file));
			String data = area.getText();
			bw.write(data);
			bw.close();
		} catch (Exception e) {	e.printStackTrace(); }
	}

// exitM ==================================================================================
	public void exitDialog(){
		int result = JOptionPane.showConfirmDialog(this, "������ ���� �����Ͻðڽ��ϱ�?", "�޸��� ����",JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
					//showOptionDialog() >> ��ư �ɼ��� ���ϴ´�� ���� ����
		if(result == JOptionPane.YES_OPTION) { saveDialog(); }
		else if(result == JOptionPane.CANCEL_OPTION) { setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);}
		else if(result == JOptionPane.NO_OPTION) { System.exit(0); }


	}

	
			
		
		
	
		
	public static void main(String[] args) {
		new TryNotepad().event();
	}
}
