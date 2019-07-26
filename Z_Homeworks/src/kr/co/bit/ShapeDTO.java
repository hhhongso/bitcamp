package kr.co.bit;
/*enum Figure{
LINE, CIRCLE, RECT, ROUNDRECT, PEN
//0		1		2		3		4	 
//==> enum: static final을 모아둔 것. 자동으로 상수화 Figure.LINE
}*/

class ShapeDTO {
private int x1, y1, x2, y2, z1, z2;

private boolean fill;
public int shape;
public static final int CIRCLE=1; 
public static final int LINE=0; 
public static final int RECT=2; 
public static final int ROUNDRECT=3; 
public static final int PEN=4; // 도형별 번호 설정. 선 = 0; 원 = 1; 사각 = 2; 둥사 = 3; 
private int	color; // index number로 가져오기. 

public ShapeDTO(int x1, int y1, int x2, int y2, int z1, int z2, boolean fill, int shape, int color){
	
	this.x1 = x1; 
	this.y1 = y1; 
	this.x2 = x2; 
	this.y2 = y2; 
	this.z1 = z1; 
	this.z2 = z2; 
	this.fill = fill; 
	this.shape = shape; 
//	this.LINE = shape;
//	this.CIRCLE = shape;
//	this.RECT = shape;
//	this.ROUNDRECT = shape;
//	this.PEN = shape;
	this.color = color; 
}

public int getX1()	{	return x1;}
public int getY1()	{	return y1;}
public int getX2()	{	return x2;}
public int getY2()	{	return y2;}
public int getZ1()	{	return z1;}
public int getZ2()	{	return z2;}

public boolean getFill(){		return fill;}
/*
public int getLine(){	return LINE;}
public int getCircle(){ return CIRCLE; }
public int getRect() { return RECT; }
public int getRoundRect() { return ROUNDRECT; }
public int getPen() { return PEN;} */

public int getShape(){ return shape;}

public int getColor(){		return color;}



}
