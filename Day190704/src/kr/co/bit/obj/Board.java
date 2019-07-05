package kr.co.bit.obj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Board {

	protected static BufferedReader br; 
	protected static Connection conn; 
	
	protected String sql;
	protected PreparedStatement pstmt; 
	protected ResultSet rs;
	protected int count; 
	
	protected String titleContent;
	protected int indexI; 
	
	protected int no;
	protected String title;
	protected String content;
	protected String author; 
	protected String nal;
	protected int readCount; 
	
	public Board() {
		no = 0;		title = null;	content = null; 	author = null; 		nal = null; 	readCount = 0; 
		sql = null; 	pstmt = null;	rs = null;		count = 0;		indexI = 0;
	}
	
	static {
		br = new BufferedReader(new InputStreamReader(System.in));
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}		
	}
	
	public static Connection getConnection() throws SQLException {
		conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE", "bitadmin", "dkdlxl");
		return conn;
	}
	
	public void setTitleContent() throws IOException {
		System.out.println("제목|내용: ");		
		titleContent = Board.br.readLine();
	}
	
	public void boardTitle() {
		System.out.println("번호 \t 제목 \t 내용 \t 작성자 \t 날짜 \t 조회수");
	}



}

interface constructorMethod {
	abstract void constructorexecute();
	}
	
interface processMethod {
	abstract void setBoard(); // ~�� �Խñ� ���� �Է�:
	abstract void setTitle(); // ��ȣ, ����, ����, �ۼ���,...
	abstract void setSql(); //
	abstract void executeSql();
	abstract void executeProcess();
	abstract void setClose();
	}

