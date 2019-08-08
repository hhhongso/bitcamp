package bitProject.cafe.dto;

import bitProject.cafe.view.Message;

public class OrderDTO {
	private String id;
	private String menuName; 
	private int amount; 
	private int menuPrice;
	private int totPrice;
	private Message status;
	private MemberDTO member;
	
	
	public OrderDTO() { //MemberDTO member
//		this.member = member;
	}
	
	public void setId(String id) {
		this.id = id;
	}	
//	public String getId() {
//		return id;
//	}	
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	public int getMenuPrice() {
		return menuPrice;
	}
	public void setMenuPrice(int menuPrice) {
		this.menuPrice = menuPrice;
	}
	
	public void setStatus(Message status) {
		this.status = status;
	}
	
	public Message getStatus() {
		return status;
	}
	
	

}
