package kr.co.bit.obj;

class VarClass {
/*
 * ���� Ŭ�������� ������� x, y ��ü 
 * static > �������� 
 * 
 * final(������, ����, ����, ����)
 * ������ final�� ������ >> ���ȭ 
 * class�� final�� ������>> Ŭ���� ��ü�� ��ӺҰ�  
 * �޼ҵ忡 final�� ������>> Ŭ������ ����� �Ǿ��ִ��� �Լ��� ��ӺҰ� 
 *   
 * 
 * final ����� �빮�ڸ� �ַ����� ����Ѵ�. 
 * 
 */
	final int x; 
	static final int y;  // ������ (static)
	
	final double PI; // ���̰��� �ʱⰪ���� 
	static {
		y = 100; // ó�� ���� �����Ѵ�. (ó������ final�� ����, �ٸ� ������ ������� �ʴ´�. ) ==> ��� 
	}
	
	public VarClass(int x) {
		this.x = x; 
		PI = 3.141592; // ���� �����ϰ� ����(final). ������ ������ ����� �� ����. (���ڷ� ������ �ִ� ���ڻ���� ����)  
	}
}

public class FinalVar {

	public static void main(String[] args) {
		//VarClass.y = 5;
		
		VarClass vc1 = new VarClass(10); // ù��° ���Ե� ó�� ���� ���� ===> ���
		//vc1.y = 50; // ����� �Ǿ����� ���� �ٲ� �� ����. (������ ��� ���)
		//vc1.x = 100;
		
		VarClass vc2 = new VarClass(500);
		//vc2.y = 70;
		//vc2.x = 90;

		System.out.println(vc1.x + 5);
		System.out.println(vc2.x + vc2.y);
	}

}
