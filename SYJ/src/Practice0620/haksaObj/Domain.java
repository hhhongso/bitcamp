package Practice0620.haksaObj;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Domain {
	public static ArrayList<HashMap<String, String>> haksaList = new ArrayList<HashMap<String, String>>();
	public static ArrayList<String> superKeyList = new ArrayList<String>();
	public static Scanner sc = new Scanner(System.in);

	private int superKey; // ������ȣ (Primary key ����)
	private int uSelect; // �޴� ���ý� ��ȣ �޴� ����

	private String name; // �̸�
	private String age; // ����
	private String numID; // �й�
	private String subject; // ����
	private String part; // �μ�
	private String key; // �л�, ����, ������ �����ؼ� �޴� Ű ��

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
