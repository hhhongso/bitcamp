package assignment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class assignhaksa_Function {
	public static int register(Scanner scan, ArrayList<HashMap<String, String>> haksaList, int choice) { //등록함수
		if (choice == 1) { // 학생등록
			HashMap<String, String> hakhash = new HashMap<String, String>();
			
			System.out.print("나이: ");
			String age = scan.next();
			System.out.print("이름: ");
			String name = scan.next();
			System.out.print("학번: ");
			String idNum = scan.next();
			
			hakhash.put("age", age);
			hakhash.put("name", name);
			hakhash.put("idNum", idNum);
			hakhash.put("type", "stu");
			haksaList.add(hakhash);	// ArrayList 안에 위 값을 넣기 
			
			System.out.println("학생이 등록되었습니다.");
			
		} else if (choice == 2) { // 교수등록
			HashMap<String, String> hakhash = new HashMap<String, String>();
			
			System.out.print("나이: ");
			String age = scan.next();
			System.out.print("이름: ");
			String name = scan.next();
			System.out.print("과목: ");
			String subject = scan.next();
			
			hakhash.put("age", age);
			hakhash.put("name", name);
			hakhash.put("subject", subject);
			hakhash.put("type", "prof");
			haksaList.add(hakhash); // ArrayList 안에 위 값을 넣기 
			
			System.out.println("교수가 등록되었습니다.");
		} else if (choice == 3) { // 관리자등록
			HashMap<String, String> hakhash = new HashMap<String, String>();
			
			System.out.print("나이: ");
			String age = scan.next();
			System.out.print("이름: ");
			String name = scan.next();
			System.out.print("부서: ");
			String part = scan.next();
			
			hakhash.put("age", age);
			hakhash.put("name", name);
			hakhash.put("part", part);
			hakhash.put("type", "mng");
			haksaList.add(hakhash);// ArrayList 안에 위 값을 넣기 
			
			System.out.println("관리자가 등록되었습니다.");
		}
		return choice;
	}   //등록함수
	
	
	public static void search(Scanner scan, ArrayList<HashMap<String, String>> haksaList, int choice) { //찾기
		
		while (true) {
			System.out.print("찾을 이름을 입력해주세요: ");
			String searchName = scan.next();		
	
			for(int i = 0; i < haksaList.size(); i++) {
				HashMap<String, String> hakhash = haksaList.get(i);
					if (hakhash.get("type").equals("stu")) { //stu type이고 
						if(searchName.equals(haksaList.get(i).get("name"))) {// 이름이 일치하면 
							System.out.print("나이: " + hakhash.get("age") + "\t");
							System.out.print("이름: " + hakhash.get("name") + "\t");
							System.out.print("학번: " + hakhash.get("idNum") + "\n");
						}
						
					} else if (hakhash.get("type").equals("prof")) { // prof type
						if(searchName.equals(haksaList.get(i).get("name"))) {
							System.out.print("나이: " + hakhash.get("age") + "\t");
							System.out.print("이름: " + hakhash.get("name") + "\t");
							System.out.print("과목: " + hakhash.get("subject") + "\n");
						}
					} else if (hakhash.get("type").equals("mng")) { // mng type 
						if(searchName.equals(haksaList.get(i).get("name"))) {
							System.out.print("나이: " + hakhash.get("age") + "\t");
							System.out.print("이름: " + hakhash.get("name") +"\t");
							System.out.print("부서: " + hakhash.get("part") + "\n");
						}
					} //else if (hakhash.get("type").equals(0)) {
						// sysout 등록된 이름이 아닙니다. ;
					//}
			} //for문 종료 
			
			System.out.println();
			System.out.print("계속하시려면 1, 종료하시려면 0을 입력해주세요. ");	
			choice = scan.nextInt();
			if (choice == 0) {
				System.out.println("종료합니다. ");
				break;
			} else {
				continue; 
			}
		} 		
	} //찾기
	
	public static void delete(Scanner scan, ArrayList<HashMap<String, String>> haksaList) { // 삭제
		System.out.print("삭제할 이름을 입력해주세요: ");
		String inputName = scan.next();		
		
		for(int i = 0; i < haksaList.size(); i++) {
			HashMap<String, String> hakhash = haksaList.get(i);
			if(hakhash.get("type").equals("stu")) {
				if(inputName.equals(hakhash.get("name"))) {
					haksaList.remove(i); 
					System.out.println(inputName + " 님이 삭제되었습니다. ");				
				}
			} else if (hakhash.get("type").equals("prof")) {
				if(inputName.equals(hakhash.get("name"))) {
					haksaList.remove(i); 
					System.out.println(inputName + " 님이 삭제되었습니다. ");		
				} 
			} else if (hakhash.get("type").equals("mng")){
				if(inputName.equals(hakhash.get("name"))) {
					haksaList.remove(i); 
					System.out.println(inputName + " 님이 삭제되었습니다. ");		
				} 
			} 
		} // sysout 등록된 이름이 아닙니다. 
	} 
	
	public static void outputList(ArrayList<HashMap<String, String>> haksaList) { // 전체출력
		for(int i = 0; i < haksaList.size(); i++) {
			HashMap<String, String> hakhash = haksaList.get(i);
			if (hakhash.get("type").equals("stu")) {
				System.out.print("나이: " + hakhash.get("age") +"\t");
				System.out.print("이름: " + hakhash.get("name") +"\t");
				System.out.print("학번: " + hakhash.get("idNum") + "\n");
				
			} else if (hakhash.get("type").equals("prof")) {
				System.out.print("나이: " + hakhash.get("age") + "\t");
				System.out.print("이름: " + hakhash.get("name") + "\t");
				System.out.print("과목: " + hakhash.get("subject") + "\n");
			} else if (hakhash.get("type").equals("mng")) {
				System.out.print("나이: " + hakhash.get("age") + "\t");
				System.out.print("이름: " + hakhash.get("name") + "\t");
				System.out.print("부서: " + hakhash.get("part") + "\n");
			}
		}
	}// 전체출력
}
