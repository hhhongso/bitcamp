package Practice0620.haksaObj;

public class Delete {

	Domain domain;

	Delete(Domain domain) {
		this.domain = domain;
	}

	public void processDelete() {
		while (true) {
			// 시스템에 등록된 사람이 있는지 확인
			if (isEmpty()) {
				System.out.println("[시스템 메세지] : 시스템에 등록된 사람이 없습니다.");
				break;
			}
			// 찾는 사람 입력받기
			System.out.print("찾을 이름을 입력해주세요. : ");
			domain.setName(domain.sc.next());
			// 찾는 사람이 있는지 조회
			if (searchIdxByName() == -1) {
				break;
			}

			// 있다면, 얼마나 있는지 찾아서 결과로 반환
			printSearchByName();
			// 모두 지울것인지, 선택해 지울것인지 고르기.
			System.out.print("모두 삭제하려면 1, 선택 삭제하려면 2를 입력하세요. : ");
			domain.setuSelect(domain.sc.nextInt());
			if (domain.getuSelect() == 1) {
				for (int i = 0; i < domain.superKeyList.size(); i++) {
					for (int j = 0; j < domain.haksaList.size(); j++) {
						if (domain.haksaList.get(j).get("superKey").equals(domain.superKeyList.get(i))) {
							domain.haksaList.remove(j);
							j--;
						}
					}
				}
			} else if (domain.getuSelect() == 2) {
				System.out.print("삭제를 원하는 사람의 번호를 입력하세요. : ");
				String sKey = domain.sc.next();
				for (int i = 0; i < domain.haksaList.size(); i++) {
					if (domain.haksaList.get(i).get("superKey").equals(sKey)) {
						domain.haksaList.remove(i);
					}
				}
			}

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
