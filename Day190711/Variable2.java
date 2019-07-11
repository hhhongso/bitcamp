class Variable2 { //클래스 :==> heap 영역
	int a; //필드 -> 초기화 이미 되어있음. (0 / null) ==> heap 영역
	static int b; // static: 한 번 만들면 객체 생성 없이도 바로 가져다 쓸 수 있음. 클래스 소속만 알고 있으면 된다. 
	String str; 

	public static void main(String[] args) { //static 함수: 실행과 동시에 메모리에 잡히게 됨.
		int a = 10; // 지역변수(로컬변수), Garbage(쓰레기값) -> 초기화 필요 ==> static 영역
		System.out.println("지역변수 a=" + a);
		System.out.println("필드 a=" + new Variable2().a); //new 연산자를 통해 객체 생성 (메뉴판을 음식으로 만드는 과정)
		System.out.println("필드 b=" + b);
		System.out.println("필드 str=" + new Variable2().str);

	}
}
