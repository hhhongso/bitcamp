package kr.co.bit;

public class Student extends Person {
	protected String schoolKind;
	protected String grade; 
	
	public Student() {
		this(null, null);
	}
	
	public Student(String schoolKind, String grade) {
		this.schoolKind = schoolKind; 
		this.grade = grade;
	}

	public String getSchoolKind() {
		return schoolKind;
	}

	public void setSchoolKind(String schoolKind) {
		this.schoolKind = schoolKind;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	@Override
	public String toString() {
		return "Student [schoolKind=" + schoolKind + ", grade=" + grade + "]";
	}

	@Override
	public void showSleepStyle() {
		System.out.println("�л����� ��Ģ���� ������ �Ѵ�. ");
	}
	
	public void study() {
		System.out.println("�л��� ���θ� �Ѵ�. ");
	}
	
	
}
