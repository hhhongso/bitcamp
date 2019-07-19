class Outer {
	private String name; 

	public void output(){
		System.out.println("이름:" + this.name + "나이: " + new Inner().age);
				//아우터 클래스는 이너 클래스의 필드를 바로 가져올 수 없다. ==> 객체 생성 필요.
				//같은 클래스 내에서 중첩으로 가져오기 때문에 setter/getter는 필요없음 
	}

	class Inner {
		private int age;

		public void disp(){
			System.out.println("이름:" + Outer.this.name + "나이: " + this.age);
					//이너 클래스는 아우터 클래스의 필드를 바로 가져올 수 있다. 
					//단, 클래스 안에서만 가능하며, 메인점은 static으로 메모리를 따로 잡기 때문에, 바로 가져올 수 없다. 
					//name 은 바로 쓸 수 있으나, 위와 같이 생략되어 있다. 
		}

	}

	public static void main(String[] args)	{
		Outer aa = new Outer();	//상속관계가 아니기 때문에, outer new 하였을 때 inner 는 만들지 않음. 
		aa.name = "홍길동"; // 같은 클래스 안에서 getter/setter 없이 가져올 수 있음.
		aa.output();

		Outer.Inner bb = aa.new Inner(); // 중첩되어 있음 ((.)은 소유여부)을 표현해주어야.
//		bb.name = "김"; *error!* 메인점은 static으로 메모리를 따로 잡기 때문에, 바로 가져올 수 없다. 
		bb.age = 25; 
		bb.disp();

		Outer.Inner cc = aa.new Inner();
		cc.age = 30; 
		cc.disp();

		Outer.Inner dd = new Outer().new Inner(); 
			//outer 객체 새로 만들고, inner 클래스의 dd객체를 생성. dd는 이너 클래스이기 때문에 outer클래스에 있는 name 에 접근 불가
		dd.age = 35; 
		dd.disp();


	}
}