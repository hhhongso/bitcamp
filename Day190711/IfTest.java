class IfTest{
	public static void main(String[] args) {
		char ch = 'A';
		int result = 0;
		//�빮���̸� �ҹ��ڷ� ��� / �ҹ����̸� �빮�ڷ� ��� 
		if(ch >= 'A' && ch <= 'Z') 	result = ch+32;
		else if (ch >= 'a' && ch <= 'z') 	result = ch-32;
		System.out.println(ch + " => " + (char)result);	
		
	}
}
