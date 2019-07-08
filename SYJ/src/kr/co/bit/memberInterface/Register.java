package kr.co.bit.memberInterface;

import java.io.IOException;

public class Register extends Member implements Process, Insert {

	@Override
	public void process() throws IOException {
		if (!isLogin()) {
			insertData();
			System.out.println("회원가입이 완료되었습니다.");
		} else {
			printAboutLog();
		}
	}

	@Override
	public void insertData() throws IOException {
		System.out.print("아이디 입력 :");
		id = Member.br.readLine();
		System.out.print("패스워드 입력 :");
		pw = Member.br.readLine();
		System.out.print("주소 입력 :");
		addr = Member.br.readLine();
		System.out.print("전화번호 입력 :");
		pNum = Member.br.readLine();

		if (hasSameID())
			return;

		member.put("id", id);
		member.put("pw", pw);
		member.put("addr", addr);
		member.put("pNum", pNum);

		Member.members.add(member);
	}

	private boolean hasSameID() {
		boolean result = false;

		if (Member.members.size() > 0) {
			for (int i = 0; i < Member.members.size(); i++) {
				if (id.equals(Member.members.get(i).get("id"))) {
					System.out.println("이미 존재하는 아이디입니다.");
					result = true;
				}
			}
		}
		return result;
	}

	@Override
	protected void printAboutLog() {
		System.out.println("이미 로그인 중입니다.");
	}

}
