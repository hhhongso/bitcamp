enum Info{
	JOIN, EXIT, SEND, SECRET
}

class InfoDTO implements java.io.Serializable {
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
숙제: 문자열이 아니라 객체로 데이터를 넘겨주고 받도록 프로그래밍
ChatClientObject
ChatServerObject
ChatHandlerObject
데이터는 InfoDTO 객체로 넘겨준다.  ==> Object Serializable , ObjectOutputStream, ObjectInputStream 
*/

