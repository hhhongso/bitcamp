import java.io.File;
import java.util.*;
import javax.swing.*;

import java.io.ObjectInputStream;
import java.io.FileInputStream;
import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

class ScoreImpl implements Score {
	private JFileChooser chooser;
	private File file;
	private ArrayList<ScoreDTO> list = new ArrayList<ScoreDTO>();
	
	@Override
	public void input(ScoreDTO dto){
		list.add(dto);		
		System.out.print(list.size());
	}

	@Override
	public void print(JTextArea output){
		output.setText("");
		for(ScoreDTO dto : list){
			output.append(dto.toString() + "\n");
		}	
	}

	public void search(JTextArea output){
		int sw = 0;
		String idNum = JOptionPane.showInputDialog(null, "학번으로 검색하기", "검색", JOptionPane.QUESTION_MESSAGE);
		if(idNum == null || idNum.equals("")) return; //취소버튼 누를 때 = null. 아무것도 입력 안할 때= "" 
		//앞 조건이 true일 시, 뒤의 조건은 확인하지 않는다. 
		// | : 앞 조건이 true 이더라도 뒤 조건까지 확인한다. 
		System.out.println("학번:" + idNum);
		output.setText("");

		for(int i = 0; i < list.size(); i++){
			if(list.get(i).getIdNum().equals(idNum)) {
				System.out.println("!");
				output.append(list.get(i).toString() + "\n");
				sw = 1;
			}
		}
		if(sw == 0) JOptionPane.showMessageDialog(null, "찾고자 하는 학번이 없습니다." );
	}


	public void sort(){
	/*	Comparator<ScoreDTO> com = new Comparator<ScoreDTO>(){
			@Override
			public int compare(ScoreDTO dto1, ScoreDTO dto2){
				return dto1.getTotal() < dto2.getTotal() ? 1 : -1 ;
											//조건 연산자: 참이면 내림차순	거짓이면 오름차순

			//	if(dto1.getTotal() < dto2.getTotal()) return 1;
			//	else if(dto1.getTotal() > dto2.getTotal()) return -1; 
			//	else return 0;
			}
		};		
		Collections.sort(list, com); */

		Collections.sort(list);
	}


	@Override
	public void save() {
		chooser = new JFileChooser();

		int result = chooser.showSaveDialog(null);
		if(result == JFileChooser.APPROVE_OPTION){
			file = chooser.getSelectedFile(); 
		}
		
		if(file == null) return; 

		int count = list.size(); // 객체의 개수 세기  
		try{												// new File(file)
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
			oos.writeInt(count);
			for(ScoreDTO dto : list){
				oos.writeObject(dto);
				oos.flush();
			}
			oos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		JOptionPane.showMessageDialog(null, "저장되었습니다." );
	}

	@Override
	public void load(){
		chooser = new JFileChooser();
		int result = chooser.showOpenDialog(null);
		if(result == JFileChooser.APPROVE_OPTION){
			file = chooser.getSelectedFile(); 
		}
		if(file == null) return; 

		try{
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
			int count = ois.readInt();

			list.clear(); // 리스트를 비우고 , 읽은 파일의 내용을 add한다.
			ScoreDTO dto = null;

			//readObject()는 read()와 달리, -1을 반환하지 않고 EOFException을 발생시킨다. 
			//그러므로, 읽어야 할 객체의 개수를 파일에 저장하거나, 예외처리를 하여야 한다. 
	//		while((dto = (ScoreDTO)ois.readObject()) != null){
	//			list.add(dto);
	//		}
			
			for(int i = 0 ; i < count ; i++){
				dto = (ScoreDTO)ois.readObject();
				list.add(dto);
			}
			
			ois.close();		
		} catch (Exception e) {
			e.printStackTrace();
		}		
		JOptionPane.showMessageDialog(null, "파일을 엽니다." );	
	}

	

}
