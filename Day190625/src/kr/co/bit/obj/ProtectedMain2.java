package kr.co.bit.obj;

import kr.co.bit.ProtectedVar;

class ProtectedMain2 extends ProtectedVar{
	
	public ProtectedMain2() {
		proVar = 10000;
	}

	public static void main(String[] args) {
		ProtectedMain2 pm = new ProtectedMain2();
		pm.proVar = 800;

		System.out.println(pm.proVar);
	}

}
