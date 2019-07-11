package Prac0702;

public class IfTest{
		public static void main(String[] args) {
			char ch = 'A';
			//대문자이면 소문자로 출력 else if 소문자이면 대문자로 출력 
			if(ch >= 65 && ch <= 90) {
				System.out.println(ch+32);
			} else if (ch >= 97 && ch <= 120) {
				System.out.println(ch-32);
				}
			
		}
	}


