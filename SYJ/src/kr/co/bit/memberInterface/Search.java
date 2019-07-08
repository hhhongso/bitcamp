package kr.co.bit.memberInterface;

import java.io.IOException;

public class Search extends Member implements Process, PrintMember {

	private String serchId;

	@Override
	public void process() throws IOException {
		if (isLogin()) {
			searchById();
			printMembers();
		} else {
			printAboutLog();
		}
	}

	private void searchById() throws IOException {
		System.out.print("찾는 ID 입력 :");
		serchId = Member.br.readLine();
	}

	@Override
	public void printMembers() {
		System.out.println("회원ID\t회원PW\t주소\t전화번호");
		for (int i = 0; i < Member.members.size(); i++) {
			member = Member.members.get(i);
			if (serchId.equals(member.get("id"))) {
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
