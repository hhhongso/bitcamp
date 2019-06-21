package Practice0620.haksaObj;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Domain {
	public static ArrayList<HashMap<String, String>> haksaList = new ArrayList<HashMap<String, String>>();
	public static ArrayList<String> superKeyList = new ArrayList<String>();
	public static Scanner sc = new Scanner(System.in);

	private int superKey; // 고유번호 (Primary key 개념)
	private int uSelect; // 메뉴 선택시 번호 받는 변수

	private String name; // 이름
	private String age; // 나이
	private String numID; // 학번
	private String subject; // 과목
	private String part; // 부서
	private String key; // 학생, 교수, 관리자 구분해서 받는 키 값

	public int getSuperKey() {
		return ++superKey;
	}

	public int getuSelect() {
		return uSelect;
	}

	public void setuSelect(int uSelect) {
		this.uSelect = uSelect;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getNumID() {
		return numID;
	}

	public void setNumID(String numID) {
		this.numID = numID;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getPart() {
		return part;
	}

	public void setPart(String part) {
		this.part = part;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

}
