package kr.co.bit;

public class Test1Main {

	public static void main(String[] args) {
		Test1_new_static_instance test1 = new Test1_new_static_instance();
		while (true) {
			switch(test1.display()) {  // instance method 니까 new 연산자로 클래스를 불러온 뒤 사용할 수 있음 
			case 1: // return number = 1 이면 
				Test1_new_static_instance.inputRecord();  // static method니까 new 연산자 없이 그래도 클래스를 불러올 수 있음 
				break;
			case 2:
				Test1_new_static_instance.deleteRecord();
				break;
			case 3:
				Test1_new_static_instance.sortRecord();
				break;
			case 4:
				Test1_new_static_instance.exitRecord();
				break;
			}
		} // while 

	}

}
