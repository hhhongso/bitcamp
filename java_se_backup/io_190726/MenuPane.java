import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class MenuPane extends JMenuBar {
	private JMenu fileM, editM, viewM; 
	private JMenuItem newM, openM, saveM, exitM, cutM, copyM, pasteM;
	
	public MenuPane(){
		fileM = new JMenu("파일");
		editM = new JMenu("편집");
		viewM = new JMenu("보기");

		newM = new JMenuItem("새로 만들기");
		openM = new JMenuItem("열기");
		saveM = new JMenuItem("저장");
		exitM = new JMenuItem("끝내기");
		cutM = new JMenuItem("잘라내기");
		copyM = new JMenuItem("복사");
		pasteM = new JMenuItem("붙여넣기");
	
		fileM.add(newM);			editM.add(cutM);			this.add(fileM);
		fileM.add(openM);			editM.add(copyM);			this.add(editM);
		fileM.add(saveM);			editM.add(pasteM);			this.add(viewM);
		fileM.add(exitM);
		
		//단축키: 윈도우에서 제공하는 Ctrl c, v, x 말고 Alt c, v, x 생성해서 테스트 해보자.
		copyM.setAccelerator(KeyStroke.getKeyStroke('C', InputEvent.ALT_MASK));
		cutM.setAccelerator(KeyStroke.getKeyStroke('X', InputEvent.ALT_MASK));
		pasteM.setAccelerator(KeyStroke.getKeyStroke('V', InputEvent.ALT_MASK));
 //modifiers: 제어자
 //MASK


	}


	
	public JMenuItem getNewM(){ return newM; }
	public JMenuItem getOpenM(){ return openM; }
	public JMenuItem getSaveM(){ return saveM; }
	public JMenuItem getExitM() { return exitM; }
	public JMenuItem getCutM() { return cutM; }
	public JMenuItem getCopyM() { return copyM; }
	public JMenuItem getPasteM() { return pasteM; }
	
}
