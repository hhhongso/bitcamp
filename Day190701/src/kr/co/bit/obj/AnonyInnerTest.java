package kr.co.bit.obj;

import java.util.Scanner;

public class AnonyInnerTest {
	//throw Anonymous anonymous = new NullPointerException(); �̶�� �͸� Ŭ������ �ڵ� ������. �̸��� ���� ������ ������ �͸� Ŭ������ ����  
	//throw new NullPointerException(); //excepthionMethod ���� nullpointerException�� ������ 


/* �������̽�, �߻�Ŭ������ new ��ü������ �Ұ��ϳ�, anonymous �� ���� �����ϴ�. 
 * Anonymous class�� �ѹ��� ����ϰ� ������. 
 * */
	public static void main(String[] args) {
		CommandProcess cp = new CommandProcess();
		Scanner scan = new Scanner(System.in);
		System.out.println("1.��Ϻ��� 2. �۾���");
		int protocol = scan.nextInt();

		// �������̽��� ��ü �����ϴ� ���� �Ұ��� ==>> Class Anonymous extends ListCommand implements Command �� �ڵ���
		// Anonymous anonymous = new ListCommand();
		// anonymous.execute();
		if (protocol == 1) {
			cp.process(new Command() {
				@Override
				public void execute() {
					System.out.println("���뺸�� ����");
				}
			});

		} else {
			cp.process(new Command() {
				@Override
				public void execute() {
					System.out.println("�۾��� ����");
				}
			});
		}
	}

}
