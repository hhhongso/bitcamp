class PersonDTO implements Comparable<PersonDTO> {
	private String name; 
	private int age; 

	public PersonDTO(String name, int age){ //setter 대신 constructor로 세팅 
		this.name = name; 
		this.age = age;
	}

	public String getName(){
		return name; 
	}
	public int getAge(){
		return age;
	}
	
	@Override
	public String toString(){
		return "이름: " + name + "	나이: " + age;
	}

	@Override				//T = class type
	public int compareTo(PersonDTO o){
		
		/* 오름차순 
		if(this.age < o.age) return -1;
		else if(this.age > o.age) return 1; 
		else return 0;
		//비교대상자가 더 크면(<) -1, 같다면(==) 0, 작으면(>) 1을 반환
		*/

		//내림차순 : 따로 reverse() 가 없음. 아래 리턴값을 바꾸면 됨.
		if(this.age < o.age) return 1;
		else if(this.age > o.age) return -1; 
		else return 0;

	}

	public static void main(String[] args) {
	}
}


/*
DTO: Data Transfer Object 데이터를 객체화하여 묶어 처리 
DAO: Data Access Object
VO: Value Object 데이터 값의 집합체
*/