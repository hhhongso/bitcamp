class Protocol {
	public static final String ENTER = "100";
	public static final String EXIT = "200";
	public static final String SEND_MESSAGE = "300";


}

/*
서버로 보냄 => 응답올 때까지 기다린다. 
서버로부터 받을 때 paint() 해야 다수의 클라이언트에 동시에 그려짐 
100:
200:
300:

.split();
*/