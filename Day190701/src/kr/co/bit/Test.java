package kr.co.bit;
/*
 * ���� / null �� ����ó���ϱ� 
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
				System.out.println("����");
			}
			
		} catch (Exception e){
			System.out.println("�̸��� null"); 
			
		}
		
		
		

	}

}
