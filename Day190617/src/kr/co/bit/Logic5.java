package kr.co.bit;

public class Logic5 {

	public static void main(String[] args) {
		String id = args[0]; // 0��° �迭
		String pw = args[1];
		
		if(!id.equals("java")) { //.equals: ���ڿ��� ������ ������ ?
			System.out.println("����� ȸ���� �ƴմϴ�. ");
		} else if (!pw.equals("java")) { // !~ equals: ~�� ���� �ʴ�  => true�̸� �ڵ��� ����
			System.out.println("��й�ȣ�� ��ġ���� �ʽ��ϴ�.");
		} else {
			System.out.println("ȯ���մϴ� !");
		}

	}

}
