package kr.co.bit.obj1;

import java.io.BufferedReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Board {

	protected BufferedReader br; 
	protected Connection conn; 
	
	protected String sql;
	protected PreparedStatement pstmt; 
	protected ResultSet rs;
	
	protected int no;
	protected String title;
	protected String content;
	protected String author; 
	protected String nal;
	protected int readCount; 
	
	protected int count; 
}



	
interface constructorMethod {
	abstract void constructorexecute();
	}
	
interface processMethod {
	abstract void setBoard(); // ~할 게시글 제목 입력:
	abstract void setTitle(); // 번호, 제목, 내용, 작성자,...
	abstract void setSql(); //
	abstract void executeSql();
	abstract void executeProcess();
	abstract void setClose();
	}

