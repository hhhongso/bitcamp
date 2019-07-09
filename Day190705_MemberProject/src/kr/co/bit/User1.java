package kr.co.bit;
//직렬화
import java.io.Serializable;

public class User1 implements Serializable {
	private String id; 
	private String pw; 
	private String addr; 
	private transient int age; // transient: 외부로 내보내지 않을 것(직렬화 시키지 않을 것)  
	private String name;
	
	public User1() {
		super();
	}

	public User1(String id, String pw, String addr, int age, String name) {
		super();
		this.id = id;
		this.pw = pw;
		this.addr = addr;
		this.age = age;
		this.name = name;
	}

	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
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
		return "User1 [아이디=" + id + ",비밀번호=" + pw + ", 주소=" + addr + ", 이름=" + name + "]";
	} 
	
	
	
}
