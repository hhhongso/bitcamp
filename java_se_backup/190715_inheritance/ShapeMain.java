import java.util.Scanner;

class ShapeTest {
	protected double area; 

	public ShapeTest(){
		System.out.println("ShapeTest �⺻������");
	}
	public void calcArea(){
		System.out.println("������ ����մϴ�.");
	}
	public void dispArea(){
		System.out.println("������ ����մϴ�.");
	}

}
// -------------------------------------------------------------
class TriTest extends ShapeTest{
	private int base, height; 

	public TriTest(){
		System.out.println("TriTest �⺻������");
		Scanner scan = new Scanner(System.in);

		System.out.print("�غ�: ");
		base = scan.nextInt();
		System.out.print("����: ");
		height = scan.nextInt();
	}

	@Override
	public void calcArea(){
		area = base * height / 2.0;
	}
	@Override
	public void dispArea(){
		System.out.println("�ﰢ���� ����= " + area);
	}

}
// -------------------------------------------------------------
class SquareTest extends ShapeTest{
	private int width, height; 

	public SquareTest(){
		System.out.println("SquareTest �⺻������");
		Scanner scan = new Scanner(System.in);

		System.out.print("����: ");
		width = scan.nextInt();
		System.out.print("����: ");
		height = scan.nextInt();
	}

	@Override
	public void calcArea(){
		area = width * height;
	}
	@Override
	public void dispArea(){
		System.out.println("�簢���� ����= " + area);
	}

}
// -------------------------------------------------------------
class TrapeTest extends ShapeTest{
	private int top, bottom, height; 

	public TrapeTest(){
		System.out.println("TrapeTest �⺻������");
		Scanner scan = new Scanner(System.in);

		System.out.print("����: ");
		top = scan.nextInt();
		System.out.print("�غ�: ");
		bottom = scan.nextInt();
		System.out.print("����: ");
		height = scan.nextInt();

	}

	@Override
	public void calcArea(){
		area = (top + bottom) * height / 2.0; 
	}
	@Override
	public void dispArea(){
		System.out.println("��ٸ����� ����= " + area);
	}

}
// -------------------------------------------------------------
class ShapeMain {
	public static void main(String[] args) {
		/* �ϴ��ϰ���. ���յ� 100%  

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
		shape = new TriTest(); //[�ٴ��� ����] �θ� ��ü �ϳ��� ��� �ڽ� Ŭ������ ����, ���յ��� �����ϰ� ��. ==> ������
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
