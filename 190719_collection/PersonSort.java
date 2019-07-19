import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class PersonSort {
	public static void main(String[] args) {
		String[] ar = {"orange", "apple", "banana", "pear", "peach", "applemango"};
		Arrays.sort(ar); //배열을 정렬할 때 
		//String class가 implements class로 Comparable을 가지고 있기 때문에 가능 

		for(String data : ar) {
			System.out.print(data + "\t");
		}
		System.out.println();

		PersonDTO aa = new PersonDTO("코난", 13);
		PersonDTO bb = new PersonDTO("또치", 40);
		PersonDTO cc = new PersonDTO("길동", 37);
		//PersonDTO에는 Comparable을 가지고 있지 않음 >> 구현 필요.

		ArrayList<PersonDTO> list = new ArrayList<PersonDTO>();
		list.add(aa);
		list.add(bb);
		list.add(cc);

		Collections.sort(list); // 배열이 아닌 것을 정렬할 때 
	
	//for문을 돌리지 않으면 주소값으로 나오는데, [~~내용~~ 이 곧 주소값이 된다 ?]
		System.out.println("나이로 오름차순: " + list);

		System.out.println();
		
		for(PersonDTO dto : list) {
			System.out.println("나이로 오름차순: " + dto);
		}
		System.out.println();

//기존 정렬 기준을 바꾸고 싶을 때: Comparator 인터페이스======================================
		Comparator<PersonDTO> com = new Comparator<PersonDTO>(){
			@Override
			public int compare(PersonDTO p1, PersonDTO p2){
				//오름차순
			//	return p1.getName().compareTo(p2.getName());
				//문자열은 >< 으로 바로 비교 불가. 자체적으로 가지고 있는 Comparable 으로 비교.
				//compareTo() 로 알아서 -1 0 1 값을 가져오면, 그 값을 리턴 

				//내림차순
				return p2.getName().compareTo(p1.getName());
			//	return p1.getName().compareTo(p2.getName()) * -1;

			}
		};
		Collections.sort(list, com); 
		System.out.println("이름으로 오름차순: " + list);
		
		System.out.println();

		for(PersonDTO dto : list) {
			System.out.println("이름으로 오름차순: " + dto);
		}

		
	}

}
