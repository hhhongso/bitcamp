package kr.co.bit;
/*
 * 파라미터 다형성 테스트 
 */

class PersonInfo {				// Person person = person / president / employee / student 이 대입됨 [축소] > person (부모객체) 의 것을 사용하게 됨
	public void showSleepingType(Person person) {
		person.showSleepStyle();
	}
}
public class ParameterPolyTest {

	public static void main(String[] args) {
		PersonInfo pf = new PersonInfo();
		Person person = new Person();
		Employee employee = new Employee();
		Student student = new Student();
		President president = new President();
		
		pf.showSleepingType(person);
		pf.showSleepingType(employee); //@Override로 부모가 아닌, 자식의 함수가 우선순위로 된다. 
		pf.showSleepingType(student);
		pf.showSleepingType(president);
	}

}
