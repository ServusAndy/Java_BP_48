
public class Item {
	private String id;
	private String title;
	private String category;
	private double price;
	
	public Item() {
		super();
	}

	public Item(String id, String title, String category, double price) {
		super();
		this.id = id;
		this.title = title;
		this.category = category;
		this.price = price;
	}

	public String getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getCategory() {
		return category;
	}

	public double getPrice() {
		return price;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Item)) {
			return false;
		}
		Item other = (Item) obj;
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Item [id=" + id + ", title=" + title + ", category=" + category + ", price=" + price + "]";
	}
	
	
}
