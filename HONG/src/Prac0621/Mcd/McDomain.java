package Prac0621.Mcd;

public class McDomain {

	private String productName; 
	private int productPrice; 
	private int productNumber;

	public McDomain(String productName, int productPrice, int productNumber) {
		super();
		this.productName = productName;
		this.productPrice = productPrice;
		this.productNumber = productNumber;
	}

	public McDomain() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}

	public int getProductNumber() {
		return productNumber;
	}

	public void setProductNumber(int productNumber) {
		this.productNumber = productNumber;
	}

	@Override
	public String toString() {
		return "McDomain [productName=" + productName + ", productPrice=" + productPrice + ", productNumber="
				+ productNumber + "]";
	}

}
