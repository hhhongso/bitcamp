package kr.co.bit.obj1;
// pptx page 113
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class HaksaProject {

	public static void main(String[] args) {
		ArrayList<HashMap<String, String>> haksaList = new ArrayList<HashMap<String, String>>(); 
		// 배열. haksaList라는 배열을 선언 
		// ArrayList에 hashMap 을 탑재 
		
		Scanner input = new Scanner(System.in);
		while(true) {
			System.out.println("=====메뉴 선택=====");
			System.out.println("1. 등록"); //ctrl +alt + 아래방향키 = 복사
			System.out.println("2. 찾기");
			System.out.println("3. 삭제");
			System.out.println("4. 전체 출력");
			System.out.println("----------------");
			System.out.println("0. 종료");
			System.out.println("----------------");
			System.out.println("번호를 선택해 주세요.. ");
			int protocol = input.nextInt();
			
			if(protocol == 1) { // 등록
								
				System.out.println("=====메뉴 선택====="); 
				System.out.println("1. 학생");
				System.out.println("2. 교수");
				System.out.println("3. 관리자");
				System.out.println("4. 이전메뉴");
				System.out.println("번호를 선택해 주세요.. ");
				protocol = input.nextInt();
				
				if(protocol == 1) { //학생
					HashMap<String, String> haksaHash = new HashMap<String, String>(); //메모리컨트롤 (기억시키기)
					//2차원배열(행, 렬) (key)String, (값;value)String 임
					// String, Integer 도 가능. 단, 이경우 변수 int는 클래스 Integer로 선언해야 
					
					/* HashMap 클래스 ?
					 * 키와 값을 묶어 하나의 entry 로 저장, 컬렉션 클래스를 구현한다 . 
					 * key 는 2개가 될 수 없으며, value는 중복 가능. 
					 * 1개의 hashMap 의 배열이 끝난 뒤에는 새로이 메모리 공간을 설정하여야.
					 * hashing (검색방법)을 사용하여 많은 양의 데이터를 검색 할 수 있다. 
					 */
					
					System.out.print("나이: ");
					String age = input.next();
					System.out.print("이름: ");
					String name = input.next();
					System.out.print("학번: ");
					String hakbun = input.next();
					
					              //key  value
					haksaHash.put("age", age);
					haksaHash.put("name", name); // key 값이 age가 될 수는 없다(중복 불가)
					haksaHash.put("hakbun", hakbun);
					haksaList.add(haksaHash);
					System.out.println("학생이 등록 되었습니다. ");
					
				
				} else if (protocol == 2) { //교수 
					HashMap<String, String> haksaHash = new HashMap<String, String>();
					System.out.print("나이: ");
					String age = input.next();
					System.out.print("이름: ");
					String name = input.next();
					System.out.print("과목: ");
					String subject = input.next();
					
					haksaHash.put("age", age);
					haksaHash.put("name", name);
					haksaHash.put("subject", subject);
					haksaList.add(haksaHash);
					System.out.println("교수가 등록 되었습니다. ");
					
				} else if (protocol == 3) { //관리자 
					HashMap<String, String> haksaHash = new HashMap<String, String>();
					System.out.print("나이: ");
					String age = input.next();
					System.out.print("이름: ");
					String name = input.next();
					System.out.print("부서: ");
					String part = input.next();
					
					haksaHash.put("age", age);
					haksaHash.put("name", name);
					haksaHash.put("part", part);
					haksaList.add(haksaHash);
					System.out.println("관리자가 등록 되었습니다. ");
					
				} else { //이전메뉴 
					System.out.println("이전메뉴로 돌아갑니다. ");
					continue;                   // '//등록' 반복문으로 올라간다. 
				}
				
			} else if(protocol == 2) { //찾기
				
			} else if (protocol == 3) { //삭제
				System.out.println("삭제");
			} else if (protocol == 4) { //전체 출력
				System.out.println("전체 출력"); //배열: n개에 해당되는 갯수가 선언되어 있음 => 반복할 횟수가 정해져 있음. =. for
				System.out.println("나이 \t 이름 \t 학번 \t 과목 \t 부서 \n");
				for(int i = 0; i < haksaList.size(); i++) { 	// length: 공간의 길이 / size: 공간의 크기(몇 개의 공간이 있는지)
					HashMap<String, String> haksaHash = haksaList.get(i);
					System.out.print(haksaHash.get("age")+ "\t");
					System.out.print(haksaHash.get("name")+ "\t");
					System.out.print(haksaHash.get("hakbun")+ "\t"); // 학생 전체출력 
					System.out.print(haksaHash.get("subject")+ "\t"); // 교수 
					System.out.print(haksaHash.get("part")+ "\t \n"); // 관리자
				}
				
				
			} else { //종료
				System.out.println("종료합니다. ");
				System.exit(0); // 시스템 종료. if- break 와 같은 역할 
			}
			
		} // while(true){}

	}

}
