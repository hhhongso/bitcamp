package kr.co.bit;

public class Test {
	public void printInfo (String...arg) { // string ...>> ... ���� �迭 Ÿ���� ����. string[]�迭�濡 arg�� ������ ������ �ϰ�. 
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
		test.printInfo("������"); // i = 0
		test.printInfo("ABC, XYZ"); // i = 0, 1
		test.printInfo("1,2,3,4,5,6,7,8,9,10");
	}
}
