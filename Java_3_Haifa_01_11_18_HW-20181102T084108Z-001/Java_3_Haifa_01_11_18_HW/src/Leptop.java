
public class Leptop extends Product{
	private String cpu;
	public Leptop(String name, 
			int id, 
			double price, 
			String size,
			String cpu) {
		super(name, id, price, size);
		this.cpu = cpu;
	}
	
	public String toString() {
		return super.toString() + " " + cpu;
	}

}
