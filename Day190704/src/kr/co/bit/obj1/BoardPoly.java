package kr.co.bit.obj1;

public class BoardPoly {
						//부모클래스[추상클래스]로 파라미터 타입 규정 >> register~update 모든 자식 클래스의 객체가 오버라이드하여 사용할 수 있음 
	public void boardSQL(Board board) { 
		board.boardSql();
	}
	
	public void boardCLOSE(Board board) {
		board.boardClose();
	}
	
	public void boardQUERY() {
		
	}
	
}
