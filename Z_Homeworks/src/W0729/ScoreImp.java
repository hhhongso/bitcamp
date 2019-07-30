package W0729;

import java.awt.HeadlessException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;

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
		output.setText("");
		output.append("학번   이름   수학   국어   수학   총점   평균 \n");
		for (ScoreDTO dto : list) {
			output.append(dto.toString() + "\n");			
		}	
	}

	@Override
	public void search(JTextArea output) {
		//다이얼로그:이름 검색
		String name = JOptionPane.showInputDialog("이름으로 검색하기");
		System.out.println(name);
		//프로세스
		
		int sw= 0;
		output.append("학번   이름   수학   국어   수학   총점   평균 \n");
		
		for (ScoreDTO dto : list) {
			if(dto.getName().equals(name)) {
				output.setText("");
				output.append(dto.toString() + "\n");
				sw++;
			}			
		}		
		if(sw == 0) output.setText("찾는 이름이 없습니다. ");
		else output.append("검색이 완료되었습니다.");
		
		if(name == "" || name == null) {
			output.setText("제대로 입력하세요. ");
		}
	}

	@Override
	public void sort() {
		Collections.sort(list);		
	}

	@Override
	public void save() {
		//다이얼로그
		File file = null;
		JFileChooser chooser = new JFileChooser();
		int result = chooser.showSaveDialog(null);
		if (result == JFileChooser.APPROVE_OPTION) {
			file = chooser.getSelectedFile();
		}
		
		
		//프로세스		
			
			try {
				ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
				if(list.size() == 0) JOptionPane.showMessageDialog(null, "저장할 내용이 없습니다.");
				else {
					for (ScoreDTO dto : list) {
						oos.writeObject(dto);
						oos.flush();
					}
					oos.close();				
					JOptionPane.showMessageDialog(null, "저장되었습니다. ");
				}
			} catch (HeadlessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
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
		
		if(file == null) return;
		
		//프로세스
			try {
				ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
				list.clear();
				int size = ois.readInt(); //java.io.EOFException
				System.out.println(size);
				
				for (int i = 0; i < size; i++) {
					ScoreDTO dto = (ScoreDTO) ois.readObject();
					list.add(dto);
				}
				JOptionPane.showMessageDialog(null, "파일을 엽니다.");
				ois.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		
	}
	

}
