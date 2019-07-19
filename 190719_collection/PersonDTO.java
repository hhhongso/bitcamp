class PersonDTO implements Comparable<PersonDTO> {
	private String name; 
	private int age; 

	public PersonDTO(String name, int age){ //setter ��� constructor�� ���� 
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
		return "�̸�: " + name + "	����: " + age;
	}

	@Override				//T = class type
	public int compareTo(PersonDTO o){
		
		/* �������� 
		if(this.age < o.age) return -1;
		else if(this.age > o.age) return 1; 
		else return 0;
		//�񱳴���ڰ� �� ũ��(<) -1, ���ٸ�(==) 0, ������(>) 1�� ��ȯ
		*/

		//�������� : ���� reverse() �� ����. �Ʒ� ���ϰ��� �ٲٸ� ��.
		if(this.age < o.age) return 1;
		else if(this.age > o.age) return -1; 
		else return 0;

	}

	public static void main(String[] args) {
	}
}


/*
DTO: Data Transfer Object �����͸� ��üȭ�Ͽ� ���� ó�� 
DAO: Data Access Object
VO: Value Object ������ ���� ����ü
*/