package haksa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.StringTokenizer;


public class fullCoding {
	public static void main(String[] args) {
		
			while(true) {				
						try {
							Class.forName("oracle.jdbc.OracleDriver"); //1. 적재(로드)
							Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE", "bitadmin", "dkdlxl"); //2. 연결
							
							if(conn != null) { // conn = null 로 했을 때는 왜 안되나? conn 은 기본값이 null 이니까 !
								System.out.println("OK");
								BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
									System.out.println("=====학사관리 프로젝트=====");
									System.out.println("1. 등록 2. 찾기 3.삭제  4.수정  5.전체출력 0. 종료");
									int protocol = Integer.parseInt(bf.readLine());
							
									if(protocol == 1) {
										System.out.println("1. 학생등록 2. 교수등록 3. 관리자등록 4. 이전메뉴로");
										protocol = Integer.parseInt(bf.readLine());
										if(protocol == 1) { //학생등록
											System.out.println("학생 번호: ");									
											int no = Integer.parseInt(bf.readLine());
											System.out.println("학생 이름: ");
											String name = bf.readLine();
											System.out.println("학생 나이: ");
											String age = bf.readLine();
											System.out.println("학생 학번: ");
											String idNum = bf.readLine();
											
//											System.out.println("학생 이름,나이: ");
//											String nameAge = bf.readLine();
//											int indexI = nameAge.indexOf(","); // indexI = 5;
//											String name = nameAge.substring(0, indexI);
//											String age = nameAge.substring(indexI+1);
	
											//3-1. 문장준비
											String sql = "INSERT INTO HAKSASTUDENT (NO, NAME, AGE, IDNUM) VALUES (?,?,?,?)";
											//3-2. 쿼리준비							
											PreparedStatement pstmt = conn.prepareStatement(sql);
											pstmt.setInt(1, no);
											pstmt.setString(2, name);
											pstmt.setString(3, age);
											pstmt.setString(4, idNum);
											
											//4. 실행
											int count = pstmt.executeUpdate();
											
											if(count == 0) {
												System.out.println("학생이 등록되지 않았습니다. ");
											} else {
												System.out.println(count + "건의 학생이 등록 되었습니다. ");
												pstmt.close(); // 5. 종료 
												conn.close();
											}
											
										} //학생등록
										else if(protocol == 2) {
											System.out.println("교수 번호: ");
											int no = Integer.parseInt(bf.readLine());
											System.out.println("교수 이름: ");
											String name = bf.readLine();
											System.out.println("교수 나이: ");
											String age = bf.readLine();
											System.out.println("교수 과목: ");
											String subject = bf.readLine();
																		
											String sql = "INSERT INTO HAKSAPROFESSOR (NO, NAME, AGE, SUBJECT) VALUES (?,?,?,?)";
																		
											PreparedStatement pstmt = conn.prepareStatement(sql);
											pstmt.setInt(1, no);
											pstmt.setString(2, name);
											pstmt.setString(3, age);
											pstmt.setString(4, subject);
											
											int count = pstmt.executeUpdate();
											
											if(count == 0) {
												System.out.println("교수가 등록되지 않았습니다. ");
											} else {
												System.out.println(count + "건의 교수가 등록 되었습니다. ");
												pstmt.close();
												conn.close();
											}
										}// 교수등록
										else if (protocol == 3) {
											System.out.println("관리자 번호: ");
											int no = Integer.parseInt(bf.readLine());
											System.out.println("관리자 이름: ");
											String name = bf.readLine();
											System.out.println("관리자 나이: ");
											String age = bf.readLine();
											System.out.println("관리자 부서: ");
											String part = bf.readLine();
											
											String sql = "INSERT INTO HAKSAMANAGER (NO, NAME, AGE, PART) VALUES (?,?,?,?)";
																		
											PreparedStatement pstmt = conn.prepareStatement(sql);
											pstmt.setInt(1, no);
											pstmt.setString(2, name);
											pstmt.setString(3, age);
											pstmt.setString(4, part);
											
											int count = pstmt.executeUpdate();
											
											if(count == 0) {
												System.out.println("관리자가 등록되지 않았습니다. ");
											} else {
												System.out.println(count + "건의 관리자가 등록 되었습니다. ");
												pstmt.close();
												conn.close();
											}// 관리자 등록
										}	
										else if (protocol == 4) {
											System.out.println("이전메뉴로 돌아갑니다.. ");
											continue;
										} //이전메뉴로
									} // 등록
									else if (protocol == 2) {
										System.out.println("1. 학생 2. 교수 3. 관리자");
										protocol = Integer.parseInt(bf.readLine());
																				
										if(protocol == 1) { //학생찾기
											System.out.println("찾을 이름을 입력하세요: ");
											String searchName = bf.readLine();
											System.out.println("번호 \t 이름 \t 나이 \t 학번 ");
											String sql = "SELECT NO, NAME, AGE, IDNUM FROM HAKSASTUDENT WHERE NAME = ?";
											PreparedStatement pstmt = conn.prepareStatement(sql);
											pstmt.setString(1, searchName);
											
											ResultSet rs = pstmt.executeQuery();
											while(rs.next()) {
												int no = rs.getInt("no");
												String age = rs.getString("age");
												String name = rs.getString("name");
												String idNum = rs.getString("idNum");
																						
												System.out.println(no + "\t" + name + "\t" + age + "\t" + idNum);
											}
										} //학생찾기
										else if (protocol == 2) { //교수찾기
											System.out.println("찾을 이름을 입력하세요: ");
											String searchName = bf.readLine();
											String sql = "SELECT NO, NAME, AGE, SUBJECT FROM HAKSAPROFESSOR WHERE NAME = ?";
											PreparedStatement pstmt = conn.prepareStatement(sql);
											pstmt.setString(1, searchName);
											
											ResultSet rs = pstmt.executeQuery();
											while(rs.next()) {
												int no = rs.getInt("no");
												String age = rs.getString("age");
												String name = rs.getString("name");
												String subject = rs.getString("subject");
												
												System.out.println("번호 \t 이름 \t 나이 \t 과목 ");
												System.out.println(no + "\t" + name + "\t" + age + "\t" + subject);
											}
										} //교수찾기
										else if (protocol == 3) { //관리자찾기
											System.out.println("찾을 이름을 입력하세요: ");
											String searchName = bf.readLine();
											String sql = "SELECT NO, NAME, AGE, PART FROM HAKSAMANAGER WHERE NAME = ?";
											PreparedStatement pstmt = conn.prepareStatement(sql);
											pstmt.setString(1, searchName);
											
											ResultSet rs = pstmt.executeQuery();
											while(rs.next()) {
												int no = rs.getInt("no");
												String age = rs.getString("age");
												String name = rs.getString("name");
												String part = rs.getString("part");
												
												System.out.println("번호 \t 이름 \t 나이 \t 부서 ");
												System.out.println(no + "\t" + name + "\t" + age + "\t" + part);
											}
										}//관리자찾기
										
									} // 찾기
									else if(protocol == 3) {
										System.out.println("삭제할 이름을 입력하세요: ");
										String delName = bf.readLine();
										System.out.println("찾는 타입을 입력하세요: 1. 학생 2. 교수 3. 관리자");
										protocol = Integer.parseInt(bf.readLine());
										
										if(protocol == 1) {
											String sql = "DELETE FROM HAKSASTUDENT WHERE NAME = ?";
											PreparedStatement pstmt = conn.prepareStatement(sql);
											pstmt.setString(1, delName);
											
											int count = pstmt.executeUpdate();
											if(count == 0) {
												System.out.println("삭제할 이름이 없습니다. ");
											} else {
												System.out.println(count + "건 삭제되었습니다. ");
											}
											
										}
										else if (protocol == 2){
											
										} 
										else if (protocol == 3) {
											
										}
										
									}//삭제
									else if (protocol == 4) { //수정
										System.out.println("수정할 이름을 입력하세요: ");
										String searchName = bf.readLine();
										String sql = "SELECT NO, NAME, AGE, IDNUM FROM HAKSASTUDENT WHERE NAME = ?";
										PreparedStatement pstmt = conn.prepareStatement(sql);
										pstmt.setString(1, searchName);
										
										ResultSet rs = pstmt.executeQuery();
										while(rs.next()) {
											int no = rs.getInt("no");
											String age = rs.getString("age");
											String name = rs.getString("name");
											String idNum = rs.getString("idNum");
											
											System.out.println("번호 \t 이름 \t 나이 \t 학번 ");
											System.out.println(no + "\t" + name + "\t" + age + "\t" + idNum);
	
												
											System.out.println("수정할 내용을 입력하세요..");
											System.out.println("학생 번호:이름:나이:학번");
											String updateStu = bf.readLine();
											sql = "UPDATE HAKSASTUDENT SET NO ";
											StringTokenizer stz = new StringTokenizer(updateStu, ":");
											
											while(stz.hasMoreTokens()) {											
												no = Integer.parseInt(stz.nextToken());
												age = stz.nextToken();
												name = stz.nextToken();
												idNum = stz.nextToken();																			
												
												System.out.println("번호 \t 이름 \t 나이 \t 학번 ");
												System.out.println(no + "\t" + name + "\t" + age + "\t" + idNum);
												
												System.out.println("학생 정보 업데이트 완료");
											}
										}
										rs.close();
										pstmt.close();
										conn.close();
									}//수정
									else if (protocol == 5) {//전체출력
										
										System.out.println("찾는 타입을 입력하세요: 1. 학생 2. 교수 3. 관리자 4. 전체");
										protocol = Integer.parseInt(bf.readLine());
										
										if(protocol == 1) {//학생전체출력
											String sql = "SELECT NO, NAME, AGE, IDNUM FROM HAKSASTUDENT";
											PreparedStatement pstmt = conn.prepareStatement(sql);
											ResultSet rs = pstmt.executeQuery();
											
											while(rs.next()) {
												int no = rs.getInt("no");
												String age = rs.getString("age");
												String name = rs.getString("name");
												String idNum = rs.getString("idNum");
												System.out.println("번호 \t 이름 \t 나이 \t 학번 ");
												System.out.println(no + "\t" + name + "\t" + age + "\t" + idNum);
											}
										} //학생전체출력
										else if (protocol == 2) {
											String sql = "SELECT NO, NAME, AGE, SUBJECT FROM HAKSAPROFESSOR";
											PreparedStatement pstmt = conn.prepareStatement(sql);
											ResultSet rs = pstmt.executeQuery();
											
											while(rs.next()) {
												int no = rs.getInt("no");
												String age = rs.getString("age");
												String name = rs.getString("name");
												String subject = rs.getString("subject");
												System.out.println("번호 \t 이름 \t 나이 \t 과목 ");
												System.out.println(no + "\t" + name + "\t" + age + "\t" + subject);
											}
										}
										else if (protocol == 3) {
											String sql = "SELECT NO, NAME, AGE, PART FROM HAKSAMANAGER";
											PreparedStatement pstmt = conn.prepareStatement(sql);
											ResultSet rs = pstmt.executeQuery();
											
											while(rs.next()) {
												int no = rs.getInt("no");
												String age = rs.getString("age");
												String name = rs.getString("name");
												String part = rs.getString("part");
												System.out.println("번호 \t 이름 \t 나이 \t 부서 ");
												System.out.println(no + "\t" + name + "\t" + age + "\t" + part);
										}
									}//관리자 전체출력
										
									} //전체출력
									else if(protocol == 0) {
										System.out.println("종료합니다. ");
										System.exit(0);
									}
									//else {
									//	System.out.println("잘못된 번호 입력 ");
									//} //잘못된 입력 처리
									
								
							} else {
								System.out.println("fail ");
							}//DB연결 끝

					
						} catch (NumberFormatException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (ClassNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
			
			}//while
	}
}