package Prac0702;

enum SchoolType {
	ELE, MID, HIGH, UNIV
}

class Student {
	SchoolType type;
	
	public Student(SchoolType type) {
		this.type = type;
	}
}

public class Enum {
public static void main(String[] args) {
	Student stu = new Student(SchoolType.ELE);
	System.out.println(stu.type);
	System.out.println(SchoolType.HIGH);
	System.out.println(stu.type);
}

}
