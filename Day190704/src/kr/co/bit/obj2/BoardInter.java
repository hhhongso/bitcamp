package kr.co.bit.obj2;

import java.io.IOException;
import java.sql.SQLException;

public interface BoardInter {
	public abstract void boardSql(); 
	public abstract void boardQuery() throws SQLException; //����ó���κб��� ����� �� �־�� ?
	public abstract void boardProcess() throws IOException, SQLException;
	public abstract void boardClose();
}
