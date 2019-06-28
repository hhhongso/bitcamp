package kr.co.bit;
/*
 * ���ú���(��������) / ��Ӻ���(�θ�Ŭ����) / �������(�ڱ��ڽ��� Ŭ����) �켱���� Ȯ���ϱ�
 */

	class Staff2 {
		protected String name; 
		
		public Staff2 () {
			name = "1";
		}
	}
	
	class Sales2 extends Staff2 {
		protected String name; 
		public Sales2() {
			name = "2";
		}
		
		public String displayInfoLocal() { // ���ú��� VS ��� VS ������� => ������ �켱����.
			String name = "3";
			return name;
		}
		
		public String displayInfoThis() { 
			String name =  "4";
			return this.name;			// this.(�ڱ��ڽ��� Ŭ���� �ȿ� �ִ� name) ��, 2
		}
		
		public String displayInfoSuper() {
			String name = "5";
			return super.name;			// super.(�θ�Ŭ������ name) ��, 1
		}
	}
	
	
	
public class SuperVarTest {
	public static void main(String[] args) {
		Sales2 sales2 = new Sales2();
		System.out.println(sales2.displayInfoLocal());
		System.out.println(sales2.displayInfoThis());
		System.out.println(sales2.displayInfoSuper());
		

	}

}
