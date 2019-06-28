package kr.co.bit.db;
/*
 * �����ͺ��̽� ! 
 * 
 * SQL���� 
 * CREATE TABLE
 * DROP TABLE
 * 
 * INSERT INTO (TABLE) ���� �̸� values ���� ��
 * DELETE FROM (TABLE)
 * 
 * SELECT �����̸� FROM (TABLE)
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DBtest {

	public static void main(String[] args) {		
		/* 1. �ε�(����): �ڹٿ��� "����Ŭ�� ����ϰڴ�"��� �˷��־�� ��  ==> Class.forName("����Ŭ ��� ���") 
																// ����Ŭ��δ�: lib������ ojdbc.jar > oracle > jdbc > driver > OracleDriver
		 	==> ����ó������ �Ϸ� (��ϼ��� - ��Ŭ�� - surround with - try/catch block)
			2. ����(Connection Interface): url(����ν�) / userID / PW (Connection conn = DriverManager.getConnection("url", "id", "pw");
		 * 3. �غ�(Statement) 
		 * 		3-1. ���� �غ�: Statement stmt = conn.createStatement();
		 * 		3-2. ���� �غ� (���� �غ�): String sql = "select / delete / insert / ~~~~";
		 * 4. ���� (Execute)
		 * 		1) executeUpdate(); : ���/ ����/ ���� �� ���
		 * 		2) executeQuery(); : �˻�/ ��� 
		 * 5. ���� (conn.close, stmt.close)
		 */
		Scanner scan = new Scanner(System.in);
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); //Class.forName("����Ŭ ��� ���") 
			while(true) {
				Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE", "bitadmin", "dkdlxl"); // ����
													// ���: DB source page - properties - driver properties - connection url
				
				System.out.println("1. ��� 2. ���� 3. ��ü��� 4. �˻�");
				int protocol = scan.nextInt();
				
				if (conn == null) {
					System.out.println("������ ���̽� ���� ����");
				} else if (protocol == 1) { //��� 
					
					System.out.println("������ ���̽� ���� ���� !");
					System.out.println("�л����");
					System.out.println("��ȣ �Է�: ");
					int no = scan.nextInt();
					System.out.println("����: ");
					String age = scan.next();
					System.out.println("�̸�: ");
					String name = scan.next();
					System.out.println("�й�: ");
					String hakbun = scan.next();
					
					Statement stmt = conn.createStatement(); // ���� �غ�
					// java.sql�� statement�� ����Ͽ��� �� ! 						//primary key �� �ΰ� �̻��� Ű�� �ߺ��Ǿ� ���� �� ���� ������, 
																				// 190624.SQL ���� INSERT ���� �־��ٸ� DELETE FROM ���� �����־�� ��
																				// �ι� ���� ���� Ű ������ ������ ��� unique constraint ���� 
					
																					// " +no+ " : DB�ȿ��� ���� ����.
					String sql = "insert into student(no, age, name, hakbun) values ("+no+", '"+age+"', '"+name+"', '"+hakbun+"')"; // ���� �غ� (=���� �غ�)
					int cnt = stmt.executeUpdate(sql); 
								// ���� �Լ� executeUpdate() : int �������� return type���� ������� ���� 
					
					if(cnt == 0) {
						System.out.println("����� ���еǾ����ϴ�. ");
					} else {
						System.out.println(cnt + "�� �л��� ��ϵǾ����ϴ�. ");
						conn.close(); // ��� �� ���� 
						stmt.close();
					} 
					
				} else if (protocol == 2) {
					System.out.println("�л� ����");
					System.out.println("������ �̸��� �Է����ּ���: ");
					String nameDelete = scan.next();
					Statement stmt = conn.createStatement(); // ���� �غ�
													//where + ����
					String sql = "DELETE FROM STUDENT WHERE name = '"+nameDelete+"'"; // ���� �غ�
					int cnt = stmt.executeUpdate(sql);
					if(cnt == 0) {
						System.out.println("�л� ���� ����");
					} else {
						System.out.println(cnt + "�� �л� �����Ǿ����ϴ�. ");
						conn.close(); //���� �� ����
						stmt.close();
					}
				} // protocol == 2 (����) ���� 
				else if (protocol == 3) {   //��ü���
					System.out.println("��ü ���");
					System.out.print("��ȣ \t ���� \t �̸� \t �й� \n");
					Statement stmt = conn.createStatement();// ���� �غ�
																			//ORDER BY NO ASC(Ascembly): �������� ����
					String sql = "SELECT NO, AGE, NAME, HAKBUN FROM STUDENT ORDER BY NO ASC"; // ���� �غ�
					ResultSet rs = stmt.executeQuery(sql);
					//java.sql�� resultSet		//executeQuery �� return type�� resultSet
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
				} // protocol == 3 (��ü���) ���� 
				else if (protocol == 4) {  //ã��
					System.out.println("�л� ã��");
					System.out.println("ã�� �̸��� �Է����ּ���: ");
					String nameSearch = scan.next();
					System.out.print("��ȣ \t ���� \t �̸� \t �й� \n");
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
				} // protocol == 4 (ã��) ���� 
			} // while��
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}

