/*
10~99������ ������ 2�� �߻��Ͽ� ���� ���ߴ� ����
�� ������ 5������ �����Ѵ�
1������ ���� 20���Դϴ�
Ʋ���� 1�� �� ��ȸ�� �����Ѵ�

[������]
[1] 12 + 36 = xx
Ʋ�ȴ�
[1] 12 + 36 = xxx
Ʋ�ȴ�...������ 48

[2] 10 + 15 = xx
������

[5] 90 + 88 =
Ʋ�ȴ�
[5] 90 + 88 = 178
������

�� ���������� 2�����̰� ������ 40���Դϴ�

�� �ҷ�(Y/N) : n
���α׷��� �����մϴ�
*/

import java.util.Scanner;
class Quiz {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		//int numQ= 0; 
		//int wrongCount = 0;
		int correctQ = 0;		int score =20;
		int a, b, answer;		String choice;


		while(true){
			correctQ = 0;
			for(int i = 1; i <= 5; i++){
				a = (int)(Math.random()*90)+10;
				b = (int)(Math.random()*90)+10;
				
				for(int j = 0 ; j < 2 ; j++){	
					System.out.print("[" + i + "]" + a + "+" + b + "= ");
					answer = scan.nextInt();
					
					if(answer == a+b) { 
						System.out.println("����!");
						correctQ++;
						break; //for j�� �����. 
					} else {
						if(j == 2) System.out.println("Ʋ�Ƚ��ϴ�. ������: " + (a+b));
						else	System.out.println("Ʋ�Ƚ��ϴ�. �ٽ� ������ּ���: ");
					}
				}//for j


			}//for i
		System.out.println("�� ���� ����: " + correctQ + "����: " + correctQ*score);

		do {
			System.out.println("����Ͻðڽ��ϱ�? Y/N");
			choice = scan.next();
			if(choice.equalsIgnoreCase("Y") || choice.equalsIgnoreCase("N")) break; 
		
		} while(true);
			if(choice.equalsIgnoreCase("N")) break; 

		}//while
	}
}





/*
	while(true){
		while(numQ < 5){
			numQ++;
			a = (int)(Math.random()*90)+10;
			b = (int)(Math.random()*90)+10;
			
			
				for(int i = 0 ; i < 2 ; i++){	
					System.out.println("[" + numQ + "]" + a + "+" + b + "= ");
					int answer = scan.nextInt();
					if(a+b == answer) { 
						System.out.println("����!");
						wrongCount = 0; correctQ++; break;
					} else { 
						System.out.println("Ʋ�Ƚ��ϴ�. �ٽ� ������ּ���: "); 
						wrongCount++; 	
						if(wrongCount == 2) { 
							System.out.println("���� ���� Ƚ�� �ʰ�.. ������: " + (a+b)); 
							wrongCount = 0;
						}	
					}
				}	

		}// while

		System.out.println("�� ���� ����: " + correctQ + "����: " + correctQ*score);

		System.out.println("����Ͻðڽ��ϱ�? Y/N");
		String choice = scan.next();
		if(choice.equalsIgnoreCase("y")) { System.out.println("ó������ ���ư��ϴ�. "); numQ=0;}
		else if(choice.equalsIgnoreCase("N")) { System.out.println("���̹���!"); System.exit(0);}
	}
	*/	
	