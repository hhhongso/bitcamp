package kr.co.bit;

public class PrivateVar {
	private int var1; //비공개 접근지정자
	
	public PrivateVar() { // 함수를 통해 접근 가능하다. 
		var1 = 10;		
	}
	public static void main(String[] args) { //같은 클래스 안에서 는 private을 가져올 수 있지만 
		PrivateVar pv = new PrivateVar();
		pv.var1 = 100;
	
	}
}
