package kr.co.bit.instructor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class MemberExecuter {
	public static String session;
	static {
		session = null;
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		ArrayList<HashMap<String, String>> memberList = new ArrayList<HashMap<String, String>>();
		while (true) {// 반복문
			System.out.println("R:회원가입 L:회원목록 S:ID찾기 D:회원탈퇴 E:회원수정I:로그인O:로그아웃");
			char protocol = input.next().charAt(0);
			if (protocol == 'R' || protocol == 'r') {// 회원가입
				if (session != null) {
					System.out.println("로그인중입니다.");
					continue;
				}
				System.out.println("아이디입력:");
				String id = input.next();
				System.out.println("패스워드입력:");
				String pw = input.next();
				System.out.println("주소입력:");
				String addr = input.next();
				System.out.println("전화번호입력:");
				String tel = input.next();
				HashMap<String, String> memberHash = new HashMap<String, String>();
				memberHash.put("id", id);
				memberHash.put("pw", pw);
				memberHash.put("addr", addr);
				memberHash.put("tel", tel);
				memberList.add(memberHash);
				System.out.println("회원등록되었습니다.");
			} // 회원가입
			else if (protocol == 'L' || protocol == 'l') {// 회원목록
				System.out.print("회원아이디\t회원패스워드\t회원주소\t회원전화번호\n");
				for (int indexI = 0; indexI < memberList.size(); indexI++) {
					HashMap<String, String> memberHash = memberList.get(indexI);
					System.out.print(memberHash.get("id") + "\t");
					System.out.print(memberHash.get("pw") + "\t");
					System.out.print(memberHash.get("addr") + "\t");
					System.out.print(memberHash.get("tel") + "\n");
				}
			} // 회원목록
			else if (protocol == 'S' || protocol == 's') {// 찾기
				System.out.println("찾는 ID를 입력:");
				String searchId = input.next();
				System.out.print("회원아이디\t회원패스워드\t회원주소\t회원전화번호\n");
				for (int indexI = 0; indexI < memberList.size(); indexI++) {// 반복문
					HashMap<String, String> memberHash = memberList.get(indexI);
					if (memberHash.get("id").equals(searchId)) {// 메모리id와입력한id같으면
						System.out.print(memberHash.get("id") + "\t");
						System.out.print(memberHash.get("pw") + "\t");
						System.out.print(memberHash.get("addr") + "\t");
						System.out.print(memberHash.get("tel") + "\n");
					} // 메모리id와입력한id가같으면
				} // 반복문
			} // 찾기
			else if (protocol == 'D' || protocol == 'd') {// 회원탈퇴
				for (int indexI = 0; indexI < memberList.size(); indexI++) {// 반복문
					HashMap<String, String> memberHash = memberList.get(indexI);
					if (memberHash.get("id").equals(session)) {// 아이디와세션이같으면
						memberList.remove(indexI);// 회원정보를 삭제한다.
					} // 아이디와세션이같으면
				} // 반복문
				session = null;
				System.out.println("회원탈퇴되었습니다.");
			} // 회원탈퇴
			else if (protocol == 'E' || protocol == 'e') {// 회원수정
				System.out.print("회원아이디\t회원패스워드\t회원주소\t회원전화번호\n");
				for (int indexI = 0; indexI < memberList.size(); indexI++) {// 반복문
					HashMap<String, String> memberHash = memberList.get(indexI);
					if (memberHash.get("id").equals(session)) {// 메모리아이디와세션이같으면수정
						System.out.print(memberHash.get("id") + "\t");
						System.out.print(memberHash.get("pw") + "\t");
						System.out.print(memberHash.get("addr") + "\t");
						System.out.print(memberHash.get("tel") + "\n");
						System.out.println("회원아이디입력:");
						String id = input.next();
						System.out.println("회원패스워드입력:");
						String pw = input.next();
						System.out.println("회원주소입력:");
						String addr = input.next();
						System.out.println("회원전화번호입력:");
						String tel = input.next();
						memberHash.put("id", id);
						memberHash.put("pw", pw);
						memberHash.put("addr", addr);
						memberHash.put("tel", tel);
						memberList.set(indexI, memberHash);
						session = id;
					} // 메모리와세션이같으면수정
				} // 반복문
				System.out.println("회원이수정되었습니다.");
			} // 회원수정
			else if (protocol == 'I' || protocol == 'i') {// 로그인
				System.out.println("아이디입력:");
				String loginId = input.next();
				System.out.println("패스워드입력:");
				String loginPw = input.next();
				for (int indexI = 0; indexI < memberList.size(); indexI++) {// 반복문
					HashMap<String, String> memberHash = memberList.get(indexI);
					if (!(loginId.equals(memberHash.get("id")))) {// 아이디가틀렸을때
						System.out.println("아이디가 틀렸습니다.");
						return;
					} // 아이디가틀렸을때
					if (!(loginPw.equals(memberHash.get("pw")))) {// 패스워드틀렸을때
						System.out.println("패스워드가 틀렸습니다.");
						return;
					} // 패스워드틀렸을때
					if (memberList.size() == 0) {
						System.out.println("아이디가 없습니다.");
						System.out.println("시스템을 종료합니다.");
						System.exit(0);
					} else {
						System.out.println("환영합니다.로그인되었습니다.");
						session = loginId;// 세션에로그인아이디를등록한다.
					}
				} // 반복문
			} // 로그인
			else if (protocol == 'O' || protocol == 'o') {// 로그아웃
				session = null;// 세션을null초기화한다.
				System.out.println("로그아웃되었습니다.");
			} // 로그아웃
		} // 반복문
	}
}