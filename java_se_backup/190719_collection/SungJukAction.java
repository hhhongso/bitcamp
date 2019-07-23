import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Scanner;
				
class SungJukAction {
	//field
	private ArrayList<SungJukDTO> list= new ArrayList<SungJukDTO>(); 
	private SungJukDTO sdto;
	private int choice;	
	private Scanner scan = new Scanner(System.in);

	public SungJukAction(){		
	}

	public void menu(){
		while(true){
			Scanner scan = new Scanner(System.in);
			System.out.println("*****************");
			System.out.println("1. �Է�");
			System.out.println("2. ���");
			System.out.println("3. �˻�");
			System.out.println("4. ����");
			System.out.println("5. ����");
			System.out.println("6. ��");
			System.out.println("*****************");
			System.out.print("���ϴ� �ɼ� �Է�: ");
			choice = scan.nextInt();

			if(choice == 1)				insertArticle();
			else if (choice == 2)		printArticle();
			else if (choice == 3)		searchArticle();
			else if (choice == 4)		deleteArticle();
			else if (choice == 5)		sortArticle();
			else if (choice == 6)		break;
		}//while
		
	}

/*
	public void insertArticle() {	
		Scanner scan = new Scanner(System.in);
		System.out.print("��ȣ �Է�: ");
		num = scan.nextInt();
		System.out.print("�̸� �Է�: ");
		name = scan.next();
		System.out.print("���� ���� �Է�: ");
		kor = scan.nextInt();
		System.out.print("���� ���� �Է�: ");
		eng = scan.nextInt();
		System.out.print("���� ���� �Է�: ");
		math = scan.nextInt();
		System.out.println("���� �Է��� �Ϸ�Ǿ����ϴ�. ");

		sdto = new SungJukDTO();
		sdto.setData(num, name, kor, eng, math);
		sdto.calc();
		list.add(sdto);
*/

	public void insertArticle() {	
		sdto = new SungJukDTO();		
		list.add(sdto);

	}

	public void printArticle() {
		System.out.print("��ȣ\t�̸�\t ����\t ����\t ����\t ����\t ���\n");
		for(SungJukDTO sdto : list) {
			System.out.print(sdto);
		}
	}

	public void searchArticle(){
		System.out.print("ã�� �̸� �Է�: ");
		String searchName = scan.next();	
		int cnt = 0; 

/*		if(    .equals(searchName)) {
			for(int i = 0; i < list.size(); i++) {
				System.out.print(list.get(i).toString()); }

		} else { System.out.println("ã�� �̸��� �����ϴ�. "); }
*/

		for(SungJukDTO sdto : list){
			if(searchName.equals(sdto.getName())) {
				cnt++;
				if(cnt == 1) System.out.print("��ȣ\t�̸�\t ����\t ����\t ����\t ����\t ���\n");	
				System.out.print(sdto);
			}
		}
		if(cnt == 0) System.out.println("ã�� �̸��� �����ϴ�. ");
	}
		


/* for(int i = 0; i < list.size(); i++) {
		if(list.get(i).getName().equals(searchName)) {					
			System.out.print(list.get(i).toString());
		} else {
			System.out.println("ã�� �̸��� �����ϴ�. ");
		}
	}		
} */

	public void deleteArticle(){
		System.out.print("���� �̸� �Է�: ");
		String delName = scan.next();
		boolean exist = false; 
		int sw = 0;  //switch���� = on / off �� ������ ���ۿ� ���� �� �ַ� ����Ѵ�. ��ȭ�� ���� üũ 

//�Ѵܰ辿 ����, iterator�� �������� ����Ŵ. ==> �����Ͱ� ���������� �ܰ谡 ������� ����
		Iterator<SungJukDTO> it = list.iterator(); 
		while(it.hasNext()){
			SungJukDTO sdto = it.next();
			if(sdto.getName().equals(delName)) {
				it.remove();  // remove(): next()�� ȣ���� �����͸� �����Ѵ�. 
				exist = true;
				sw = 1;				
			//iterator�� ����Ű�� ���� ���� ����� ���� �ܰ�� �Ѿ(.next()) 
			}
		} 
		if(sw == 0) System.out.println("ã�� �̸��� �����ϴ�. ");
		else System.out.println("�����͸� �����Ͽ����ϴ�.");
	}


//ConcurrentModificationException ���� �߻�: remove �� ��, arrayList���� �ε��� �ѹ��� �ϳ��� ��ܿ��� ����
	/*	for(SungJukDTO sdto : list){
			if(delName.equals(sdto.getName())) {
				cnt++;
				list.remove(sdto);		
			}
		}
		System.out.println(cnt + "�� ���� �Ϸ�");
		if(cnt == 0) System.out.println("ã�� �̸��� �����ϴ�. ");
	} */ 
	

	public void sortArticle(){
		while(true){
			System.out.println("1. �̸� �������� ���� 2. ���� �������� ���� 3. ���� �޴���");
			choice = scan.nextInt();
			if(choice == 1) {
				Comparator<SungJukDTO> com = new Comparator<SungJukDTO>(){
					@Override
					public int compare(SungJukDTO s1, SungJukDTO s2){
						return s1.getName().compareTo(s2.getName());
					}
				};

					Collections.sort(list, com);
					printArticle();
				
			} else if(choice == 2) {
				Collections.sort(list);
				printArticle();

			} else if(choice ==3) {
				break;
			}
		}//while		

	}

		


}
