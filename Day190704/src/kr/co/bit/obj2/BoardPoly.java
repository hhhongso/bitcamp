package kr.co.bit.obj2;

import java.io.IOException;
import java.sql.SQLException;

public class BoardPoly  {
						//�θ�Ŭ����[�߻�Ŭ����]�� �Ķ���� Ÿ�� ���� >> register~update ��� �ڽ� Ŭ������ ��ü�� �������̵��Ͽ� ����� �� ���� 
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
