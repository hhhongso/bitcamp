package kr.co.bit;

public class Card {
	// �ν��Ͻ� ���� : ��ȭ�ϴ� ��
	String kind;  // ����
	int number;  // ����  
	
	public Card() { // ������ �Լ��� �ʱ�ȭ (�����Ϸ��� �ڵ����� ����)
		kind = null;
		number = 0; 
	}
	
	// Ŭ���� ���� : ��ȭ���� �ʴ� �� => �޸� ���� �ϳ��� ����� 
	public static int width; // ����
	public static int height; // ���� 
	
	static { // static ������ ����� �ʱ�ȭ (�����Ϸ��� �ڵ����� ����; 100 -> 0;) 
		width = 100;
		height = 250;
	}

	public void set () { //�Լ� �����
		int lv = 0; // ���� ���� ����  
		System.out.println(lv);
	}
	
	//main ������ �ʿ� 
	public static void main(String[] args) {
		Card card1 = new Card(); // Card Ŭ���� - new �����ڷ� �ҷ��� �ν��Ͻ� ���� ��� 
		card1.kind = "spade";
		card1.number = 4; 
		System.out.println(card1.kind + "\t" + card1.number + "\t" + Card.height + "\t" + Card.width); // static ������ �ִ� ������ new ������ ���� CardŬ����.__ �� �ٷ� �ҷ��´�. 
		
		Card card2 = new Card();
		card2.kind = "heart"; // new �����ڷ� �ҷ��� ���ο� �ν��Ͻ� ����(��ȭ�ϴ� ����)�� ���� �� �ִ� .
		card2.number = 8; 
		System.out.println(card2.kind + "\t" + card2.number + "\t" + Card.height + "\t" + Card.width); // static ������ �ִ� ������ new ������ ���� CardŬ����.__ �� �ٷ� �ҷ��´�.
		
	}
}
