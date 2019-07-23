class AbstractMain {
	public static void main(String[] args)	{
		AbstractTest at = new AbstractTest(){ // 익명 inner class $1(이름이 없으니 번호로 표기)
			@Override
			public void setName(String name){
				this.name = name; 
			}
		};

		InterA ia = new InterA(){ // 익명 inner class $2
			@Override
			public void aa(){}
			@Override
			public void bb(){}		
		};

		AbstractExam ae = new AbstractExam(){}; // 익명 inner class $3
	}
}


/*
추상클래스/인터페이스를 new 할 수 없으니
1. 메소드 사용
2. sub class 사용 (반드시 추상메소드를 오버라이드 해 주어야 함)
3. 익명 클래스 사용: 자식 클래스가 아닐지라도 반드시 추상메소드를 오버라이드 해 준다면 객체 생성 할 수 있음. 

추상메소드를 구현할 수 있는 body를 가졌다면 == (클래스의 이름이 없어도) 클래스.
*/