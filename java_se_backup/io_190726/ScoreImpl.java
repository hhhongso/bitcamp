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
		String idNum = JOptionPane.showInputDialog(null, "�й����� �˻��ϱ�", "�˻�", JOptionPane.QUESTION_MESSAGE);
		if(idNum == null || idNum.equals("")) return; //��ҹ�ư ���� �� = null. �ƹ��͵� �Է� ���� ��= "" 
		//�� ������ true�� ��, ���� ������ Ȯ������ �ʴ´�. 
		// | : �� ������ true �̴��� �� ���Ǳ��� Ȯ���Ѵ�. 
		System.out.println("�й�:" + idNum);
		output.setText("");

		for(int i = 0; i < list.size(); i++){
			if(list.get(i).getIdNum().equals(idNum)) {
				System.out.println("!");
				output.append(list.get(i).toString() + "\n");
				sw = 1;
			}
		}
		if(sw == 0) JOptionPane.showMessageDialog(null, "ã���� �ϴ� �й��� �����ϴ�." );
	}


	public void sort(){
	/*	Comparator<ScoreDTO> com = new Comparator<ScoreDTO>(){
			@Override
			public int compare(ScoreDTO dto1, ScoreDTO dto2){
				return dto1.getTotal() < dto2.getTotal() ? 1 : -1 ;
											//���� ������: ���̸� ��������	�����̸� ��������

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

		int count = list.size(); // ��ü�� ���� ����  
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
		JOptionPane.showMessageDialog(null, "����Ǿ����ϴ�." );
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

			list.clear(); // ����Ʈ�� ���� , ���� ������ ������ add�Ѵ�.
			ScoreDTO dto = null;

			//readObject()�� read()�� �޸�, -1�� ��ȯ���� �ʰ� EOFException�� �߻���Ų��. 
			//�׷��Ƿ�, �о�� �� ��ü�� ������ ���Ͽ� �����ϰų�, ����ó���� �Ͽ��� �Ѵ�. 
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
		JOptionPane.showMessageDialog(null, "������ ���ϴ�." );	
	}

	

}
