/*
	����		��1	��2	��3
�����
	��1		=	w	l
	��2		l	=	w		
	��3		w	l	=
*/

/*���� ���� ��
1: ���� 2: ���� 3:�� 
��ǻ��: 1~3 ������ ������ �߻� 
�����: 1~3 �� �ϳ��� �Է� (System.in.read()�� ���)
��ǻ��: ����, ��: ���� 
���� ! ����� �ݾ��� nnn

�⺻�ݾ�: 10,000 ���� 
���ñݾ�: �Է¹ޱ�
���͸� ġ����....

�ݾ��� 0�̰� ���̳ʽ��̸� ���� ���� ���� ���� y/n
n: ���α׷� ���� 
y: ���� ����


'A' --- [32] --- 'a'
0 --- [48] --- '0'
*/

import java.util.Scanner; 
class Game {
	public static void main(String[] args) throws java.io.IOException {
		int com, user, bet, charge;
		int money = 10000;
		Scanner scan = new Scanner(System.in);
//1. 
while(true){
		while(money > 0){
			com = (int)(Math.random()*3)+1;
			System.out.println("1.���� 2.���� 3.�� �� �ϳ��� ����");

			user = System.in.read()-'0';
			scan.nextLine();
			//System.in.read(); // flush
			//System.in.read();

			System.out.println("�󸶸� �����Ͻðڽ��ϱ�? ");
			bet = scan.nextInt(); 
			scan.nextLine();
			//���� \r\n
				
			System.out.print("�����Ͻ÷��� ����Ű�� �Է��ϼ���..");
		    //scan.nextLine();
			System.in.read();
			System.in.read();

			if(com == 1){
				if(user == 1){
					System.out.println("��ǻ��: ����, �����: ����");
					System.out.println("�����ϴ�.");

				} else if (user == 2){
					System.out.println("��ǻ��: ����, �����: ����");	
					System.out.println("�̰���ϴ�.");
					money +=bet;
				
				} else if (user == 3){
					System.out.println("��ǻ��: ����, �����: ��");
					System.out.println("�����ϴ�.");
					money -=bet;
				}
				
			}

			else if(com == 2){
				if(user == 1){
					System.out.println("��ǻ��: ����, �����: ����");
					System.out.println("�����ϴ�.");
					money -=bet;
				} else if (user == 2){
					System.out.println("��ǻ��: ����, �����: ����");	
					System.out.println("�����ϴ�.");
				} else if (user == 3){
					System.out.println("��ǻ��: ����, �����: ��");
					System.out.println("�̰���ϴ�.");
					money +=bet;
				}
				
			}

			else if(com == 3){
				if(user == 1){
					System.out.println("��ǻ��: ��, �����: ����");
					System.out.println("�̰���ϴ�.");
					money +=bet;
				} else if (user == 2){
					System.out.println("��ǻ��: ��, �����: ����");	
					System.out.println("�����ϴ�.");
					money -=bet;
				} else if (user == 3){
					System.out.println("��ǻ��: ��, �����: ��");
					System.out.println("�����ϴ�.");
				}				
			}

			System.out.println("���� ������ " + money + "�� �Դϴ�.");
			System.out.println();
		
		}//while
			System.out.print("���� ������ �����ϴ�. �����Ͻðڽ��ϱ�? y/n");
			String choice = scan.next();
			if(choice.equalsIgnoreCase("Y")) {
				System.out.print("���� �ݾ��� �Է��ϼ���: ");
				charge = scan.nextInt();
				System.out.print(charge + "�� ���� �Ϸ�. ó������ ���ư��ϴ�.");
				money = charge;
			} else if(choice.equalsIgnoreCase("N")){
				System.out.print("���̹���! ");
				break; //System.exit(0); �� �ϰ� ���� �� ������ �Ʒ� sysout �� ���� �� ���� (�̹� exit)
			}
	}//while
	System.out.println("���α׷��� �����մϴ�. ");
}
}


//2.
/*
			int result = user - com;
			if(result == 1 || result == -2) {
				System.out.println("�̰���ϴ�.");
			} else if(result == -1 || result == 2) {
				System.out.println("�����ϴ�.");
			} else {
				System.out.println("�����ϴ�.");
			}

			System.out.println("��ǻ��: " + com + "�����: " + user);
*/


