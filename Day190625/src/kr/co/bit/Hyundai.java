package kr.co.bit;

public class Hyundai extends Car { // ���
	public int cnt;
	
	public Hyundai() {
		cnt = 1; //�ʱ�ȭ 
		engine.kind = "���뿣��"; // engine �� Car�� �����ϰ� �����ϱ�, ��ӿ� �޸� engine Ŭ���� �״�� �����ͼ� ����� �� �ִ�.
		for (int i = 0; i < door.length; i++) {
			door[i].window = cnt++;
		}
	}
	
	public static void main(String[] args) {
		Hyundai hy = new Hyundai();
		System.out.println(hy.engine.kind); 
		
		for(int i = 0; i < hy.door.length; i++) {
			System.out.println(hy.door[i].window);
		}
	}
}
