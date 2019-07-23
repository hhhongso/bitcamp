class AbstractTest {
	private String name; 

	public abstract void setName(String name);

	public String getName(){
		return name; 
	}

}

/*
추상 메소드가 있는 클래스는 반드시 추상 클래스 이어야 한다. 
	**추상클래스 안에
추상메소드 반드시 있어야
추상클래스 있을수도 없을수도

*/