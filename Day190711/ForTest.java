class ForTest{
	public static void main(String[] args) {
	/*
		double a; 
		for(int i = 0;  i < 100; i++) {
		a = Math.random();	
		System.out.println(a); 
		}
		
		int b; 			
					//int����ȯ ���� ==> 0 ==> (*100)�� ���� �����־�� ��	
		for(int i = 0;  i < 100; i++) {
			b = (int)(Math.random()*100)+1; 
			System.out.println(b); 
		}
*/
		int c;		int count = 0;
		for(int i =0 ; i <100; i++){ 
			c = (int)(Math.random()*26)+65; // 65~90
			if(c == 'Q') count++;
			System.out.print((char)c + " ");
			if(i % 10 == 0) System.out.println();
		}
		System.out.println();
		System.out.println((char)c + " �� ����: " + count);

	}

}
		
	

//Math.random()		new Random().

//����: ��ǻ�Ͱ� �ұ�Ģ�ϰ� �߻��ϴ� ��. 
//	0 <= ���� < 1