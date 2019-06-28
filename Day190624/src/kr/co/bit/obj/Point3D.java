package kr.co.bit.obj;
/*
 * 상속은 종류가 같을 때에만 가능하다. 
 * 종류가 다르다면, 포함관계로 사용하여야 한다. 
 */
public class Point3D extends Point2D {
	protected int z; 
	
	@Override
	public String toString() {
		return super.toString() + "Point3D [z=" + z + "]";
	}

	public Point3D() {
		// super();  ==> 컴파일러가 자동으로 작성해주는 부분 
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
