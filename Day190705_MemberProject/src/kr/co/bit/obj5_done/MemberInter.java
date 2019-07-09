package kr.co.bit.obj5_done;

import java.sql.SQLException;

public interface MemberInter {

	public abstract void setSql();
	public abstract void setQuery() throws SQLException; 
	public abstract void execute() throws SQLException;
	public abstract void close() throws SQLException;

}

