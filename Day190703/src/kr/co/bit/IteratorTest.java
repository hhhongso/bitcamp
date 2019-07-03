package kr.co.bit;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public class IteratorTest {

	public static void main(String[] args) {
		ArrayList<String> al = new ArrayList<String>();
		al.add("축구1");
		al.add("야구2");
		al.add("농구3");
		al.add("배구4");
		al.add("탁구5");

		//for문을 이용하여 가져올 수 있기는 하나, 
		//이 경우 [0]->[1]
		//		[0]->[1]->[2]
		//		[0]->[1]->[2]->[3] ... 으로 진행되어 속도가 떨어지게 됨 ==> Iterator / ListIterator 사용 [ArrayList 배열방에서만 사용한다]
																//[0]을찍고 그 자리를 기억하기 때문에 한번에 [0]->[1]->[2]->[3]->[4]을 할 수 있음 

		// Iterator 를 이용하여 출력: 순차적으로 출력, 전방향 only
		Iterator<String> it = al.iterator();
		while(it.hasNext()) { // 전방향
			System.out.println(it.next());
		}
		System.out.println();
		
		// ListIterator 를 이용하여 출력: 순차적 출력, 전/후방향
		ListIterator<String> lit = al.listIterator(); 
		while(lit.hasNext()) { // 전방향
			System.out.println(lit.next());
		}
		System.out.println();
		
		while(lit.hasPrevious()) { // 후방향
			System.out.println(lit.previous());
		}
	}

}
