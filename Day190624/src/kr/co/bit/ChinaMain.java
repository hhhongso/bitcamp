package kr.co.bit;

import java.util.Scanner;

public class ChinaMain {

	public static void main(String[] args) {
		SeoulChina sc = new SeoulChina(); 
		BusanChina bc = new BusanChina(3000, 5000, 7000, 20000); // new �����ڷ� �ʱ�ȭ �� ������ �ȿ��� �ٷ� �ʱ�ȭ&�� �Է� �� ���� �ְ� 
		Scanner scan = new Scanner(System.in);
		
		while(true) {
			System.out.println("1. �����߱��� 2. �λ��߱���");
			int protocol = scan.nextInt();
			
			if (protocol == 1) {
				System.out.println("���� �߱���");
				sc.setZa(5000); // new�����ڷδ� �ʱ�ȭ�� �ϰ�, set�Լ��� ���� ������ ���� �ִ�. 
				sc.setZzam(6000);
				sc.setTang(10000);
				sc.setJangza(18000);
				System.out.println("����:" + sc.getZa() + "	«��: " + sc.getZzam() + "	������: " + sc.getTang() + "	�������: " + sc.getJangza()
				+ "	����: " + sc.getTotal());
				System.out.println(sc.toString());
			} else if (protocol == 2) {
				System.out.println("�λ� �߱���");
				System.out.println("����:" + bc.getZa() + "	«��: " + bc.getZzam() + "	������: " + bc.getTang() + "	�Ｑ«��: " + bc.getSamzzam()
				+ "	����: " + bc.getTotal());
				System.out.println(bc.toString());
			}
		} // while��

	}

}
