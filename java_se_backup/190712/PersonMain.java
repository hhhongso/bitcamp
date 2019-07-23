//����ȭ �۾�================
class Person {
	private String name;
	private int age;

	public void setName(String n) { //setter: �Ķ���� ���� ������, ����Ÿ���� ����
		name = n;
	}
	
	public void setAge(int a) {
		age = a;
	}

	public void setData(String n, int a) { // overload
		name = n; 
		age = a; 
	}

	public void setData(){} // overload
	
	public String getName(){ //getter: �Ķ���� ���� ����, ����Ÿ�Ը� ���� 
		return name;
	}

	public int getAge(){
		return age;
	}

	Person(){} //new > ��ü ���� ��, �����ڰ� ������ �ڵ����� ������. ** �����ڴ� ���� Ÿ���� ����. **
}

//=========================>> ������ ��, Person.class, PersonMain.class �� ���� ����. 
public class PersonMain {
	public static void main(String[] args) {
		Person aa; 
		aa = new Person();
		System.out.println("��ü aa = " + aa); //��ü�� �����ּ�
		System.out.println("��ü aa = " + aa.toString()); //��� �ڵ�� ��� .toString�� �����Ǿ� �ִ� ��.
		System.out.println("��ü aa = " + aa.hashCode()); //�����ּҸ� 10������ �����ִ� �Լ�.
		
		//ȣ��
		aa.setName("ȫ�浿");
		System.out.println("�̸�: " + aa.getName());

		aa.setAge(25);
		System.out.println("����: " + aa.getAge());

		System.out.println();		// -----------------------------------------���ο� ��ü ���� -----------------------------
		Person bb = new Person();
		System.out.println("��ü bb = " + bb);
		System.out.println("��ü bb = " + bb.hashCode());
		
		bb.setName("�ڳ�");
		System.out.println("�̸�: " + bb.getName());

		bb.setAge(10);
		System.out.println("����: " + bb.getAge());

		System.out.println();
		Person cc = new Person();
		cc.setData("��ġ", 30);
		System.out.println("��ü cc = " + cc.hashCode());
		System.out.println("�̸�: " + cc.getName());
		System.out.println("����: " + cc.getAge());

		System.out.println();
		Person dd = new Person();
		dd.setData();
		System.out.println("��ü dd = " + dd.hashCode());
		System.out.println("�̸�: " + dd.getName());
		System.out.println("����: " + dd.getAge());

		System.out.println();
		aa = cc; 
		System.out.println("��ü aa = " + aa.hashCode());


	}
}

/*
int aa; ������ ����
int[] aa; ������ �迭 
double aa; �Ǽ��� ����
Person aa; ��ü
Person[] ar; ��ü �迭
*/