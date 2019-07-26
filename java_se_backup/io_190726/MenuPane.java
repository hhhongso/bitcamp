import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class MenuPane extends JMenuBar {
	private JMenu fileM, editM, viewM; 
	private JMenuItem newM, openM, saveM, exitM, cutM, copyM, pasteM;
	
	public MenuPane(){
		fileM = new JMenu("����");
		editM = new JMenu("����");
		viewM = new JMenu("����");

		newM = new JMenuItem("���� �����");
		openM = new JMenuItem("����");
		saveM = new JMenuItem("����");
		exitM = new JMenuItem("������");
		cutM = new JMenuItem("�߶󳻱�");
		copyM = new JMenuItem("����");
		pasteM = new JMenuItem("�ٿ��ֱ�");
	
		fileM.add(newM);			editM.add(cutM);			this.add(fileM);
		fileM.add(openM);			editM.add(copyM);			this.add(editM);
		fileM.add(saveM);			editM.add(pasteM);			this.add(viewM);
		fileM.add(exitM);
		
		//����Ű: �����쿡�� �����ϴ� Ctrl c, v, x ���� Alt c, v, x �����ؼ� �׽�Ʈ �غ���.
		copyM.setAccelerator(KeyStroke.getKeyStroke('C', InputEvent.ALT_MASK));
		cutM.setAccelerator(KeyStroke.getKeyStroke('X', InputEvent.ALT_MASK));
		pasteM.setAccelerator(KeyStroke.getKeyStroke('V', InputEvent.ALT_MASK));
 //modifiers: ������
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
