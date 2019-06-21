package Practice0620.haksaObj;

public class Search {
	Domain domain;

	Search(Domain domain) {
		this.domain = domain;
	}

	public void processSearch() {
		while (true) {
			if (isEmpty()) {
				System.out.println("[시스템 메세지] : 시스템에 등록된 사람이 없습니다.");
				break;
			}
			// 찾는 사람 입력받기
			System.out.println("찾을 이름을 입력해주세요. : ");
			domain.setName(domain.sc.next());
			// 찾는 사람이 있는지 조회
			if (searchIdxByName() == -1) {
				break;
			}
			// 있다면, 얼마나 있는지 찾고
			// 그 결과를 반환해서 출력한다.
			printSearchByName();
			// idxList 역할이 끝났으니 비워줌.
			domain.superKeyList.removeAll(domain.superKeyList);

			System.out.print("계속 하시려면 1, 종료 하시려면 0을 입력해주세요. : ");
			int yOrNo = domain.sc.nextInt();
			if (yOrNo == 1) { // 계속
				continue;
			} else { // 종료
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

				String result = "No." + sKey + " |\t나이 : " + domain.getAge() + "\t이름 : " + domain.getName() + "\t";

				if (domain.getKey().equals("1")) {
					domain.setNumID(domain.haksaList.get(i).get("numID"));
					result += "학번 : " + domain.getNumID();
				} else if (domain.getKey().equals("2")) {
					domain.setSubject(domain.haksaList.get(i).get("subject"));
					result += "과목 : " + domain.getSubject();
				} else if (domain.getKey().equals("3")) {
					domain.setPart(domain.haksaList.get(i).get("part"));
					result += "부서 : " + domain.getPart();
				}
				System.out.println(result);
			}
		}
		System.out.println("===========================================");
		System.out.println("총 " + domain.superKeyList.size() + "개의 같은 이름이 검색되었습니다.");
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
