package kr.co.bit;

public class while_Test4_dowhile {

	public static void main(String[] args) {
		int i = 0; 
		
		while(i>= 1) { //false �̸� �ڵ����� �Ѿ, 1���� �������� �ʰ� �ȴ�. 
			System.out.println("while area");
		}
		
		do {
			System.out.println("do~while area");
		} while (i>= 1); // while ������ �Ʒ��� �޷�����. False�̴��� 1���� �����ϰ� ��.   

	}

}
