class IfTest{
	public static void main(String[] args) {
		char ch = 'A';
		int result = 0;
		//대문자이면 소문자로 출력 / 소문자이면 대문자로 출력 
		if(ch >= 'A' && ch <= 'Z') 	result = ch+32;
		else if (ch >= 'a' && ch <= 'z') 	result = ch-32;
		System.out.println(ch + " => " + (char)result);	
		
	}
}
