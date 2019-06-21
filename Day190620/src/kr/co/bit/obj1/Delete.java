package kr.co.bit.obj1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Delete {
	
	private String nameDelete; // 
	private String type;
	
	public Delete() {
		nameDelete = null;
		type = null;
	
	}
	
	public void setDeleteName() {
		System.out.println("삭제할 이름을 입력하세요: ");
		nameDelete = Register.input.next();
		
	}
	public void setDeleteType () {
		System.out.println("1. 학생 2. 교수 3. 관리자 ");
		type = Register.input.next();
	}
	
	 public void deleteProcess () { //삭제 함수
			setDeleteName();
			setDeleteType();
			
			for (int i = 0; i < Register.haksaList.size();i++) {
				HashMap<String, String> haksaHash = Register.haksaList.get(i);
				if(haksaHash.get("type").equals("1")) { // 학생 삭제  // 학사해시에서 ->type = stu에 일치하면 
					if (nameDelete.equals(haksaHash.get("name"))) { // => nameDelete가 학사해시(stu)의 name과 일치하면 	
						Register.haksaList.remove(i); // 해당 i번째 열의 ArrayList를 삭제한다. 
						System.out.println(nameDelete + "님이 삭제되었습니다. ");
						//i = i -1; // 혹은 key 값을 하나 추가해서, 동일 key값을 한번에 지울 수 있도록 (동명이인 처리하기) 
					}
				} else if(haksaHash.get("type").equals("2")) { //교수 삭제
					if(nameDelete.equals(haksaHash.get("name"))) {
						Register.haksaList.remove(i);
						System.out.println(nameDelete + "님이 삭제되었습니다. ");
					}
				} else if(haksaHash.get("type").equals("3")) { // 관리자 삭제
					if (nameDelete.equals(haksaHash.get("name"))) {
						Register.haksaList.remove(i);
						System.out.println(nameDelete + "님이 삭제되었습니다. ");
					}
				}
			}
	} //삭제 함수 끝
}
