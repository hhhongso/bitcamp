package kr.co.bit.db;
/*
 * 데이터베이스 ! 
 * 
 * SQL에서 
 * CREATE TABLE
 * DROP TABLE
 * 
 * INSERT INTO (TABLE) 변수 이름 values 변수 값
 * DELETE FROM (TABLE)
 * 
 * SELECT 변수이름 FROM (TABLE)
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DBtest {

	public static void main(String[] args) {		
		/* 1. 로드(적재): 자바에게 "오라클을 사용하겠다"라고 알려주어야 함  ==> Class.forName("오라클 사용 경로") 
																// 오라클경로는: lib폴더의 ojdbc.jar > oracle > jdbc > driver > OracleDriver
		 	==> 예외처리까지 완료 (블록설정 - 우클릭 - surround with - try/catch block)
			2. 연결(Connection Interface): url(경로인식) / userID / PW (Connection conn = DriverManager.getConnection("url", "id", "pw");
		 * 3. 준비(Statement) 
		 * 		3-1. 공간 준비: Statement stmt = conn.createStatement();
		 * 		3-2. 문장 준비 (쿼리 준비): String sql = "select / delete / insert / ~~~~";
		 * 4. 실행 (Execute)
		 * 		1) executeUpdate(); : 등록/ 삭제/ 수정 시 사용
		 * 		2) executeQuery(); : 검색/ 목록 
		 * 5. 종료 (conn.close, stmt.close)
		 */
		Scanner scan = new Scanner(System.in);
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); //Class.forName("오라클 사용 경로") 
			while(true) {
				Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE", "bitadmin", "dkdlxl"); // 연결
													// 경로: DB source page - properties - driver properties - connection url
				
				System.out.println("1. 등록 2. 삭제 3. 전체출력 4. 검색");
				int protocol = scan.nextInt();
				
				if (conn == null) {
					System.out.println("데이터 베이스 연결 실패");
				} else if (protocol == 1) { //등록 
					
					System.out.println("데이터 베이스 연결 성공 !");
					System.out.println("학생등록");
					System.out.println("번호 입력: ");
					int no = scan.nextInt();
					System.out.println("나이: ");
					String age = scan.next();
					System.out.println("이름: ");
					String name = scan.next();
					System.out.println("학번: ");
					String hakbun = scan.next();
					
					Statement stmt = conn.createStatement(); // 공간 준비
					// java.sql의 statement을 사용하여야 함 ! 						//primary key 는 두개 이상의 키가 중복되어 사용될 수 없기 때문에, 
																				// 190624.SQL 에서 INSERT 값이 있었다면 DELETE FROM 으로 지워주어야 함
																				// 두번 연속 같은 키 값으로 실행할 경우 unique constraint 오류 
					
																					// " +no+ " : DB안에서 변수 인정.
					String sql = "insert into student(no, age, name, hakbun) values ("+no+", '"+age+"', '"+name+"', '"+hakbun+"')"; // 문장 준비 (=쿼리 준비)
					int cnt = stmt.executeUpdate(sql); 
								// 실행 함수 executeUpdate() : int 정수형이 return type으로 만들어져 있음 
					
					if(cnt == 0) {
						System.out.println("등록이 실패되었습니다. ");
					} else {
						System.out.println(cnt + "건 학생이 등록되었습니다. ");
						conn.close(); // 등록 후 종료 
						stmt.close();
					} 
					
				} else if (protocol == 2) {
					System.out.println("학생 삭제");
					System.out.println("삭제할 이름을 입력해주세요: ");
					String nameDelete = scan.next();
					Statement stmt = conn.createStatement(); // 공간 준비
													//where + 조건
					String sql = "DELETE FROM STUDENT WHERE name = '"+nameDelete+"'"; // 쿼리 준비
					int cnt = stmt.executeUpdate(sql);
					if(cnt == 0) {
						System.out.println("학생 삭제 실패");
					} else {
						System.out.println(cnt + "건 학생 삭제되었습니다. ");
						conn.close(); //삭제 후 종료
						stmt.close();
					}
				} // protocol == 2 (삭제) 종료 
				else if (protocol == 3) {   //전체출력
					System.out.println("전체 출력");
					System.out.print("번호 \t 나이 \t 이름 \t 학번 \n");
					Statement stmt = conn.createStatement();// 공간 준비
																			//ORDER BY NO ASC(Ascembly): 오름차순 정렬
					String sql = "SELECT NO, AGE, NAME, HAKBUN FROM STUDENT ORDER BY NO ASC"; // 쿼리 준비
					ResultSet rs = stmt.executeQuery(sql);
					//java.sql의 resultSet		//executeQuery 의 return type이 resultSet
					// rs == table 
					while(rs.next()) {
						int no = rs.getInt("no");
						String age = rs.getString("age");
						String name = rs.getString("name");
						String hakbun = rs.getString("hakbun");
						System.out.print(no + "\t" + age + "\t" + name + "\t" + hakbun + "\n");
					}
					conn.close();
					stmt.close();
				} // protocol == 3 (전체출력) 종료 
				else if (protocol == 4) {  //찾기
					System.out.println("학생 찾기");
					System.out.println("찾을 이름을 입력해주세요: ");
					String nameSearch = scan.next();
					System.out.print("번호 \t 나이 \t 이름 \t 학번 \n");
					Statement stmt = conn.createStatement();
					String sql = "SELECT NO, AGE, NAME, HAKBUN FROM STUDENT WHERE NAME = '"+nameSearch+"'";
					ResultSet rs = stmt.executeQuery(sql);
					
					while(rs.next()) {
						int no = rs.getInt("no");
						String age = rs.getString("age");
						String name = rs.getString("name");
						String hakbun = rs.getString("hakbun");
						System.out.print(no + "\t" + age + "\t" + name + "\t" + hakbun + "\n");
					}
					conn.close();
					stmt.close();
				} // protocol == 4 (찾기) 종료 
			} // while문
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}

