
public class TV extends Product{
	private boolean isSmart;
	public TV(String name, 
			int id, 
			double price, 
			String size,
			boolean isSmart) {
		super(name, id, price, size);
		this.isSmart = isSmart;
	}

	public String toString() {
		String str = isSmart ? "SMART" : "NoSmart";
		return super.toString() + " " + str;
	}
}
