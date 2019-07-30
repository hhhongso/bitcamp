import java.io.ObjectInputStream;
import java.io.FileInputStream;
import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
//import java.lang.ClassNotFoundException;

class PersonMain {
	public static void main(String[] args) throws ClassNotFoundException, IOException{
		PersonDTO dto = new PersonDTO("ȫ�浿", 35, 182.5);

		//��(Ŭ����) ��������, �����Ͱ� '������' ���̴ϱ� output 
/*		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("result2.txt"));
		oos.writeObject(dto); //�����͸� �Ѳ����� ��ü�� �ѱ��. 
		oos.close(); */
		
		//��������
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("result2.txt"));
		
		PersonDTO dto2 = (PersonDTO)ois.readObject();
							//return type�� Object. ==> ���������� �ϴ� Ŭ���� Ÿ������ ĳ�����ؾ��� 
		
		System.out.println("�̸�:" + dto2.getName() + "	����:" + dto2.getAge() + "	Ű:" + dto2.getHeight());
		ois.close();
	}
}
