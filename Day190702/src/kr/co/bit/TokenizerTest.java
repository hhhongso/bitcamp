package kr.co.bit;
/*
 * Tokenizer: ���ϴ� ������� ��� ����ϵ��� �ϴ� Ŭ����
 * countTokens()               ��ū�� ������ �����Ѵ�.
	nextToken()                ���� ��ū�� �����Ѵ�. ���� ��ū�� �����Ѵ�.
	nextToken(String delim)    ��ȹ����(delimiter)�� delim���� �ٲ� �� �ٲ� ���� ��ū�� �����Ѵ�. 
								������� this$1is$1string �̶�� �ϸ� �����ڿ��� ��ȹ���ڸ�$1�� �����ߴٰ� nextToken���� this�� �ް� 
								2��° nextToken�� delim�� $�� ������(nextToken("$")) 1is�� �����Ѵ�.
	hasMoreTokens()            ������ ���� ��ū�� ������ true�� ���� ��ū�� ������ false�� �����Ѵ�.
 */
import java.util.StringTokenizer;

public class TokenizerTest {

	public static void main(String[] args) {
		String source1 = "111-123|������|��õ��|��赿"; //������ ����Ʈ�� ����( )
		StringTokenizer st1 = new StringTokenizer(source1, "|"); 
//		String postCode = st1.nextToken();
//		String province = st1.nextToken();
//		String city = st1.nextToken();
//		String add = st1.nextToken();
//		System.out.println("�����ȣ: " + postCode);
//		System.out.println("��: " + province);
//		System.out.println("��: " + city);
//		System.out.println("��: " + add);
		
		while(st1.hasMoreTokens()) {
			System.out.println(st1.nextToken());
		}
	}

}
