package kr.co.bit.obj;

import java.util.Scanner;

public class AnonyInnerTest {
	//throw Anonymous anonymous = new NullPointerException(); 이라고 익명 클래스를 자동 컴파일. 이름이 없을 때에만 스스로 익명 클래스를 돌림  
	//throw new NullPointerException(); //excepthionMethod 에서 nullpointerException을 강제함 


/* 인터페이스, 추상클래스에 new 객체생성은 불가하나, anonymous 를 통해 가능하다. 
 * Anonymous class는 한번만 사용하고 버린다. 
 * */
	public static void main(String[] args) {
		CommandProcess cp = new CommandProcess();
		Scanner scan = new Scanner(System.in);
		System.out.println("1.목록보기 2. 글쓰기");
		int protocol = scan.nextInt();

		// 인터페이스로 객체 생성하는 것은 불가능 ==>> Class Anonymous extends ListCommand implements Command 를 자동함
		// Anonymous anonymous = new ListCommand();
		// anonymous.execute();
		if (protocol == 1) {
			cp.process(new Command() {
				@Override
				public void execute() {
					System.out.println("내용보기 실행");
				}
			});

		} else {
			cp.process(new Command() {
				@Override
				public void execute() {
					System.out.println("글쓰기 실행");
				}
			});
		}
	}

}
