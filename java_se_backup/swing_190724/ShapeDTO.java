/*enum Figure{
	LINE, CIRCLE, RECT, ROUNDRECT, PEN
	//0		1		2		3		4	 
	//==> enum: static final�� ��Ƶ� ��. �ڵ����� ���ȭ Figure.LINE
}*/

class ShapeDTO {
	private int x1, y1, x2, y2, z1, z2;
	
	private boolean fill;
	public static int SHAPE;// LINE=0, CIRCLE=1, RECT=2, ROUNDRECT=3, PEN=4; // ������ ��ȣ ����. �� = 0; �� = 1; �簢 = 2; �ջ� = 3; 
	private int	color; // index number�� ��������. 

	public ShapeDTO(int x1, int y1, int x2, int y2, int z1, int z2, boolean fill, int shape, int color){
		this.x1 = x1; 
		this.y1 = y1; 
		this.x2 = x2; 
		this.y2 = y2; 
		this.z1 = z1; 
		this.z2 = z2; 
		this.fill = fill; 
		this.SHAPE = shape;
		this.color = color; 
	}

	public int getX1()	{	return x1;}
	public int getY1()	{	return y1;}
	public int getX2()	{	return x2;}
	public int getY2()	{	return y2;}
	public int getZ1()	{	return z1;}
	public int getZ2()	{	return z2;}
	public boolean getFill(){		return fill;}

	public int getShape(){
		return SHAPE;
	}
	public int getColor(){		return color;}



}
