package Prac0701;

public class Test {

	public void exMethod() throws SpaceExp {
		throw new SpaceExp("dd");
	}
	
	public static void main(String[] args) {
		Test t1 = new Test();	
			try {
				t1.exMethod();
			} catch (SpaceExp e) {
				e.printStackTrace();
			}
	

	}

}
