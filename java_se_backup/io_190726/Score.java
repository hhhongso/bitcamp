import javax.swing.*;

interface Score {
	public void input(ScoreDTO dto);
	public void print(JTextArea output);
	public void sort();
	public void save();
	public void load();
	public void search(JTextArea output);
	
}