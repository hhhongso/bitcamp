class AbstractMain extends AbstractTest {
	@Override
	public void setName(String name){
		this.name = name; 
	}

	public static void main(String[] args) {
					//추상클래스는 new생성이 불가하기 때문에, 부모 클래스로 new 하여 자식 클래스를 참조한다. [Upcasting]
		AbstractTest at = new AbstractMain(); 
		at.setName("김김김");
		System.out.println("이름: " + at.getName());
	}
}

/* 추상클래스는 new 생성 불가
- sub class 를 이용하여 new 생성한다. 반드시 sub class는 추상 메소드를 오버라이드[재구현]하여야 한다. 
- 메소드를 이용하여 new 생성한다.
*/