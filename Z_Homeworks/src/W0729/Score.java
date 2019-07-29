package W0729;

import javax.swing.JTextArea;

public interface Score {
	public void input(ScoreDTO dto);
	public void disp(JTextArea output);
	public void search();
	public void sort();
	public void save();
	public void load();
	

}
