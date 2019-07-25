class PersonDTO {
	private String id; 
	private String name; 
	private String email; 
	private String tel;
	
	public PersonDTO(String id, String name, String email, String tel){
		this.id = id; 
		this.name = name; 
		this.email = email; 
		this.tel = tel; 
	}

	public String getId(){
		return id;
	}

	public String getName(){
		return name;
	}

	public String getEmail(){
		return email;
	}

	public String getTel(){
		return tel;
	}

}
