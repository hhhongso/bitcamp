package kr.co.bit.obj3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class BoardProject_all {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//DB�� �ٲٸ鼭 ArrayList & hashMap �� �ʿ�����ϱ� 
		
			
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					while(true) { // ������ ��� �ݺ�				
						Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE", "bitadmin", "dkdlxl");				
						if(conn == null) {
							System.out.println("fail");
						} else { // DB������
							System.out.println("OK!");
							System.out.println("====�Խ��� �ۼ�====");
							System.out.println("R:���  S:�˻�  D:����  U:����  L:���");
							String protocol = br.readLine();
							
							if(protocol.equals("R") || protocol.equals("r")) {
								System.out.println("�Խñ� ��ȣ �Է�: ");
								int no = Integer.parseInt(br.readLine()); //readline >> int �� ����ȯ
								System.out.println("����|����: ");
								String titleContent = br.readLine();
								int indexI = titleContent.indexOf("|");
								String title = titleContent.substring(0, indexI);
								String content = titleContent.substring(indexI+1);
								
								String sql = "INSERT INTO BOARD (NO, TITLE, CONTENT, AUTHOR, NAL, READCOUNT) VALUES (?, ?, ?, ?, ?, ?)";
								PreparedStatement pstmt = conn.prepareStatement(sql);
								pstmt.setInt(1, no);
								pstmt.setString(2, title);
								pstmt.setString(3, content);
								pstmt.setString(4, "�谡��");
								pstmt.setString(5, "190701");
								pstmt.setInt(6, 0);
								
								int count = pstmt.executeUpdate();
								System.out.println(count + "�� �Խñ��� ��� �Ǿ����ϴ�. ");
								
								pstmt.close();
								conn.close();
								
							} // R ���
							else if (protocol.equals("S") || protocol.equals("s")) { // S ã��
								System.out.println("ã�� �Խñ� ���� �Է�: ");								
								String searchTitle = br.readLine();
								String sql = "SELECT NO, TITLE, CONTENT, AUTHOR, NAL, READCOUNT FROM BOARD WHERE TITLE = ? ";
								PreparedStatement pstmt = conn.prepareStatement(sql);
								pstmt.setString(1, searchTitle);
								ResultSet rs = pstmt.executeQuery();
								
								while(rs.next()) {
									int no = rs.getInt("no");
									String title = rs.getString("title");
									String content = rs.getString("content");
									String author = rs.getString("author");
									String nal = rs.getString("nal");
									int readCount = rs.getInt("readcount");
									
									System.out.println("��ȣ" + "\t" + "����" + "\t" +"����" + "\t" +"�ۼ���" + "\t" +"��¥" + "\t" +"��ȸ��");
									System.out.println(no + "\t" + title + "\t" + content + "\t" + author + "\t" + nal + "\t" + readCount);
								}
							} // S ã��
							else if (protocol.equals("D") || protocol.equals("d")) { // D ����
								System.out.println("������ �Խñ� ���� �Է�: ");								
								String delTitle = br.readLine();
								String sql = "SELECT NO, TITLE, CONTENT, AUTHOR, NAL, READCOUNT FROM BOARD WHERE TITLE = ? ";
								PreparedStatement pstmt = conn.prepareStatement(sql);
								pstmt.setString(1, delTitle);

								int count = pstmt.executeUpdate();
								System.out.println(count + "�� �Խñ��� ���� �Ǿ����ϴ�. ");
								
								pstmt.close();
								conn.close();
								
							} // D ����
							else if (protocol.equals("L") || protocol.equals("l")) { // L ��ü���
								System.out.println("�Խñ� ��ü ���");
								System.out.println("��ȣ \t ���� \t ���� \t �ۼ��� \t ��¥ \t ��ȸ��");
								
								String sql = "SELECT NO, TITLE, CONTENT, AUTHOR, NAL, READCOUNT FROM BOARD"; //select * from board >> ��� �׸� �� ��������
								PreparedStatement pstmt = conn.prepareStatement(sql);
								ResultSet rs = pstmt.executeQuery();
								
								while(rs.next()) {
									int no = rs.getInt("no");
									String title = rs.getString("title");
									String content = rs.getString("content");
									String author = rs.getString("author");
									String nal = rs.getString("nal");
									int readCount = rs.getInt("readcount");
									
									System.out.println(no + "\t" + title + "\t" + content + "\t" + author + "\t" + nal + "\t" + readCount);
									
								}
								pstmt.close();
								conn.close();
							}// L ��ü���
						} // DB������
					} //while��
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} catch (SQLException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
		
		
		
		/*
		while(true) {
			String protocol;
		
				if(protocol.equals("R") || protocol.equals("r")) {
					HashMap<String, String> hashMap = new HashMap<String, String>();
					
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
			
			
			
		} // while��
		*/

	}

}
