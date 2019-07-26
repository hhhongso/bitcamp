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
		this.setJMenuBar(menu); //따로 공간 설정해주지 않아도, 이미 menubar 의 공간이 잇음 
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

	public void actionPerformed(ActionEvent e) {	//오버라이드 함수에는 throsw 불가.	
		
		if(e.getSource() == menu.getNewM()){ area.setText(""); } 
		else if(e.getSource() == menu.getOpenM()){	
			openDialog();
			fileRead();  //호출
		}
		else if(e.getSource() == menu.getSaveM()){ 
			saveDialog();
			fileWrite();
		}  //저장공간, 파일명 
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
	
	public void fileRead() { //구현부에 throws가 생기면, 호출 부분에서도 throws해주어야 한다. 
		if(file == null) { return; }
		
		String line = null;
		area.setText("");
			try{
				BufferedReader br = new BufferedReader(new FileReader(file));
				while((line = br.readLine()) != null){ area.append(line+ "\n"); } //setText()는 덮어쓴다. 
						//readLine()은 즉 엔터 앞까지를 한 줄로 보아 읽어온다.  
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
		int result = JOptionPane.showConfirmDialog(this, "나가기 전에 저장하시겠습니까?", "메모장 종료",JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
					//showOptionDialog() >> 버튼 옵션을 원하는대로 설정 가능
		if(result == JOptionPane.YES_OPTION) { saveDialog(); }
		else if(result == JOptionPane.CANCEL_OPTION) { setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);}
		else if(result == JOptionPane.NO_OPTION) { System.exit(0); }


	}

	
			
		
		
	
		
	public static void main(String[] args) {
		new TryNotepad().event();
	}
}
