package kr.co.bit;
// sequenceInputStream : �Է� ��Ʈ�� ���� ���� �ϳ��� �Է½�Ʈ������  �����ؼ� �����͸� �о���ϼ� �ִ� �Է� ��Ʈ��
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.SequenceInputStream;
import java.util.Enumeration;
import java.util.Vector;

public class SequenceInputStreamTest {

	public static void main(String[] args) {
		FileInputStream fin1 = null; 
		FileInputStream fin2 = null; 
		FileInputStream fin3 = null; 
		
		SequenceInputStream si1 = null; 
		SequenceInputStream si2 = null; 
		
		try {
			fin1 = new FileInputStream("C:\\Users\\bitcamp\\Documents\\GitHub\\bitcamp\\Day190704\\src\\kr\\co\\bit\\test1.txt");
			fin2 = new FileInputStream("C:\\Users\\bitcamp\\Documents\\GitHub\\bitcamp\\Day190704\\src\\kr\\co\\bit\\test2.txt");
			fin3 = new FileInputStream("C:\\Users\\bitcamp\\Documents\\GitHub\\bitcamp\\Day190704\\src\\kr\\co\\bit\\test3.TXT");
			
			//VECTOR == ARRAYLIST ������ �����̸�, �Լ��� ����. [��]vector - enumeration / [��]arrayList - Iterator �� ������ �б� ����. 
			Vector v1 = new Vector();
			v1.add(fin1);
			v1.add(fin2);
			v1.add(fin3);
			
			Enumeration e = v1.elements();
			si1 = new SequenceInputStream(e); //������ �Ѳ����� �ֱ�
			int var_readbyte = -1; 
			while((var_readbyte = si1.read()) != -1) {
				System.out.print((char)var_readbyte);
			}
			System.out.println();
			
			
			
			fin1 = new FileInputStream("C:\\Users\\bitcamp\\Documents\\GitHub\\bitcamp\\Day190704\\src\\kr\\co\\bit\\test1.txt");
			fin2 = new FileInputStream("C:\\Users\\bitcamp\\Documents\\GitHub\\bitcamp\\Day190704\\src\\kr\\co\\bit\\test2.txt");
			si2 = new SequenceInputStream(fin1, fin2); //������ �ϳ��� �ֱ�
			var_readbyte = -1;
			while((var_readbyte = si2.read()) != -1) { // si2.read�� �ѱ��ھ� �о� var_readbyte�� �ѱ�� 
				System.out.print((char)var_readbyte);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
