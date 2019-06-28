package kr.co.bit.obj;

import kr.co.bit.ProtectedVar; //다른 패키지에 있는 protectedVar 클래스를 수입해옴 


public class ProtectedMain{

	public static void main(String[] args) {
		ProtectedVar pv = new ProtectedVar();
		//pv.proVar = 1000; 
		// 다른패키지 안에 있다면 protected 접근제한자로 가져올 수 없다.
		//단, 패키지가 다르더라도 상속받은 후 상속받은 클래스 내에서는 사용이 가능한다. 

	}

}
