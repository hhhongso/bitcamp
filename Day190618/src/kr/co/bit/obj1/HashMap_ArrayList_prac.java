package kr.co.bit.obj1;

import java.util.ArrayList;
import java.util.HashMap;

public class HashMap_ArrayList_prac {
	public static void main(String[] args) {
	ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
	/* ArrayList�� ����
	 * ArrayList�� HashMap Ÿ���� �־��� ��ȹ�̸�, 
	 * HashMap�� key(String��), value(String��)
	 */
	
	HashMap<String, String> hashMap = new HashMap<String, String> ();
	hashMap.put("1", "��ö��");
	hashMap.put("2", "�̿���");
	hashMap.put("3", "�ڻ���"); // key, valuse�� String�� ���� �־��ְ�
	list.add(hashMap); // �̸� ArrayList Ŭ������ list ������ ���� 
	
	hashMap = new HashMap<String, String>();
	
		
	}
 	
	
	
}

