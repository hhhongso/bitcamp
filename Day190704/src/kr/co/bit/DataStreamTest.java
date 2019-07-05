package kr.co.bit;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataStreamTest {

	public static void main(String[] args) {
		FileOutputStream fout = null; 
		FileInputStream fin = null;  //���Ͽ��� ������ 
		DataOutputStream dout = null; // �����͸� ���Ͽ� �� ��(output) / �о�� ��(input) ==> �����ڰ� �ƴ� �⺻���� �а� �� �� �ְ� �� 
		DataInputStream din = null; 
		
		try {
			fout = new FileOutputStream("C:\\Users\\bitcamp\\Documents\\GitHub\\bitcamp\\Day190704\\src\\kr\\co\\bit\\datafile.TXT");
			fin = new FileInputStream("C:\\Users\\bitcamp\\Documents\\GitHub\\bitcamp\\Day190704\\src\\kr\\co\\bit\\datafile.txt");
			dout = new DataOutputStream(fout); //�����ͽ�Ʈ�� (���)�� ����(fout)�� ������  
			din = new DataInputStream(fin); //�����ͽ�Ʈ�� (�Է�)�� ����(fin)�� ������
			
			dout.writeShort(-1); //output>> ���� ����(write) 	//short: 2byte�� ���� ���� >> fout�� datafile�� -1�� ����		// 2byte����(-2178561~+179368d�� �������� -1 = �ִ밪 = 65535)
			dout.writeByte(2);
			dout.writeDouble(3.14);
			dout.writeLong(300);
			dout.writeUTF("datastreamTEST_안뇽"); //UTF-8 Ÿ��(�ٱ���)
			System.out.println(din.readUnsignedShort()); //
			din.skip(1); //1�� �ѱ�� 
			
			System.out.println(din.readDouble()); // input >> ���� �о����(read)
			System.out.println(din.readLong());
			System.out.println(din.readUTF());
					//> �о�� ���� ������ Ÿ������ ����������, TXT.�� �� �� ���� �� Ÿ���� �������� �ʾ� ������ ��  
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
