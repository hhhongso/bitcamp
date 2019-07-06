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
							Class.forName("oracle.jdbc.OracleDriver"); //1. ����(�ε�)
							Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE", "bitadmin", "dkdlxl"); //2. ����
							
							if(conn != null) { // conn = null �� ���� ���� �� �ȵǳ�? conn �� �⺻���� null �̴ϱ� !
								System.out.println("OK");
								BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
									System.out.println("=====�л���� ������Ʈ=====");
									System.out.println("1. ��� 2. ã�� 3.����  4.����  5.��ü��� 0. ����");
									int protocol = Integer.parseInt(bf.readLine());
							
									if(protocol == 1) {
										System.out.println("1. �л���� 2. ������� 3. �����ڵ�� 4. �����޴���");
										protocol = Integer.parseInt(bf.readLine());
										if(protocol == 1) { //�л����
											System.out.println("�л� ��ȣ: ");									
											int no = Integer.parseInt(bf.readLine());
											System.out.println("�л� �̸�: ");
											String name = bf.readLine();
											System.out.println("�л� ����: ");
											String age = bf.readLine();
											System.out.println("�л� �й�: ");
											String idNum = bf.readLine();
											
//											System.out.println("�л� �̸�,����: ");
//											String nameAge = bf.readLine();
//											int indexI = nameAge.indexOf(","); // indexI = 5;
//											String name = nameAge.substring(0, indexI);
//											String age = nameAge.substring(indexI+1);
	
											//3-1. �����غ�
											String sql = "INSERT INTO HAKSASTUDENT (NO, NAME, AGE, IDNUM) VALUES (?,?,?,?)";
											//3-2. �����غ�							
											PreparedStatement pstmt = conn.prepareStatement(sql);
											pstmt.setInt(1, no);
											pstmt.setString(2, name);
											pstmt.setString(3, age);
											pstmt.setString(4, idNum);
											
											//4. ����
											int count = pstmt.executeUpdate();
											
											if(count == 0) {
												System.out.println("�л��� ��ϵ��� �ʾҽ��ϴ�. ");
											} else {
												System.out.println(count + "���� �л��� ��� �Ǿ����ϴ�. ");
												pstmt.close(); // 5. ���� 
												conn.close();
											}
											
										} //�л����
										else if(protocol == 2) {
											System.out.println("���� ��ȣ: ");
											int no = Integer.parseInt(bf.readLine());
											System.out.println("���� �̸�: ");
											String name = bf.readLine();
											System.out.println("���� ����: ");
											String age = bf.readLine();
											System.out.println("���� ����: ");
											String subject = bf.readLine();
																		
											String sql = "INSERT INTO HAKSAPROFESSOR (NO, NAME, AGE, SUBJECT) VALUES (?,?,?,?)";
																		
											PreparedStatement pstmt = conn.prepareStatement(sql);
											pstmt.setInt(1, no);
											pstmt.setString(2, name);
											pstmt.setString(3, age);
											pstmt.setString(4, subject);
											
											int count = pstmt.executeUpdate();
											
											if(count == 0) {
												System.out.println("������ ��ϵ��� �ʾҽ��ϴ�. ");
											} else {
												System.out.println(count + "���� ������ ��� �Ǿ����ϴ�. ");
												pstmt.close();
												conn.close();
											}
										}// �������
										else if (protocol == 3) {
											System.out.println("������ ��ȣ: ");
											int no = Integer.parseInt(bf.readLine());
											System.out.println("������ �̸�: ");
											String name = bf.readLine();
											System.out.println("������ ����: ");
											String age = bf.readLine();
											System.out.println("������ �μ�: ");
											String part = bf.readLine();
											
											String sql = "INSERT INTO HAKSAMANAGER (NO, NAME, AGE, PART) VALUES (?,?,?,?)";
																		
											PreparedStatement pstmt = conn.prepareStatement(sql);
											pstmt.setInt(1, no);
											pstmt.setString(2, name);
											pstmt.setString(3, age);
											pstmt.setString(4, part);
											
											int count = pstmt.executeUpdate();
											
											if(count == 0) {
												System.out.println("�����ڰ� ��ϵ��� �ʾҽ��ϴ�. ");
											} else {
												System.out.println(count + "���� �����ڰ� ��� �Ǿ����ϴ�. ");
												pstmt.close();
												conn.close();
											}// ������ ���
										}	
										else if (protocol == 4) {
											System.out.println("�����޴��� ���ư��ϴ�.. ");
											continue;
										} //�����޴���
									} // ���
									else if (protocol == 2) {
										System.out.println("1. �л� 2. ���� 3. ������");
										protocol = Integer.parseInt(bf.readLine());
																				
										if(protocol == 1) { //�л�ã��
											System.out.println("ã�� �̸��� �Է��ϼ���: ");
											String searchName = bf.readLine();
											System.out.println("��ȣ \t �̸� \t ���� \t �й� ");
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
										} //�л�ã��
										else if (protocol == 2) { //����ã��
											System.out.println("ã�� �̸��� �Է��ϼ���: ");
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
												
												System.out.println("��ȣ \t �̸� \t ���� \t ���� ");
												System.out.println(no + "\t" + name + "\t" + age + "\t" + subject);
											}
										} //����ã��
										else if (protocol == 3) { //������ã��
											System.out.println("ã�� �̸��� �Է��ϼ���: ");
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
												
												System.out.println("��ȣ \t �̸� \t ���� \t �μ� ");
												System.out.println(no + "\t" + name + "\t" + age + "\t" + part);
											}
										}//������ã��
										
									} // ã��
									else if(protocol == 3) {
										System.out.println("������ �̸��� �Է��ϼ���: ");
										String delName = bf.readLine();
										System.out.println("ã�� Ÿ���� �Է��ϼ���: 1. �л� 2. ���� 3. ������");
										protocol = Integer.parseInt(bf.readLine());
										
										if(protocol == 1) {
											String sql = "DELETE FROM HAKSASTUDENT WHERE NAME = ?";
											PreparedStatement pstmt = conn.prepareStatement(sql);
											pstmt.setString(1, delName);
											
											int count = pstmt.executeUpdate();
											if(count == 0) {
												System.out.println("������ �̸��� �����ϴ�. ");
											} else {
												System.out.println(count + "�� �����Ǿ����ϴ�. ");
											}
											
										}
										else if (protocol == 2){
											
										} 
										else if (protocol == 3) {
											
										}
										
									}//����
									else if (protocol == 4) { //����
										System.out.println("������ �̸��� �Է��ϼ���: ");
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
											
											System.out.println("��ȣ \t �̸� \t ���� \t �й� ");
											System.out.println(no + "\t" + name + "\t" + age + "\t" + idNum);
	
												
											System.out.println("������ ������ �Է��ϼ���..");
											System.out.println("�л� ��ȣ:�̸�:����:�й�");
											String updateStu = bf.readLine();
											sql = "UPDATE HAKSASTUDENT SET NO ";
											StringTokenizer stz = new StringTokenizer(updateStu, ":");
											
											while(stz.hasMoreTokens()) {											
												no = Integer.parseInt(stz.nextToken());
												age = stz.nextToken();
												name = stz.nextToken();
												idNum = stz.nextToken();																			
												
												System.out.println("��ȣ \t �̸� \t ���� \t �й� ");
												System.out.println(no + "\t" + name + "\t" + age + "\t" + idNum);
												
												System.out.println("�л� ���� ������Ʈ �Ϸ�");
											}
										}
										rs.close();
										pstmt.close();
										conn.close();
									}//����
									else if (protocol == 5) {//��ü���
										
										System.out.println("ã�� Ÿ���� �Է��ϼ���: 1. �л� 2. ���� 3. ������ 4. ��ü");
										protocol = Integer.parseInt(bf.readLine());
										
										if(protocol == 1) {//�л���ü���
											String sql = "SELECT NO, NAME, AGE, IDNUM FROM HAKSASTUDENT";
											PreparedStatement pstmt = conn.prepareStatement(sql);
											ResultSet rs = pstmt.executeQuery();
											
											while(rs.next()) {
												int no = rs.getInt("no");
												String age = rs.getString("age");
												String name = rs.getString("name");
												String idNum = rs.getString("idNum");
												System.out.println("��ȣ \t �̸� \t ���� \t �й� ");
												System.out.println(no + "\t" + name + "\t" + age + "\t" + idNum);
											}
										} //�л���ü���
										else if (protocol == 2) {
											String sql = "SELECT NO, NAME, AGE, SUBJECT FROM HAKSAPROFESSOR";
											PreparedStatement pstmt = conn.prepareStatement(sql);
											ResultSet rs = pstmt.executeQuery();
											
											while(rs.next()) {
												int no = rs.getInt("no");
												String age = rs.getString("age");
												String name = rs.getString("name");
												String subject = rs.getString("subject");
												System.out.println("��ȣ \t �̸� \t ���� \t ���� ");
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
												System.out.println("��ȣ \t �̸� \t ���� \t �μ� ");
												System.out.println(no + "\t" + name + "\t" + age + "\t" + part);
										}
									}//������ ��ü���
										
									} //��ü���
									else if(protocol == 0) {
										System.out.println("�����մϴ�. ");
										System.exit(0);
									}
									//else {
									//	System.out.println("�߸��� ��ȣ �Է� ");
									//} //�߸��� �Է� ó��
									
								
							} else {
								System.out.println("fail ");
							}//DB���� ��

					
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