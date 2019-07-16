abstract class AbstractTest {
	protected String name; 

	public abstract void setName(String name);

	public String getName(){
		return name; 
	}
}

/*
추상 클래스는 반드시 추상 메소드를 가져야 한다. 
*** 추상 클래스 안에 
추상 클래스는 반드시 필요 
추상 클래스는 있을수도 없을수도 
*/