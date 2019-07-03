package kr.co.bit;
/*
 * Tokenizer: 원하는 단위대로 끊어서 사용하도록 하는 클래스
 * countTokens()               토큰의 갯수를 리턴한다.
	nextToken()                다음 토큰을 리턴한다. 이전 토큰은 제거한다.
	nextToken(String delim)    구획문자(delimiter)를 delim으로 바꾼 후 바뀐 다음 토큰을 리턴한다. 
								예를들어 this$1is$1string 이라고 하면 생성자에서 구획문자를$1로 설정했다가 nextToken으로 this를 받고 
								2번째 nextToken은 delim을 $로 받으면(nextToken("$")) 1is를 리턴한다.
	hasMoreTokens()            리턴할 다음 토큰이 있으면 true를 다음 토큰이 없으면 false를 리턴한다.
 */
import java.util.StringTokenizer;

public class TokenizerTest {

	public static void main(String[] args) {
		String source1 = "111-123|강원도|춘천시|퇴계동"; //구분의 디폴트는 공백( )
		StringTokenizer st1 = new StringTokenizer(source1, "|"); 
//		String postCode = st1.nextToken();
//		String province = st1.nextToken();
//		String city = st1.nextToken();
//		String add = st1.nextToken();
//		System.out.println("우편번호: " + postCode);
//		System.out.println("도: " + province);
//		System.out.println("시: " + city);
//		System.out.println("동: " + add);
		
		while(st1.hasMoreTokens()) {
			System.out.println(st1.nextToken());
		}
	}

}
