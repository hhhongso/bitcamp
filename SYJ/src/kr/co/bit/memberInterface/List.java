package kr.co.bit.memberInterface;

public class List extends Member implements Process, PrintMember {

	@Override
	public void process() {
		if (isLogin()) {
			printMembers();
		} else {
			printAboutLog();
		}
	}

	@Override
	public void printMembers() {
		System.out.println("회원ID\t회원PW\t주소\t전화번호");
		for (int i = 0; i < Member.members.size(); i++) {
			member = Member.members.get(i);
			id = member.get("id");
			pw = member.get("pw");
			addr = member.get("addr");
			pNum = member.get("pNum");
			System.out.printf("%s\t%s\t%s\t%s\n", id, pw, addr, pNum);
		}
	}
}
