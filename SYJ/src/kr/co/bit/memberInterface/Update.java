package kr.co.bit.memberInterface;

import java.io.IOException;

public class Update extends Member implements Process, Insert, PrintMember, Session {

	private int idx;

	@Override
	public void process() throws IOException {
		if (isLogin()) {
			printMembers();
			insertData();
			changeSessionStatus();
			System.out.println("회원 수정이 완료되었습니다.");
		} else {
			printAboutLog();
		}
	}

	@Override
	public void changeSessionStatus() {
		Member.session = id;
	}

	@Override
	public void insertData() throws IOException {
		System.out.println("수정할 ID :");
		id = Member.br.readLine();
		System.out.println("수정할 PW :");
		pw = Member.br.readLine();
		System.out.println("수정할 주소 :");
		addr = Member.br.readLine();
		System.out.println("수정할 전화번호 :");
		pNum = Member.br.readLine();

		member.put("id", id);
		member.put("pw", pw);
		member.put("addr", addr);
		member.put("pNum", pNum);

		Member.members.set(idx, member);
	}

	@Override
	public void printMembers() {
		System.out.println("회원ID\t회원PW\t주소\t전화번호");
		for (int i = 0; i < Member.members.size(); i++) {
			member = Member.members.get(i);
			idx = i;
			if (Member.session.equals(member.get("id"))) {
				id = member.get("id");
				pw = member.get("pw");
				addr = member.get("addr");
				pNum = member.get("pNum");
				System.out.printf("%s\t%s\t%s\t%s\n", id, pw, addr, pNum);
				break;
			}
		}
	}

}
