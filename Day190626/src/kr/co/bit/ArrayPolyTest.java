package kr.co.bit;

public class ArrayPolyTest {

	public static void main(String[] args) {
		Person[] pArray = new Person[3]; 	//[]는 배열공간을 만든다. ()는 공간 하나를 만든다.
		pArray[0] = new Employee();
		pArray[1] = new Student();
		pArray[2] = new President();
		
		for(int i = 0; i < pArray.length; i++) {
			pArray[i].showSleepStyle(); // 오버라이드 함수니까 
		}

	}

}
