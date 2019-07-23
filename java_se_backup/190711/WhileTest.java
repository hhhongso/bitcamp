class WhileTest {
	public static void main(String[] args) {

		char alp = 65; //'A' 
		int num = 0;

		while(true) {
			System.out.print(alp); 
			alp++;			num++; 
			if(num % 7 == 0) System.out.println(); 
			if(alp == 91) break;
		}


	}
}
