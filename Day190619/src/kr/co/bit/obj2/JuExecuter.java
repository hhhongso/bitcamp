package kr.co.bit.obj2;
//ctrl+shift+f : �ڵ� �ٸ��� 

import java.util.Scanner;

public class JuExecuter {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		while(true) {
			String JU = JuFunction.juSelect(scan); //ctrl+ Ŀ���ø� == �ش� �Լ� ��ġ Ȯ�� ����
			//static�� ���� class�� method�� ���� ȣ��
			
			if(JU.equals("yes") || JU.equals("YES")) { // ���ڿ��� ���ϱ� .equals() ==> Ŭ�������� ���ϴ� �� 
				JuFunction.juDisp(1);
				
				int menu = JuFunction.menuSelect(scan); // ()�� Ű���尪�� �״�� ������ scan  				
				if(menu == 1) {
					JuFunction.menuDisp(1);
					String GOB = JuFunction.gobSelect(scan);
					if(GOB.equals("yes") || GOB.equals("YES")) { 
						JuFunction.gobDisp(1);
					} else {
						JuFunction.gobDisp(2);
					}
					
				} else if (menu == 2) {
					JuFunction.menuDisp(2);
					String GOB = JuFunction.gobSelect(scan);
					if(GOB.equals("yes") || GOB.equals("YES")) { 
						JuFunction.gobDisp(3);
					} else {
						JuFunction.gobDisp(4);
					}
					
				} else if (menu == 3) {
					JuFunction.menuDisp(3);
					int TANG = JuFunction.tangSelect(scan);
					if (TANG == 1) {
						JuFunction.tangDisp(1);
					} else if (TANG == 2) {
						JuFunction.tangDisp(2);
					} else if (TANG == 3) {
						JuFunction.tangDisp(3);
					}
					
				}
			} else {
				JuFunction.juDisp(2);
				break;
			}
			
		} // while�� ��

	}

}
