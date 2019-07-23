import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;


class CollectionTest{

	@SuppressWarnings("unchecked")
	public static void main(String[] args){
		Collection coll = new ArrayList(); //인터페이스 implementing class  
//		ArrayList list = new ArrayList(); 일반적 

		//Collection은 기본적으로 object >> int, double, string 모두 가능 
		coll.add("호랑");
		coll.add("사자");
		coll.add("호랑"); // 중복 허용, 순서 있음 
		coll.add(25);
		coll.add(43.8);
		coll.add("기린");
		coll.add("코끼리");

		//iterator 는 인터페이스 ! >> 함수를 통해 생성 
		Iterator it = coll.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}

	//	it.hasNext();	지정한 곳에 항목이 있으면 true, 아니면 false
	//	it.next();		항목을 꺼내고 다음으로 이동.

/* Warning!
Note: CollectionTest.java uses unchecked or unsafe operations.
Note: Recompile with -Xlint:unchecked for details.

==> 해결방법
1. 억제 : annotation @SuppressWarnings("unchecked")
2. 원인해결: Generic
*/


	}
}
