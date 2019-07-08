package kr.co.bit.memberInterface;

import java.io.IOException;

public class Login extends Member implements Process, Session {

	private boolean rightID;
	private boolean rightPW;

	@Override
	public void process() throws IOException {
		printFailStatus();
		forceLogout();
		if (isLogin()) {
			printAboutLog();
		} else if (Member.members.size() < 1) {
			System.out.println("등록된 회원이 없습니다.");
		} else if (!isLogin() && Member.members.size() > 0) {
			System.out.print("아이디 입력 :");
			id = Member.br.readLine();
			System.out.println("패스워드 입력 :");
			pw = Member.br.readLine();
			tryLogin();
		}
	}

	@Override
	public void changeSessionStatus() {
		Member.session = id;
	}

	@Override
	protected void printAboutLog() {
		System.out.println("이미 로그인 하셨습니다.");
	}

	private void tryLogin() {
		for (int i = 0; i < Member.members.size(); i++) {
			member = Member.members.get(i);
			rightID = id.equals(member.get("id"));
			rightPW = pw.equals(member.get("pw"));

			if (rightID && rightPW) {
				System.out.println("환영합니다. 로그인 되었습니다."); 
				initFailCount();
				changeSessionStatus();
				return;
			} else if (!rightID) {
				System.out.println("아이디가 틀렸습니다.");
				countFail();
				return;
			} else {
				System.out.println("비밀번호가 틀렸습니다.");
				countFail();
				return;
			}
		}
	}

	private void printFailStatus() {
		if (Member.count > 0 && Member.count < 5) {
			System.out.println((5 - Member.count) + "번 안에 로그인에 성공하지 않을시 강제 종료합니다.");
		}
	}

	private void forceLogout() {
		if (Member.count == 5) {
			System.out.println("로그인 실패 가능 회수를 초과했습니다. 시스템을 종료합니다.");
			System.exit(0);
		}
	}

	private void countFail() {
		Member.count++;
	}

	private void initFailCount() {
		Member.count = 0;
	}

}
