package kr.co.bit;

public class ZajangDomain {

	private String productName; 
	private int productDan; 
	private int productSu; 
	private int productMoney;

	public ZajangDomain(String productName, int productDan, int productSu, int productMoney) {
		super();
		this.productName = productName;
		this.productDan = productDan;
		this.productSu = productSu;
		this.productMoney = productMoney;
	}
// 생성자함수는 1번만 생성되고 끝나니까, 초기화의 역할만 하고 끝나니까 , return할 값이 없으니까 > void 가 필요 없다. 

	public ZajangDomain() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getProductDan() {
		return productDan;
	}

	public void setProductDan(int productDan) {
		this.productDan = productDan;
	}

	public int getProductSu() {
		return productSu;
	}

	public void setProductSu(int productSu) {
		this.productSu = productSu;
	}

	public int getProductMoney() {
		return productMoney;
	}

	public void setProductMoney(int productMoney) {
		this.productMoney = productMoney;
	}

	@Override
	public String toString() {
		return "Zajang [productName=" + productName + ", productDan=" + productDan + ", productSu=" + productSu
				+ ", productMoney=" + productMoney + "]";
	}
	
}
