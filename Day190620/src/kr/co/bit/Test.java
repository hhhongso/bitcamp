package kr.co.bit;

public class Test {
	public void printInfo (String...arg) { // string ...>> ... 으로 배열 타입을 선언. string[]배열방에 arg을 변수로 선언을 하고. 
		if (arg.length != 0) {
			for(int i = 0; i < arg.length; i++) {
			System.out.println(arg[i]);
			}
		} else {			
			System.out.println("??");
		}
	}

	public static void main(String[] args) {
		Test test = new Test();
		test.printInfo(); 
		test.printInfo("가나다"); // i = 0
		test.printInfo("ABC, XYZ"); // i = 0, 1
		test.printInfo("1,2,3,4,5,6,7,8,9,10");
	}
}
