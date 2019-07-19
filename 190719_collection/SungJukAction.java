import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Scanner;
				
class SungJukAction {
	//field
	private ArrayList<SungJukDTO> list= new ArrayList<SungJukDTO>(); 
	private SungJukDTO sdto;
	private int choice;	
	private Scanner scan = new Scanner(System.in);

	public SungJukAction(){		
	}

	public void menu(){
		while(true){
			Scanner scan = new Scanner(System.in);
			System.out.println("*****************");
			System.out.println("1. 입력");
			System.out.println("2. 출력");
			System.out.println("3. 검색");
			System.out.println("4. 삭제");
			System.out.println("5. 정렬");
			System.out.println("6. 끝");
			System.out.println("*****************");
			System.out.print("원하는 옵션 입력: ");
			choice = scan.nextInt();

			if(choice == 1)				insertArticle();
			else if (choice == 2)		printArticle();
			else if (choice == 3)		searchArticle();
			else if (choice == 4)		deleteArticle();
			else if (choice == 5)		sortArticle();
			else if (choice == 6)		break;
		}//while
		
	}

/*
	public void insertArticle() {	
		Scanner scan = new Scanner(System.in);
		System.out.print("번호 입력: ");
		num = scan.nextInt();
		System.out.print("이름 입력: ");
		name = scan.next();
		System.out.print("국어 성적 입력: ");
		kor = scan.nextInt();
		System.out.print("영어 성적 입력: ");
		eng = scan.nextInt();
		System.out.print("수학 성적 입력: ");
		math = scan.nextInt();
		System.out.println("성적 입력이 완료되었습니다. ");

		sdto = new SungJukDTO();
		sdto.setData(num, name, kor, eng, math);
		sdto.calc();
		list.add(sdto);
*/

	public void insertArticle() {	
		sdto = new SungJukDTO();		
		list.add(sdto);

	}

	public void printArticle() {
		System.out.print("번호\t이름\t 국어\t 영어\t 수학\t 총점\t 평균\n");
		for(SungJukDTO sdto : list) {
			System.out.print(sdto);
		}
	}

	public void searchArticle(){
		System.out.print("찾을 이름 입력: ");
		String searchName = scan.next();	
		int cnt = 0; 

/*		if(    .equals(searchName)) {
			for(int i = 0; i < list.size(); i++) {
				System.out.print(list.get(i).toString()); }

		} else { System.out.println("찾는 이름이 없습니다. "); }
*/

		for(SungJukDTO sdto : list){
			if(searchName.equals(sdto.getName())) {
				cnt++;
				if(cnt == 1) System.out.print("번호\t이름\t 국어\t 영어\t 수학\t 총점\t 평균\n");	
				System.out.print(sdto);
			}
		}
		if(cnt == 0) System.out.println("찾는 이름이 없습니다. ");
	}
		


/* for(int i = 0; i < list.size(); i++) {
		if(list.get(i).getName().equals(searchName)) {					
			System.out.print(list.get(i).toString());
		} else {
			System.out.println("찾는 이름이 없습니다. ");
		}
	}		
} */

	public void deleteArticle(){
		System.out.print("지울 이름 입력: ");
		String delName = scan.next();
		boolean exist = false; 
		int sw = 0;  //switch변수 = on / off 두 가지의 경우밖에 없을 때 주로 사용한다. 변화의 유무 체크 

//한단계씩 진행, iterator는 참조값을 가리킴. ==> 데이터가 지워지더라도 단계가 당겨지지 않음
		Iterator<SungJukDTO> it = list.iterator(); 
		while(it.hasNext()){
			SungJukDTO sdto = it.next();
			if(sdto.getName().equals(delName)) {
				it.remove();  // remove(): next()로 호출한 데이터를 삭제한다. 
				exist = true;
				sw = 1;				
			//iterator가 가리키는 곳의 값을 지우고 다음 단계로 넘어감(.next()) 
			}
		} 
		if(sw == 0) System.out.println("찾는 이름이 없습니다. ");
		else System.out.println("데이터를 삭제하였습니다.");
	}


//ConcurrentModificationException 에러 발생: remove 된 후, arrayList안의 인덱스 넘버가 하나씩 당겨오기 때문
	/*	for(SungJukDTO sdto : list){
			if(delName.equals(sdto.getName())) {
				cnt++;
				list.remove(sdto);		
			}
		}
		System.out.println(cnt + "건 삭제 완료");
		if(cnt == 0) System.out.println("찾는 이름이 없습니다. ");
	} */ 
	

	public void sortArticle(){
		while(true){
			System.out.println("1. 이름 오름차순 정렬 2. 총점 내림차순 정렬 3. 이전 메뉴로");
			choice = scan.nextInt();
			if(choice == 1) {
				Comparator<SungJukDTO> com = new Comparator<SungJukDTO>(){
					@Override
					public int compare(SungJukDTO s1, SungJukDTO s2){
						return s1.getName().compareTo(s2.getName());
					}
				};

					Collections.sort(list, com);
					printArticle();
				
			} else if(choice == 2) {
				Collections.sort(list);
				printArticle();

			} else if(choice ==3) {
				break;
			}
		}//while		

	}

		


}
