class Sub extends Parent {
	protected String name;
	protected int age;

	public Sub(String name, int age, double weight, double height){
		super(weight,height); // 부모 생성자 호출 
		System.out.println("Sub 파라미터 있는 생성자");
		this.name = name;
		this.age = age;
	}

	@Override
	public void disp(){
		System.out.println("이름: " + name);
		System.out.println("나이: " + age);
		super.disp();
	}

	public static void main(String[] args) {
		Sub sub = new Sub("김이정", 25, 60, 170);
		sub.disp();
		System.out.println("------------------------");

		Parent pa = new Sub("코난", 11, 30, 130); 
		pa.disp();
	}
}
