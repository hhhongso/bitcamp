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
			System.out.println("====�Խ��� �ۼ�====");
			System.out.println("R:���  S:�˻�  D:����  U:����  L:���");
			String protocol;
			try {
				protocol = br.readLine();
				if(protocol.equals("R") || protocol.equals("r")) {
					HashMap<String, String> hashMap = new HashMap<String, String>();
					
					System.out.println("����|����: ");
					String titleContent= br.readLine();
					int indexI = titleContent.indexOf("|"); // ==> int indexI = 2;
					String title = titleContent.substring(0,indexI); // ���ڿ��� �ڸ� �� ����ϴ� �Լ� substring
					String content = titleContent.substring(indexI+1);
					//��ȿ�� �˻� ==> ����ó���� ���� 
					if(title == null || title == "") {
						System.out.println("������ �����̰ų� null�� �� ");
					}
					if(content == null || content == "") {
						System.out.println("������ �����̰ų� null�� �� ");
					}
					hashMap.put("title", title);
					hashMap.put("content", content);
					
					hashMap.put("author", "�谡��");
					hashMap.put("date", "190701");
					hashMap.put("readcount", "0");
					
					boardList.add(hashMap);
					System.out.println("�Խñ� ��� �Ϸ�");
					
				} else if (protocol.equals("S") || protocol.equals("s")) {
					HashMap<String, String> hashMap = new HashMap<String, String>();
					System.out.println("ã�� �Խñ� ���� �Է�: ");
					String searchTitle = br.readLine();
					for(int i = 0; i < boardList.size(); i++) {
						hashMap = boardList.get(i);
						if(hashMap.get("title").equals(searchTitle)) {
							System.out.println("���� \t ���� \t �ۼ���  \t ��¥ \t ��ȸ��");
							System.out.println(hashMap.get("title") + "\t" 
									+ hashMap.get("content") + "\t" + hashMap.get("author") + "\t" 
									+hashMap.get("date") + "\t" + hashMap.get("readcount") + "\t");					
						}
					}
					
				} else if (protocol.equals("D") || protocol.equals("d")) {
					HashMap<String, String> hashMap = new HashMap<String, String>();
					System.out.println("������ �Խñ� ���� �Է�: ");
					String delTitle = br.readLine();
					for(int i = 0; i < boardList.size(); i++) {
						hashMap = boardList.get(i);
						if(hashMap.get("title").equals(delTitle)) {
							boardList.remove(i);
							System.out.println("�ش� �Խñ��� �����Ǿ����ϴ�. ");
						}
					}
				} else if (protocol.equals("U") || protocol.equals("u")) {
					HashMap<String, String> hashMap = new HashMap<String, String>();
					System.out.println("������ �Խñ� ���� �Է�: ");
					String searchTitle = br.readLine();
					for(int i = 0; i < boardList.size(); i++) {
						hashMap = boardList.get(i);
						if(hashMap.get("title").equals(searchTitle)) {
							System.out.println("���� �� ����:");
							System.out.println("���� \t ���� \t �ۼ���  \t ��¥ \t ��ȸ��");
							System.out.println(hashMap.get("title") + "\t" 
									+ hashMap.get("content") + "\t" + hashMap.get("author") + "\t" 
									+hashMap.get("date") + "\t" + hashMap.get("readcount") + "\t");					
							
							System.out.println(" �ش� �Խñ��� �˻��Ǿ����ϴ�. ");	
						}
						
						System.out.println("������ ����|���� �Է�: ");
						String titleContent = br.readLine();
						int indexI = titleContent.indexOf("|"); // ==> int indexI = 2;
						String title = titleContent.substring(0,indexI); // ���ڿ��� �ڸ� �� ����ϴ� �Լ� substring
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
						System.out.println("�Խñ� ���� �Ϸ�");
						
					}
					
					
				} else if (protocol.equals("L") || protocol.equals("l")) {
					HashMap<String, String> hashMap = new HashMap<String, String>();
					System.out.println("==== ��ü��� ====");
					System.out.println("���� \t ���� \t �ۼ���  \t ��¥ \t ��ȸ��");
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
			
		} // while��
		

	}

}
