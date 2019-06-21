package kr.co.bit;

public class MemberSearch {
	//�迭 ���� ����: ��� Ŭ������ �迭�濡 members��� �̸����� ���� ����
	private Member[] members;
	
	public MemberSearch() {
		members = new Member[5];
		members[0] = new Member("�踻��", 180, 61, "���ѹα�");
		members[1] = new Member("������", 155, 43, "���ѹα�");
		members[2] = new Member("Mike", 177, 60, "USA");
		members[3] = new Member("Rachel", 170, 48, "Spain");
		members[4] = new Member("Uri", 150, 57, "Japan");
	}
	
	// searchMemeber �Լ� ����� : boolean Ÿ���� �Լ�
	//�ܺο��� ������ �� 
	public boolean searchMember(String name) {
		boolean searchResult = false; // �⺻���� false , 
		for(int i = 0; i < members.length; i++) {
			if(members[i].getName().equals(name)) { //���� ������ ã�ҵ� 
				printInfo(members[i]); // printInfo �Լ��� member[i����] �� ������
				searchResult = true; // ã���� �� true ��� 
			}
		}
		return searchResult; // boolean type�� ���� ������ 
	}
	
	
	//������Լ��� �ڱ� �ڽ��� Ŭ���������� printInfo �Լ��� ����մϴ�. 
	private void printInfo(Member member) { // printInfo(member[i��°] �� �ִ�  Member Ŭ������ member������ ��� ��
		System.out.println(member.getName() + "���� �˻� ���");
		System.out.println("�̸�:" + member.getName());
		System.out.println("Ű:" + member.getHeight());
		System.out.println("������:" + member.getWeight());
		System.out.println("����:" + member.getNation());
		System.out.println(member.toString());
		
		
	}
}
