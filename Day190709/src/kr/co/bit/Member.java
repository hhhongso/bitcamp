package kr.co.bit;
/* API의 함수적 인터페이스::  andThen(), compose()
 * andThen()은 모두 다 가능
 */
public class Member {
	private String name; 
	private String id;
	private Address address;
	
	public Member(String name, String id, Address address) {
		super();
		this.name = name;
		this.id = id;
		this.address = address;
	}
	public String getName() {
		return name;
	}
	public String getId() {
		return id;
	}
	public Address getAddress() {
		return address;
	} 
	
	
	
}
