package kr.co.bit;
/*
 * �Ķ���� ������ �׽�Ʈ 
 */

class PersonInfo {				// Person person = person / president / employee / student �� ���Ե� [���] > person (�θ�ü) �� ���� ����ϰ� ��
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
		pf.showSleepingType(employee); //@Override�� �θ� �ƴ�, �ڽ��� �Լ��� �켱������ �ȴ�. 
		pf.showSleepingType(student);
		pf.showSleepingType(president);
	}

}
