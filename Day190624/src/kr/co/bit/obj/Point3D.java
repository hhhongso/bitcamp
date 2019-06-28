package kr.co.bit.obj;
/*
 * ����� ������ ���� ������ �����ϴ�. 
 * ������ �ٸ��ٸ�, ���԰���� ����Ͽ��� �Ѵ�. 
 */
public class Point3D extends Point2D {
	protected int z; 
	
	@Override
	public String toString() {
		return super.toString() + "Point3D [z=" + z + "]";
	}

	public Point3D() {
		// super();  ==> �����Ϸ��� �ڵ����� �ۼ����ִ� �κ� 
	}
	
	public Point3D(int x, int y, int z) {
		super(x,y) ;
		this.z = z; 
		
	}
	
	public static void main(String[] args) {
		Point3D p3 = new Point3D();
		p3.x = 10; 
		p3.y = 20; 
		p3.z = 30; 
		System.out.println(p3.toString());
		
	}
}
