import java.io.ObjectInputStream;
import java.io.FileInputStream;
import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
//import java.lang.ClassNotFoundException;

class PersonMain {
	public static void main(String[] args) throws ClassNotFoundException, IOException{
		PersonDTO dto = new PersonDTO("홍길동", 35, 182.5);

		//나(클래스) 기준으로, 데이터가 '나가는' 것이니까 output 
/*		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("result2.txt"));
		oos.writeObject(dto); //데이터를 한꺼번에 객체로 넘긴다. 
		oos.close(); */
		
		//꺼내오기
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("result2.txt"));
		PersonDTO dto2 = (PersonDTO)ois.readObject();
							//return type은 Object. ==> 가져오고자 하는 클래스 타입으로 캐스팅해야함 
		ois.close();
		System.out.println("이름:" + dto2.getName() + "	나이:" + dto2.getAge() + "	키:" + dto2.getHeight());
		
	}
}
