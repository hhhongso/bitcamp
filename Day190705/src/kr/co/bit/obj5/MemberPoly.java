package kr.co.bit.obj5;

import java.io.IOException;
import java.sql.SQLException;

/*1. 인터페이스 만들기(추상 메소드)
 * 2. 폴리 클래스 만들기
 * 3. 메인메소드에 폴리 객체 생성
 * 4. 하위 클래스에 implements 
 * 5. @override 재정의
 * 6. try-catch
 * 
 * 
 * *** implements로 받을 시, 해당 인터페이스에 있는 추상 메소드를 모두 구현 하여야 한다. 
 */
public class MemberPoly {

	public void setSql(MemberInter memInter) {
		memInter.setSql();		
	}
	
	public void setQuery(MemberInter memInter) throws SQLException{
		memInter.setQuery();		
	}


	public void execute(MemberInter memInter) throws SQLException{
		memInter.execute();		
	}


	public void close(MemberInter memInter) throws SQLException{
		memInter.close();		
	}

	public void isLogin(LoginInter logInter) {
		logInter.isLogin();
	}
	
	public void set(SetInter setInter) throws IOException {
		setInter.set();		
	}
	

}
