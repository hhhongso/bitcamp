package Practice0620.haksaObj;

public class PrintAll {
	Domain domain;

	PrintAll(Domain domain) {
		this.domain = domain;
	}

	public void processPrintAll() {
		while (true) {

			if (isEmpty()) {
				System.out.println("[�ý��� �޼���] : �ý��ۿ� ��ϵ� ����� �����ϴ�.");
				break;
			}

			printAllPeople();

			System.out.print("��� �Ͻ÷��� 1, ���� �Ͻ÷��� 0�� �Է����ּ���. : ");
			int yOrNo = domain.sc.nextInt();

			if (yOrNo == 1) { // ���
				continue;
			} else { // ����
				break;
			}
		}
	}

	public boolean isEmpty() {
		if (domain.haksaList.size() < 1) {
			return true;
		}
		return false;
	}

	public void printAllPeople() {
		for (int i = 0; i < domain.haksaList.size(); i++) {
			domain.setAge(domain.haksaList.get(i).get("age"));
			domain.setName(domain.haksaList.get(i).get("name"));
			domain.setNumID(domain.haksaList.get(i).get("numID"));
			domain.setSubject(domain.haksaList.get(i).get("subject"));
			domain.setPart(domain.haksaList.get(i).get("part"));
			domain.setKey(domain.haksaList.get(i).get("key"));

			String sKey = domain.haksaList.get(i).get("superKey");

			String result = "No." + sKey + " |\t���� : " + domain.getAge() + "\t�̸� : " + domain.getName() + "\t";

			if (domain.getKey().equals("1")) {
				result += "�й� : " + domain.getNumID();
			} else if (domain.getKey().equals("2")) {
				result += "���� : " + domain.getSubject();
			} else if (domain.getKey().equals("3")) {
				result += "�μ� : " + domain.getPart();
			}
			System.out.println(result);
		}
	}

}
