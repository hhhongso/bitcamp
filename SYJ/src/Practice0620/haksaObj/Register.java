package Practice0620.haksaObj;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.ArrayList;

public class Register {

	Domain domain;
//	public static int superKey;
//	Scanner sc;
//	ArrayList<HashMap<String, String>> haksaList = new ArrayList<HashMap<String, String>>();
//	String age;
//	String name;
//	String numID;
//	String subject;
//	String part;

	Register(Domain domain) {
		this.domain = domain;
	}

	public void processRegit() {
		while (true) {
			printMenuRegit();
			domain.setuSelect(selectMenu());
			if (domain.getuSelect() == 1) {
				regitPerson();
			} else if (domain.getuSelect() == 2) {
				regitPerson();
			} else if (domain.getuSelect() == 3) {
				regitPerson();
			} else if (domain.getuSelect() == 4) {
				break;
			}
		}
	}

	public void printMenuRegit() {
		System.out.println("==========등록 선택==========");
		System.out.println("1. 학생");
		System.out.println("2. 교수");
		System.out.println("3. 관리자");
		System.out.println("4. 이전메뉴");
		System.out.print("번호를 선택해 주세요... : ");
	}

	public int selectMenu() {
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

	public void regitPerson() {
		HashMap<String, String> haksa = new HashMap<String, String>();
		System.out.print("나이 : ");
		domain.setAge(domain.sc.next());
		System.out.print("이름 : ");
		domain.setName(domain.sc.next());
		haksa.put("age", domain.getAge());
		haksa.put("name", domain.getName());
		haksa.put("superKey", Integer.toString(domain.getSuperKey()));
		if (domain.getuSelect() == 1) { // 학생
			System.out.print("학번 : ");
			domain.setNumID(domain.sc.next());
			haksa.put("numID", domain.getNumID());
			haksa.put("key", Integer.toString(domain.getuSelect()));
		} else if (domain.getuSelect() == 2) { // 교수
			System.out.print("과목 : ");
			domain.setSubject(domain.sc.next());
			haksa.put("subject", domain.getSubject());
			haksa.put("key", Integer.toString(domain.getuSelect()));
		} else if (domain.getuSelect() == 3) { // 관리자
			System.out.print("부서 : ");
			domain.setPart(domain.sc.next());
			haksa.put("part", domain.getPart());
			haksa.put("key", Integer.toString(domain.getuSelect()));
		}
		domain.haksaList.add(haksa);
	}
}
