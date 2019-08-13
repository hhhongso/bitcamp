package bitProject.cafe.dto;

public class OrderDTO {
	private String id;
	private String menuName;
	private int amount;
	private int menuPrice;
	private int totPrice;

	public String setId(String id) {
		this.id = id;
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

}
