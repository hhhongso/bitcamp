import java.net.InetAddress;
import java.net.UnknownHostException;

class InetAddressTest {
	public static void main(String[] args) throws UnknownHostException {
		// IP추적
		InetAddress naver = InetAddress.getByName("www.naver.com");
							//new로 생성 불가 => 메소드로 생성하기 
		System.out.println("Naver IP: " + naver.getHostAddress());
		System.out.println();
		// 내 IP 보기
		InetAddress local = InetAddress.getLocalHost();
		System.out.println("LocalHost IP: " + local.getHostAddress());
		System.out.println();
		
		InetAddress[] ar = InetAddress.getAllByName("www.daum.net");
		for(InetAddress data : ar){
			System.out.println("Daum IP: " + data.getHostAddress());
		}

	}
}
