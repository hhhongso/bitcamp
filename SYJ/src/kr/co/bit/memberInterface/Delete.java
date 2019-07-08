package kr.co.bit.memberInterface;

public class Delete extends Member implements Process, Session {

	@Override
	public void process() {
		if (isLogin()) {
			leave();
			changeSessionStatus();
			System.out.println("회원탈퇴 되었습니다.");
		} else {
			printAboutLog();
		}
	}

	@Override
	public void changeSessionStatus() {
		Member.session = null;
	}

	private void leave() {
		for (int i = 0; i < Member.members.size(); i++) {
			member = Member.members.get(i);
			if (Member.session.equals(member.get("id"))) {
				Member.members.remove(i);
				return;
			}
		}
	}
}
