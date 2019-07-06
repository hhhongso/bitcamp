package kr.co.bit;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ObjectStreamTest1 {

	public static void main(String[] args) {
		User1 beforeUser1 = new User1("idid", "pwwww", "seoul", 25, "김가나");
		User1 afterUser1 = null;  // new User1(); 이라고 했다면 타입 캐스팅 불가 
		
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		FileInputStream fis = null;
		ObjectInputStream ois = null; 
		
		try {
			//보내기							 // \ 하나는 제어문자가 되니까 \\로 쓰는 것												//직렬화파일: 메모장에서 열어도 알아볼 수 없음
			fos = new FileOutputStream("C:\\Users\\bitcamp\\Documents\\GitHub\\bitcamp\\Day190705\\src\\kr\\co\\bit\\userInfo.ser");
			oos = new ObjectOutputStream(fos);
			oos.writeObject(beforeUser1);
			
			//읽어오기
			fis = new FileInputStream("C:\\Users\\bitcamp\\Documents\\GitHub\\bitcamp\\Day190705\\src\\kr\\co\\bit\\userInfo.ser");
			ois = new ObjectInputStream(fis);
			afterUser1 = (User1)ois.readObject(); // downcasting 부모->자식 클래스로
			//객체에서 		객체로 	타입 캐스팅  	~객체의 다형성~
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fos.close();
				fis.close();
				oos.close();
				ois.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println(afterUser1); // = afterUser1.toString() [객체로 쓰고 -> 읽어서 객체로 꺼내오기]
	}

}
