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
		int numQ= 0; 
		int wrongCount = 0;
		int correctQ = 0;
	while(true){
		while(numQ < 5){
			numQ++;
			int a = (int)(Math.random()*90)+10;
			int b = (int)(Math.random()*90)+10;
			
			
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

		System.out.println("�� ���� ����: " + correctQ + "����: " + correctQ*20);

		System.out.println("����Ͻðڽ��ϱ�? Y/N");
		String choice = scan.next();
		if(choice.equalsIgnoreCase("y")) { System.out.println("ó������ ���ư��ϴ�. "); numQ=0;}
		else if(choice.equalsIgnoreCase("N")) { System.out.println("���̹���!"); System.exit(0);}
	}
		
	}
}
