
public class Product {
	private String name;
	private int id;
	private double price;
	private String size;
	
	public Product(String name, 
			int id, 
			double price, 
			String size) {
		this.name = name;
		this.id = id;
		this.price = price;
		this.size = size;
	}
	
	public String toString() {
		return id + " " + name + " " + price + " " + size;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Product)) {
			return false;
		}
		Product other = (Product) obj;
		if (id != other.id) {
			return false;
		}
		return true;
	}

	
	
	
}
