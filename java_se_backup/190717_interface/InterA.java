interface InterA {
	public static final String NAME = "홍길동";	//상수 변수는 대문자 
	public int AGE = 25;
	public abstract void aa();
	public void bb();
	// interface에는 상수, 추상만 들어가기 때문에,  static final, abstract 생략 가능. 구현{}은 불가!
}