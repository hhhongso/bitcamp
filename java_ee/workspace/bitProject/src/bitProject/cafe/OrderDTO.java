package bitProject.cafe;

public class OrderDTO {
	private String menuOption;
	private String menuSelect; 
	private String amount; 
	private int price;
	
	public String getMenuOption() {
		return menuOption;
	}
	public void setMenuOption(String menuOption) {
		this.menuOption = menuOption;
	}
	public String getMenuSelect() {
		return menuSelect;
	}
	public void setMenuSelect(String menuSelect) {
		this.menuSelect = menuSelect;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return menuSelect + "\t" + amount + "\t" + price;
	} 
	
	

}
