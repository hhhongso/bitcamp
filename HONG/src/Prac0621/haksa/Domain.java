package Prac0621.haksa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Domain {

	//학사관리 시스템에 필요한 필드 
	private String name; 
	private int age; 
	private String idNum; 
	private String subject; 
	private String part; 
	private int type; // stu = 1 prof =2 mng =3
	
	public static ArrayList<HashMap<String, String>> haksaList;
	public static Scanner sc;
	
	
	public Domain(String name, int age, String idNum, String subject, String part, int type) {
		super();
		this.name = name;
		this.age = age;
		this.idNum = idNum;
		this.subject = subject;
		this.part = part;
		this.type = type;
	}

	public Domain() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getIdNum() {
		return idNum;
	}

	public void setIdNum(String idNum) {
		this.idNum = idNum;
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

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public static ArrayList<HashMap<String, String>> getHaksaList() {
		return haksaList;
	}

	public static void setHaksaList(ArrayList<HashMap<String, String>> haksaList) {
		Domain.haksaList = haksaList;
	}

	public static Scanner getSc() {
		return sc;
	}

	public static void setSc(Scanner sc) {
		Domain.sc = sc;
	}

	
	
}
