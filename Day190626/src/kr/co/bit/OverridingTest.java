package kr.co.bit;

public class OverridingTest {

	public static void main(String[] args) {
		Employee employee = new Employee();
		Person person = employee;  // ���
		
		
		System.out.println("������:" + employee.x);
		System.out.println("���:" + person.x);
		
		employee.sleep();
		person.sleep(); 
			// ���� ��ҵǾ� �ڽ��� ���� ������� ���ϰ�, �θ� ���� ����ϴ� ��������, 
			// [����������] �������̵� �� ���� ������, �ڽ��� �Լ�/������ �켱����.
			// ===> �θ��� ���� ���� �ϰ� �ʹٸ� ? �ڽ�Ŭ�������� super. �� ����´�. 
		
		/* ���α׷� ���� ��������, 
		 * ���� ����� �״�� �����ϸ鼭, ���ο� ������Ʈ�� �߰��� �� [�������̵�]�� ����Ѵ�.
		 * [���� �ڵ带 ����]				[����Ͽ� �߰�] 
		 */
		
		person.setName("��"); 
			// �������̵� �Ǿ� ���� ���� �Լ�/������ ���Ͽ���, �ڽ��� ���� ������� ���ϱ� ������, �θ��� ���� ������ 
		
	}

}
