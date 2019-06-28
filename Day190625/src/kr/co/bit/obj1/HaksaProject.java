package kr.co.bit.obj1;

/*
 * DB
 * 배열을 메모리 대신 DB로 관리하기 - 몰코딩 
 */

/* 1. 로드(적재) : 자바에게 DB 오라클을 사용할 것이라고 알려주는 단계 
 * 		lib 폴더 만든 후 ojdbc6 복사해두기 : 경로 C:\Program Files\Java\jdk1.8.0_211\jre\lib\ext
 * 									혹은 C:\oraclexe\app\oracle\product\11.2.0\server\jdbc\lib
 * 		우클릭 - build path - add
 * 
 * 2. 연결(Connection)
 * 		DriverManager 클래스를 컨트롤한다. 
 * 
 * 3. 준비 
 * 	3-1. 공간준비
 * 	3-2. 쿼리준비 (문장준비)
 * 
 * 4. 실행
 *  1) executeUpdate(): 등록, 삭제, 수정  
 *  2) executeQuery(): 찾기, 목록
 *  
 *  예외처리 설정해주기 (우클릭 - source - surround with - try/catch block
 */

/*
 * DB 페이지에서 open scrapBook 에 테이블 작성
 * TABLE 작성 시에는 JAVA 단에서 만든 변수의 이름(number, age, name, idNum)와 관계없이, 테이블에서 사용한 이름을 이용해야 한다. 
 * file - save as - 파일명.sql >>> javaProject Folder에 저장  >> javaEE 에서 확인 
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


public class HaksaProject {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Connection conn = null; 
						//DB연결 성공/실패 확인용으로 지역변수 conn을 한 번 사용했기 때문에, 함수 밖에서 초기화 시켜야 3-1. 에서도 사용할 수 있음 
	
		while(true) {
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				//url: 자바화면에서 connect 되어있는 new oracle 통에서 가져옴 
				conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE", "bitadmin", "dkdlxl");
				if (conn == null) {
					System.out.println("데이터베이스 연결 실패 ");
				} else {
					System.out.println("데이터베이스 연결 성공 ~ ");
				}
			} catch (ClassNotFoundException e) { 	//Class.forName 안의 패키지 주소 or 클래스명이 틀림 => 없는 클래스or패키지를 찾으려 하니 클래스를 찾을 수 없다는 예외가 뜸 
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) { 						//SQL안의 예외만 캐치함 
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			/*
			 * conn은 ? 
			 * 가리키는 공간.  ====> Database XE 통을 가리킨다. 
			 */
			System.out.println("=========학사 관리 메뉴=========");
			System.out.println("1. 등록");
			System.out.println("2. 찾기");
			System.out.println("3. 삭제");
			System.out.println("4. 전체출력");
			System.out.println("0. 종료");
			System.out.println("============================");
			System.out.println("번호 선택: ");
			int protocol = scan.nextInt();
			if(protocol == 1) {
				System.out.println("=======등록 메뉴=======");
				System.out.println("1. 학생"); // 테이블 등록하기
				System.out.println("2. 교수");
				System.out.println("3. 관리자");
				System.out.println("4. 이전메뉴");
				System.out.println("=====================");
				System.out.println("번호 선택: ");
				protocol = scan.nextInt();
				
				if(protocol == 1) {
					System.out.println("번호입력: ");
					int number = scan.nextInt();
					System.out.println("나이: ");
					String age = scan.next();
					System.out.println("이름: ");
					String name = scan.next();
					System.out.println("학번: ");
					String idNum = scan.next();
					
					try {
						Statement stmt = conn.createStatement(); // 3-1. 공간준비
										//이 부분은 대소문자 상관없이 적을 수 있으나 데이터베이스이름과 같아야하며	// 이 변수의 이름은 상기 선언한대로 대소문자를 구분해주어야 한다. 
						String sql = "INSERT INTO STUDENT(NO, AGE, NAME, HAKBUN) VALUES ("+number+", '"+age+"', '"+name+"', '"+idNum+"')"; // 3-2. 쿼리준비
																						//쿼리에 변수를 넣어준다. 
						int cnt = stmt.executeUpdate(sql);
						System.out.println(cnt + "건 학생이 등록되었습니다. ");
										
						conn.close();
						stmt.close(); // 종료
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} //학생
				
				else if (protocol == 2) {
					try {
						System.out.println("번호입력: ");
						int number = scan.nextInt();
						System.out.println("나이: ");
						String age = scan.next();
						System.out.println("이름: ");
						String name = scan.next();
						System.out.println("과목: ");
						String subject = scan.next();
						
						Statement stmt = conn.createStatement();
						String sql = "INSERT INTO PROFESSOR (NO, AGE, NAME, SUBJECT) VALUES ("+number+", '"+age+"', '"+name+"', '"+subject+"')";
						
						int cnt = stmt.executeUpdate(sql);
						if(cnt == 1) {
							System.out.println(cnt +"건 교수가 등록되었습니다. ");
							stmt.close();
							conn.close(); // 종료 반드시 해주라 
						} else {
							System.out.println("교수 등록 실패");
						}
						
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}// 교수
				else if(protocol == 3) {
					
						System.out.println("번호입력: ");
						int number = scan.nextInt();
						System.out.println("나이: ");
						String age = scan.next();
						System.out.println("이름: ");
						String name = scan.next();
						System.out.println("부서: ");
						String part = scan.next();
					try {
						Statement stmt = conn.createStatement();
						String sql = "INSERT INTO MANAGER (NO, AGE, NAME, PART) VALUES ("+number+", '"+age+"', '"+name+"', '"+part+"')";
						
						int cnt = stmt.executeUpdate(sql);
						if (cnt == 0) {
							System.out.println("관리자 등록 실패 ");
						} else {
							System.out.println(cnt + "건 관리자가 등록 되었습니다. ");							
						}
						
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}//관리자
			} //등록
			
			else if (protocol == 2) { //찾기
				System.out.println("1. 학생 찾기 2. 교수 찾기 3. 관리자 찾기");
				int choice = scan.nextInt();
				System.out.println("찾을 이름을 입력하세요: ");
				String searchName = scan.next();
				
				if (choice == 1) {
					System.out.print("번호 \t 나이 \t 이름 \t 학번 \n");
					try {
						Statement stmt = conn.createStatement();
						String sql = "SELECT NO, AGE, NAME, HAKBUN FROM STUDENT WHERE NAME = '"+searchName+"'";
								
						ResultSet rs = stmt.executeQuery(sql);
						
						if(rs.next()) {
							int number = rs.getInt("no");
							String name = rs.getString("name");
							String age = rs.getString("age");
							String idNum = rs.getString("hakbun");
							System.out.print(number + "\t"+ age + "\t"+ name + "\t"+ idNum + "\n");
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				} // 학생찾기 
				else if (choice == 2) {
					System.out.print("번호 \t 나이 \t 이름 \t 과목 \n");
					try {
						Statement stmt = conn.createStatement();
						String sql = "SELECT NO, AGE, NAME, SUBJECT FROM PROFESSOR WHERE NAME = '"+searchName+"'";
								
						ResultSet rs = stmt.executeQuery(sql);
						
						if(rs.next()) {
							int number = rs.getInt("no");
							String name = rs.getString("name");
							String age = rs.getString("age");
							String subject = rs.getString("subject");
							System.out.print(number + "\t"+ age + "\t"+ name + "\t"+ subject + "\n");
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} // 교수찾기
				else if (choice == 3) {
					System.out.print("번호 \t 나이 \t 이름 \t 부서 \n");
					try {
						Statement stmt = conn.createStatement();
						String sql = "SELECT NO, AGE, NAME, PART FROM MANAGER WHERE NAME = '"+searchName+"'";
								
						ResultSet rs = stmt.executeQuery(sql);
						
						if(rs.next()) {
							int number = rs.getInt("no");
							String name = rs.getString("name");
							String age = rs.getString("age");
							String part = rs.getString("part");
							System.out.print(number + "\t"+ age + "\t"+ name + "\t"+ part + "\n");
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} // 관리자 찾기
			} //찾기
			
			else if (protocol == 3) { //삭제
				
					System.out.println("1. 학생 삭제 2. 교수 삭제 3. 관리자 삭제");
					int choice = scan.nextInt();
					System.out.println("삭제할 이름을 입력하세요: ");
					String name = scan.next();
					
					if(choice == 1) {
						try {
							Statement stmt = conn.createStatement();				
							String sql = "DELETE FROM STUDENT WHERE NAME ='"+name+"'";
							
							int cnt = stmt.executeUpdate(sql);
							if (cnt == 0) {
								System.out.println("삭제 실패 = 찾는 이름이 없습니다. ");
							} else {
								System.out.println(cnt + "건 학생 삭제되었습니다.");
								conn.close();
								stmt.close();
							}
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
//						if(name.equals("name")) { >>>> 이게 아니라 DB니까 "DELETE~~~ WHERE NAME 으로 조건 잡아준다. 
//						}
						
					} // 학생 삭제
					else if (choice == 2) {
						try {
							Statement stmt = conn.createStatement();
							String sql = "DELETE FROM PROFESSOR WHERE NAME '"+name+"'";
							int cnt = stmt.executeUpdate(sql);
							
							if(cnt == 0) { 								
								System.out.println("교수 삭제 실패 - 찾는 이름이 없습니다. ");
							} else {
								System.out.println(cnt + "건 교수 삭제 되었습니다. ");
								conn.close();
								stmt.close();
							}
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}// 교수 삭제
					else if (choice == 3) {
						try {
							Statement stmt = conn.createStatement();
							String sql = "DELETE FROM MANAGER WHERE NAME '"+name+"'";
							int cnt = stmt.executeUpdate(sql);
							 											// CNT = count (갯수변수 ) === > 동명이인일 시, cnt = 2
							if(cnt == 0) {
								System.out.println("관리자 삭제 실패 - 찾는 이름이 없습니다. ");
							} else {
								System.out.println(cnt + "건 관리자 삭제 되었습니다. ");
								conn.close();
								stmt.close();
							}
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					} //관리자 삭제
				
			} //삭제
			else if (protocol == 4) { // 전체출력
				//로드는 다 되어있음. 준비 & 실행만 처리하면 된다. 
				System.out.println("전체 출력");
				System.out.println("1. 학생 전체출력 2. 교수 전체출력 3. 관리자 전체출력"); // 전체 전체출력은, join 을 이용하여야 한다. 
				int choice  = scan.nextInt();
					
				if(choice == 1) {
					try {
						System.out.print("번호 \t 나이 \t 이름 \t 학번 \n");
						
						Statement stmt = conn.createStatement();				// ASC 오름차순 정렬 <-> DESC 내림차순 정렬
						String sql = "SELECT NO, AGE, NAME, HAKBUN FROM STUDENT ORDER BY NO ASC";
						ResultSet rs = stmt.executeQuery(sql); 
						
						while(rs.next()) {
						// java단의 변수명			//DB단의 변수명
							int number = rs.getInt("no");
							String age = rs.getString("age");
							String name = rs.getString("name");
							String idNum = rs.getString("hakbun");
							System.out.print(number + "\t"+ age + "\t"+ name + "\t"+ idNum + "\n");
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} // 학생 전체출력 
				else if (choice == 2) {
					System.out.print("번호 \t 나이 \t 이름 \t 과목 \n");
					
					try {
						Statement stmt = conn.createStatement();							
						String sql = "SELECT NO, AGE, NAME, SUBJECT FROM PROFESSOR ORDER BY NO DESC";
						ResultSet rs = stmt.executeQuery(sql);
						
						/*
						 * rs.next() 는 현재 위치에서 1개의 줄을 이동시키는데, 여기 자료가 있으면 true, 없으면 false 가 리턴됩니다.
							의도하시는 결과를 위해 while(rs.next()) 이렇게 코딩해야 하는 *이유*는, 모든 레코드를 간단하게 싹 읽기 위해서라고 생각되구요. (if를 사용할 경우 1개 값만 가져오게됨)
							while() 루프문은 while(boolean) 내의 boolean 값이 false 이면 루프가 끝나게 됩니다.
							이제 이 설명을 이해하신다면 위의 설명 범위 - while(rs.next()) -내에서 짝/홀수번째 레코드만, 특정 위치의 레코드만 가져올 수 있는 방안이 떠오르실겁니다.
						 */
						
						while(rs.next()) { 
							int number = rs.getInt("no"); 
							String age = rs.getString("age");
							String name = rs.getString("name") ; 
							String subject = rs.getString("subject"); 
							System.out.print(number + "\t"+ age + "\t"+ name + "\t"+ subject + "\n");
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}// 교수 전체출력
				else if (choice == 3) {
					System.out.print("번호 \t 나이 \t 이름 \t 부서 \n");
					try {
						Statement stmt = conn.createStatement();
						String sql = "SELECT NO, AGE, NAME, PART FROM MANAGER ORDER BY NO ASC";
						
						ResultSet rs = stmt.executeQuery(sql);
						
						while(rs.next()) {
							int number = rs.getInt("no");
							String age = rs.getString("age");
							String name = rs.getString("name");
							String part = rs.getString("part");
							System.out.println(number + "\t"+ age + "\t"+ name + "\t"+ part + "\n");
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}// 관리자 전체출력
				
			} //전체출력
			else if (protocol == 0) {
				System.out.println("종료합니다. ");
				System.exit(0);
			} //종료
			else {
				System.out.println("번호를 다시 입력해주세요. ");
			} 
		} //while문
	}

}
