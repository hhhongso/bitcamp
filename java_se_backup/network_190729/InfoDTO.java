enum Info{
	JOIN, EXIT, SEND //, SECRET
}

class InfoDTO implements java.io.Serializable {
	private static final long serialVersionUID = 1L; //�ܺο����� ������ �� �ֵ��� �ø�������� ������ �����. 
	private String nickName; 
	private String message; 
	private Info command; 

	public InfoDTO(String nickName, String message, Info command){
		this.nickName = nickName; 
		this.message = message; 
		this.command = command; 
	}
	
	public InfoDTO(){}

	public void setNickname(String nickName) { this.nickName = nickName; }
	public void setMessage(String message) {this.message = message;}
	public void setCommand(Info command) {this.command = command;}

	public String getNickname(){ return nickName;}
	public String getMessage() { return message;}
	public Info getCommand() { return command;} 

	public String toString(){
		return "[" + nickName + "] " + message ;
	}

}

/*
����: ���ڿ��� �ƴ϶� ��ü�� �����͸� �Ѱ��ְ� �޵��� ���α׷���
ChatClientObject
ChatServerObject
ChatHandlerObject
�����ʹ� InfoDTO ��ü�� �Ѱ��ش�.  ==> Object Serializable , ObjectOutputStream, ObjectInputStream 
*/

