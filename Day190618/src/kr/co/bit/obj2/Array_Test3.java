package kr.co.bit.obj2;
// ���ڿ� (�迭)�ʱ�ȭ = {} 
// �ʱⰪ�� {} �ȿ� �ִ´�. 

public class Array_Test3 {

	public static void main(String[] args) {
		 				//	0		1		2	  3		 4
		String[] cities = {"����", "�뱸", "��õ", "����", "õ��"};
		String[] nations = new String[] {"�̱�", "����", "�Ϻ�", "������"};
		/*new ������ �� ���ٸ� ?
		 * �޸� ������ �� �� ����(Stack)������ �۾��� �̷�� ����. 
		 * => new�� �̿��Ͽ� �޸� ������ �������� �и�, Heap(��������, �޸𸮰���)���� �� �迭�� ������ => ���� �а� ������ Ȱ��.  
		 */
		
		//�迭�� ���
		for(int i = 0; i < cities.length; i++) {
			System.out.println(cities[i]);
		}
		for(int i = 0; i < nations.length; i++) {
			System.out.println(nations[i]);
		}
	}

}
