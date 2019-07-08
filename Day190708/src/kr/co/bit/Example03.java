package kr.co.bit;
			//element에 실제로 "값"을 넣을 수 있도록 함 
@MyAnnotation1("aaa")
public class Example03 {
	int a; 
	int b; 
	
	@MyAnnotation1(eleName1 = "bbb", eleName2 = 4, value = "value값")
	public Example03(int a, int b) {
		super();
		this.a = a;
		this.b = b;
	}

	@MyAnnotation1("cccc")
	public void method1() {
		
	}
	
	public void method2(int a, int b) {
		
	}
	
	public static void main(String[] args) {
	
}
}
