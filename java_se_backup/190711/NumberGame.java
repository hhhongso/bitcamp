//1~100 ������ ������ �߻��Ͽ� ���ߴ� ����. 
//���� �Է� -> ���� �Է� -> up/down -> n������ ������ϴ� ! 

import java.util.Scanner; 

class NumberGame {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
	
		while(true){
			int randomNum;			int count = 0;
			randomNum = (int)(Math.random()*100)+1;
			System.out.println("1~100������ ������ �߻��Ͽ����ϴ�.");
			
			while(true){
				System.out.print("���� �Է�: ");
				int num = scan.nextInt();
				count++;
				if(num < randomNum) { System.out.println(num + "���� ū �����Դϴ�!"); }
				else if(num > randomNum) { System.out.println(num + "���� ���� �����Դϴ�!"); }
				else if(num == randomNum) { System.out.println(count + "�� ���� ���߼̽��ϴ�.");	break;}	
			} //while
			
			
			System.out.println("����Ͻðڽ��ϱ�? Y/N");		
			String choice = scan.next();
				if(choice.equalsIgnoreCase("y")) { System.out.println("ó������ ���ư��ϴ�."); continue;} 
				else if(choice.equalsIgnoreCase("n")) { System.out.println("�����մϴ�."); System.exit(0);}
			}
				
		
	}
}
