import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.net.MalformedURLException;
import java.net.URL;

class URLTest {
	public static void main(String[] args) throws IOException, MalformedURLException {
		URL url = new URL("https://www.naver.com/index.html");
		System.out.println("��������:" + url.getProtocol());
		System.out.println("ȣ��Ʈ:" + url.getHost());
		System.out.println("��Ʈ:" + url.getPort()); //��Ʈ��ȣ�� �������� ����(����) => -1
		System.out.println("�⺻ ��Ʈ:" + url.getDefaultPort()); //����Ʈ
		System.out.println("����:" + url.getFile());
		System.out.println();

		BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
		String line = null;
		while((line = br.readLine()) != null){
			System.out.println(line);
		}
		br.close();


	}
}
