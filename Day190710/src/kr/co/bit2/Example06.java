package kr.co.bit2;

import java.net.InetAddress;

public class Example06 {
	public static void main(String[] args) {
		try {
			//127.0.0.1 : 나 자신을 가리키는 IP주소 
			InetAddress iaddr = InetAddress.getLocalHost();
			System.out.println("호스트 이름: " + iaddr.getHostName());
			System.out.println("호스트 주소: " + iaddr.getHostAddress());
			iaddr = InetAddress.getByName("www.daum.net");
			System.out.println("호스트 이름: " + iaddr.getHostName());
			System.out.println("호스트 주소: " + iaddr.getHostAddress());
			InetAddress[] sw = InetAddress.getAllByName("www.daum.net");
			for(InetAddress sw_temp : sw) {
				System.out.println("호스트 이름: " + sw_temp.getHostName());
				System.out.println("호스트 주소: " + sw_temp.getHostAddress());
					
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
