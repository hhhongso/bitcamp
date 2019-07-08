package kr.co.bit.memberInterface;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class Member {
	protected static BufferedReader br;
	protected static ArrayList<HashMap<String, String>> members;

	protected static String session;

	protected static int count;

	static {
		br = new BufferedReader(new InputStreamReader(System.in));
		members = new ArrayList<HashMap<String, String>>();

		session = null;

		count = 0;
	}

	protected HashMap<String, String> member;
	protected String id;
	protected String pw;
	protected String addr;
	protected String pNum;

	Member() {
		member = new HashMap<String, String>();
	}

	protected boolean isLogin() {
		boolean login = true;
		if (Member.session == null) {
			login = false;
		}
		return login;
	}
	
	protected void printAboutLog() {
		System.out.println("로그인 먼저 하세요");
	}
}
