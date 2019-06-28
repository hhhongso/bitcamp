package kr.co.bit;

public class ProtectedMain {

	public static void main(String[] args) {
		ProtectedVar pv = new ProtectedVar();
		pv.proVar = 100; // protected 접근제한자는 같은 패키지 내의 외부 클래스에서 접근하여 가져올 수 있다. (default == protected)

	}

}
