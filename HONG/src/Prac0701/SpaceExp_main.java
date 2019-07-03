package Prac0701;

public class SpaceExp_main {

	String name = "";
	
	public void spaceMethod() throws SpaceExp, NullPointerException {
		if (name.equals("")) {
			throw new SpaceExp("공백에러");
		}
		else {
			throw new NullPointerException();			
		}
	}
	public static void main(String[] args) {
		SpaceExp_main sp = new SpaceExp_main();
		try {
			sp.spaceMethod();
		} catch (NullPointerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SpaceExp e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
