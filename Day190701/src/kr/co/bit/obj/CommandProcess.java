package kr.co.bit.obj;

public class CommandProcess {   
						//인터페이스를 파라미터변수
	public void process(Command command) {
		command.execute();
	}
	
	/*
	 * 메소드에 인터페이스를 파라미터로 전달이 가능하다.
	 * 이것의 의미는 , 메소드 안에 해당 인터페이스를 구현한 클래스 만이 파라미터로 올 수 있다는 것이다.
	 * 이는 인터페이스를 구현한 클래스들을 모두 사용할 수 있게 되고 , 특정 클래스들을 그룹화 하는 기능을 구현하게 된다.
	 */
	

}
