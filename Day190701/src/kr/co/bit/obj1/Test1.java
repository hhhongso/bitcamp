package kr.co.bit.obj1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test1 {

	public static void main(String[] args) {	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {				//  0 1 2 34: ���ڿ� > �Է°� ���ÿ� �迭�� �ʱ�ȭ"
			System.out.println("���� | ����");
			String titleContent= br.readLine();
			int indexI = titleContent.indexOf("|"); // ==> int indexI = 2;
			String title = titleContent.substring(0,indexI); // ���ڿ��� �ڸ� �� ����ϴ� �Լ� substring
			String content = titleContent.substring(indexI+1);
			System.out.println(title);
			System.out.println(content);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
