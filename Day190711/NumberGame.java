//1~100 사이의 난수를 발생하여 맞추는 게임. 
//난수 입력 -> 숫자 입력 -> up/down -> n번만에 맞췄습니다 ! 

import java.util.Scanner; 

class NumberGame {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
	
		while(true){
			int randomNum;			int count = 0;
			randomNum = (int)(Math.random()*100)+1;
			System.out.println("1~100사이의 난수가 발생하였습니다.");
			
			while(true){
				System.out.print("숫자 입력: ");
				int num = scan.nextInt();
				count++;
				if(num < randomNum) { System.out.println(num + "보다 큰 숫자입니다!"); }
				else if(num > randomNum) { System.out.println(num + "보다 작은 숫자입니다!"); }
				else if(num == randomNum) { System.out.println(count + "번 만에 맞추셨습니다.");	break;}	
			} //while
			
			
			System.out.println("계속하시겠습니까? Y/N");		
			String choice = scan.next();
				if(choice.equalsIgnoreCase("y")) { System.out.println("처음으로 돌아갑니다."); continue;} 
				else if(choice.equalsIgnoreCase("n")) { System.out.println("종료합니다."); System.exit(0);}
			}
				
		
	}
}
