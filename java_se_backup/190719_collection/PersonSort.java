import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class PersonSort {
	public static void main(String[] args) {
		String[] ar = {"orange", "apple", "banana", "pear", "peach", "applemango"};
		Arrays.sort(ar); //�迭�� ������ �� 
		//String class�� implements class�� Comparable�� ������ �ֱ� ������ ���� 

		for(String data : ar) {
			System.out.print(data + "\t");
		}
		System.out.println();

		PersonDTO aa = new PersonDTO("�ڳ�", 13);
		PersonDTO bb = new PersonDTO("��ġ", 40);
		PersonDTO cc = new PersonDTO("�浿", 37);
		//PersonDTO���� Comparable�� ������ ���� ���� >> ���� �ʿ�.

		ArrayList<PersonDTO> list = new ArrayList<PersonDTO>();
		list.add(aa);
		list.add(bb);
		list.add(cc);

		Collections.sort(list); // �迭�� �ƴ� ���� ������ �� 
	
	//for���� ������ ������ �ּҰ����� �����µ�, [~~����~~ �� �� �ּҰ��� �ȴ� ?]
		System.out.println("���̷� ��������: " + list);

		System.out.println();
		
		for(PersonDTO dto : list) {
			System.out.println("���̷� ��������: " + dto);
		}
		System.out.println();

//���� ���� ������ �ٲٰ� ���� ��: Comparator �������̽�======================================
		Comparator<PersonDTO> com = new Comparator<PersonDTO>(){
			@Override
			public int compare(PersonDTO p1, PersonDTO p2){
				//��������
			//	return p1.getName().compareTo(p2.getName());
				//���ڿ��� >< ���� �ٷ� �� �Ұ�. ��ü������ ������ �ִ� Comparable ���� ��.
				//compareTo() �� �˾Ƽ� -1 0 1 ���� ��������, �� ���� ���� 

				//��������
				return p2.getName().compareTo(p1.getName());
			//	return p1.getName().compareTo(p2.getName()) * -1;

			}
		};
		Collections.sort(list, com); 
		System.out.println("�̸����� ��������: " + list);
		
		System.out.println();

		for(PersonDTO dto : list) {
			System.out.println("�̸����� ��������: " + dto);
		}

		
	}

}
