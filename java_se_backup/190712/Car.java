/* �������� ���α׷�(POS)
�����Ǿ� ������ true, ���� ������ false. ���� ���� ������ 5��. 
===============================
1. ���� 2. ���� 3. ��������Ʈ 4. ��
===============================
��ȣ�Է�: 1
���� ��ġ �Է�: 3 ==> arr[2]
if(arr == true) �̹� �����Ǿ� �ֽ��ϴ�. 
else n���� �����Ǿ����ϴ�. ===> ���� �ñ���� 10�д� 1000�� 

��ȣ�Է�: 2
if(arr != true) ������ ���� �����ϴ�. 
else n���� �����մϴ�. ������� nnnn �� �Դϴ�. 

��ȣ�Է�: 3
1 ��ġ: false (default)
2 ��ġ: 
3 ��ġ: 
4 ��ġ: 
5 ��ġ: 

*/
import java.util.Scanner;
class Car {
	public static void main(String[] args)	{
		int choice;		int i; 
		String carNum; 
		
		Scanner scan = new Scanner(System.in);
		boolean[] arr = new boolean[5]; //default = false; �迭�� ��ü�� > �����ּҰ��� �����´�. 
		System.out.println("arr�� �����ּҰ�: " + arr);
		
		while(true){
			System.out.println("======�������� ������Ʈ=======");
			System.out.println("1.���� 2.���� 3.����Ʈ 4. ����");
			System.out.println("=============================");
			choice = scan.nextInt();
			if(choice == 1){ //1.����
				
				System.out.print("���� ��ġ �Է�: ");
				i = scan.nextInt();
				if(arr[i-1]) { //boolean ���� T/F�� ���� �̹� ������ ���� => arr[] == true ��� ���� true == true ��� ����� ���̴� �׳� arr[] �̶�� �ᵵ T/F�� Ȯ��. 
					System.out.println("�̹� ������ �����Դϴ�. ");
				} else {
				System.out.print("������ȣ: ");
				carNum = scan.next();
				arr[i-1] = true;
				System.out.println(i + "�� ������ ���� �Ϸ�");
				}

			} //1.���� 
			else if(choice == 2){ //2.����
				System.out.print("���� ��ġ �Է�: ");
				i = scan.nextInt();
				if(arr[i-1]) { 
					System.out.println(i + "�� �������� ���� �Ϸ�Ǿ����ϴ�. ");
					arr[i-1] = false;
				} else {
					System.out.println("�ش� ������ ������ ������ �����ϴ�. ");
				}
			} //2.����
			
			else if(choice == 3){ //3.����Ʈ
				for (i = 0; i < arr.length; i++) {
					System.out.println("��ġ: " + (i+1) + "	���� ����/����: " + arr[i]);
				}
			
			} //3.����Ʈ
			else if(choice == 4){ //4.����	
				break;
			} //4.����
			else { //�߸��� ��ȣ �Է�. ���ư��ϴ�. 
				System.out.println("�߸��� ��ȣ�Դϴ�. �ٽ� �Է����ּ���. ");
				continue;
			}//�߸��� ��ȣ �Է�

		}//while
		System.out.println("�����մϴ�. ");
	}
}
