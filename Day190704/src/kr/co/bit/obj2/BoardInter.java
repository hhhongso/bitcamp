package kr.co.bit.obj2;

import java.io.IOException;
import java.sql.SQLException;

public interface BoardInter {
	public abstract void boardSql(); 
	public abstract void boardQuery() throws SQLException; //예외처리부분까지 상속을 해 주어야 ?
	public abstract void boardProcess() throws IOException, SQLException;
	public abstract void boardClose();
}
