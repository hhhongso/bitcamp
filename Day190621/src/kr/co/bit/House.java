package kr.co.bit;

public class House {
	public int price; 
	public int size; 
	public String dong; 
	public String kind; 
	
	@Override
	public String toString() {
		return "House [����=" + price + ", ���=" + size + ", ��=" + dong + ", ����=" + kind + "]";
	}


	public House() { //������ �Լ� �ȿ��� 
		this(100, 32, "���Ǳ�", "����Ʈ"); // ������ �Լ��� �� �ҷ��´�. 
	}
	
	/* ��� this() �Լ��� ������� �ʴ´ٸ�, �Ʒ��� ���� this.���� = �� �ϳ��� �� �ʱ�ȭ�� �ʱ�ȭ ������� �ϴ� ���ŷο�. 
	 * public House () {
	 * this.price = 100; 
	 * this.size = 32;
	 * this.dong = "���Ǳ�" ;
	 * this.kind = "����Ʈ";
	 */
	
	public House(int price) { // house2�� �����
		this(price, 32, "���Ǳ�", "����");
			//�ʱ�ȭ	
	}
	
	public House(int price, int size) {
		this(price, size, "���Ǳ�", "����");
			//�ʱ�ȭ, �ʱ�ȭ	
	}
	
	public House(int price, int size, String dong) {
		this(price, size, dong, "����Ʈ");
	}
	
	public House(int price, int size, String dong, String kind) { // house Ŭ������ �������Լ�
		this.price = price; 
		this.size = size; 
		this.dong = dong; 
		this.kind = kind; 
	}


	public static void main(String[] args) {
		House house1 = new House(); // public House()�ȿ� �Ķ���ʹ� ������, this()�� �������Լ��� ���������� { this(100.32.���Ǳ�.����Ʈ) } �� �ҷ���
		System.out.println(house1.toString());
		
		House house2 = new House(1000);
		System.out.println(house2.toString());
		
		House house3 = new House(10000, 55);
		System.out.println(house3.toString());
		
		House house4 = new House(10, 50, "���ʵ�");
		System.out.println(house4.toString());
		
		House house5 = new House(100, 50, "���ʵ�", "����");  // this �Ⱦ��� house �������Լ� �״�� ������
		System.out.println(house5.toString());
	}
}
