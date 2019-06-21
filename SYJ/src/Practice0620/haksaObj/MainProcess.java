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
			printMenu(); // 메뉴 프린트
			domain.setuSelect(selectMenu()); // 메뉴번호 선택
			if (domain.getuSelect() == 1) { // 등록선택
				register.processRegit();
			} else if (domain.getuSelect() == 2) { // 찾기선택
				search.processSearch();
			} else if (domain.getuSelect() == 3) { // 삭제선택
				delete.processDelete();
			} else if (domain.getuSelect() == 4) { // 전체출력
				printAll.processPrintAll();
			} else if (domain.getuSelect() == 0) { // 종료
				System.out.println("[시스템 메세지] : 프로그램을 종료합니다. 감사합니다.");
				System.exit(0);
			} else {
				System.out.println("존재하지 않는 메뉴입니다.");
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
		System.out.println("==========메뉴 선택==========");
		System.out.println("1. 등록");
		System.out.println("2. 찾기");
		System.out.println("3. 삭제");
		System.out.println("4. 전체 출력");
		System.out.println("-----------------------------");
		System.out.println("0. 종료");
		System.out.print("번호를 선택해 주세요... : ");
	}

	public static void main(String[] args) {
		MainProcess mainProcess = new MainProcess();
		mainProcess.startHaksa();
	}
}
