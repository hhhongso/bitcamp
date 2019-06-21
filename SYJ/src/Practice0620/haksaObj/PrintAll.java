package Practice0620.haksaObj;

public class PrintAll {
	Domain domain;

	PrintAll(Domain domain) {
		this.domain = domain;
	}

	public void processPrintAll() {
		while (true) {

			if (isEmpty()) {
				System.out.println("[시스템 메세지] : 시스템에 등록된 사람이 없습니다.");
				break;
			}

			printAllPeople();

			System.out.print("계속 하시려면 1, 종료 하시려면 0을 입력해주세요. : ");
			int yOrNo = domain.sc.nextInt();

			if (yOrNo == 1) { // 계속
				continue;
			} else { // 종료
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

			String result = "No." + sKey + " |\t나이 : " + domain.getAge() + "\t이름 : " + domain.getName() + "\t";

			if (domain.getKey().equals("1")) {
				result += "학번 : " + domain.getNumID();
			} else if (domain.getKey().equals("2")) {
				result += "과목 : " + domain.getSubject();
			} else if (domain.getKey().equals("3")) {
				result += "부서 : " + domain.getPart();
			}
			System.out.println(result);
		}
	}

}
