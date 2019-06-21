package kr.co.bit;

public class Member {
	private String name; 
	private int height; 
	private int weight; 
	private String nation;

	// source > generate constructor using field: 매개변수가 있는 생성자 함수 자동완성
	public Member(String name, int height, int weight, String nation) {
		super();
		this.name = name;
		this.height = height;
		this.weight = weight;
		this.nation = nation;
	}

	// source > generate constructor from superclass: 매개변수가 없는 생성자 함수 자동완성
	public Member() {
		super();
		// TODO Auto-generated constructor stub
	}

	// get함수: 하나의 멤버변수를 하나씩 꺼내옴
	// set함수: 하나씩 입력함
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public String getNation() {
		return nation;
	}

	public void setNation(String nation) {
		this.nation = nation;
	}

	// toString: 모든 멤버변수를 한꺼번에 꺼내옴 ( get함수와의 차이점)
	@Override
	public String toString() {
		return "Member [name=" + name + ", height=" + height + ", weight=" + weight + ", nation=" + nation + "]";
	}
	
	
	
}
