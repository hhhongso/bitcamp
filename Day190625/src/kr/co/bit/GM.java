package kr.co.bit;

public class GM extends Car { // 상속
	protected int cnt; 
	
//	public Engine engine; ==> Car를 상속받았으므로 Car안에 포함되어있는 engine, door 는 추가적으로 포함시켜줄 필요 없다. 
//	public Door door[];
	
	public GM() {
		cnt = 1;
		
		engine.kind = "대우";
		for (int i = 0; i < door.length; i++) {
			door[i].window = cnt++;			
		}
	}
	
	public static void main(String[] args) {
		GM gm = new GM();
		gm.engine.kind = "GM대우";
		System.out.println(gm.engine.kind);
		for(int i = 0; i < gm.door.length; i++) {
			System.out.println(gm.door[i].window);
		}
	}
}
