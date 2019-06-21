package Practice0620.haksaObj;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MainProcess {

	Domain domain = new Domain();
	Register register = new Register(domain);
	Search search = new Search(domain);
	Delete delete = new Delete(domain);
	PrintAll printAll = new PrintAll(domain);

	public void startHaksa() {
		while (true) {
			printMenu(); // �޴� ����Ʈ
			domain.setuSelect(selectMenu()); // �޴���ȣ ����
			if (domain.getuSelect() == 1) { // ��ϼ���
				register.processRegit();
			} else if (domain.getuSelect() == 2) { // ã�⼱��
				search.processSearch();
			} else if (domain.getuSelect() == 3) { // ��������
				delete.processDelete();
			} else if (domain.getuSelect() == 4) { // ��ü���
				printAll.processPrintAll();
			} else if (domain.getuSelect() == 0) { // ����
				System.out.println("[�ý��� �޼���] : ���α׷��� �����մϴ�. �����մϴ�.");
				System.exit(0);
			} else {
				System.out.println("�������� �ʴ� �޴��Դϴ�.");
			}
		}
	}

	private int selectMenu() {
		try {
			domain.sc = new Scanner(System.in);
			domain.setuSelect(domain.sc.nextInt());
			if (domain.getuSelect() > 4 || domain.getuSelect() < 0) {
				return -1;
			}
			return domain.getuSelect();
		} catch (InputMismatchException ime) {
			return -1;
		}
	}

	private void printMenu() {
		System.out.println("==========�޴� ����==========");
		System.out.println("1. ���");
		System.out.println("2. ã��");
		System.out.println("3. ����");
		System.out.println("4. ��ü ���");
		System.out.println("-----------------------------");
		System.out.println("0. ����");
		System.out.print("��ȣ�� ������ �ּ���... : ");
	}

	public static void main(String[] args) {
		MainProcess mainProcess = new MainProcess();
		mainProcess.startHaksa();
	}
}
