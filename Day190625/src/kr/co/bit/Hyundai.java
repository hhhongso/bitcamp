package kr.co.bit;

public class Hyundai extends Car { // 상속
	public int cnt;
	
	public Hyundai() {
		cnt = 1; //초기화 
		engine.kind = "현대엔진"; // engine 은 Car에 포함하고 있으니까, 상속와 달리 engine 클래스 그대로 가져와서 사용할 수 있다.
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
