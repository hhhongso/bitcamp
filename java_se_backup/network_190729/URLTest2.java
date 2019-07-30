import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

class URLTest2 {
	public static void main(String[] args) throws IOException, MalformedURLException {
		URL url = new URL("https://www.chanel.com/ko_KR/watches-jewelry/fine-jewelry/c/rings/J001000?show=All");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
		String data;
		int count =0;
		int index =0;
		String str = "18K";

		while((data = br.readLine()) != null) {
//			contains �δ� �� �ٿ� 2�� �ִ� ��츦 ���� �� ���� 
//			if(data.contains("18K") || data.contains("18k")) count++;

		//���ڿ� ������ ������ �ε����κ��� �˻��� �����ؼ� ������ ���ڰ� ���ʷ� �����ϴ� ��ġ�� �ε����� �����Ѵ�.
			while(true) {
				index = data.indexOf(str, index);
				if(index != -1){
					count++;
					index=index + str.length();
				}
				else break;	
			}
		}//while


		//����ǥ����
//		Pattern pattern = Pattern.compile("[0-9a-zA-Z]{3,3}");
//		Matcher matcher = pattern.matcher("[18K]");
//		if(matcher.matches()) count++;
	

		System.out.println("18K/ 18k�� ����:" + count); //82
	

		br.close();
	}
}
