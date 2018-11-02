
public class Phone extends Product{
	private String os;
	public Phone(String name, 
			int id, 
			double price, 
			String size,
			String os) {
		super(name, id, price, size);
		this.os = os;
	}
	
	public String toString() {
		return super.toString() + " " + os;
	}

}
