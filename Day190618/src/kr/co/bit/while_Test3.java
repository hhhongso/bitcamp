package kr.co.bit;
//구구단 2~9단 중 임의의 숫자 받아서 구구단 찍기 

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
