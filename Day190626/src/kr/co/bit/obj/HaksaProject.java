package kr.co.bit.obj;

/*
 * DB
 * �迭�� �޸� ��� DB�� �����ϱ� - ���ڵ� 
 */

/* 1. �ε�(����) : �ڹٿ��� DB ����Ŭ�� ����� ���̶�� �˷��ִ� �ܰ� 
 * 		lib ���� ���� �� ojdbc6 �����صα� : ��� C:\Program Files\Java\jdk1.8.0_211\jre\lib\ext
 * 									Ȥ�� C:\oraclexe\app\oracle\product\11.2.0\server\jdbc\lib
 * 		��Ŭ�� - build path - add
 * 
 * 2. ����(Connection)
 * 		DriverManager Ŭ������ ��Ʈ���Ѵ�. 
 * 
 * 3. �غ� 
 * 	3-1. �����غ�
 * 	3-2. �����غ� (�����غ�)
 * 
 * 4. ����
 *  1) executeUpdate(): ���, ����, ����  
 *  2) executeQuery(): ã��, ���
 *  
 *  ����ó�� �������ֱ� (��Ŭ�� - source - surround with - try/catch block
 */

/*
 * DB ���������� open scrapBook �� ���̺� �ۼ�
 * TABLE �ۼ� �ÿ��� JAVA �ܿ��� ���� ������ �̸�(number, age, name, idNum)�� �������, ���̺��� ����� �̸��� �̿��ؾ� �Ѵ�. 
 * file - save as - ���ϸ�.sql >>> javaProject Folder�� ����  >> javaEE ���� Ȯ�� 
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
						//DB���� ����/���� Ȯ�ο����� �������� conn�� �� �� ����߱� ������, �Լ� �ۿ��� �ʱ�ȭ ���Ѿ� 3-1. ������ ����� �� ���� 
	
		while(true) {
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				//url: �ڹ�ȭ�鿡�� connect �Ǿ��ִ� new oracle �뿡�� ������ 
				conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE", "bitadmin", "dkdlxl");
				if (conn == null) {
					System.out.println("�����ͺ��̽� ���� ���� ");
				} else {
					System.out.println("�����ͺ��̽� ���� ���� ~ ");
				}
			} catch (ClassNotFoundException e) { 	//Class.forName ���� ��Ű�� �ּ� or Ŭ�������� Ʋ�� => ���� Ŭ����or��Ű���� ã���� �ϴ� Ŭ������ ã�� �� ���ٴ� ���ܰ� �� 
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) { 						//SQL���� ���ܸ� ĳġ�� 
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			/*
			 * conn�� ? 
			 * ����Ű�� ����.  ====> Database XE ���� ����Ų��. 
			 */
			System.out.println("=========�л� ���� �޴�=========");
			System.out.println("1. ���");
			System.out.println("2. ã��");
			System.out.println("3. ����");
			System.out.println("4. ��ü���");
			System.out.println("0. ����");
			System.out.println("============================");
			System.out.println("��ȣ ����: ");
			int protocol = scan.nextInt();
			if(protocol == 1) {
				System.out.println("=======��� �޴�=======");
				System.out.println("1. �л�"); // ���̺� ����ϱ�
				System.out.println("2. ����");
				System.out.println("3. ������");
				System.out.println("4. �����޴�");
				System.out.println("=====================");
				System.out.println("��ȣ ����: ");
				protocol = scan.nextInt();
				
				if(protocol == 1) {
					System.out.println("��ȣ�Է�: ");
					int number = scan.nextInt();
					System.out.println("����: ");
					String age = scan.next();
					System.out.println("�̸�: ");
					String name = scan.next();
					System.out.println("�й�: ");
					String idNum = scan.next();
					
					try {
						Statement stmt = conn.createStatement(); // 3-1. �����غ�
										//�� �κ��� ��ҹ��� ������� ���� �� ������ �����ͺ��̽��̸��� ���ƾ��ϸ�	// �� ������ �̸��� ��� �����Ѵ�� ��ҹ��ڸ� �������־�� �Ѵ�. 
						String sql = "INSERT INTO STUDENT(NO, AGE, NAME, HAKBUN) VALUES ("+number+", '"+age+"', '"+name+"', '"+idNum+"')"; // 3-2. �����غ�
																						//������ ������ �־��ش�. 
						int cnt = stmt.executeUpdate(sql);
						System.out.println(cnt + "�� �л��� ��ϵǾ����ϴ�. ");
										
						conn.close();
						stmt.close(); // ����
					} catch (SQLException e) {	
						e.printStackTrace();
					}
				} //�л�
				
				else if (protocol == 2) {
					try {
						System.out.println("��ȣ�Է�: ");
						int number = scan.nextInt();
						System.out.println("����: ");
						String age = scan.next();
						System.out.println("�̸�: ");
						String name = scan.next();
						System.out.println("����: ");
						String subject = scan.next();
						
						Statement stmt = conn.createStatement();
						String sql = "INSERT INTO PROFESSOR (NO, AGE, NAME, SUBJECT) VALUES ("+number+", '"+age+"', '"+name+"', '"+subject+"')";
						
						int cnt = stmt.executeUpdate(sql);
						if(cnt == 1) {
							System.out.println(cnt +"�� ������ ��ϵǾ����ϴ�. ");
							stmt.close();
							conn.close(); // ���� �ݵ�� ���ֶ� 
						} else {
							System.out.println("���� ��� ����");
						}
						
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}// ����
				else if(protocol == 3) {
					
						System.out.println("��ȣ�Է�: ");
						int number = scan.nextInt();
						System.out.println("����: ");
						String age = scan.next();
						System.out.println("�̸�: ");
						String name = scan.next();
						System.out.println("�μ�: ");
						String part = scan.next();
					try {
						Statement stmt = conn.createStatement();
						String sql = "INSERT INTO MANAGER (NO, AGE, NAME, PART) VALUES ("+number+", '"+age+"', '"+name+"', '"+part+"')";
						
						int cnt = stmt.executeUpdate(sql);
						if (cnt == 0) {
							System.out.println("������ ��� ���� ");
						} else {
							System.out.println(cnt + "�� �����ڰ� ��� �Ǿ����ϴ�. ");							
						}
						
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}//������
			} //���
			
			else if (protocol == 2) { //ã��
				System.out.println("1. �л� ã�� 2. ���� ã�� 3. ������ ã��");
				int choice = scan.nextInt();
				System.out.println("ã�� �̸��� �Է��ϼ���: ");
				String searchName = scan.next();
				
				if (choice == 1) { // �л�ã�� 
					System.out.print("��ȣ \t ���� \t �̸� \t �й� \n");
					try {
						Statement stmt = conn.createStatement();
						String sql = "SELECT NO, AGE, NAME, HAKBUN FROM STUDENT WHERE NAME = '"+searchName+"'";
								
						ResultSet rs = stmt.executeQuery(sql);
						//ResultSet rs�����ͺ��� > ����Ű�� ���� �� ���̺� > STUDENT
						
							// next(): ���� �ٷ� �̵��϶�. >> rs ������ >> (STUDNET)���̺� ���� 1�پ� �̵�
						while(rs.next()) {
							// �˻����� �ϳ��� �־���Ѵ�.(��������) >> ��ü��� ������ �ϴ� ����
							int number = rs.getInt("no");
							String age = rs.getString("age");
							String name = rs.getString("name");
							String idNum = rs.getString("hakbun");
							System.out.print(number + "\t"+ age + "\t"+ name + "\t"+ idNum + "\n");
						}
					} catch (SQLException e) {
						e.printStackTrace();
					}
					
				} // �л�ã�� 
				else if (choice == 2) {
					System.out.print("��ȣ \t ���� \t �̸� \t ���� \n");
					try {
						Statement stmt = conn.createStatement();
						String sql = "SELECT NO, AGE, NAME, SUBJECT FROM PROFESSOR WHERE NAME = '"+searchName+"'";
								
						ResultSet rs = stmt.executeQuery(sql);
						
						while(rs.next()) { 								//if�̸� �ȵǳ� ?
							int number = rs.getInt("no");
							String name = rs.getString("name");
							String age = rs.getString("age");
							String subject = rs.getString("subject");
							System.out.print(number + "\t"+ age + "\t"+ name + "\t"+ subject + "\n");
						}
					} catch (SQLException e) {
						e.printStackTrace();
					}
				} // ����ã��
				else if (choice == 3) {
					System.out.print("��ȣ \t ���� \t �̸� \t �μ� \n");
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
				} // ������ ã��
			} //ã��
			
			else if (protocol == 3) { //����
				
					System.out.println("1. �л� ���� 2. ���� ���� 3. ������ ����");
					int choice = scan.nextInt();
					System.out.println("������ �̸��� �Է��ϼ���: ");
					String name = scan.next();
					
					if(choice == 1) {
						try {
							Statement stmt = conn.createStatement();				
							String sql = "DELETE FROM STUDENT WHERE NAME ='"+name+"'";
							
							int cnt = stmt.executeUpdate(sql);
							if (cnt == 0) {
								System.out.println("���� ���� = ã�� �̸��� �����ϴ�. ");
							} else {
								System.out.println(cnt + "�� �л� �����Ǿ����ϴ�.");
								conn.close();
								stmt.close();
							}
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
//						if(name.equals("name")) { >>>> �̰� �ƴ϶� DB�ϱ� "DELETE~~~ WHERE NAME ���� ���� ����ش�. 
//						}
						
					} // �л� ����
					else if (choice == 2) {
						try {
							Statement stmt = conn.createStatement();
							String sql = "DELETE FROM PROFESSOR WHERE NAME '"+name+"'";
							int cnt = stmt.executeUpdate(sql);
							
							if(cnt == 0) { 								
								System.out.println("���� ���� ���� - ã�� �̸��� �����ϴ�. ");
							} else {
								System.out.println(cnt + "�� ���� ���� �Ǿ����ϴ�. ");
								conn.close();
								stmt.close();
							}
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}// ���� ����
					else if (choice == 3) {
						try {
							Statement stmt = conn.createStatement();
							String sql = "DELETE FROM MANAGER WHERE NAME '"+name+"'";
							int cnt = stmt.executeUpdate(sql);
							 											// CNT = count (�������� ) === > ���������� ��, cnt = 2
							if(cnt == 0) {
								System.out.println("������ ���� ���� - ã�� �̸��� �����ϴ�. ");
							} else {
								System.out.println(cnt + "�� ������ ���� �Ǿ����ϴ�. ");
								conn.close();
								stmt.close();
							}
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					} //������ ����
				
			} //����
			else if (protocol == 4) { // ��ü���
				//�ε�� �� �Ǿ�����. �غ� & ���ุ ó���ϸ� �ȴ�. 
				System.out.println("��ü ���");
				System.out.println("1. �л� ��ü��� 2. ���� ��ü��� 3. ������ ��ü���"); // ��ü ��ü�����, join �� �̿��Ͽ��� �Ѵ�. 
				int choice  = scan.nextInt();
					
				if(choice == 1) {
					try {
						System.out.print("��ȣ \t ���� \t �̸� \t �й� \n");
						
						Statement stmt = conn.createStatement();				// ASC �������� ���� <-> DESC �������� ����
						String sql = "SELECT NO, AGE, NAME, HAKBUN FROM STUDENT ORDER BY NO ASC";
						ResultSet rs = stmt.executeQuery(sql); 
						
						while(rs.next()) {
						// java���� ������			//DB���� ������
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
				} // �л� ��ü��� 
				else if (choice == 2) {
					System.out.print("��ȣ \t ���� \t �̸� \t ���� \n");
					
					try {
						Statement stmt = conn.createStatement();							
						String sql = "SELECT NO, AGE, NAME, SUBJECT FROM PROFESSOR ORDER BY NO DESC";
						ResultSet rs = stmt.executeQuery(sql);
						
						/*
						 * rs.next() �� ���� ��ġ���� 1���� ���� �̵���Ű�µ�, ���� �ڷᰡ ������ true, ������ false �� ���ϵ˴ϴ�.
							�ǵ��Ͻô� ����� ���� while(rs.next()) �̷��� �ڵ��ؾ� �ϴ� *����*��, ��� ���ڵ带 �����ϰ� �� �б� ���ؼ���� �����Ǳ���. (if�� ����� ��� 1�� ���� �������Ե�)
							while() �������� while(boolean) ���� boolean ���� false �̸� ������ ������ �˴ϴ�.
							���� �� ������ �����ϽŴٸ� ���� ���� ���� - while(rs.next()) -������ ¦/Ȧ����° ���ڵ常, Ư�� ��ġ�� ���ڵ常 ������ �� �ִ� ����� �������ǰ̴ϴ�.
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
				}// ���� ��ü���
				else if (choice == 3) {
					System.out.print("��ȣ \t ���� \t �̸� \t �μ� \n");
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
					
				}// ������ ��ü���
				
			} //��ü���
			else if (protocol == 0) {
				System.out.println("�����մϴ�. ");
				System.exit(0);
			} //����
			else {
				System.out.println("��ȣ�� �ٽ� �Է����ּ���. ");
			} 
		} //while��
	}

}
