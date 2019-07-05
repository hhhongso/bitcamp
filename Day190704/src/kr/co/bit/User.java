package kr.co.bit;

import java.io.Serializable;

/*
 * private - getter/setter는 내부 [로컬]에서밖에 사용하지 못함. 
 * 다른곳[외부]에 있는 데이터베이스 서버에 보내기 위해선 [직렬화Serialization] 가 필요 ==> 인터페이스 implements Serializable 
 */
public class User implements Serializable {

	private String ID; 
	private String pw; 
	private String addr; 
	private int age; 
	private String name;
	
	public User() {
	} 
	
	public User(String iD, String pw, String addr, int age, String name) {
		super();
		ID = iD;
		this.pw = pw;
		this.addr = addr;
		this.age = age;
		this.name = name;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "User [아이디=" + ID + ", 비밀번호=" + pw + ", 주소=" + addr + ", 나이=" + age + ", 이름=" + name + "]";
	}
	
	
}
