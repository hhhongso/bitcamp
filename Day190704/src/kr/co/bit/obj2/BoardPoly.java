package kr.co.bit.obj2;

import java.io.IOException;
import java.sql.SQLException;

public class BoardPoly  {
						//부모클래스[추상클래스]로 파라미터 타입 규정 >> register~update 모든 자식 클래스의 객체가 오버라이드하여 사용할 수 있음 
	public void boardSQL(BoardInter boardint) { 
		boardint.boardSql();
	}
	
	public void boardCLOSE(BoardInter boardint) {
		boardint.boardClose();
	}
	
	public void boardQUERY(BoardInter boardint) throws SQLException {
		boardint.boardQuery();
	}
	
//	public void boardProcess(BoardInter boardint) throws IOException, SQLException {
//		boardint.boardProcess();
//	}
//	
}
