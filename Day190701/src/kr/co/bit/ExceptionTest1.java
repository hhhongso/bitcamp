package kr.co.bit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ExceptionTest1 {

	public static void main(String[] args) {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); //Scanner���� ������ �Է±�
		System.out.println("���ڿ� �Է�: ");
		try {	//������ �� ����[readLine]�� ����ó���� ����ش�. 
			String str = bf.readLine(); // �� �� ��ü�� �о� �鿩���� �Լ� 
		} catch (IOException e) { //
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		/*
		 * ������ �� ������ ���� ��� > ��ǻ�Ͱ� ���� �� try/catch �� �ڵ����� ���� 
		 * ������ �� �� ������ ���� ��� >> Runtime ��Ӱ��� X > �����ڰ� ���� try/catch ó�����־��
		 * if-else �� ���� = try/catch 
		 * ����ó�� �Ŀ��� ���α׷��� ��� ����ȴ� 
		 */
		
		
		
//		int num = Integer.parseInt(args[0]);
//		int result = 10 / num; // num = 0 �� �� �� ���� > ������ ��, ������ �� ���� �߻�
//		System.out.println(result);
	
	
	
	}

}
