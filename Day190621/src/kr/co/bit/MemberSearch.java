package kr.co.bit;

public class MemberSearch {
	//배열 변수 선언: 멤버 클래스의 배열방에 members라는 이름으로 변수 선언
	private Member[] members;
	
	public MemberSearch() {
		members = new Member[5];
		members[0] = new Member("김말이", 180, 61, "대한민국");
		members[1] = new Member("떡볶이", 155, 43, "대한민국");
		members[2] = new Member("Mike", 177, 60, "USA");
		members[3] = new Member("Rachel", 170, 48, "Spain");
		members[4] = new Member("Uri", 150, 57, "Japan");
	}
	
	// searchMemeber 함수 만들기 : boolean 타입의 함수
	//외부에서 접근할 것 
	public boolean searchMember(String name) {
		boolean searchResult = false; // 기본으로 false , 
		for(int i = 0; i < members.length; i++) {
			if(members[i].getName().equals(name)) { //같은 네임을 찾았따 
				printInfo(members[i]); // printInfo 함수로 member[i번쨰] 를 던진다
				searchResult = true; // 찾았을 시 true 출력 
			}
		}
		return searchResult; // boolean type의 값을 리턴함 
	}
	
	
	//비공개함수로 자기 자신의 클래스에서만 printInfo 함수를 사용합니다. 
	private void printInfo(Member member) { // printInfo(member[i번째] 에 있는  Member 클래스의 member변수의 모든 값
		System.out.println(member.getName() + "으로 검색 결과");
		System.out.println("이름:" + member.getName());
		System.out.println("키:" + member.getHeight());
		System.out.println("몸무게:" + member.getWeight());
		System.out.println("국적:" + member.getNation());
		System.out.println(member.toString());
		
		
	}
}
