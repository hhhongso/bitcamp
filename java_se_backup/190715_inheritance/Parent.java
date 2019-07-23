class Parent {
	protected double weight, height;

	public Parent(){
		System.out.println("Parent 기본생성자");
	}

	public Parent(double weight, double height){
		System.out.println("Parent 파라미터 있는 생성자");
		this.weight = weight; 
		this.height = height; 
	}

	public void disp(){
		System.out.println("몸무게: " + weight + "	키: " + height);
	}
}
