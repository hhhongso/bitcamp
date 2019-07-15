import java.util.Scanner;

class ShapeTest {
	protected double area; 

	public ShapeTest(){
		System.out.println("ShapeTest 기본생성자");
	}
	public void calcArea(){
		System.out.println("도형을 계산합니다.");
	}
	public void dispArea(){
		System.out.println("도형을 출력합니다.");
	}

}
// -------------------------------------------------------------
class TriTest extends ShapeTest{
	private int base, height; 

	public TriTest(){
		System.out.println("TriTest 기본생성자");
		Scanner scan = new Scanner(System.in);

		System.out.print("밑변: ");
		base = scan.nextInt();
		System.out.print("높이: ");
		height = scan.nextInt();
	}

	@Override
	public void calcArea(){
		area = base * height / 2.0;
	}
	@Override
	public void dispArea(){
		System.out.println("삼각형의 넓이= " + area);
	}

}
// -------------------------------------------------------------
class SquareTest extends ShapeTest{
	private int width, height; 

	public SquareTest(){
		System.out.println("SquareTest 기본생성자");
		Scanner scan = new Scanner(System.in);

		System.out.print("가로: ");
		width = scan.nextInt();
		System.out.print("세로: ");
		height = scan.nextInt();
	}

	@Override
	public void calcArea(){
		area = width * height;
	}
	@Override
	public void dispArea(){
		System.out.println("사각형의 넓이= " + area);
	}

}
// -------------------------------------------------------------
class TrapeTest extends ShapeTest{
	private int top, bottom, height; 

	public TrapeTest(){
		System.out.println("TrapeTest 기본생성자");
		Scanner scan = new Scanner(System.in);

		System.out.print("윗변: ");
		top = scan.nextInt();
		System.out.print("밑변: ");
		bottom = scan.nextInt();
		System.out.print("높이: ");
		height = scan.nextInt();

	}

	@Override
	public void calcArea(){
		area = (top + bottom) * height / 2.0; 
	}
	@Override
	public void dispArea(){
		System.out.println("사다리꼴의 넓이= " + area);
	}

}
// -------------------------------------------------------------
class ShapeMain {
	public static void main(String[] args) {
		/* 일대일관계. 결합도 100%  

		TriTest tri = new TriTest();
		tri.calcArea();
		tri.dispArea();
		System.out.println();

		SquareTest sq = new SquareTest();
		sq.calcArea();
		sq.dispArea();
		System.out.println();

		TrapeTest trape = new TrapeTest();
		trape.calcArea();
		trape.dispArea();
		System.out.println();	*/

		ShapeTest shape;
		shape = new TriTest(); //[다대일 관계] 부모 객체 하나가 모든 자식 클래스를 참조, 결합도를 느슨하게 함. ==> 다형성
		shape.calcArea();
		shape.dispArea();
		System.out.println();

		shape = new SquareTest();
		shape.calcArea();
		shape.dispArea();
		System.out.println();

		shape = new TrapeTest();
		shape.calcArea();
		shape.dispArea();
		System.out.println();


	}
}
