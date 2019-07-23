import java.util.Scanner;

class Compute {
	private int x, y, sum, sub, mul;
	private double div;
						//parameter(매개변수) ,= argument(인수): C에서는 확실히 구분되나, java에서는 같은 것으로 사용
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

//----------------------------------------------- [객체 배열 사용]


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

		System.out.println("X \t Y \t 합 \t 차 \t 곱 \t 몫");

		for(Compute com : cp){			
			System.out.println(com);
		}
	}
}
