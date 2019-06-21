package Practice0620.haksaObj;

public class Search {
	Domain domain;

	Search(Domain domain) {
		this.domain = domain;
	}

	public void processSearch() {
		while (true) {
			if (isEmpty()) {
				System.out.println("[�ý��� �޼���] : �ý��ۿ� ��ϵ� ����� �����ϴ�.");
				break;
			}
			// ã�� ��� �Է¹ޱ�
			System.out.println("ã�� �̸��� �Է����ּ���. : ");
			domain.setName(domain.sc.next());
			// ã�� ����� �ִ��� ��ȸ
			if (searchIdxByName() == -1) {
				break;
			}
			// �ִٸ�, �󸶳� �ִ��� ã��
			// �� ����� ��ȯ�ؼ� ����Ѵ�.
			printSearchByName();
			// idxList ������ �������� �����.
			domain.superKeyList.removeAll(domain.superKeyList);

			System.out.print("��� �Ͻ÷��� 1, ���� �Ͻ÷��� 0�� �Է����ּ���. : ");
			int yOrNo = domain.sc.nextInt();
			if (yOrNo == 1) { // ���
				continue;
			} else { // ����
				break;
			}
		}
	}

	public void printSearchByName() {
		for (int i = 0; i < domain.haksaList.size(); i++) {
			if (domain.haksaList.get(i).get("name").equals(domain.getName())) {
				String sKey = domain.haksaList.get(i).get("superKey");
				domain.setAge(domain.haksaList.get(i).get("age"));
				domain.setName(domain.haksaList.get(i).get("name"));
				domain.setKey(domain.haksaList.get(i).get("key"));
				domain.superKeyList.add(domain.haksaList.get(i).get("superKey"));

				String result = "No." + sKey + " |\t���� : " + domain.getAge() + "\t�̸� : " + domain.getName() + "\t";

				if (domain.getKey().equals("1")) {
					domain.setNumID(domain.haksaList.get(i).get("numID"));
					result += "�й� : " + domain.getNumID();
				} else if (domain.getKey().equals("2")) {
					domain.setSubject(domain.haksaList.get(i).get("subject"));
					result += "���� : " + domain.getSubject();
				} else if (domain.getKey().equals("3")) {
					domain.setPart(domain.haksaList.get(i).get("part"));
					result += "�μ� : " + domain.getPart();
				}
				System.out.println(result);
			}
		}
		System.out.println("===========================================");
		System.out.println("�� " + domain.superKeyList.size() + "���� ���� �̸��� �˻��Ǿ����ϴ�.");
	}

	public int searchIdxByName() {
		for (int i = 0; i < domain.haksaList.size(); i++) {
			if (domain.haksaList.get(i).get("name").equals(domain.getName())) {
				return i;
			}
		}
		return -1;
	}

	public boolean isEmpty() {
		if (domain.haksaList.size() < 1) {
			return true;
		}
		return false;
	}
}
