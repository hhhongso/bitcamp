package W0729;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class ScoreImp implements Score {
	private ArrayList<ScoreDTO> list = new ArrayList<ScoreDTO>(); 
	private ScoreMain sm;

	@Override
	public void input(ScoreDTO dto) {
/*		this.sm = sm;
		
		String idNum = sm.getIdNumT().getText();
		String name = sm.getNameT().getText();
		int kor = Integer.parseInt(sm.getKorT().getText());
		int eng = Integer.parseInt(sm.getEngT().getText());
		int math = Integer.parseInt(sm.getMathT().getText());
	*/	
		list.add(dto);
		JOptionPane.showMessageDialog(sm, "등록 완료!");
		
	}

	@Override
	public void disp(JTextArea output) {
		output.append("학번  이름  수학  국어  수학  총점  평균 \n");
		for (ScoreDTO scoreDTO : list) {
			output.append(scoreDTO.toString() + "\n");			
		}
		
	}

	@Override
	public void search() {
		
	}

	@Override
	public void sort() {
		
	}

	@Override
	public void save() {
		
	}

	@Override
	public void load() {
		File file = null; 
		//다이얼로그
		JFileChooser chooser = new JFileChooser();
		int result = chooser.showOpenDialog(null);
		if(result == JFileChooser.APPROVE_OPTION) {
			file = chooser.getSelectedFile();
		}
		JOptionPane.showMessageDialog(null, "파일을 엽니다." );
		
		if(file == null) return;
		
		//프로세스
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
			ScoreDTO dto = (ScoreDTO) ois.readObject(); 
			list.clear();

			while(dto != null) {
				list.add(dto);
			}
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	

}
