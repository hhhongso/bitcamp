package kr.co.bit2;
/*
 * 
파이프라인 : 스트림(컬렉션, 배열, 파일)이 연결되어 있는 구조
필터링, 매팅, 정렬, 그룹핑 등 중간 처리 메소드가 있으며, 이 메소드들은 중간 처리된 스트림을 리턴한다. 
>> 최종적으로 정제된 데이터를 호출 

 */
public class Member {
	public static int MALE = 0; 
	public static int FEMALE = 1; 
	
	private String name; 
	private int gender; 
	private int age;
	
	public Member(String name, int gender, int age) {
		super();
		this.name = name;
		this.gender = gender;
		this.age = age;
	}

	public static int getMALE() {
		return MALE;
	}

	public static int getFEMALE() {
		return FEMALE;
	}

	public int getGender() {
		return gender;
	}

	public int getAge() {
		return age;
	}
	
	
}
