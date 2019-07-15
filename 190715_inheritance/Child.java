class Child extends Parent {
	protected String name;
	protected int age;

	public Child(String name, int age, double weight, double height){
		System.out.println("Child 파라미터 있는 생성자");
//		super(weight, height);
		this.name = name;
		this.age = age;
		this.weight = weight; // 부모 클래스의 필드가 자식 클래스에게 상속 >> 자식 클래스에서 바로 불러올 수 있음(this.) 
		super.height = height; //부모클래스로 올라가서 데려올 것이니, super. 라고 써줘도 가능 
	}

	public void output(){
		System.out.println("이름: " + name);
		System.out.println("나이: " + age);
		disp(); // super.를 적어주지 않아도, 자식 클래스 내에 없다면 상속받은 부모 클래스로 알아서 올라갈 것
//		System.out.println("몸무게: " + weight);
//		System.out.println("키: " + height);
	}

	public static void main(String[] args)	{
		Child ch = new Child("김김김", 25, 50, 160); // *error!* 생성자가 하나도 없을 시, default 생성자를 자동 호출한다. 위의 경우 파라미터가 있는 생성자가 이미 있기 때문에, 디폴트 생성자를 자동 호출할 수 없다. 
		 //자식 클래스로 new > 메모리 생성 시, Super, Sub 클래스 2개의 메모리를 동시에 생성한다. 즉, 생성자도 Super, Sub 2번 호출된다.
		 ch.output();
		System.out.println("------------------------");
		ch.disp();
		System.out.println("************************");

		Parent pa = new Child("코난", 11, 30, 130); //Upcasting. Super Class의 것만 사용할 수 있음.
		//pa.output(); *error!* 자식만 가지고 있는 필드/메소드에 접근 불가 
		pa.disp();

		
	}
}



