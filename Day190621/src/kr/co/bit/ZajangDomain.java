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
// �������Լ��� 1���� �����ǰ� �����ϱ�, �ʱ�ȭ�� ���Ҹ� �ϰ� �����ϱ� , return�� ���� �����ϱ� > void �� �ʿ� ����. 

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
