package kr.co.bit;

public class Test1 {

	private String name; 
	public Test1() {
		name = "";
	}
	
	
	public void method() throws NullPointerException, SpaceException { // 두개 이상의 예외클래스를 던진 때에는 if 조건을 걸어주어야 
		if(name == null) {
			throw new NullPointerException(); // throw 로 강제로 발생시킴
		}
		if(name.equals("")) { //공백일 때는 .equals("")
			throw new SpaceException("공백 입력 시 에러"); //공백에 대한 예외처리는 따로 없으므로 직접 만들어 주어야 함[사용자 정의 예외]
		}
	}
	public static void main(String[] args) {
		Test1 test1 = new Test1();
		try {
			test1.method();
		} catch (NullPointerException e1) {
			e1.printStackTrace();
		} catch (SpaceException e2) {
			e2.printStackTrace();
		}

	}

}
