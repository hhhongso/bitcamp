package kr.co.bit;

public class OverridingTest {

	public static void main(String[] args) {
		Employee employee = new Employee();
		Person person = employee;  // 축소
		
		
		System.out.println("직장인:" + employee.x);
		System.out.println("사람:" + person.x);
		
		employee.sleep();
		person.sleep(); 
			// 본래 축소되어 자식의 것은 사용하지 못하고, 부모 것을 사용하는 것이지만, 
			// [예외적으로] 오버라이드 된 것이 있으면, 자식의 함수/변수가 우선순위.
			// ===> 부모의 것을 재사용 하고 싶다면 ? 자식클래스에서 super. 로 끌어온다. 
		
		/* 프로그램 유지 보수에서, 
		 * 기존 기능을 그대로 유지하면서, 새로운 업데이트를 추가할 때 [오버라이드]를 사용한다.
		 * [기존 코드를 유지]				[상속하여 추가] 
		 */
		
		person.setName("김"); 
			// 오버라이드 되어 있지 않은 함수/변수에 대하여는, 자식의 것을 사용하지 못하기 때문에, 부모의 것을 가져옴 
		
	}

}
