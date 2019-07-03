package kr.co.bit.obj2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class BoardProject_all {

	public static void main(String[] args) {
		ArrayList<HashMap<String, String>> boardList = new ArrayList<HashMap<String, String>>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			System.out.println("====게시판 작성====");
			System.out.println("R:등록  S:검색  D:삭제  U:수정  L:목록");
			String protocol;
			try {
				protocol = br.readLine();
				if(protocol.equals("R") || protocol.equals("r")) {
					HashMap<String, String> hashMap = new HashMap<String, String>();
					
					System.out.println("제목|내용: ");
					String titleContent= br.readLine();
					int indexI = titleContent.indexOf("|"); // ==> int indexI = 2;
					String title = titleContent.substring(0,indexI); // 문자열을 자를 때 사용하는 함수 substring
					String content = titleContent.substring(indexI+1);
					//유효성 검사 ==> 예외처리로 발전 
					if(title == null || title == "") {
						System.out.println("제목이 공백이거나 null일 때 ");
					}
					if(content == null || content == "") {
						System.out.println("내용이 공백이거나 null일 때 ");
					}
					hashMap.put("title", title);
					hashMap.put("content", content);
					
					hashMap.put("author", "김가나");
					hashMap.put("date", "190701");
					hashMap.put("readcount", "0");
					
					boardList.add(hashMap);
					System.out.println("게시글 등록 완료");
					
				} else if (protocol.equals("S") || protocol.equals("s")) {
					HashMap<String, String> hashMap = new HashMap<String, String>();
					System.out.println("찾는 게시글 제목 입력: ");
					String searchTitle = br.readLine();
					for(int i = 0; i < boardList.size(); i++) {
						hashMap = boardList.get(i);
						if(hashMap.get("title").equals(searchTitle)) {
							System.out.println("제목 \t 내용 \t 작성자  \t 날짜 \t 조회수");
							System.out.println(hashMap.get("title") + "\t" 
									+ hashMap.get("content") + "\t" + hashMap.get("author") + "\t" 
									+hashMap.get("date") + "\t" + hashMap.get("readcount") + "\t");					
						}
					}
					
				} else if (protocol.equals("D") || protocol.equals("d")) {
					HashMap<String, String> hashMap = new HashMap<String, String>();
					System.out.println("삭제할 게시글 제목 입력: ");
					String delTitle = br.readLine();
					for(int i = 0; i < boardList.size(); i++) {
						hashMap = boardList.get(i);
						if(hashMap.get("title").equals(delTitle)) {
							boardList.remove(i);
							System.out.println("해당 게시글은 삭제되었습니다. ");
						}
					}
				} else if (protocol.equals("U") || protocol.equals("u")) {
					HashMap<String, String> hashMap = new HashMap<String, String>();
					System.out.println("수정할 게시글 제목 입력: ");
					String searchTitle = br.readLine();
					for(int i = 0; i < boardList.size(); i++) {
						hashMap = boardList.get(i);
						if(hashMap.get("title").equals(searchTitle)) {
							System.out.println("수정 전 내용:");
							System.out.println("제목 \t 내용 \t 작성자  \t 날짜 \t 조회수");
							System.out.println(hashMap.get("title") + "\t" 
									+ hashMap.get("content") + "\t" + hashMap.get("author") + "\t" 
									+hashMap.get("date") + "\t" + hashMap.get("readcount") + "\t");					
							
							System.out.println(" 해당 게시글이 검색되었습니다. ");	
						}
						
						System.out.println("수정할 제목|내용 입력: ");
						String titleContent = br.readLine();
						int indexI = titleContent.indexOf("|"); // ==> int indexI = 2;
						String title = titleContent.substring(0,indexI); // 문자열을 자를 때 사용하는 함수 substring
						String content = titleContent.substring(indexI+1);
						
						hashMap.put("title", title);
						hashMap.put("content", content);
						boardList.set(i, hashMap);
						
						
//							hashMap.replace("title", title);
//							hashMap.replace("content", content);
//							
//							hashMap.replace("author", "ABC");
//							hashMap.replace("date", "181231");
//							hashMap.replace("readcount", "100");
//							//boardList.set(i, hashMap);
						System.out.println("게시글 수정 완료");
						
					}
					
					
				} else if (protocol.equals("L") || protocol.equals("l")) {
					HashMap<String, String> hashMap = new HashMap<String, String>();
					System.out.println("==== 전체출력 ====");
					System.out.println("제목 \t 내용 \t 작성자  \t 날짜 \t 조회수");
					for(int i = 0; i < boardList.size(); i++) {
						hashMap = boardList.get(i);
						System.out.println(hashMap.get("title") + "\t" 
								+ hashMap.get("content") + "\t" + hashMap.get("author") + "\t" 
								+hashMap.get("date") + "\t" + hashMap.get("readcount") + "\t");
						
						
					}
				}
			
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		} // while문
		

	}

}
