package bitProject.cafe.dto;

import javax.swing.JCheckBox;

public class MemberDTO {
	private String id;
	private String pw;
	private String name;
	private String emailAccount;
	private String emailDomain;
	private String tel1;
	private String tel2;
	private String tel3;
	private int birthYear;
	private int birthMonth;
	private int birthDate;
	private boolean isStaff;
	private boolean isManager;
	private boolean isAgreeEssen;
	private boolean isAgreeSelec;
	private int memberPoint;
	
	
	public MemberDTO(String id, String pw, String name, String emailAccount, String emailDomain, String tel1,
			String tel2, String tel3, int birthYear, int birthMonth, int birthDate, boolean isAgreeEssen, boolean isAgreeSelec) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.emailAccount = emailAccount;
		this.emailDomain = emailDomain;
		this.tel1 = tel1;
		this.tel2 = tel2;
		this.tel3 = tel3;
		this.birthYear = birthYear;
		this.birthMonth = birthMonth;
		this.birthDate = birthDate;
		this.isAgreeEssen = isAgreeEssen;
		this.isAgreeSelec = isAgreeSelec;
		this.memberPoint = 0;
	}
	
	// 테스트용 스태프 생성자
	public MemberDTO(String id, String pw, String name, String emailAccount, String emailDomain, String tel1,
			String tel2, String tel3, int birthYear, int birthMonth, int birthDate, boolean isStaff, boolean isAgreeEssen, boolean isAgreeSelec) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.emailAccount = emailAccount;
		this.emailDomain = emailDomain;
		this.tel1 = tel1;
		this.tel2 = tel2;
		this.tel3 = tel3;
		this.birthYear = birthYear;
		this.birthMonth = birthMonth;
		this.birthDate = birthDate;
		this.isStaff = isStaff;		
		this.isAgreeEssen = isAgreeEssen;
		this.isAgreeSelec = isAgreeSelec;		
		this.memberPoint = 0;
	}

	public String getId() {
		return id;
	}

	public String getPw() {
		return pw;
	}

	public String getName() {
		return name;
	}

	public String getEmailAccount() {
		return emailAccount;
	}

	public String getEmailDomain() {
		return emailDomain;
	}

	public String getTel1() {
		return tel1;
	}

	public String getTel2() {
		return tel2;
	}

	public String getTel3() {
		return tel3;
	}

	public int getBirthYear() {
		return birthYear;
	}

	public int getBirthMonth() {
		return birthMonth;
	}

	public int getBirthDate() {
		return birthDate;
	}

	public boolean isStaff() {
		return isStaff;
	}

	public void setStaff(boolean isStaff) {
		this.isStaff = isStaff;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public void setEmailAccount(String emailAccount) {
		this.emailAccount = emailAccount;
	}

	public void setEmailDomain(String emailDomain) {
		this.emailDomain = emailDomain;
	}

	public void setTel1(String tel1) {
		this.tel1 = tel1;
	}

	public void setTel2(String tel2) {
		this.tel2 = tel2;
	}

	public void setTel3(String tel3) {
		this.tel3 = tel3;
	}
	
	
	public boolean isAgreeEssen() {
		return isAgreeEssen;
	}
	
	public boolean isAgreeSelec() {
		return isAgreeSelec;
	}
	
}



