package kr.co.bit;
//������ 2~9�� �� ������ ���� �޾Ƽ� ������ ��� 

public class while_Test3 {
public static void main(String[] args) {
	int gugudan = Integer.parseInt(args[0]);
	if (gugudan >= 2 && gugudan <= 9) {
		int num = 1; 
		int result = 0;
		while (num <=9) {
			result = gugudan * num; 
			System.out.println(gugudan + "X" + num + "=" + result);
			num++;
		}
	}
	
	}
}
