package kr.co.bit;

public class GM extends Car { // ���
	protected int cnt; 
	
//	public Engine engine; ==> Car�� ��ӹ޾����Ƿ� Car�ȿ� ���ԵǾ��ִ� engine, door �� �߰������� ���Խ����� �ʿ� ����. 
//	public Door door[];
	
	public GM() {
		cnt = 1;
		
		engine.kind = "���";
		for (int i = 0; i < door.length; i++) {
			door[i].window = cnt++;			
		}
	}
	
	public static void main(String[] args) {
		GM gm = new GM();
		gm.engine.kind = "GM���";
		System.out.println(gm.engine.kind);
		for(int i = 0; i < gm.door.length; i++) {
			System.out.println(gm.door[i].window);
		}
	}
}
