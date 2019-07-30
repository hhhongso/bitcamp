import java.net.InetAddress;
import java.net.UnknownHostException;

class InetAddressTest {
	public static void main(String[] args) throws UnknownHostException {
		// IP����
		InetAddress naver = InetAddress.getByName("www.naver.com");
							//new�� ���� �Ұ� => �޼ҵ�� �����ϱ� 
		System.out.println("Naver IP: " + naver.getHostAddress());
		System.out.println();
		// �� IP ����
		InetAddress local = InetAddress.getLocalHost();
		System.out.println("LocalHost IP: " + local.getHostAddress());
		System.out.println();
		
		InetAddress[] ar = InetAddress.getAllByName("www.daum.net");
		for(InetAddress data : ar){
			System.out.println("Daum IP: " + data.getHostAddress());
		}

	}
}
