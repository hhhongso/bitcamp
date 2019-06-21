package Notes;

public class KoreanEx {

	public static void main(String[] args) {
		Korean k1 = new Korean("이름", "주민번호");
		System.out.println(k1.nation + k1.name + k1.idNum);
		
		Korean k2 = new Korean("새이름", "새주민번호");
		System.out.println(k2.nation + k2.name + k2.idNum);
		
	}

}
