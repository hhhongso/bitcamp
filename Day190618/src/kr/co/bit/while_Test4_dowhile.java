package kr.co.bit;

public class while_Test4_dowhile {

	public static void main(String[] args) {
		int i = 0; 
		
		while(i>= 1) { //false 이면 코드블록을 넘어가, 1번도 수행하지 않게 된다. 
			System.out.println("while area");
		}
		
		do {
			System.out.println("do~while area");
		} while (i>= 1); // while 조건이 아래에 달려있음. False이더라도 1번은 수행하게 됨.   

	}

}
