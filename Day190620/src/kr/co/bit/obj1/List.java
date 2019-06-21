package kr.co.bit.obj1;

import java.util.ArrayList;
import java.util.HashMap;

public class List {
	
	public void displayList() {
		 System.out.println("전체 출력"); //배열: n개에 해당되는 갯수가 선언되어 있음 => 반복할 횟수가 정해져 있음. =. for
			System.out.println("나이 \t 이름 \t 학번 \t 과목 \t 부서");
	}
	
	public void listProcess () { //전체 출력 함수
			displayList();
			
			for(int i = 0; i < Register.haksaList.size(); i++) { 	// length: 공간의 길이 / size: 공간의 크기(몇 개의 공간이 있는지)
				HashMap<String, String> haksaHash = Register.haksaList.get(i);
				if(haksaHash.get("type").equals("1")) { 
					System.out.print(haksaHash.get("age")+ "\t");
					System.out.print(haksaHash.get("name")+ "\t");
					System.out.print(haksaHash.get("hakbun")+ "\n"); // 학생 전체출력 
				} else if (haksaHash.get("type").equals("2")) {
					System.out.print(haksaHash.get("age") + "\t");
					System.out.print(haksaHash.get("name") + "\t \t");
					System.out.print(haksaHash.get("subject") + "\n");
				} else if (haksaHash.get("type").equals("3")) {
					System.out.print(haksaHash.get("age") + "\t");
					System.out.print(haksaHash.get("name") + "\t \t \t");
					System.out.print(haksaHash.get("part") + "\n");
				}
				
			}
	 } // 전체 출력 끝 
}
