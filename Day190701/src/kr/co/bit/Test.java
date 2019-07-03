package kr.co.bit;
/*
 * 공백 / null 값 예외처리하기 
 */
public class Test {
	private String name; 
	public Test() {
		name = "";
	}
	public static void main(String[] args) {
		Test test = new Test();
		try {
			if(test.name == null || test.name.equals("")) {
				System.out.println("공백");
			}
			
		} catch (Exception e){
			System.out.println("이름은 null"); 
			
		}
		
		
		

	}

}
