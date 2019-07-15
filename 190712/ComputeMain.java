import java.util.Scanner;

class Compute {
	private int x, y, sum, sub, mul;
	private double div;
						//parameter(�Ű�����) ,= argument(�μ�): C������ Ȯ���� ���еǳ�, java������ ���� ������ ���
	public Compute(int x, int y){
		this.x = x;
		this.y = y;
	}

	public void calc(){
		sum = x + y; 
		sub = x - y;
		mul = x * y;
		div = (double)x / y; 
	}

	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public int getSum() {
		return sum;
	}
	public int getSub() {
		return sub;
	}
	public int getMul() {
		return mul;
	}
	public double getDiv() {
		return div;
	}

	@Override
	public String toString(){
		return x + "\t" +  y + "\t" + sum + "\t" + sub + "\t" + mul + "\t" + String.format("%.3f", div);
	}


}

//----------------------------------------------- [��ü �迭 ���]


public class ComputeMain {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);				
		Compute[] cp = new Compute[3];

		//Compute[] cp = {new Compute(1, 2), new Compute(3, 4), new Compute(5, 6)}; 
		//== Compute[] cp = new Compute[3];
		//== Compute[] cp = new Compute[]{new Compute(1, 2), new Compute(3, 4), new Compute(5, 6)};
		

		for(int j = 0; j < cp.length; j++){
			int x = scan.nextInt();		int y = scan.nextInt();
			cp[j] = new Compute(x, y);	
			cp[j].calc();
		}

		System.out.println("X \t Y \t �� \t �� \t �� \t ��");

		for(Compute com : cp){			
			System.out.println(com);
		}
	}
}
