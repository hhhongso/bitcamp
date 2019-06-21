package kr.co.bit;

public class Member {
	private String name; 
	private int height; 
	private int weight; 
	private String nation;

	// source > generate constructor using field: �Ű������� �ִ� ������ �Լ� �ڵ��ϼ�
	public Member(String name, int height, int weight, String nation) {
		super();
		this.name = name;
		this.height = height;
		this.weight = weight;
		this.nation = nation;
	}

	// source > generate constructor from superclass: �Ű������� ���� ������ �Լ� �ڵ��ϼ�
	public Member() {
		super();
		// TODO Auto-generated constructor stub
	}

	// get�Լ�: �ϳ��� ��������� �ϳ��� ������
	// set�Լ�: �ϳ��� �Է���
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

	// toString: ��� ��������� �Ѳ����� ������ ( get�Լ����� ������)
	@Override
	public String toString() {
		return "Member [name=" + name + ", height=" + height + ", weight=" + weight + ", nation=" + nation + "]";
	}
	
	
	
}
