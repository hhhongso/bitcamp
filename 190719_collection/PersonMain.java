import java.util.ArrayList;

class PersonMain {

	public ArrayList<PersonDTO> init(){
		PersonDTO aa = new PersonDTO("�ڳ�", 13);
		PersonDTO bb = new PersonDTO("��ġ", 20);
		PersonDTO cc = new PersonDTO("�浿", 37);

		//ArrayList�� �����Ͱ� �ִ� �� �޸𸮰� �Ҹ���� �ʴ´�.
		ArrayList<PersonDTO> list = new ArrayList<PersonDTO>();
		list.add(aa);
		list.add(bb);
		list.add(cc);
		
		return list; // �������־�� main���� �� �� ����. ������ 1���� ������ arrayList�� ����.
					//���Ͻÿ��� arr�� �ּҰ��� ������ 
	}

	public static void main(String[] args) {
		PersonMain pm = new PersonMain();
		ArrayList<PersonDTO> list = pm.init();
		// ���Ϲ��� �ּҰ��� �ٽ� arrayList �� �־�� �־�� ���� ����. 
		
		for(int i = 0; i < list.size(); i++){
			System.out.println("�̸�: " + list.get(i).getName() + "	����: " + list.get(i).getAge());
										//list.get(i) >> i��° list�� �ּҰ��� ������. 
		}
		
		System.out.println();

		for(PersonDTO dto : list){
			System.out.println("�̸�: " + dto.getName() + "	����: " + dto.getAge());
		}

		System.out.println();

		for(PersonDTO dto : list){
			System.out.println(dto); // .toString()		
		}

	}
}
