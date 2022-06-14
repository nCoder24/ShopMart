package shopmart.models;

public class Product {
	private int productID;
	private int price;
	private String title;
	private String type;
	private String catagory;
	private String description;
	public Product(int productID, int price, String title, String type, String catagory, String description) {
		super();
		this.productID = productID;
		this.price = price;
		this.title = title;
		this.type = type;
		this.catagory = catagory;
		this.description = description;
	}
	public int getProductID() {
		return productID;
	}
	public void setProductID(int productID) {
		this.productID = productID;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCatagory() {
		return catagory;
	}
	public void setCatagory(String catagory) {
		this.catagory = catagory;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "Product [productID=" + productID + ", price=" + price + ", title=" + title + ", description="
				+ description + "]";
	}
}
