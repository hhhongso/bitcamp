import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;


class CollectionTest{

	@SuppressWarnings("unchecked")
	public static void main(String[] args){
		Collection coll = new ArrayList(); //�������̽� implementing class  
//		ArrayList list = new ArrayList(); �Ϲ��� 

		//Collection�� �⺻������ object >> int, double, string ��� ���� 
		coll.add("ȣ��");
		coll.add("����");
		coll.add("ȣ��"); // �ߺ� ���, ���� ���� 
		coll.add(25);
		coll.add(43.8);
		coll.add("�⸰");
		coll.add("�ڳ���");

		//iterator �� �������̽� ! >> �Լ��� ���� ���� 
		Iterator it = coll.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}

	//	it.hasNext();	������ ���� �׸��� ������ true, �ƴϸ� false
	//	it.next();		�׸��� ������ �������� �̵�.

/* Warning!
Note: CollectionTest.java uses unchecked or unsafe operations.
Note: Recompile with -Xlint:unchecked for details.

==> �ذ���
1. ���� : annotation @SuppressWarnings("unchecked")
2. �����ذ�: Generic
*/


	}
}
