package kr.co.bit;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

public class TryNotepad extends JFrame implements ActionListener{
	private MenuPane mp;
	private JTextArea area;
	private File file;
	private JFileChooser chooser;
	
	public TryNotepad() {
		area = new JTextArea();
		JScrollPane scroll = new JScrollPane(area);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);	
		mp = new MenuPane();
		
		setJMenuBar(mp);
		getContentPane().add("Center", scroll);
		
		
		setBounds(700, 100, 300, 400);
		setVisible(true);
		
	} //constructor
	
	public void event() {
		mp.getNewM().addActionListener(this);
		mp.getOpenM().addActionListener(this);
		mp.getSaveM().addActionListener(this);
		mp.getExitM().addActionListener(this);
		mp.getCutM().addActionListener(this);
		mp.getCopyM().addActionListener(this);
		mp.getPasteM().addActionListener(this);	
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == mp.getNewM()) {	
			area.setText("");	
		}
		else if(e.getSource() == mp.getOpenM()) {
			openDialog();			fileRead();	
		}
		else if(e.getSource() == mp.getSaveM()) {
			saveDialog();			fileWrite();
		}
		else if(e.getSource() == mp.getExitM()) {
			exitDialog();
		}
		else if(e.getSource() == mp.getCutM()) { area.cut();}
		else if(e.getSource() == mp.getCopyM()) { area.copy();}
		else if(e.getSource() == mp.getPasteM()) { area.paste();}		
	}


//==========================================================================================================================	
	public void openDialog() {
		chooser = new JFileChooser();	
		int result = chooser.showOpenDialog(this);		
		if(result == JFileChooser.APPROVE_OPTION) { 	JOptionPane.showMessageDialog(this, file);}
	
	}
	
	private void fileRead() {
		if(file == null) return;
		
		String data = null; 
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));	
			while((data = br.readLine()) != null) {
				area.append(data);
			}
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	private void saveDialog() {	
		chooser = new JFileChooser();	
		int result = chooser.showSaveDialog(this);
		if(result == JFileChooser.APPROVE_OPTION) {
			file = chooser.getSelectedFile();
		}
		JOptionPane.showMessageDialog(this, "저장하였습니다. ");
	}
	
	public void fileWrite() {
		if(file == null) return;
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(file));
			String data = area.getText();
			bw.write(data);
			bw.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}		
	}
	
	private void exitDialog() {
		JOptionPane.showConfirmDialog(this, "나가기 전에 저장하기? ", "종료", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null);
		int result = 0; 
		if(result == JOptionPane.YES_NO_OPTION) { saveDialog();}
		else if(result == JOptionPane.NO_OPTION) { System.exit(0);}
		else if(result == JOptionPane.CANCEL_OPTION) {setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);}	
	}

	

//================================================================================================================
	public static void main(String[] args) {
		new TryNotepad().event();
	}

	
}
