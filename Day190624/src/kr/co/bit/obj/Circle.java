package kr.co.bit.obj;
/*
 * �κ�Ŭ������ ���� ����� ��ü Ŭ������ �����Ͽ� ���Խ�Ų��. 
 */
public class Circle {
	public Point point; 
					// public Point point = new Point(); ���������� C���� ���� ����ϴ� ���, �ڹٿ����� �Ʒ��� ���� �ۼ��Ѵ�.  
	public Circle() {  // ��ü Ŭ����
		point = new Point(); // �κ� Ŭ����: ������ �Լ� �ȿ��� point Ŭ����(�κ�)�� ��ü�� �����Ѵ�.  ///////// Macca ���� Ȯ�� (O)
	}
	
	public static void main(String[] args) {
		Circle circle = new Circle();
		
		circle.point.y = 20;
		System.out.println(circle.point.x); // x�� ���� ���������� �ʾ����� �ʱ�ȭ ���� 0�� ��µ�
		System.out.println(circle.point.y); // ��Ӱ� �޸� ���԰��踦 ���� ������ (��üŬ����).(���ԵǴ� �κ� Ŭ����).(����) �� ������ 
	
	}

}
