import java.util.ArrayList;

class PersonMain {

	public ArrayList<PersonDTO> init(){
		PersonDTO aa = new PersonDTO("코난", 13);
		PersonDTO bb = new PersonDTO("또치", 20);
		PersonDTO cc = new PersonDTO("길동", 37);

		//ArrayList는 데이터가 있는 한 메모리가 소멸되지 않는다.
		ArrayList<PersonDTO> list = new ArrayList<PersonDTO>();
		list.add(aa);
		list.add(bb);
		list.add(cc);
		
		return list; // 리턴해주어야 main에서 볼 수 있음. 리턴은 1개만 받으니 arrayList로 잡음.
					//리턴시에는 arr의 주소값을 가져옴 
	}

	public static void main(String[] args) {
		PersonMain pm = new PersonMain();
		ArrayList<PersonDTO> list = pm.init();
		// 리턴받은 주소값을 다시 arrayList 에 넣어야 넣어둔 값이 들어옴. 
		
		for(int i = 0; i < list.size(); i++){
			System.out.println("이름: " + list.get(i).getName() + "	나이: " + list.get(i).getAge());
										//list.get(i) >> i번째 list의 주소값을 가져옴. 
		}
		
		System.out.println();

		for(PersonDTO dto : list){
			System.out.println("이름: " + dto.getName() + "	나이: " + dto.getAge());
		}

		System.out.println();

		for(PersonDTO dto : list){
			System.out.println(dto); // .toString()		
		}

	}
}
