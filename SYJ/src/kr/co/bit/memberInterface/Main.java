package kr.co.bit.memberInterface;

import java.io.IOException;

public class Main {

	public static void main(String[] args) {

		Poly p = new Poly();
		Register r = new Register();
		List l = new List();
		Search s = new Search();
		Delete d = new Delete();
		Update u = new Update();
		Login in = new Login();
		Logout out = new Logout();

		String uSelect = null;

		while (true) {
			System.out.println(Member.session);
			// 세션 변화를 확인할 수 있도록 집어 넣은 코드.
			// 테스트용이므로 지워도 상관 없음.

			System.out.println("R: 회원가입 | L: 회원목록 | S: ID찾기");
			System.out.println("D: 회원탈퇴 | E: 회원수정 | I: 로그인");
			System.out.println("O: 로그아웃 | Q: 종료");

			try {
				uSelect = Member.br.readLine();
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}

			if (uSelect.equalsIgnoreCase("r")) { // 회원가입
				p.process(r);
			} else if (uSelect.equalsIgnoreCase("l")) { // 회원목록
				p.process(l);
			} else if (uSelect.equalsIgnoreCase("s")) { // id 찾기 선택
				p.process(s);
			} else if (uSelect.equalsIgnoreCase("d")) { // 회원탈퇴
				p.process(d);
			} else if (uSelect.equalsIgnoreCase("e")) { // 회원수정
				p.process(u);
			} else if (uSelect.equalsIgnoreCase("i")) { // 로그인
				p.process(in);
			} else if (uSelect.equalsIgnoreCase("o")) { // 로그아웃
				p.process(out);
			} else if (uSelect.equalsIgnoreCase("q")) {
				System.out.println("시스템을 종료합니다. 감사합니다.");
				System.exit(0);
			} else {
				System.out.println("잘못된 메뉴입니다.");
				continue;
			}
		}
	}
}
