package kr.co.bit.obj;

import java.io.IOException;

public class InputStream {

	public static void main(String[] args) {
		int var_byte = -1;
		System.out.println("���� �ϳ��� �Է��ϼ���. ");
		
		do {
			try {
				var_byte = System.in.read(); // �����ϳ��� �о�� �ε� �� ���ڿ��� �������� ?
			} catch (IOException e) {
				e.printStackTrace();
			} 
			
			if(var_byte == 10 || var_byte == 13) // 10, 13 = enter��
				continue;
			if(var_byte == '*')
				break; 
			System.out.println("������: " + (char)var_byte); // var_byte�� ������ - (char)���� ����ȯ
		} while(true);

	}

}
