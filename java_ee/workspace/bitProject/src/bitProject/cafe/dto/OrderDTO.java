package bitProject.cafe.dto;

import java.io.Serializable;

public class OrderDTO implements Serializable {
	private String id;
	private String menuName;
	private int amount;
	private int menuPrice;
	private int totPrice;
	private MemberDTO member;
	private boolean isStaff;
	private String orderDate;

	
	public OrderDTO() {
		this.member = member;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}
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

	public void setStaff(boolean isStaff) {
		this.isStaff = isStaff;
	}
	
	public boolean getStaff() {
		return isStaff;
	}

	public int getTotPrice() {
		return totPrice;
	}

	public void setTotPrice(int totPrice) {
		this.totPrice = totPrice;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	
	public String getOrderDate() {
		return orderDate;
	}

}
