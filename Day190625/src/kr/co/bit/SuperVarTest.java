package kr.co.bit;
/*
 * 로컬변수(지역변수) / 상속변수(부모클래스) / 멤버변수(자기자신의 클래스) 우선순위 확인하기
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
		
		public String displayInfoLocal() { // 로컬변수 VS 상속 VS 멤버변수 => 로컬이 우선순위.
			String name = "3";
			return name;
		}
		
		public String displayInfoThis() { 
			String name =  "4";
			return this.name;			// this.(자기자신의 클래스 안에 있는 name) 즉, 2
		}
		
		public String displayInfoSuper() {
			String name = "5";
			return super.name;			// super.(부모클래스의 name) 즉, 1
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
