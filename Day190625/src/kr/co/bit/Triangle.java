package kr.co.bit;

public class Triangle extends Point2D { // 상속
	protected Point2D[] point; // 배열으로 포함 
	
	public Triangle(Point2D[] p) {
		this.point = p; 
	}
}
